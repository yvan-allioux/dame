import java.util.ArrayList;

public class ModelTerrain {
    //atributs
    ModelPion matriceDePion[][] = new ModelPion[10][10];
    //Constructeur
    public ModelTerrain() {

        System.out.println("creation terrain");

        for (int i = 0; i < matriceDePion.length; i++) {//parcours de la matrice de pion
            for (int j = 0; j < matriceDePion[i].length;j++) {//parcours de la ligne

                if (i % 2 == 0){
                    if (j % 2 == 0){
                        matriceDePion[i][j] = new ModelPion(true,i,j);
                    }
                    else {
                        matriceDePion[i][j] = new ModelPion(false,i,j);
                    }
                }
                else {
                    if (j % 2 == 0){
                        matriceDePion[i][j] = new ModelPion(false,i,j);
                    }
                    else {
                        matriceDePion[i][j] = new ModelPion(true,i,j);
                    }
                }


                System.out.print(matriceDePion[i][j].getCouleur() + " | ");

            }
            System.out.println(" ");
        }


        //ModelPion unPion = new ModelPion(true);

    }
}
