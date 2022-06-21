import javax.swing.*;
public class ButtonCase extends JButton{
    // ATTRIBUTS
    private String nom;
    private int x,y;
    // CONSTRUCTEUR
    public ButtonCase(String unNom, int unX, int unY) {
        nom = unNom;
        x = unX;
        y = unY;
    }
    // ACCESSEURS
    public String getNom(){
        return nom;
    }

    public int getCoordonneesX(){
        return x;
    }
    public int getCoordonneesY(){
        return y;
    }
}
