import java.util.ArrayList;

public class Enclos {
    private String zoneName;
    private int zoneNum;

    private int enclosNum;

    private String tailleEnclos;


    public Enclos(String zoneName, int zoneNum,int enclosNum, String tailleEnclos) {
        this.zoneName = zoneName;
        this.zoneNum = zoneNum;
        this.enclosNum=enclosNum;
        this.tailleEnclos=tailleEnclos;
    }



    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public int getZoneNum() {
        return zoneNum;
    }

    public void setZoneNum(int zoneNum) {
        this.zoneNum = zoneNum;
    }

    public String getTailleEnclos() {
        return tailleEnclos;
    }

    public void setTailleEnclos(String tailleEnclos) {
        this.tailleEnclos = tailleEnclos;
    }

    public int getEnclosNum() {
        return enclosNum;
    }

    public void setEnclosNum(int enclosNum) {
        this.enclosNum = enclosNum;
    }

    public String Enclos() {return getZoneName()+getZoneNum()+"."+getEnclosNum();}

    @Override
    public String toString() {
        return "************************** "+Enclos()+" **************************\n"+
                "Taille de l'enclos: " + tailleEnclos+"\n"
                ;
    }
}

