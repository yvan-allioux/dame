import javax.swing.*;

public class Controleur {
    //attention le controleur est juste une interface entre le model et la vue dans le cadre de ce projet !!!

    // ATTRIBUTS //
    private ModelJoueur joueur1;
    private ModelJoueur joueur2;
    private ModelTerrain mTerrain;
    private FenetreJeu vueJeu;

    // CONSTRUCTEUR //
    public Controleur(ModelJoueur unJoueur1, ModelJoueur unJoueur2, ModelTerrain mTerrainParam, FenetreJeu vueJeuParam) {
        joueur1 = unJoueur1;
        joueur2 = unJoueur2;
        this.mTerrain = mTerrainParam;
        this.vueJeu = vueJeuParam;
    }
    // METHODES //
    public void enregistrerPseudo(String pseudo1, String pseudo2)
    {
        // mise a jour du pseudo du joueur

       joueur1.setPseudo(pseudo1);
       joueur2.setPseudo(pseudo2);
       System.out.println(joueur1.getPseudo() + " - " +joueur2.getPseudo());

       if(joueur1.getPseudo().equals(""))
       {
           vueJeu.setLabelJ1("J 1 : JOUEUR 1");
       }
       else
       {
           vueJeu.setLabelJ1("J 1 : "+joueur1.getPseudo());
           vueJeu.setlabelPseudo1Tour("tour de "+joueur1.getPseudo());
       }

       if(joueur2.getPseudo().equals(""))
       {
           vueJeu.setLabelJ2("J 2 : JOUEUR 2");
       }
       else
       {
           vueJeu.setLabelJ2("J 2 : "+joueur2.getPseudo());
           vueJeu.setlabelPseudo2Tour("tour de "+joueur2.getPseudo());
       }


    }
}