import javax.swing.*;
import java.awt.*;

public class FenetreJeu extends JFrame {

    // Attributs //

    private JLabel labelJ1, labelJ2, labelScoreJ1, labelScoreJ2;


    private JButton boutonQuitter, boutonRejouer, boutonFinTourJ1, boutonFinTourJ2;
    private PanelTerrain panelTerrain;
    private ModelTerrain modelTerrain;

    // Constructeurs //
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

        boutonFinTourJ1 = new JButton("Tour fini");
        boutonFinTourJ1.setSize(150,30);
        boutonFinTourJ1.setLocation(20,400);
        this.add(boutonFinTourJ1);

        boutonFinTourJ2 = new JButton("Tour fini");
        boutonFinTourJ2.setSize(150,30);
        boutonFinTourJ2.setLocation(810,400);
        this.add(boutonFinTourJ2);

        boutonRejouer = new JButton("Rejouer");
        boutonRejouer.setSize(150,30);
        boutonRejouer.setLocation(20,600);
        this.add(boutonRejouer);


        boutonQuitter = new JButton("Quitter");
        boutonQuitter.setSize(150,30);
        boutonQuitter.setLocation(810,600);
        boutonQuitter.addActionListener(new EcouteurFermer(this));
        this.add(boutonQuitter);

    }

}
