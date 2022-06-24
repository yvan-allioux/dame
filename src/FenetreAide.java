import javax.swing.*;

public class FenetreAide extends JFrame{
    private JLabel textarea1;

    //constructeur
    public FenetreAide(String titre, int withParam, int heightParam, String aideParamText) {

        setSize(withParam,heightParam);
        setTitle(titre);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        textarea1 = new JLabel("<html>"+aideParamText+"</html>");
        textarea1.setLocation(10,10);
        textarea1.setSize(withParam-25,heightParam-50);
        this.add(textarea1);

    }
}
