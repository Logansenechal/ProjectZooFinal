public enum Exotique {
    Panthère("la panthère"),
    Hippopotame("l'hippopotame"),
    Lynx("le lynx"),
    Lion("le lion"),
    Jaguar("le jaguar"),
    Élephant("l'éléphant"),
    Chimpanze("le chimpanzé"),
    Kangourou("le kangourou"),
    Crocodile("le crocodile"),
    Léopart("le léopart");
    String msg;

    Exotique(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
