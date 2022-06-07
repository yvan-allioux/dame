public class ModelJoueur {
    // ATTRIBUTS //
    private String pseudo;
    private int nbJetons;

    // CONSTRUCTEURS //
    public ModelJoueur(){
        pseudo ="pseudo";
        nbJetons = 0;
    }

    // MODIFICATEURS //
    public void setPseudo(String newPseudo){
        pseudo=newPseudo;
    }

    public void setNbJetons(int newJetons){
        nbJetons=newJetons;
    }

    // ACCESSEURS //
    public String getPseudo(){
        return pseudo;
    }

    public int getNbJetons(){
        return nbJetons;
    }

}
