public class Employe {
    private static int numEmploye=1;
    private int numero;
    private String nomEmploye;
    private String prenomEmploye;

    public Employe() {

       this.numero=numEmploye++;
    }

    public Employe( String nomEmploye, String prenomEmploye) {
        this.numero=numEmploye++;
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
    }


    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public String getPrenomEmploye() {
        return prenomEmploye;
    }



    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;

    }
    public int getNumEmploye() {
        return numero;
    }

    @Override
    public String toString() {
        return "Numéro de l'employé: " + getNumEmploye()+"\n"+
                "Nom de l'employé: " + getNomEmploye()+"\n"+
                "Prénom de l'employé: " + getPrenomEmploye()+"\n";
    }
}
