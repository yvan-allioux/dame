import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.*;

public class PanelTerrain extends JPanel {

    //ATTRIBUTS

    private ModelTerrain unModelTerrain;
    private Border blackline = BorderFactory.createLineBorder(Color.black,1);
    private  ButtonCase[][] plateau;
    private boolean testClic = false;
    private ButtonCase depart, arrivee;


    //CONSTRUCTEUR

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
                    // initialisation case blanche
                    plateau[i][j]= new ButtonCase("bouton" + i+j, i, j);
                    plateau[i][j].setBackground(Color.WHITE);
                    plateau[i][j].setEnabled(false);
                    this.add(plateau[i][j]);

                }
                else{
                    //initialisation case noire
                    plateau[i][j]= new ButtonCase("bouton" + i+j, i, j);
                    plateau[i][j].setBorder(blackline);
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
                if((unModelTerrain.getPionSurTerrainAvecPosition(depart.getCoordonneesX(), depart.getCoordonneesY()).getCouleur() == 'D') || (unModelTerrain.getTourJoueur1() && (unModelTerrain.getPionSurTerrainAvecPosition(depart.getCoordonneesX(), depart.getCoordonneesY()).getCouleur() == 'N')) || (!(unModelTerrain.getTourJoueur1()) && (unModelTerrain.getPionSurTerrainAvecPosition(depart.getCoordonneesX(), depart.getCoordonneesY()).getCouleur() == 'B'))){
                    //console
                    System.out.println("prepiere selection case vide, reset -- OU -- tour des blanc et premier clic pion noir - OU - tour des noir et clic sur pion blanc");
                    testClic = false;
                }else{
                    testClic = true;
                }


            }else{
                arrivee = (ButtonCase) e.getSource();
                System.out.println("x" + arrivee.getCoordonneesX() + "y" + arrivee.getCoordonneesY());
                System.out.println("clic Arrivée");
                System.out.println("Depart : x " + depart.getCoordonneesX() + " y " + depart.getCoordonneesY());
                System.out.println("Arrivee : x " + arrivee.getCoordonneesX() + " y " + arrivee.getCoordonneesY());

                //depacement du pion dans le model terrain
                System.out.println("lancement du delacement --- "+ unModelTerrain.getPionSurTerrainAvecPosition(depart.getCoordonneesX(), depart.getCoordonneesY()).getCouleur() + " : x "+ depart.getCoordonneesX() + " y " + depart.getCoordonneesY() + "  -->  " + unModelTerrain.getPionSurTerrainAvecPosition(arrivee.getCoordonneesX(), arrivee.getCoordonneesY()).getCouleur() +" : z " + arrivee.getCoordonneesX() + " y " + arrivee.getCoordonneesY());//descripteur de deplacement
                if((unModelTerrain.deplacerPion(depart.getCoordonneesX(), depart.getCoordonneesY(), arrivee.getCoordonneesX(), arrivee.getCoordonneesY())) == 2){//si on clic sur une case vide
                    System.out.println("--------- ERREUR --------");
                }
                if(unModelTerrain.getPionSurTerrainAvecPosition(depart.getCoordonneesX(), depart.getCoordonneesY()).getEstDame() == true){
                    unModelTerrain.getPionSurTerrainAvecPosition(depart.getCoordonneesX(), depart.getCoordonneesY()).setEstDame(false);
                    unModelTerrain.getPionSurTerrainAvecPosition(arrivee.getCoordonneesX(), arrivee.getCoordonneesY()).setEstDame(true);
                }


                unModelTerrain.afficherTerrainConsole();
                //actualisation de l'affichage du terrain et des pion avec les icones
                actualiserAffichage();

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

        ImageIcon dameNoir = new ImageIcon("src/case_dN.png"); //dame
        ImageIcon dameBlanc = new ImageIcon("src/case_dB.png");


        for(int i=0; i<10 ; i++){ // parcours chaque ligne
            for(int j=0;j<10;j++) { // parcours chaque colonne


                //unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur(); // Je pense pas que ce soit utile puisque tu stock pas l'info et que tu refais le test à chaque fois
                if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur() == 'N') {
                    if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getEstDame()){
                        plateau[i][j].setIcon(dameNoir);//dame
                    }else{
                        plateau[i][j].setIcon(pionNoir); // on place un pion noir
                    }

                }else if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur() == 'B') {
                    if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getEstDame()){
                        plateau[i][j].setIcon(dameBlanc); // on place une dame
                    }else{
                        plateau[i][j].setIcon(pionBlanc); // on place un pion blanc
                    }
                }else if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur() == '_') {
                    //rien c'est une case blanche
                }else if(unModelTerrain.getPionSurTerrainAvecPosition(i, j).getCouleur() == 'D') {
                    plateau[i][j].setIcon(caseVide); //on remet en noir la case comme a l'origine

                }

            }
        }


    }

}

