import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        ArrayList<Animal> arrayOfAnimal = new ArrayList<Animal>();
        ArrayList<Nourrisseur> arrayOfNourrisseur = new ArrayList<Nourrisseur>();
        ArrayList<Gardien> arrayOfGardien = new ArrayList<Gardien>();
        ArrayList<Aliment> arrayOfAliment = new ArrayList<Aliment>();
        ArrayList<Enclos> arrayOfEnclos = new ArrayList<Enclos>();
        //String enclos,nomAnimal,espece,Ddn,dateArrivee,isExotic,nomZone = null;
        //double quantiteAliment;
        //int frequenceRation;
        //boolean Exotic;
        Enclos enclos1 = new Enclos("Herbe", 2, 1, "Grande");
        Enclos enclos2 = new Enclos("Omni", 3, 2, "Moyenne");
        Enclos enclos3 = new Enclos("Carni", 2, 2, "Grande");
        Enclos enclos4 = new Enclos("Carni", 3, 3, "Petite");
        arrayOfEnclos.add(enclos1);
        arrayOfEnclos.add(enclos2);
        arrayOfEnclos.add(enclos3);
        arrayOfEnclos.add(enclos4);
        Animal animal1 = new Animal(true, "Léo", "Lion", 'M', 8, 2, "2004-05-13", "2022-03-11", "Omni", 3, 2);
        arrayOfAnimal.add(animal1);
        Animal animal2 = new Animal(true, "Nana", "Pantere", 'F', 8, 2, "2004-06-13", "2022-03-15", "Carni", 2, 2);
        arrayOfAnimal.add(animal2);
        Animal animal3 = new Animal(false, "Nono", "Pantere", 'M', 8, 2, "2004-06-13", "2022-03-15", "Carni", 3, 3);
        Nourrisseur employe1 = new Nourrisseur("bob", "bob", "Carni", 2);
        arrayOfNourrisseur.add(employe1);
        arrayOfAnimal.add(animal3);
        Nourrisseur employe2 = new Nourrisseur("fefe", "bette", "Omni", 3);
        Nourrisseur employe3 = new Nourrisseur("joe", "biden", "Herbe", 1);
        arrayOfNourrisseur.add(employe2);
        arrayOfNourrisseur.add(employe3);
        Aliment aliment1 = new Aliment("Viande", 1.5, "livre");
        arrayOfAliment.add(aliment1);

        boolean loop = true;
        while (loop) {
            System.out.println("""
                    ************************** info du zoo **************************
                    [1]: Ajouter un nouvel enclos
                    [2]: Ajouter un nouvel animal
                    [3]: Afficher tous les animaux de chacun des enclos;
                    [4]: Ajouter un nouvel employé
                    [5]: Afficher tout les employés
                    [6]: Afficher les animaux dont un nourrisseur est responsable
                    [7]: Ajouter des aliment dans l'inventaire
                    [8]: Afficher les aliments de l'inventaire
                    [9]: Quitter""");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    ajouterEnclos(arrayOfEnclos);
                    break;
                }
                case 2: {
                    ajouterAnimal(arrayOfAnimal);
                    break;
                }
                case 3: {
                    afficherAnimauxParEnclos(arrayOfEnclos, arrayOfAnimal);
                    break;
                }
                case 4: {
                    ajouterEmploye(arrayOfGardien, arrayOfNourrisseur);
                    break;
                }
                case 5: {
                    arrayOfNourrisseur.forEach((System.out::println));
                    arrayOfGardien.forEach((System.out::println));
                    break;
                }
                case 6: {
                    afficherAnimauxParNourrisseur(arrayOfNourrisseur, arrayOfAnimal);
                    break;
                }
                case 7: {
                    ajouterAliment(arrayOfAliment);
                    break;
                }
                case 8: {
                    System.out.println("************************** inventaire **************************");
                    arrayOfAliment.forEach(System.out::println);
                    break;
                }
                case 9: {
                    loop = false;
                    break;
                }
            }
        }

    }

    public static void afficherAnimauxParNourrisseur(ArrayList<Nourrisseur> nourrisseurs, ArrayList<Animal> animaux) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le numéro de l'employé qui s'occupe des animaux que vous souhaitez afficher :");
        int numEmploye = sc.nextInt();

        Nourrisseur employe = null;
        for (Nourrisseur nourrisseur : nourrisseurs) {
            if (nourrisseur.getNumEmploye() == numEmploye) {
                employe = nourrisseur;
                break;
            }
        }

        if (employe != null) {
            System.out.println("Animaux que doit nourrir l'employé " + employe.getNumEmploye() + " :");
            for (Animal animal : animaux) {
                if (animal.getNomZone().equals(employe.getNomZoneResponsable()) && animal.getNumZone() == employe.getNumZoneResponsable()) {
                    System.out.println(animal);
                }
            }
        } else {
            System.out.println("Aucun employé trouvé avec le numéro " + numEmploye);
        }
    }

    public static void afficherAnimauxParEnclos(ArrayList<Enclos> enclos, ArrayList<Animal> animaux) {


        for (Enclos enclo : enclos) {
            System.out.println(enclo);
            boolean animalTrouve = false;
            // Boucle for pour parcourir les animaux
            for (Animal animal : animaux) {
                // Si l'animal est dans le même enclos que le gardien
                if (animal.getNomZone().equals(enclo.getZoneName()) && animal.getNumZone() == (enclo.getZoneNum()) && animal.getNumEnclos() == enclo.getEnclosNum()) {
                    System.out.println(animal);
                    animalTrouve = true;
                }
            }

        if (!animalTrouve) {
            System.out.println("Enclos vide");
        }}}

        public static void ajouterAnimal (ArrayList < Animal > arrayOfAnimal) {
            String nomAnimal, isExotic, espece, Ddn, dateArrivee, nomZone = null;
            boolean i = true;
            boolean Exotic;
            char genre;
            double quantiteAliment;
            int frequenceRation, numZone, numEnclos;
            Scanner sc = new Scanner(System.in);
            String reponse;
            do {
                System.out.println("Quel est le nom de l'animal ?");
                nomAnimal = sc.next();
                System.out.println("L'animal est t'il exotique? (Oui/Non): ");
                isExotic = sc.next();
                if (isExotic.equalsIgnoreCase("oui")) Exotic = true;
                else Exotic = false;
                System.out.println("Entrez l'espèce de l'animal: ");
                espece = sc.next();


                System.out.println("Entrez le genre de l'animal (M/F) : ");
                genre = sc.next(".").charAt(0);

                System.out.println("Entrez la date de naissance de l'animal: ");
                Ddn = sc.next();

                System.out.println("Entrez la date d'arrivée de l'animal: ");
                dateArrivee = sc.next();
                System.out.println("Entrez la quantité d'aliment par repas que recevera l'animal: ");
                quantiteAliment = sc.nextDouble();
                System.out.println("Entrez le nombre de repas que l'animal recevera par jour: ");
                frequenceRation = sc.nextInt();
                System.out.println("Choissez le nom de la zone oû l'animal sera logé: \n[1] : Herbe \n[2] : Carni \n[3] : Omni");
                int choix = sc.nextInt();
                switch (choix) {
                    case 1 -> {
                        nomZone = "Herbe";
                    }
                    case 2 -> {
                        nomZone = "Carni";
                    }
                    case 3 -> {
                        nomZone = "Omni";
                    }
                }
                System.out.println("Entrez le numéro de la zone oû l'animal sera logé: ");
                numZone = sc.nextInt();

                System.out.println("Entrer le numéro de l'enclo oû l'animal sera logé: ");
                numEnclos = sc.nextInt();

                Animal animalAjout = new Animal(Exotic, nomAnimal, espece, genre, quantiteAliment, frequenceRation, Ddn, dateArrivee, nomZone, numZone, numEnclos);
                for (Animal animal : arrayOfAnimal) {
                    if (animal.getNom().equals(nomAnimal) && animal.getEspece().equals(espece)) {
                        i = false;
                        System.err.println("un animal de l'espèce " + espece + " au nom de " + nomAnimal + " existe déja");
                    }
                }
                if (i) {
                    arrayOfAnimal.add(animalAjout);
                    System.out.println("L'enclos " + nomZone + numZone + "." + numEnclos + " à été ajouté aux enclos");
                }

                System.out.println(animalAjout);
                System.out.println("Voulez-vous ajoutez un nouvel animal? (Oui/Non): ");
                reponse = sc.next();
            } while (!reponse.equalsIgnoreCase("NON"));
        }

        public static void ajouterEmploye
        (ArrayList < Gardien > arrayOfGardien, ArrayList < Nourrisseur > arrayOfNourrisseur){
            Scanner sc = new Scanner(System.in);
            String reponse;

            do {
                System.out.println("Entrer le nom du nouvel employé: ");
                String nomEmploye = sc.next();
                System.out.println("Entrer le prenom du nouvel employé: ");
                String prenomEmploye = sc.next();
                System.out.println("Quel type d'employé voulez-vous ajouter? (Gardien/Nourrisseur)");
                String typeEmploye = sc.next();

                if (Objects.equals(typeEmploye, "Nourrisseur")) {
                    System.out.println("Entrer le nom de la zone du zoo dont le nourrisseur sera responsable");
                    String nomZoneResponsable = sc.next();
                    System.out.println("Entrer le numéro de la zone du zoo dont le nourrisseur sera responsable");
                    int numZoneResponsable = sc.nextInt();
                    Nourrisseur nourrisseurAjout = new Nourrisseur(nomEmploye, prenomEmploye, nomZoneResponsable, numZoneResponsable);
                    arrayOfNourrisseur.add(nourrisseurAjout);
                }
                if (Objects.equals(typeEmploye, "Gardien")) {
                    Gardien gardienAjout = new Gardien(nomEmploye, prenomEmploye);
                    arrayOfGardien.add(gardienAjout);
                }

                System.out.println("Voulez vous ajouter un autre employé?");
                reponse = sc.next();
            } while (!reponse.equalsIgnoreCase("NON"));
        }

        public static void ajouterAliment (ArrayList < Aliment > aliments) {
            String mesure, type = null;
            Scanner sc = new Scanner(System.in);

            System.out.println("Quel type d'aliment voulez- ajouter?\n[1] : Viande\n[2] : Graine\n[3] : Foin\n[4] : Autre");
            int choix = sc.nextInt();
            switch (choix) {
                case 1 -> {
                    type = "Viande";
                }
                case 2 -> {
                    type = "Graine";
                }
                case 3 -> {
                    type = "Foin";
                }
                case 4 -> {
                    System.out.println("Veuillez spécifier le type d'aliment à ajouter: ");
                    type = sc.next();
                }
            }
            if (type.equals("Graine")) {
                mesure = "boisseau(x)";
            } else if (type.equals("Foin")) {
                mesure = "balle(s)";
            } else {
                mesure = "livre(s)";
            }
            System.out.println("Entrez la quantité de " + type + " en " + mesure + " à ajouter dans l'inventaire:");
            double quantiteAliment = sc.nextDouble();
            Aliment alimentAjout = new Aliment(type, quantiteAliment, mesure);
            boolean i = false;
            for (Aliment aliment : aliments) {
                if (aliment.getTypeAliment().equals(type)) {
                    i = true;
                    aliment.setStockAliment(aliment.getStockAliment() + quantiteAliment);
                }
            }
            if (!i) {
                aliments.add(alimentAjout);
            }
        }


        public static void ajouterEnclos (ArrayList < Enclos > enclos) {
            System.out.println("Choissez la zone ou sera situé le nouvel enclos: \n[1] : Herbe \n[2] : Carni \n[3] : Omni");
            Scanner sc = new Scanner(System.in);
            String nomZone = null;
            int numZone, numEnclos;
            int choix = sc.nextInt();
            switch (choix) {
                case 1 -> {
                    nomZone = "Herbe";
                }
                case 2 -> {
                    nomZone = "Carni";
                }
                case 3 -> {
                    nomZone = "Omni";
                }

            }
            ;
            System.out.println("Entrez le numéro de la zone oû le nouvel enclos sera situé: ");
            numZone = sc.nextInt();
            System.out.println("Entrer le numéro qui sera assigné à l'enclo : ");
            numEnclos = sc.nextInt();
            String taille = null;
            System.out.println("Quel est la taille du nouvel enclos: \n[1] : Petite \n[2] : Moyenne \n[3] : Grande");
            int choix2 = sc.nextInt();

            switch (choix2) {
                case 1 -> {
                    taille = "Petite";
                }
                case 2 -> {
                    taille = "Moyenne";
                }
                case 3 -> {
                    taille = "Grande";
                }
            }

            Enclos enclosAjout = new Enclos(nomZone, numZone, numEnclos, taille);
            boolean i = true;
            for (Enclos enclo : enclos) {
                if (enclo.Enclos().equals(nomZone + numZone + "." + numEnclos)) {
                    i = false;
                    System.err.println("L'enclos " + enclo.Enclos() + " existe déja ");

                }
            }
            if (i) {
                enclos.add(enclosAjout);
                System.out.println("L'enclos " + nomZone + numZone + "." + numEnclos + " à été ajouté aux enclos");
            }
        }
    }











