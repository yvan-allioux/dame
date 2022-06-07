import java.util.ArrayList;

public class ModelTerrain {

    //atributs
    ModelPion matriceDePion[][] = new ModelPion[10][10];
    //Constructeur
    public ModelTerrain() {

        System.out.println("creation terrain");

        for (int i = 0; i < matriceDePion.length; i++) {//parcours de la matrice de pion
            for (int j = 0; j < matriceDePion[i].length;j++) {//parcours de la ligne

                if (i % 2 == 0) {//si la ligne est pair
                    if (j % 2 == 0){
                        matriceDePion[i][j] = new ModelPion('_',i,j);
                    }
                    else {
                        if(i == 0 || i == 1 || i == 2 || i == 3){
                            matriceDePion[i][j] = new ModelPion('N',i,j);
                        }else if(i == 6 || i == 7 || i == 8 || i == 9){
                            matriceDePion[i][j] = new ModelPion('B',i,j);
                        }else{
                            matriceDePion[i][j] = new ModelPion('_',i,j);
                        }

                    }
                } else {
                    if (j % 2 == 0){
                        if(i == 0 || i == 1 || i == 2 || i == 3){
                            matriceDePion[i][j] = new ModelPion('N',i,j);
                        }else if(i == 6 || i == 7 || i == 8 || i == 9){
                            matriceDePion[i][j] = new ModelPion('B',i,j);
                        }else{
                            matriceDePion[i][j] = new ModelPion('_',i,j);
                        }
                    } else {
                        matriceDePion[i][j] = new ModelPion('_',i,j);
                    }
                }


                System.out.print(matriceDePion[i][j].getCouleur() + " | ");

            }
            System.out.println(" ");
        }


        //ModelPion unPion = new ModelPion(true);

    }

    //méthode
    //renisialisation du terrain
    public void reinitialiserTerrain() {

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
