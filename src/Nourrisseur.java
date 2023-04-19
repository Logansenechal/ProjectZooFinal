public class Nourrisseur extends Employe{
    private String nomZoneResponsable;
    private int numZoneResponsable;

    public Nourrisseur() {}

    public Nourrisseur( String nomEmploye, String prenomEmploye,String nomZoneResponsable,int numZoneResponsable ) {
        super(nomEmploye,prenomEmploye);
        this.nomZoneResponsable = nomZoneResponsable;
        this.numZoneResponsable = numZoneResponsable;
    }


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

    @Override
    public String toString() {
        return  super.toString()+"Nourrisseur responsable de la zone :" +getNomZoneResponsable()+getNumZoneResponsable()+"\n-----------------------------------------------------------------" ;
    }
}
