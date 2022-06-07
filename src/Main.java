public class Main {
    public static void main(String[] args) {

        ModelJoueur joueur1, joueur2;

        joueur1 = new ModelJoueur();
        joueur2 = new ModelJoueur();
        Controleur controleur;
        controleur = new Controleur(joueur1, joueur2);
        FenetrePseudo fPseudo = new FenetrePseudo("pseudo", controleur);

        fPseudo.setVisible(true);


        ModelTerrain unModelTerrain = new ModelTerrain();
        System.out.println("position 8 1 : " + unModelTerrain.getPionSurTerrainAvecPosition(8, 1).getCouleur());

        FenetreJeu fJeu = new FenetreJeu("Jeu", unModelTerrain);
        fJeu.setVisible(true);

        //test yvan

    }
}