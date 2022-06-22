import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FenetreJeu extends JFrame {

    // ATTRIBUTS
    private JLabel labelJ1, labelJ2, labelScoreJ1, labelScoreJ2, labelPseudo1Tour, labelPseudo2Tour;
    private JButton boutonQuitter, boutonRejouer, boutonFinTourJ1, boutonFinTourJ2;
  
    private PanelTerrain panelTerrain;
    private ModelTerrain modelTerrain;


    // CONSTRUCTEUR
    public FenetreJeu(String titre , ModelTerrain unModelTerrain) {

        setSize(980, 700);
        setTitle(titre);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        modelTerrain = unModelTerrain;

        construireFJeu();
    }
    //METHODES
    private void construireFJeu() {

        labelJ1 = new JLabel("Joueur 1");
        labelJ1.setSize(150,30);
        labelJ1.setLocation(20,30);
        this.add(labelJ1);


        panelTerrain=new PanelTerrain(this,  modelTerrain);

        panelTerrain.setLocation(190,30);
        this.add(panelTerrain);

        labelJ2 = new JLabel("Joueur 2");
        labelJ2.setSize(150,30);
        labelJ2.setLocation(810,30);
        this.add(labelJ2);


        //pour ajouter les scores il faudrait appeler une fonction d'actualisation quand dans panel terrain on clique quelque par
        //et cette fonction appeler depuis panel terrain va chercher dans le model le score des utilisateurs
        labelScoreJ1 = new JLabel("score joueur 1 : 0");
        labelScoreJ1.setSize(150,30);
        labelScoreJ1.setLocation(20,100);
        this.add(labelScoreJ1);

        labelScoreJ2 = new JLabel("score joueur 2 : 0");
        labelScoreJ2.setSize(150,30);
        labelScoreJ2.setLocation(810,100);
        this.add(labelScoreJ2);

        labelPseudo1Tour = new JLabel("c'est le tour de J1");
        labelPseudo1Tour.setSize(150,30);
        labelPseudo1Tour.setLocation(20,360);
        labelPseudo1Tour.setVisible(true);
        this.add(labelPseudo1Tour);

        boutonFinTourJ1 = new JButton("Tour fini J1");
        boutonFinTourJ1.setSize(150,30);
        boutonFinTourJ1.setLocation(20,400);
        boutonFinTourJ1.addActionListener(new EcouteurFinTourJ1(this));
        boutonFinTourJ1.setVisible(true);
        this.add(boutonFinTourJ1);

        labelPseudo2Tour = new JLabel("c'est le tour de J2");
        labelPseudo2Tour.setSize(150,30);
        labelPseudo2Tour.setLocation(810,360);
        labelPseudo2Tour.setVisible(false);
        this.add(labelPseudo2Tour);

        boutonFinTourJ2 = new JButton("Tour fini J2");
        boutonFinTourJ2.setSize(150,30);
        boutonFinTourJ2.setLocation(810,400);
        boutonFinTourJ2.addActionListener(new EcouteurFinTourJ2(this));
        boutonFinTourJ2.setVisible(false);
        this.add(boutonFinTourJ2);

        boutonRejouer = new JButton("Rejouer");
        boutonRejouer.setSize(150,30);
        boutonRejouer.setLocation(20,600);
        boutonRejouer.addActionListener(new EcouteurRejouer(this));
        this.add(boutonRejouer);



        boutonQuitter = new JButton("Quitter");
        boutonQuitter.setSize(150,30);
        boutonQuitter.setLocation(810,600);
        boutonQuitter.addActionListener(new EcouteurFermer(this));
        this.add(boutonQuitter);

    }
    //action listeners pour le bouton fin tour J1
    class EcouteurFinTourJ1 implements ActionListener {
        private FenetreJeu fenetreJeu;
        public EcouteurFinTourJ1(FenetreJeu uneFenetreJeu) {
            fenetreJeu = uneFenetreJeu;
        }
        public void actionPerformed(ActionEvent e) {
            System.out.println("Fin du tour du joueur 1");
            fenetreJeu.modelTerrain.setTourJoueur1(false);

            fenetreJeu.boutonFinTourJ1.setVisible(false);
            fenetreJeu.boutonFinTourJ2.setVisible(true);

            fenetreJeu.labelPseudo1Tour.setVisible(false);
            fenetreJeu.labelPseudo2Tour.setVisible(true);

            //on actualise le score

            labelScoreJ1.setText("score joueur 1 : "+ modelTerrain.getPionNoirMort());
            labelScoreJ2.setText("score joueur 2 : "+ modelTerrain.getPionBlancMort());
        }
    }
    //action listeners pour le bouton fin tour J2
    class EcouteurFinTourJ2 implements ActionListener {
        private FenetreJeu fenetreJeu;
        public EcouteurFinTourJ2(FenetreJeu uneFenetreJeu) {
            fenetreJeu = uneFenetreJeu;
        }
        public void actionPerformed(ActionEvent e) {
            System.out.println("Fin du tour du joueur 2");
            fenetreJeu.modelTerrain.setTourJoueur1(true);

            fenetreJeu.boutonFinTourJ2.setVisible(false);
            fenetreJeu.boutonFinTourJ1.setVisible(true);

            fenetreJeu.labelPseudo2Tour.setVisible(false);
            fenetreJeu.labelPseudo1Tour.setVisible(true);

            //on actualise le score
            labelScoreJ1.setText("score joueur 1 : "+ modelTerrain.getPionNoirMort());
            labelScoreJ2.setText("score joueur 2 : "+ modelTerrain.getPionBlancMort());
        }
    }

    //action listener pour le bouton rejouer
    public class EcouteurRejouer implements ActionListener
    {
        FenetreJeu fenetre;

        public EcouteurRejouer(FenetreJeu fenetre)
        {
            this.fenetre=fenetre;
        }

        public void actionPerformed(ActionEvent e)
        {
            System.out.print("rejouer");
            System.out.print("- reset tour");
            modelTerrain.setTourJoueur1(true);//on remet le tour du joueur 1
            boutonFinTourJ2.setVisible(false);
            boutonFinTourJ1.setVisible(true);
            labelPseudo2Tour.setVisible(false);
            labelPseudo1Tour.setVisible(true);
            System.out.print("- reset plateau");
            modelTerrain.reinitialiserTerrain();
            panelTerrain.actualiserAffichage();
            System.out.print("- reset scor");
            modelTerrain.setPionBlancMort(0);
            modelTerrain.setPionNoirMort(0);
            labelScoreJ1.setText("score joueur 1 : "+ modelTerrain.getPionNoirMort());
            labelScoreJ2.setText("score joueur 2 : "+ modelTerrain.getPionBlancMort());

        }
    }
    //action listener pour le bouton quitter
    public class EcouteurFermer implements ActionListener {
        private FenetreJeu f;

        public EcouteurFermer(FenetreJeu uneFenetre){
            f = uneFenetre;
        }

        public void actionPerformed(ActionEvent event){
            f.dispose();
        }
    }


    //ACCESSEURS

    //getters

    public JLabel getLabelJ1() {
        return labelJ1;
    }
    public JLabel getLabelJ2() {
        return labelJ2;
    }


    //MODIFICATEURS

    //setters

    public void setLabelJ1(String pseudo1Param) {
        labelJ1.setText(pseudo1Param);
    }
    public void setLabelJ2(String pseudo2Param) {
        labelJ2.setText(pseudo2Param);
    }
    public void setlabelPseudo2Tour(String pseudoParam) {
        labelPseudo2Tour.setText(pseudoParam);
    }
    public void setlabelPseudo1Tour(String pseudoParam) {
        labelPseudo1Tour.setText(pseudoParam);
    }
    public void setLabelScoreJ1(String setLabelScoreJ1) {
        labelJ1.setText(setLabelScoreJ1);
    }

}

