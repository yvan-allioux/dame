import javax.swing.*;
import java.awt.*;

public class FenetreJeu extends JFrame {

    // Attributs //
    private JLabel labelJ1, labelJ2, labelScorJ1, labelScorJ2;
    private JLabel labelImageJ1, labelImageJ2;

    private JButton boutonQuitter;
    private PanelTerrain panelTerrain;

    // Constructeurs //
    public FenetreJeu(String titre, ModelTerrain unModelTerrain) {
        setSize(980, 700);
        setTitle(titre);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Y : je pas en param le trerrain
        construireFJeu(unModelTerrain);
    }

    private void construireFJeu(ModelTerrain unModelTerrain) {
        labelJ1 = new JLabel("Joueur 1");
        labelImageJ1 = new JLabel(new ImageIcon("src/avatar/Axelane.png"));
        labelImageJ1.setSize(100,120);
        labelJ1.setSize(150,30);
        labelJ1.setLocation(20,30);
        this.add(labelJ1);

        panelTerrain = new PanelTerrain(this, unModelTerrain);
        panelTerrain.setLocation(190,30);
        this.add(panelTerrain);

        labelJ2 = new JLabel("Joueur 2");
        labelImageJ2 = new JLabel(new ImageIcon("src/avatar/Axelane.png"));
        labelJ2.setSize(150,30);
        labelJ2.setLocation(810,30);
        this.add(labelJ2);

        //pour ajouter les scor il faudrais apler une fonction d'actualisation quand dans panel terrain on clique quelqie par
        //et cette fonction apler depuis panel terrain va chercher dans le model le scor des user
        labelScorJ1 = new JLabel("scor joueur 1 : 0");
        labelScorJ1.setSize(150,30);
        labelScorJ1.setLocation(20,100);
        this.add(labelScorJ1);

        labelScorJ2 = new JLabel("scor joueur 2 : 0");
        labelScorJ2.setSize(150,30);
        labelScorJ2.setLocation(810,100);
        this.add(labelScorJ2);

        boutonQuitter = new JButton("Quitter");
        boutonQuitter.setSize(150,30);
        boutonQuitter.setLocation(810,600);
        boutonQuitter.addActionListener(new EcouteurFermer(this));
        this.add(boutonQuitter);

    }

    //getters
    public JLabel getLabelJ1() {
        return labelJ1;
    }
    public JLabel getLabelJ2() {
        return labelJ2;
    }

    //setters
    public void setLabelJ1(String pseudo1Param) {
        labelJ1.setText(pseudo1Param);
    }
    public void setLabelJ2(String pseudo2Param) {
        labelJ2.setText(pseudo2Param);
    }

}
