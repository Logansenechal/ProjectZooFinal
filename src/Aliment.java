public class Aliment {
    // Déclaration des variables qui seront utilisés pour gérer les aliments de l'inventaire.
    private String typeAliment;
    private double stockAliment;

    private String mesureAliment;

    // CONSTRUCTEUR VIDE
    public Aliment(){};

    // Contructeur pour initialiser les aliments lors de leur création.
    public Aliment(String typeAliment, double stockAliment, String mesureAliment) {
        this.typeAliment = typeAliment;
        this.stockAliment = stockAliment;
        this.mesureAliment = mesureAliment;
    }
    // Getters et setters pour modifier et accéder aux propriétés des aliments.
    public String getTypeAliment() {
        return typeAliment;
    }

    public void setTypeAliment(String typeAliment) {
        this.typeAliment = typeAliment;
    }

    public double getStockAliment() {
        return stockAliment;
    }

    public void setStockAliment(double stockAliment) {
        this.stockAliment = stockAliment;
    }

    public String getMesureAliment() {
        return mesureAliment;
    }

    public void setMesureAliment(String mesureAliment) {
        this.mesureAliment = mesureAliment;
    }

    // Méthode toString pour afficher correctement les aliments.
    @Override
    public String toString() {
        return getTypeAliment()+" : "+getStockAliment()+" "+getMesureAliment();
    }
}
