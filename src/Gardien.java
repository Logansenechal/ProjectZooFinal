public class Gardien extends Employe{
    public Gardien(){}

    public Gardien(String nomEmploye, String prenomEmploye) {
        super(nomEmploye, prenomEmploye);
    }

    @Override
    public String toString() {
        return super.toString()+"-----------------------------------------------------------------";
    }
}
