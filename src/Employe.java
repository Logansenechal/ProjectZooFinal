public class Employe {
    // variable statique qui représente le numéro d'employé, initialisée à 1
    private static int numEmploye=1;
    // Création des propriétés qui seront utilisées dans le constructeur.

    private int numero;
    private String nomEmploye;
    private String prenomEmploye;

    //CONSTRUCTEUR VIDE pour les employés ayant aucune propriété.
    public Employe() {
// affecter le numéro d'employé actuel et incrémenter la variable statique pour le prochain employé
       this.numero=numEmploye++;
    }
    // Constructeur pour la création d'employé à l'aide de leurs propriétés.
    public Employe( String nomEmploye, String prenomEmploye) {
        // affecter le numéro d'employé actuel et incrémenter la variable statique pour le prochain employé
        this.numero=numEmploye++;
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
    }
    // Getters et setters pour modifier ou accéder aux informations des employés.
    public String getNomEmploye() {
        return nomEmploye;
    }
    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }
    public String getPrenomEmploye() {
        return prenomEmploye;
    }
    public void setPrenomEmploye(String prenomEmploye) {this.prenomEmploye = prenomEmploye;}
    public int getNumEmploye() {
        return numero;
    }

    // Méthode toString qui affiche correctement les informations des employés.
    @Override
    public String toString() {
        return "Numéro de l'employé: " + getNumEmploye()+"\n"+
                "Nom de l'employé: " + getNomEmploye()+"\n"+
                "Prénom de l'employé: " + getPrenomEmploye()+"\n";
    }
}
