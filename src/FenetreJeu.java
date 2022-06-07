import javax.swing.*;
import java.awt.*;

public class FenetreJeu extends JFrame {

    // Attributs //
    private JLabel labelJ1, labelJ2;
    private JLabel labelImageJ1, labelImageJ2;

    private JButton boutonQuitter;
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
        labelImageJ1 = new JLabel(new ImageIcon("src/avatar/Axelane.png"));
        labelImageJ1.setSize(100,120);
        labelJ1.setSize(150,30);
        labelJ1.setLocation(20,30);
        this.add(labelJ1);

        panelTerrain=new PanelTerrain(this,  modelTerrain);
        panelTerrain.setLocation(190,30);
        this.add(panelTerrain);

        labelJ2 = new JLabel("Joueur 2");
        labelImageJ2 = new JLabel(new ImageIcon("src/avatar/Axelane.png"));
        labelJ2.setSize(150,30);
        labelJ2.setLocation(810,30);
        this.add(labelJ2);

        boutonQuitter = new JButton("Quitter");
        boutonQuitter.setSize(150,30);
        boutonQuitter.setLocation(810,600);
        boutonQuitter.addActionListener(new EcouteurFermer(this));
        this.add(boutonQuitter);

    }

}
