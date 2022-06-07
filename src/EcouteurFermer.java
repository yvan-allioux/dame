import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurFermer implements ActionListener {
    private FenetreJeu f;

    public EcouteurFermer(FenetreJeu uneFenetre){
        f = uneFenetre;
    }

    public void actionPerformed(ActionEvent event){
        f.dispose();
    }
}