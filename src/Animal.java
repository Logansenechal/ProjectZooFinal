import java.util.Date;

public class Animal {

    private String type;
    private String nom;
    private char genre;
    private String espece;
    private String aliment;
    private double quantiteAliment;
    private int frequenceRation;
    private String Ddn;
    private  String dateArrivee;
    private String nomZone;
    private int numZone;
    private int numEnclos;
    private String lieuNaissance;
    private String groupeSocial;
    public Animal(){}

    public Animal(String type, String nom, String espece, char genre, String aliment, double quantiteAliment, int frequenceRation, String ddn, String dateArrivee, String nomZone, int numZone, int numEnclos, String lieuNaissance, String groupeSocial) {
        this.type = type;
        this.nom = nom.substring(0,1).toUpperCase()+nom.substring(1).toLowerCase();
        this.genre = genre;
        this.aliment = aliment;
        this.quantiteAliment = quantiteAliment;
        this.espece=espece.substring(0,1).toUpperCase()+espece.substring(1).toLowerCase();
        this.frequenceRation = frequenceRation;
        Ddn = ddn;
        this.dateArrivee = dateArrivee;
        this.nomZone = nomZone;
        this.numZone = numZone;
        this.numEnclos=numEnclos;
        this.lieuNaissance = lieuNaissance;
        this.groupeSocial = groupeSocial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public void setGroupeSocial(String groupeSocial) {
        this.groupeSocial = groupeSocial;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public String getGroupeSocial() {
        return groupeSocial;
    }

    public String getAliment() {
        return aliment;
    }

    public void setAliment(String aliment) {
        this.aliment = aliment;
    }


    public void setExotic(String type) {
        this.type=type;
        }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGenre() {
        String genreStr = null;
        if (genre=='m'){genreStr="Mâle";}
        else if (genre=='f') {genreStr="Femelle";}
        return genreStr;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public String getEspece() {
        return espece;
    }
    public String getEspeceMsg(){
        if (getType().equalsIgnoreCase("Domestique")){return (Domestique.valueOf(getEspece())).msg;}
        else return (Exotique.valueOf(getEspece())).msg;
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
        if (getAliment().equalsIgnoreCase("Viande")){typeNourriture="livre(s) de viandes";}
        else if (getAliment().equalsIgnoreCase("Foin")) {typeNourriture="balle(s) de foin";}
        else if (getAliment().equalsIgnoreCase("Graine")){typeNourriture="boisseau(x) de graine";}
        else typeNourriture="livre(s) de "+getAliment();
        return typeNourriture;

        }
    public int Age(){
      Date d=new Date();
        int year=d.getYear()+1900;
        String s= getDdn();
           int n=4;
        int length=s.length();
        return year-Integer.parseInt(s.substring(length -n, length));

    }

    @Override
    public String toString() {
        return getNom()+" "+getEspeceMsg()+"\n"+
                "Type :" + getType() + '\n' +
                "Genre :" + getGenre() + '\n'  +
                "Groupe social : "+getGroupeSocial()+'\n' +
                "Doit manger "+getQuantiteAliment()+" "+typeNourriture()+" "+ getFrequenceRation() + " fois par jour\n" +
                "Date de l'arrivé :" + getDateArrivee() +'\n' +
                "Lieu de naissance :"+getLieuNaissance()+'\n' +
                "Age :" + Age() +'\n'+
                "Enclos: "+ getNomZone()+getNumZone()+"."+getNumEnclos()+"\n"

                ;
    }
   }



