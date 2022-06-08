import java.util.ArrayList;

public class ModelTerrain {

    //atributs
    ModelPion matriceDePion[][] = new ModelPion[10][10];
    //Constructeur
    public ModelTerrain() {

        System.out.println("creation terrain");
        reinitialiserTerrain();
        System.out.println("affichage terrain");
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
                        if (i == 0 || i == 1 || i == 2 || i == 3) {
                            matriceDePion[i][j] = new ModelPion('N', i, j);
                        } else if (i == 6 || i == 7 || i == 8 || i == 9) {
                            matriceDePion[i][j] = new ModelPion('B', i, j);
                        } else {
                            matriceDePion[i][j] = new ModelPion('_', i, j);
                        }

                    }
                } else {
                    if (j % 2 == 0) {
                        if (i == 0 || i == 1 || i == 2 || i == 3) {
                            matriceDePion[i][j] = new ModelPion('N', i, j);
                        } else if (i == 6 || i == 7 || i == 8 || i == 9) {
                            matriceDePion[i][j] = new ModelPion('B', i, j);
                        } else {
                            matriceDePion[i][j] = new ModelPion('_', i, j);
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
        ModelPion pion = matriceDePion[x][y];
        ModelPion pion2 = matriceDePion[x2][y2];
        pion.setPosition(x2, y2);
        pion2.setPosition(x, y);
        matriceDePion[x][y] = pion2;
        matriceDePion[x2][y2] = pion;
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
