
public class Animal {

    private boolean isExotic;

    private String nom;

    private char genre;

    private String espece;


    private double quantiteAliment;

    private int frequenceRation;

    private String Ddn;

    private  String dateArrivee;

    private String nomZone;
    private int numZone;
    private int numEnclos;

    public Animal(){}

    public Animal(boolean isExotic, String nom, String espece, char genre, double quantiteAliment, int frequenceRation, String ddn, String dateArrivee, String nomZone, int numZone,int numEnclos) {
        this.isExotic = isExotic;
        this.nom = nom;
        this.genre = genre;

        this.quantiteAliment = quantiteAliment;
        this.espece=espece;
        this.frequenceRation = frequenceRation;
        Ddn = ddn;
        this.dateArrivee = dateArrivee;

        this.nomZone = nomZone;
        this.numZone = numZone;
        this.numEnclos=numEnclos;
    }

    public String GetIsExotic() {
        if (isExotic == true){return "exotique";}

        else return "domestique";
    }

    public void setExotic(boolean exotic) {
        isExotic=exotic;
        }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getNomZone() {
        return nomZone;
    }

    public void setNomZone(String nomZone) {
        this.nomZone = nomZone;
    }

    public int getNumZone() {
        return numZone;
    }

    public void setNumZone(int numZone) {
        this.numZone = numZone;
    }

    public int getNumEnclos() {
        return numEnclos;
    }

    public void setNumEnclos(int numEnclos) {
        this.numEnclos = numEnclos;
    }

    public double getQuantiteAliment() {
        return quantiteAliment;
    }

    public void setQuantiteAliment(double quantiteAliment) {
        this.quantiteAliment = quantiteAliment;
    }

    public int getFrequenceRation() {
        return frequenceRation;
    }

    public void setFrequenceRation(int frequenceRation) {
        this.frequenceRation = frequenceRation;
    }

    public String getDdn() {
        return Ddn;
    }

    public void setDdn(String ddn) {
        Ddn = ddn;
    }

    public String getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(String dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public String typeNourriture(){

        String typeNourriture = null;
        if (getNomZone()=="Carni"){typeNourriture="livre(s) de viandes";}
        else if (getNomZone().equals("Herbe")) {typeNourriture="balle(s) de foin";}
        else typeNourriture="livre(s) de fruits et de viandes";
        return typeNourriture;

        }

    @Override
    public String toString() {
        return "Nom de l'animal:"+getNom()+"\n"+
                "Espèce :" +getEspece()+'\n' +
                "Type :" + GetIsExotic() + '\n' +
                "Genre :" + getGenre() + '\n'  +
                "Doit manger "+getQuantiteAliment()+" "+typeNourriture()+" "+ getFrequenceRation() + " fois par jour\n" +
                "Date de l'arrivé :" + getDateArrivee() +'\n' +
                "Date de naissance :" + getDdn() +'\n'+
                "Enclos: "+ getNomZone()+getNumZone()+"."+getNumEnclos()+"\n"

                ;
    }
   }



