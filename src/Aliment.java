public class Aliment {

    private String typeAliment;
    private double stockAliment;

    private String mesureAliment;

    public Aliment(String typeAliment, double stockAliment, String mesureAliment) {
        this.typeAliment = typeAliment;
        this.stockAliment = stockAliment;
        this.mesureAliment = mesureAliment;
    }

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

    @Override
    public String toString() {
        return getTypeAliment()+" : "+getStockAliment()+" "+getMesureAliment();
    }
}
