public class Gardien extends Employe{
    // CONSTRUCTEUR VIDE pour créer un gardien sans propriétés.
    public Gardien(){}
    // Constructeur pour créer un gardien avec les propriétés passées de la classe mère.
    public Gardien(String nomEmploye, String prenomEmploye) {
        super(nomEmploye, prenomEmploye);
    }

    // Méthode toString qui utilise le toString de la classe mère.
    @Override
    public String toString() {
        return super.toString()+"-----------------------------------------------------------------";
    }
}
