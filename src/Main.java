public class Main {
    public static void main(String[] args) {

        ModelTerrain unModelTerrain = new ModelTerrain();

        FenetreJeu fJeu = new FenetreJeu("Jeu", unModelTerrain);

        ModelJoueur joueur1, joueur2;

        joueur1 = new ModelJoueur();
        joueur2 = new ModelJoueur();
        Controleur controleur;
        controleur = new Controleur(joueur1, joueur2, unModelTerrain, fJeu);
        FenetrePseudo fPseudo = new FenetrePseudo("pseudo", controleur, unModelTerrain, fJeu);

        fPseudo.setVisible(true);


        //test yvan

        System.out.println("position 8 1 : " + unModelTerrain.getPionSurTerrainAvecPosition(8, 1).getCouleur());

        fJeu.setVisible(true);

        //test yvan

    }
}