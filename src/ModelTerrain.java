import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


public class ModelTerrain{

    //ATTRIBUTS
    ModelPion matriceDePion[][] = new ModelPion[10][10];

    private int pionNoirMort = 0;
    private int pionBlancMort = 0;

    private boolean tourJoueur1 = true;


    //CONSTRUCTEUR

    public ModelTerrain() {

        System.out.println("creation terrain");
        reinitialiserTerrain();
        System.out.println("affichage terrain console");
        afficherTerrainConsole();

    }


    //METHODES
    //réinisialisation du terrain

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
    public int deplacerPion(int x, int y, int x2, int y2) {
        char couleurPion1 = matriceDePion[x][y].getCouleur();
        char couleurPion2 = matriceDePion[x2][y2].getCouleur();

        if(couleurPion1 == couleurPion2){//si les pions sont de la meme couleur
            System.out.println("Impossible de deplacer un pion sur une case de meme couleur");
            return 1;
        }else if(couleurPion1 == '_'){//si la case 1 est vide
            System.out.println("case blanche");
            return 1;
        }else if(couleurPion1 == 'D'){//si pas de pion dans la case 1
            System.out.println("premiere selection case vide, deplacement interdit");
            //reset des clics
            return 2;
        }else if(couleurPion2 == '_') {//si la case 2 est blanche
            System.out.println("case de destination blanche, deplacement interdit");
            return 1;
        }else if(couleurPion2 == 'B' || couleurPion2 == 'N') {//si la case de destination est un pion
            System.out.println("case de destination blanche ou noire, ok");

            //transformation dame
            if( ((matriceDePion[x][y].getCouleur() == 'B') && x2 == 0) || ((matriceDePion[x][y].getCouleur() == 'N') && x2 == 9) ){
                System.out.println("TRANSFORMATION EN DAMME");
                matriceDePion[x2][y2].setEstDame(true);
            }

            matriceDePion[x2][y2].setCouleur(couleurPion1);//on change la couleur du pion de la case de destination
            matriceDePion[x][y].setCouleur('D');//on change la couleur de la case 1
            //PION MORT
            mortPion(couleurPion2);
            return 0;
        }else if(couleurPion2 == 'D') {//si la case de destination est une case vide
            System.out.println("case de destination vide, ok");
            matriceDePion[x2][y2].setCouleur(couleurPion1);//on change la couleur du pion
            matriceDePion[x][y].setCouleur('D');//on change la couleur de la case 1
            return 0;
        }else{
            System.out.println("erreur");
            System.out.println("couleurPion1 " + couleurPion1 + " couleurPion2 " + couleurPion2);
            System.out.println("x " + x + " y " + y + " x2 " + x2 + " y2 " + y2);
            return 1;
        }
    }

    //Mort d'un pion

    public void mortPion(char couleurDuPionPort) {
        if(couleurDuPionPort == 'B'){
            System.out.println("Pion blanc mort");
            this.pionBlancMort++;
            System.out.println("Pion blanc pris par les noirs : " + this.pionBlancMort);
        }else if(couleurDuPionPort == 'N'){
            System.out.println("Pion noir mort");
            this.pionNoirMort++;
            System.out.println("Pion noir pris par les blancs : " + this.pionNoirMort);
        }else{
            System.out.println("ERREUR COULEUR DE TION MORT NON DEFINIE");
        }

    }

    //sauvegarde
    public void sauvegarde(){
        try {
            File myObj = new File("save.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("save.txt");
            String stringToSave = getStringMatriceDePionForSave(matriceDePion);
            System.out.println(" ---stringToSave--- " + stringToSave);
            myWriter.write(stringToSave);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }


    //ACCESSEURS
    //GETTER
    public ModelPion[][] getMatriceDePion() {
        return matriceDePion;
    }
    public String getStringMatriceDePionForSave(ModelPion[][] maMatriceDePionParam) {
        String monTerrainString = "";

        for (int i = 0; i < matriceDePion.length; i++) {//parcours de la matrice de pion
            for (int j = 0; j < matriceDePion[i].length; j++) {//parcours de la ligne
                monTerrainString = monTerrainString + matriceDePion[i][j].getCouleur() + " | ";
            }
            monTerrainString = monTerrainString + "\n";
        }

        return monTerrainString;
    }
    public int getPionNoirMort() {
        return pionNoirMort;
    }
    public int getPionBlancMort() {
        return pionBlancMort;
    }
    //getter pour la matrice de pion
    public ModelPion getPionSurTerrainAvecPosition(int i, int j) {
        return matriceDePion[i][j];
    }

    public boolean getTourJoueur1() {
        return tourJoueur1;
    }
    //MODIFICATEURS
    //SETTER
    public void setMatriceDePion(ModelPion[][] matriceDePion) {
        this.matriceDePion = matriceDePion;
    }
    public void setPionNoirMort(int pionNoirMort) {
        this.pionNoirMort = pionNoirMort;
    }
    public void setPionBlancMort(int pionBlancMort) {
        this.pionBlancMort = pionBlancMort;
    }
    public void setTourJoueur1(boolean tourJoueur1) {
        this.tourJoueur1 = tourJoueur1;
    }
}
