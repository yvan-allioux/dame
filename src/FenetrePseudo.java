import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetrePseudo extends JFrame{
    // Attributs //
    private JLabel labelJ1, labelJ2;
    private ModelTerrain unModelTerrain;
    private JTextField pseudoJ1, pseudoJ2;
    private JButton boutonValide, boutonAide1;
    private Controleur controleur;
    private FenetreJeu fjeu;
    private FenetreAide faide;


    // Constructeurs //
    public FenetrePseudo(String titre, Controleur unControleur, ModelTerrain unModelTerrain, FenetreJeu fJeuParam) {
        this.fjeu = fJeuParam;
        this.unModelTerrain = unModelTerrain;
        controleur = unControleur;
        setSize(400,400);

        setTitle(titre);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        construireFPseudo();

    }
    
    private void construireFPseudo(){
        labelJ1 = new JLabel("Pseudo Joueur 1");
        labelJ1.setLocation(10,10);
        labelJ1.setSize(200,20);
        this.add(labelJ1);
        
        pseudoJ1 = new JTextField();
        pseudoJ1.setLocation(210,10);
        pseudoJ1.setSize(100,20);
        this.add(pseudoJ1);
        
        
        labelJ2 = new JLabel("Pseudo Joueur 2");
        labelJ2.setLocation(10,30);
        labelJ2.setSize(200,20);
        this.add(labelJ2);
        
        pseudoJ2 = new JTextField();
        pseudoJ2.setLocation(210,30);
        pseudoJ2.setSize(100,20);
        this.add(pseudoJ2);
        
        boutonValide = new JButton("Valider");
        boutonValide.setLocation(10,60);
        boutonValide.setSize(100,20);
        boutonValide.addActionListener(new EcouteurValide(this));
        this.add(boutonValide);

        boutonAide1 = new JButton("Règle du jeux");
        boutonAide1.setLocation(10,100);
        boutonAide1.setSize(140,20);
        boutonAide1.addActionListener(new EcouteurAide(this));
        this.add(boutonAide1);
    }

    public class EcouteurValide implements ActionListener
    {
        FenetrePseudo fenetre;

        public EcouteurValide(FenetrePseudo fenetre)
        {
            this.fenetre=fenetre;
        }

        public void actionPerformed(ActionEvent e)
        {

            fjeu.setVisible(true);

            controleur.enregistrerPseudo(pseudoJ1.getText(),pseudoJ2.getText());
        }
    }

    public class EcouteurAide implements ActionListener
    {
        FenetrePseudo fenetre;

        public EcouteurAide(FenetrePseudo fenetreParam)
        {
            this.fenetre=fenetreParam;
        }

        public void actionPerformed(ActionEvent e)
        {
            System.out.println("lancement de l'aide");
            String text = "jeu de dames<br />" +
                    "Les joueurs jouent chacun à leur tour. Les blancs commencent toujours.<br />" +
                    "<br />" +
                    "Le but du jeu est de capturer tous les pions adverses.<br />" +
                    "Si un joueur ne peut plus bouger, même s'il lui reste des pions, il perd la partie.<br />" +
                    "Chaque pion peut se déplacer d'une case vers l'avant en diagonale.<br />" +
                    "Un pion arrivant sur la dernière rangée et s'y arrêtant est promu en « dame ». Il est alors doublé (on pose dessus un deuxième pion de sa couleur).<br />" +
                    "La dame se déplace sur une même diagonale d'autant de cases qu'elle le désire, en avant et en arrière.<br />" +
                    "<br />" +
                    " La prise par un pion<br />" +
                    "<br />" +
                    "Un pion peut en prendre un autre en sautant par dessus le pion adverse pour se rendre sur la case vide située derrière celui-ci. Le pion sauté est retiré du jeu.<br />" +
                    "<br />" +
                    "La prise peut également s'effectuer en arrière.<br />" +
                    "<br />" +
                    "La prise est obligatoire.<br />" +
                    "<br />" +
                    "Si, après avoir pris un premier pion, vous vous retrouvez de nouveau en position de prise, vous devez continuer, jusqu'à ce que cela ne soit plus possible.<br />" +
                    "<br />" +
                    "Les pions doivent être enlevés à la fin de la prise et non pas un par un au fur et à mesure.<br />" +
                    "<br />" +
                    "La prise majoritaire<br />" +
                    "<br />" +
                    "Lorsque plusieurs prises sont possibles, il faut toujours prendre du côté du plus grand nombre de pièces.<br />" +
                    "<br />" +
                    "Cela signifie que si on peut prendre une dame ou deux pions, il faut prendre les deux pions<br />" +
                    "<br />" +
                    "Dans l'exemple ci-contre, un pion blanc peut prendre un pion noir, mais l'autre pion blanc peut en prendre 3, c'est donc ce coup qui doit être joué.<br />" +
                    "<br />" +
                    " La prise par la dame<br />" +
                    "<br />" +
                    "Puisque la dame a une plus grande marge de manoeuvre, elle a aussi de plus grandes possibilités pour les prises.<br />" +
                    "<br />" +
                    "La dame doit prendre tout pion situé sur sa diagonale (s'il y a une case libre derrière) et doit changer de direction à chaque fois qu'une  nouvelle prise est possible.<br />" +
                    "<br />" +
                    "On ne peut passer qu'une seule fois sur un même pion.<br />" +
                    "<br />" +
                    "En revanche, on peut passer deux fois sur la même case.<br />" +
                    "<br />" +
                    "Dans cet exemple, la dame blanche peut prendre les 4 pions noirs et pourra s'arrêter au choix sur l'une des 2 cases marquées d'une croix.<br />" +
                    "<br />" +
                    "Enfin, la partie peut être déclarée nulle si aucun des deux joueurs ne peut prendre toutes les pièces adverses (par exemple 3 dames contre une).";
            FenetreAide uneFenaitreAide = new FenetreAide("Aide", 900,900,text);

        }
    }

    //settters
    public void setFjeu(FenetreJeu fjeu) {
        this.fjeu = fjeu;
    }
    //getters
    public FenetreJeu getFjeu() {
        return fjeu;
    }
}



