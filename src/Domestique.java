public enum Domestique {
    Cochon("le cochon"),
    Cheval("le cheval"),
    Chèvre("la chèvre"),
    Chien("le chien"),
    Âne("l'âne"),
    Lapin("le lapin"),
    Mouton("le mouton"),
    Poule("la poule"),
    Chat("le chat"),
    Oie("l'oie");
    String msg;

    Domestique(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
