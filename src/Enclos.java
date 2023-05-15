public class Enclos {
    // Déclaration des propriétés qui seront utilisées dans le constructeur.
    private String zoneName;
    private int zoneNum;
    private int enclosNum;
    private tailleEnclos taille;
    private typeEnclos type;

    // CONSTRUCTEUR VIDE pour créer un enclos sans propriétés.
    public Enclos(){};

    // Constructeur pour créer un enclos avec l'aide de ses propriétés.
    public Enclos(String zoneName, int zoneNum, int enclosNum, tailleEnclos taille, typeEnclos type) {
        this.zoneName = zoneName;
        this.zoneNum = zoneNum;
        this.enclosNum=enclosNum;
        this.taille=taille;
        this.type = type;
    }

    // Setters et getters pour modifier et accéder aux informations des enclos.
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

    // Méthode qui retourne le nom complet de l'enclos.
    public String Enclos() {return getZoneName()+getZoneNum()+"."+getEnclosNum();}

    // Méthode toString qui affiche correctement les informations des enclos.
    @Override
    public String toString() {
        return "************************** "+Enclos()+" **************************\n"+
                getTailleEnclos()+getTypeEnclos()+"\n";
    }
}

