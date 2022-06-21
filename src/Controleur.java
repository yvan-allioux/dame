public class Controleur {
    // ATTRIBUTS //
    private ModelJoueur joueur1;
    private ModelJoueur joueur2;
    private ModelPion mPion;
    private ModelTerrain mTerrain;
    private FenetreJeu vueJeu;
    private FenetrePseudo vuePseudo;
    // CONSTRUCTEUR //
    public Controleur(ModelJoueur unJoueur1, ModelJoueur unJoueur2){
        joueur1 = unJoueur1;
        joueur2 = unJoueur2;
    }
    // METHODES //
    public void enregistrerPseudo(String pseudo1, String pseudo2)
    {
        // mise a jour du pseudo du joueur

       joueur1.setPseudo(pseudo1);
       joueur2.setPseudo(pseudo2);

        System.out.println(joueur1.getPseudo() + joueur2.getPseudo());

       System.out.println(joueur1.getPseudo() + " - " +joueur2.getPseudo());
          vueJeu.setLabelJ1("Joueur 1 : "+joueur1.getPseudo());
           vueJeu.setLabelJ2("Joueur 2 : "+joueur2.getPseudo());

    }
}
