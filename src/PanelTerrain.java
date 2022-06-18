import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.*;

public class PanelTerrain extends JPanel {

    private ModelTerrain unModelTerrain;
    private Border blackline = BorderFactory.createLineBorder(Color.black,1);
    private  ButtonCase[][] plateau;
    private boolean testClic = false;
    private ButtonCase depart, arrivee;

    //constructeur ???
    public PanelTerrain(JFrame fenetre, ModelTerrain unModelTerrain) {
        this.unModelTerrain = unModelTerrain;//on recupere le model terrain
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
        actualiserAffichage();//on actualise l'affichage avec des backgrounds blancs et noirs selon le model
    }

    //actualise le plateau
    public class EcouteurCase implements ActionListener {
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

                //depacement du pion dans le model terrain
                System.out.println("lancement du delacement --- "+ unModelTerrain.getPionSurTerrainAvecPosition(depart.getCoordonneesX(), depart.getCoordonneesY()).getCouleur() + " : x "+ depart.getCoordonneesX() + " y " + depart.getCoordonneesY() + "  -->  " + unModelTerrain.getPionSurTerrainAvecPosition(arrivee.getCoordonneesX(), arrivee.getCoordonneesY()).getCouleur() +" : z " + arrivee.getCoordonneesX() + " y " + arrivee.getCoordonneesY());//descripteur de deplacement
                unModelTerrain.deplacerPion(depart.getCoordonneesX(), depart.getCoordonneesY(), arrivee.getCoordonneesX(), arrivee.getCoordonneesY());
                unModelTerrain.afficherTerrainConsole();
                //actualisation de l'affichage du terrain et des pion avec les icones
                actualiserAffichage();

                testClic = false;
            }

        }
    }

    //fonction qui permet de mettre a jour l'affichage du terrain en fonction du model terrain
    public void actualiserAffichage(){

        for(int i=0; i<10 ; i++){ // parcours chaque ligne
            for(int j=0;j<10;j++) { // parcours chaque colonne

                unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur();
                if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur() == 'N') {
                    plateau[i][j].setBackground(Color.DARK_GRAY);
                }else if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur() == 'B') {
                    plateau[i][j].setBackground(Color.LIGHT_GRAY);
                }else if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur() == '_') {
                    //rien c'est une case blanche
                }else if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur() == 'D') {
                    plateau[i][j].setBackground(Color.BLACK);//on remet en noir la case comme a lorigine
                }

            }
        }


    }
}

