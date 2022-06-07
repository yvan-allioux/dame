import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.*;

public class PanelTerrain extends JPanel {
    private Border blackline = BorderFactory.createLineBorder(Color.black,1);
    private  ButtonCase[][] plateau;
    private boolean testClic = false;
    private ButtonCase depart, arrivee;
    public PanelTerrain(JFrame fenetre){
        this.setLayout(new GridLayout(10,10)); // création de la grille 10x10
        this.setBorder(blackline);
        this.setSize(600, 600);
        depart = new ButtonCase("depart", 0,0);
        arrivee = new ButtonCase("arrivee", 0,0);
        plateau = new ButtonCase[10][10];
       for(int i=0; i<10 ; i++){ // parcours chaque ligne
            for(int j=0;j<10;j++){ // parcours chaque colonne
                if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
                    plateau[i][j]= new ButtonCase("bouton" + i+j, i, j);
                    plateau[i][j].setBackground(Color.WHITE);
                    plateau[i][j].setEnabled(false);
                   this.add(plateau[i][j]);
                }
                else{
                    plateau[i][j]= new ButtonCase("bouton" + i+j, i, j);
                    plateau[i][j].setBorder(blackline);
                    plateau[i][j].setBackground(Color.BLACK);
                    plateau[i][j].addActionListener(new EcouteurCase(this));
                    this.add(plateau[i][j]);
                }
            }

        }
    }

    public class EcouteurCase implements ActionListener
    {
        PanelTerrain panel;

        public EcouteurCase(PanelTerrain panel)
        {
            this.panel=panel;
        }

        public void actionPerformed(ActionEvent e)
        {

            if (testClic == false){
                depart = (ButtonCase) e.getSource();
                System.out.println("x" + depart.getCoordonneesX() + "y" + depart.getCoordonneesY());
                System.out.println("clic Depart");
                testClic=true;
            }else{
                arrivee = (ButtonCase) e.getSource();
                System.out.println("x" + arrivee.getCoordonneesX() + "y" + arrivee.getCoordonneesY());
                System.out.println("clic Arrivée");
                System.out.println("Depart : x " + depart.getCoordonneesX() + " y " + depart.getCoordonneesY());
                System.out.println("Arrivee : x " + arrivee.getCoordonneesX() + " y " + arrivee.getCoordonneesY());
                testClic = false;
            }

        }
    }

}

