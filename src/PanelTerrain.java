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
    private ModelTerrain modelTerrain;
    public PanelTerrain(JFrame fenetre, ModelTerrain unModelTerrain){
        this.setLayout(new GridLayout(10,10)); // création de la grille 10x10
        this.setBorder(blackline);
        this.setSize(600, 600);
        depart = new ButtonCase("depart", 0,0);
        arrivee = new ButtonCase("arrivee", 0,0);
        plateau = new ButtonCase[10][10];
        modelTerrain = unModelTerrain;
       for(int i=0; i<10 ; i++){ // parcours chaque ligne
            for(int j=0;j<10;j++){ // parcours chaque colonne
                if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
                    // initialisation case blanche
                    plateau[i][j]= new ButtonCase("bouton" + i+j, i, j);
                    plateau[i][j].setBackground(Color.WHITE);
                    plateau[i][j].setEnabled(false);
                    this.add(plateau[i][j]);

                }
                else{
                    // initialisation case noir
                    plateau[i][j]= new ButtonCase("bouton" + i+j, i, j);
                    plateau[i][j].setBorder(blackline);
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

        /*public void paint (Graphics g){
            super.paint(g);
            Dimension size = getSize();

        }*/
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

    //fonction qui permet de mettre a jour l'affichage du terrain en fonction du model terrain
    public void actualiserAffichage(){
        // initialisation des images de fond pour les cases
        ImageIcon pionNoir = new ImageIcon("src/case_pN.png"); // case noir avec un pion noir dessus
        ImageIcon pionBlanc = new ImageIcon("src/case_pB.png"); // case noir avec un pion blanc dessus
        ImageIcon caseVide = new ImageIcon("src/case.png"); // case noir vide

        for(int i=0; i<10 ; i++){ // parcours chaque ligne
            for(int j=0;j<10;j++) { // parcours chaque colonne

                //unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur(); // Je pense pas que ce soit utile puisque tu stock pas l'info et que tu refais le test à chaque fois
                if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur() == 'N') {
                  plateau[i][j].setIcon(pionNoir); // on place un pion noir
                }else if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur() == 'B') {
                    plateau[i][j].setIcon(pionBlanc); // on place un pion blanc
                }else if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur() == '_') {
                    //rien c'est une case blanche
                }else if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur() == 'D') {
                    plateau[i][j].setIcon(caseVide); //on remet en noir la case comme a l'origine
                }

            }
        }


    }

}

