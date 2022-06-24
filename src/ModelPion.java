public class ModelPion {

    //ATTRIBUTS
    char couleur;// terue = blanc false = noire
    int positionX;
    int positionY;

    boolean estDame = false;

    //CONSTRUCTEURS
    public ModelPion(char couleurParam, int positionXParam, int positionYParam){
        this.couleur = couleurParam;
        this.positionX = positionXParam;
        this.positionY = positionYParam;
    }

    //ACCESSEURS
    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public char getCouleur() {
        return couleur;
    }
    public boolean getEstDame() {
        return estDame;
    }

    //setter
    public void setCouleur(char couleur) {
        this.couleur = couleur;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public void setEstDame(boolean estDame) {
        this.estDame = estDame;
    }

}
