import java.util.ArrayList;

public class ModelTerrain {

    //atributs
    ModelPion matriceDePion[][] = new ModelPion[10][10];
    //Constructeur
    public ModelTerrain() {

        System.out.println("creation terrain");
        reinitialiserTerrain();
        System.out.println("affichage terrain console");
        afficherTerrainConsole();

    }

    //méthode
    //renisialisation du terrain
    public void reinitialiserTerrain() {
        for (int i = 0; i < matriceDePion.length; i++) {//parcours de la matrice de pion
            for (int j = 0; j < matriceDePion[i].length; j++) {//parcours de la ligne

                if (i % 2 == 0) {//si la ligne est pair
                    if (j % 2 == 0) {
                        matriceDePion[i][j] = new ModelPion('_', i, j);
                    } else {

                        switch (i) {
                            case 0:
                                matriceDePion[i][j] = new ModelPion('N', i, j);
                                break;
                            case 1:
                                matriceDePion[i][j] = new ModelPion('N', i, j);
                                break;
                            case 2:
                                matriceDePion[i][j] = new ModelPion('N', i, j);
                                break;
                            case 3:
                                matriceDePion[i][j] = new ModelPion('N', i, j);
                                break;
                            case 4:
                                matriceDePion[i][j] = new ModelPion('D', i, j);
                                break;
                            case 5:
                                matriceDePion[i][j] = new ModelPion('D', i, j);
                                break;
                            case 6:
                                matriceDePion[i][j] = new ModelPion('B', i, j);
                                break;
                            case 7:
                                matriceDePion[i][j] = new ModelPion('B', i, j);
                                break;
                            case 8:
                                matriceDePion[i][j] = new ModelPion('B', i, j);
                                break;
                            case 9:
                                matriceDePion[i][j] = new ModelPion('B', i, j);
                                break;
                            default:
                                matriceDePion[i][j] = new ModelPion('_', i, j);
                                break;
                        }

                    }
                } else {
                    if (j % 2 == 0) {

                        switch (i) {
                            case 0:
                                matriceDePion[i][j] = new ModelPion('N', i, j);
                                break;
                            case 1:
                                matriceDePion[i][j] = new ModelPion('N', i, j);
                                break;
                            case 2:
                                matriceDePion[i][j] = new ModelPion('N', i, j);
                                break;
                            case 3:
                                matriceDePion[i][j] = new ModelPion('N', i, j);
                                break;
                            case 4:
                                matriceDePion[i][j] = new ModelPion('D', i, j);
                                break;
                            case 5:
                                matriceDePion[i][j] = new ModelPion('D', i, j);
                                break;
                            case 6:
                                matriceDePion[i][j] = new ModelPion('B', i, j);
                                break;
                            case 7:
                                matriceDePion[i][j] = new ModelPion('B', i, j);
                                break;
                            case 8:
                                matriceDePion[i][j] = new ModelPion('B', i, j);
                                break;
                            case 9:
                                matriceDePion[i][j] = new ModelPion('B', i, j);
                                break;
                            default:
                                matriceDePion[i][j] = new ModelPion('_', i, j);
                                break;
                        }

                    } else {
                        matriceDePion[i][j] = new ModelPion('_', i, j);
                    }
                }
            }
        }

    }
    //affichage du terrain console
    public void afficherTerrainConsole() {
        for (int i = 0; i < matriceDePion.length; i++) {//parcours de la matrice de pion
            for (int j = 0; j < matriceDePion[i].length; j++) {//parcours de la ligne
                System.out.print(matriceDePion[i][j].getCouleur() + " | ");
            }
            System.out.println(" ");
        }
    }
    //metheode deplacement du pion
    public void deplacerPion(int x, int y, int x2, int y2) {
        char couleurPion1 = matriceDePion[x][y].getCouleur();
        char couleurPion2 = matriceDePion[x2][y2].getCouleur();

        if(couleurPion1 == couleurPion2){
            System.out.println("Impossible de deplacer un pion sur une case de meme couleur");
        }else if(couleurPion1 == '_'){//si la case 1 est vide
            System.out.println("case blanche");
        }else if(couleurPion1 == 'D'){//si pas de case dans la case 1
            System.out.println("case vide, deplacement interdit");
            //matriceDePion[x2][y2].setCouleur(couleurPion1);//on change la couleur du pion

        }else if(couleurPion2 == '_') {//si la case 2 est blanche
            System.out.println("case de destination blanche");
        }else if(couleurPion2 == 'B' || couleurPion2 == 'N') {//si la case 2 est un pion
            System.out.println("case de destination blanche ou noire, ok");
            matriceDePion[x2][y2].setCouleur(couleurPion1);//on change la couleur du pion
        }
    }

    //getters
    public ModelPion[][] getMatriceDePion() {
        return matriceDePion;
    }
    //getter pour la matrice de pion
    public ModelPion getPionSurTerrainAvecPosition(int i, int j) {
        return matriceDePion[i][j];
    }
    //setters
    public void setMatriceDePion(ModelPion[][] matriceDePion) {
        this.matriceDePion = matriceDePion;
    }
}
