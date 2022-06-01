import javax.swing.*;

public class FenetreJeu extends JFrame {

    // Attributs //
    private JLabel labelJ1, labelJ2;
    private JTextField pseudoJ1, pseudoJ2;
    private JButton boutonValide;

    // Constructeurs //
    public FenetreJeu(String titre) {
        setSize(400, 400);
        setTitle(titre);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        construireFJeu();
    }

    private void construireFJeu() {
        labelJ1 = new JLabel("Pseudo Joueur 1");
    }
}
