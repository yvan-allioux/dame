import java.util.ArrayList;

public class ModelTerrain {

    //ATTRIBUTS
    ModelPion matriceDePion[][] = new ModelPion[10][10];

    private int pionNoirPrisParLesBlancs = 0;
    private int pionBlancPrisParLesNoirs = 0;

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
    public void deplacerPion(int x, int y, int x2, int y2) {
        char couleurPion1 = matriceDePion[x][y].getCouleur();
        char couleurPion2 = matriceDePion[x2][y2].getCouleur();

        if(couleurPion1 == couleurPion2){
            System.out.println("Impossible de deplacer un pion sur une case de meme couleur");
        }else if(couleurPion1 == '_'){//si la case 1 est vide
            System.out.println("case blanche");
        }else if(couleurPion1 == 'D'){//si pas de case dans la case 1
            System.out.println("premiere selection case vide, deplacement interdit");
        }else if(couleurPion2 == '_') {//si la case 2 est blanche
            System.out.println("case de destination blanche, deplacement interdit");
        }else if(couleurPion2 == 'B' || couleurPion2 == 'N') {//si la case de destination est un pion
            System.out.println("case de destination blanche ou noire, ok");
            matriceDePion[x2][y2].setCouleur(couleurPion1);//on change la couleur du pion de la case de destination
            matriceDePion[x][y].setCouleur('D');//on change la couleur de la case 1
            //PION MORT
            mortPion(couleurPion2);
        }else if(couleurPion2 == 'D') {//si la case de destination est une case vide
            System.out.println("case de destination vide, ok");
            matriceDePion[x2][y2].setCouleur(couleurPion1);//on change la couleur du pion
            matriceDePion[x][y].setCouleur('D');//on change la couleur de la case 1
        }else{
            System.out.println("erreur");
            System.out.println("couleurPion1 " + couleurPion1 + " couleurPion2 " + couleurPion2);
            System.out.println("x " + x + " y " + y + " x2 " + x2 + " y2 " + y2);
        }
    }

    //Mort d'un pion

    public void mortPion(char couleurDuPionPort) {
        if(couleurDuPionPort == 'B'){
            System.out.println("Pion blanc mort");
            this.pionBlancPrisParLesNoirs++;
            System.out.println("Pion blanc pris par les noirs : " + this.pionBlancPrisParLesNoirs);
        }else if(couleurDuPionPort == 'N'){
            System.out.println("Pion noir mort");
            this.pionNoirPrisParLesBlancs++;
            System.out.println("Pion noir pris par les blancs : " + this.pionNoirPrisParLesBlancs);
        }else{
            System.out.println("ERREUR COULEUR DE TION MORT NON DEFINIE");
        }

    }

    //ACCESSEURS
    //GETTER
    public ModelPion[][] getMatriceDePion() {
        return matriceDePion;
    }
    public int getPionNoirPrisParLesBlancs() {
        return pionNoirPrisParLesBlancs;
    }
    public int getPionBlancPrisParLesNoirs() {
        return pionBlancPrisParLesNoirs;
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
    public void setPionNoirPrisParLesBlancs(int pionNoirPrisParLesBlancs) {
        this.pionNoirPrisParLesBlancs = pionNoirPrisParLesBlancs;
    }
    public void setPionBlancPrisParLesNoirs(int pionBlancPrisParLesNoirs) {
        this.pionBlancPrisParLesNoirs = pionBlancPrisParLesNoirs;
    }
    public void setTourJoueur1(boolean tourJoueur1) {
        this.tourJoueur1 = tourJoueur1;
    }
}
