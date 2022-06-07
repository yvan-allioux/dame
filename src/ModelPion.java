public class ModelPion {










    //atrubut
    boolean couleur;// terue = blanc false = noire
    int positionX;
    int positionY;

    //constructeur
    public ModelPion(boolean couleurParam, int positionXParam, int positionYParam){
        this.couleur = couleurParam;
        this.positionX = positionXParam;
        this.positionY = positionYParam;
    }

    //getter
    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public boolean getCouleur() {
        return couleur;
    }
    //setter
    public void setCouleur(boolean couleur) {
        this.couleur = couleur;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

}
