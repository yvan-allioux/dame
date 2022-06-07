import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetrePseudo extends JFrame{
    // Attributs //
    private JLabel labelJ1, labelJ2;
    private JTextField pseudoJ1, pseudoJ2;
    private JButton boutonValide;
    private Controleur controleur;
    // Constructeurs //
    public FenetrePseudo(String titre, Controleur unControleur){
        controleur= unControleur;
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
            controleur.enregistrerPseudo(pseudoJ1.getText(),pseudoJ2.getText());
        }
    }
}



