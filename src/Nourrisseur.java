public class Nourrisseur extends Employe{
    // Définition des propriétés des nourrisseurs.
    private String nomZoneResponsable;
    private int numZoneResponsable;
    //CONSTRUCTEUR VIDE pour créer un nourrisseur sans propriétés.
    public Nourrisseur() {}
    // Constructeur pour créer des nourrisseurs avec leurs propriétés et les attributs de la classe mère.
    public Nourrisseur( String nomEmploye, String prenomEmploye,String nomZoneResponsable,int numZoneResponsable ) {
        super(nomEmploye,prenomEmploye);
        this.nomZoneResponsable = nomZoneResponsable;
        this.numZoneResponsable = numZoneResponsable;
    }
    // Getters et setters pour accéder et modifier les informations des nourrisseurs.

    public  String getNomZoneResponsable() {
        return nomZoneResponsable;
    }

    public void setNomZoneResponsable(String nomZoneResponsable) {
        this.nomZoneResponsable = nomZoneResponsable;
    }

    public int getNumZoneResponsable() {
        return numZoneResponsable;
    }

    public void setNumZoneResponsable(int numZoneResponsable) {
        this.numZoneResponsable = numZoneResponsable;
    }

    // Méthode toString qui ajoute les informations des nourrisseurs au toString de la classe mère.
    @Override
    public String toString() {
        return  super.toString()+"Nourrisseur responsable de la zone :" +getNomZoneResponsable()+getNumZoneResponsable()+"\n-----------------------------------------------------------------" ;
    }
}
