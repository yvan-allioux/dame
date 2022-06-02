import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.*;

public class PanelTerrain extends JPanel {
    private Border blackline = BorderFactory.createLineBorder(Color.black,1);
    private  ButtonCase[][] plateau;
    public PanelTerrain(JFrame fenetre){
        this.setLayout(new GridLayout(10,10)); // création de la grille 10x10
        this.setBorder(blackline);
        this.setSize(600, 600);
        plateau = new ButtonCase[10][10];
       for(int i=0; i<10 ; i++){ // parcours chaque ligne
            for(int j=0;j<10;j++){ // parcours chaque colonne
                if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
                   plateau[i][j]= new ButtonCase();
                    plateau[i][j].setBackground(Color.WHITE);
                   this.add(plateau[i][j]);
                }
                else{
                    plateau[i][j]= new ButtonCase();
                    plateau[i][j].setBorder(blackline);
                    plateau[i][j].setBackground(Color.BLACK);
                    this.add(plateau[i][j]);
                }
            }
        }
    }



}

