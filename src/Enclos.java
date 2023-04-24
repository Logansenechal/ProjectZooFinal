public class Enclos {
    private String zoneName;
    private int zoneNum;
    private int enclosNum;
    private tailleEnclos taille;
    private typeEnclos type;

    public Enclos(String zoneName, int zoneNum, int enclosNum, tailleEnclos taille, typeEnclos type) {
        this.zoneName = zoneName;
        this.zoneNum = zoneNum;
        this.enclosNum=enclosNum;
        this.taille=taille;
        this.type = type;
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
        return taille.msg;
    }

    public String getTypeEnclos() {return type.msg;}

    public void setTypeEnclos(typeEnclos type) {this.type = type;}

    public void setTailleEnclos(tailleEnclos taille) {
        this.taille = taille;
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
                getTailleEnclos()+getTypeEnclos()+"\n";
    }
}

