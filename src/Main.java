
import com.cp.utils.MyMethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

// Création des tableaux dynamiques pour stocker les objets
        ArrayList<Animal> arrayOfAnimal = new ArrayList<>();
        ArrayList<Nourrisseur> arrayOfNourrisseur = new ArrayList<>();
        ArrayList<Gardien> arrayOfGardien = new ArrayList<>();
        ArrayList<Aliment> arrayOfAliment = new ArrayList<>();
        ArrayList<Enclos> arrayOfEnclos = new ArrayList<>();

        readFile("listOfAnimals",arrayOfNourrisseur,arrayOfGardien,arrayOfAnimal,arrayOfAliment,arrayOfEnclos);
        readFile("listOfEmploye",arrayOfNourrisseur,arrayOfGardien,arrayOfAnimal,arrayOfAliment,arrayOfEnclos);
        readFile("listOfEnclos",arrayOfNourrisseur,arrayOfGardien,arrayOfAnimal,arrayOfAliment,arrayOfEnclos);
        readFile("listOfAliment",arrayOfNourrisseur,arrayOfGardien,arrayOfAnimal,arrayOfAliment,arrayOfEnclos);

        // Boucle while pour afficher le menu tant que l'utilisateur ne quitte pas.
        boolean loop = true;
        while (loop) {
            // Affichage du menu avec les différentes options disponibles.
            String message=("""
                    ************************** info du zoo **************************
                    [1]: Ajouter un nouvel enclos
                    [2]: Ajouter un nouvel animal
                    [3]: Afficher tous les animaux de chacun des enclos;
                    [4]: Ajouter un nouvel employé
                    [5]: Afficher tout les employés
                    [6]: Afficher les animaux dont un nourrisseur est responsable
                    [7]: Ajouter des aliment dans l'inventaire
                    [8]: Afficher les aliments de l'inventaire
                    [9]: Nourrir un animal
                    [10]:Modifier une propriété d'un animal
                    [11]:Quitter""");

            // Utilisation de la méthode readChoix() pour lire l'option sélectionnée par l'utilisateur.
            switch (MyMethods.readChoix(message, 1, 11)) {
                // Exécution de la méthode appropriée en fonction de l'option sélectionnée.
                case 1 -> ajouterEnclos(arrayOfEnclos);
                case 2 -> ajouterAnimal(arrayOfAnimal,arrayOfEnclos);
                case 3 -> afficherAnimauxParEnclos(arrayOfEnclos, arrayOfAnimal);
                case 4 -> ajouterEmploye(arrayOfGardien, arrayOfNourrisseur);
                case 5 -> afficherEmploye(arrayOfNourrisseur,arrayOfGardien);
                case 6 -> afficherAnimauxParNourrisseur(arrayOfNourrisseur, arrayOfAnimal);
                case 7 -> ajouterAliment(arrayOfAliment);
                case 8 -> afficherAliment( arrayOfAliment);
                case 9 -> nourrirAnimal(arrayOfAnimal, arrayOfAliment);
                case 10-> modifierAnimal(arrayOfAnimal,arrayOfEnclos);
                case 11 -> loop = false; // Sortie de la boucle while pour quitter le programme.

            }
            }
    }
    //Méthode qui permet d'afficher les animaux de chacun des enclos.
    public static void afficherAnimauxParNourrisseur(ArrayList<Nourrisseur> nourrisseurs, ArrayList<Animal> animaux) {
        Scanner sc = new Scanner(System.in);
        // Demande à l'utilisateur d'entrer le numéro de l'employé.
        System.out.println("Entrez le numéro de l'employé qui s'occupe des animaux que vous souhaitez afficher :");
        int numEmploye = sc.nextInt();

        Nourrisseur employe = null;// Initialisation de la variable employe.
        for (Nourrisseur nourrisseur : nourrisseurs) {
            // Si l'employé est trouvé dans la liste des nourrisseurs.
            if (nourrisseur.getNumEmploye() == numEmploye) {
                // Assigner l'employé à la variable employe.
                employe = nourrisseur;
                break; // Sortir de la boucle.
            }
        }
        // Si un employé est trouvé
        if (employe != null) {
            System.out.println("Animal(s) que doit nourrir l'employé " + employe.getNumEmploye() + " :");
            // Boucle pour parcourir tous les animaux.
            for (Animal animal : animaux) {
                // Si l'animal appartient à la zone dont l'employé est responsable.
                if (animal.getNomZone().equals(employe.getNomZoneResponsable()) && animal.getNumZone() == employe.getNumZoneResponsable()) {
                    System.out.println(animal);// Afficher l'animal.
                }
            }// Si aucun employé n'est trouvé, afficher un message d'erreur.
        } else {System.out.println("Aucun employé trouvé avec le numéro : " + numEmploye);}
    }

    public static void afficherAnimauxParEnclos(ArrayList<Enclos> enclos, ArrayList<Animal> animaux) {
        // Parcourt chaque enclos de la liste.
        boolean i=true;
        for (Enclos enclo : enclos) {
            i=false;
            // Affiche le détail de l'enclos.
            System.out.println(enclo);
            boolean animalTrouve = false;
            // Boucle for pour parcourir les animaux.
            for (Animal animal : animaux) {
                // Affiche l'animal s'il est situé dans cette enclos.
                if (animal.getNomZone().equals(enclo.getZoneName()) && animal.getNumZone() == (enclo.getZoneNum()) && animal.getNumEnclos() == enclo.getEnclosNum()) {
                    System.out.println(animal);
                    animalTrouve = true;
                }
            }

            // Si aucun animal n'est trouvé dans l'enclos, affiche "Enclos vide.".
            if (!animalTrouve) {
                System.out.println("Enclos vide.");
            }
        }
        if (i){
            System.err.println("Aucun enclos: Veuillez d'abord ajouter un enclos.");
        }
    }

        public static void ajouterAnimal (ArrayList < Animal > arrayOfAnimal,ArrayList <Enclos> arrayOfEnclos ) {
            // Déclaration des variables nécessaires pour créer un nouvel animal.
            String nomAnimal,espece = null, nomZone = null,especeMsg = null;;
            char genre = '\0';
            double quantiteAliment;
            int frequenceRation, numZone, numEnclos,especeInt;
            Scanner sc = new Scanner(System.in);
            Domestique[]domestiques=Domestique.values();
            Exotique[]exotiques=Exotique.values();
            String reponse = null;
            // Boucle do-while pour permettre d'ajouter plusieurs animaux.
            do {
                // Demande à l'utilisateur de choisir la zone où l'animal sera logé.
                String message=("Choissez le nom de la zone oû l'animal sera logé: \n[1] : Herbe \n[2] : Carni \n[3] : Omni");

                switch (MyMethods.readChoix(message,1,3)) {
                    case 1 -> nomZone = "Herbe";
                    case 2 -> nomZone = "Carni";
                    case 3 -> nomZone = "Omni";
                }
                System.out.println("Entrez le numéro de la zone oû l'animal sera logé : ");
                numZone = sc.nextInt();
                System.out.println("Entrer le numéro de l'enclo oû l'animal sera logé : ");
                numEnclos = sc.nextInt();
                boolean enclosExist=false;
                for (Enclos enclo:arrayOfEnclos)
                    if ((nomZone + numZone + "." + numEnclos).equals(enclo.getZoneName()+enclo.getZoneNum()+"."+enclo.getEnclosNum())) {
                        enclosExist = true;
                        break;
                    }
                if(!enclosExist){
                    System.err.println("Impossible d'ajouter l'animal à l'enclos: L'enclos est inexistant");
                    break;

                }
                // Demande de saisie du nom de l'animal.
                System.out.println("Entrez le nom de l'animal :");
                nomAnimal = sc.next();
                // Demande à l'utilisateur de choisir le type de l'animal.
                String msgExotic=("Selectionnez le type est l'animal :\n[1] : Exotique\n[2] : Domestique");
                String typeAnimal = null;
                switch (MyMethods.readChoix(msgExotic,1,2)){
                    // Si l'utilisateur choisit 1, le type de l'animal est Exotique.
                    case 1 -> typeAnimal = "Exotique";
                    // Si l'utilisateur choisit 2, le type de l'animal est Domestique.
                    case 2 -> typeAnimal = "Domestique";
                }

                // Demande de saisie de l'espèce de l'animal.
                System.out.println("Quel est l'espèce de l'animal ? ");
                if (typeAnimal.equalsIgnoreCase("Domestique")){
                    for (Domestique domest: domestiques){
                        System.out.println("["+ (domest.ordinal()+1)+"]: " + domest.name());}
                    System.out.print("Entrez son choix:  ");
                    especeInt= sc.nextInt();
                    espece =domestiques[especeInt-1].name();
                }
                else{
                    for (Exotique exot: exotiques){
                    System.out.println("["+ (exot.ordinal()+1)+"]: "+ exot.name() );
                    }System.out.print("Entrez son choix:  ");
                    especeInt= sc.nextInt();
                    espece =exotiques[especeInt-1].name();
                }

                if(typeAnimal.equalsIgnoreCase("Domestique")){especeMsg=Domestique.valueOf(espece).getMsg();}
                else{especeMsg=Exotique.valueOf(espece).getMsg();}
                // Demande de saisie du genre de l'animal (M ou F).
                do {
                    System.out.println("Entrez le genre de l'animal (M/F) : ");
                    try {
                        genre = Character.toLowerCase(sc.next(".").charAt(0));
                        if (genre != 'm' && genre != 'f') {
                            throw new IllegalArgumentException("Veuillez entrer un genre valide : " + genre);
                        }
                    } catch (Exception e) {
                        System.err.println("Erreur : Veuillez entrer un genre valide." );
                        sc.nextLine();
                    }
                } while (genre != 'm' && genre != 'f');

                // Demande de saisie du groupe social de l'animal.
                System.out.println("Entrez le groupe social de l'animal : ");
                String groupeSocial= sc.next();

                // Demande de saisie du lieu de naissance de l'animal.
                System.out.println("Entrez le lieu de naissance de l'animal :");
                String lieuNaissance = sc.next();

                // Demande de saisie de la date de naissance de l'animal.
                String msgDdn=("Entrez la date de naissance de l'animal (jj/mm/aaaa) : ");
                Date Ddn= (MyMethods.readDate(msgDdn));
                // Demande de saisie de la date d'arrivée de l'animal.

                String msgArrive=("Entrer la date d'arrivée de l'animal (jj/mm/aaaa) : ");
                Date dateArrive = MyMethods.readDate(msgArrive);

                // Demande de saisie du type d'aliment qui sera utilisé pour nourrir l'animal.
                String aliment = null;
                String msgAliment=("Entrer l'aliment qui sera principalement servi à l'animal\n[1] : Viande\n[2] : Graine\n[3] : Foin\n[4] : Autre ");
                switch (MyMethods.readChoix(msgAliment,1,4)) {
                    case 1 -> aliment = "Viande";
                    case 2 -> aliment = "Graine";
                    case 3 -> aliment = "Foin";
                    case 4 -> {
                        System.out.println("Veuillez spécifier le type d'aliment qui sera servi à l'animal : ");
                        aliment = sc.next();}}

                // Demande de saisi de la quantité d'aliment et de la fréquence de ration pour l'animal.
                String msgQte=("Entrez la quantité de "+aliment + " que recevera l'animal par repas : ");
                quantiteAliment = MyMethods.readDouble(msgQte);
                System.out.println("Entrez le nombre de repas que l'animal recevera par jour : ");
                frequenceRation = sc.nextInt();


                // Création d'un objet Animal avec les informations saisies par l'utilisateur.
                Animal animalAjout = new Animal(typeAnimal, nomAnimal, espece, genre, aliment, quantiteAliment, frequenceRation, Ddn.toString(), dateArrive.toString() , nomZone, numZone, numEnclos, lieuNaissance, groupeSocial);

                // Vérifie si un animal avec le même nom et la même espèce existe déjà.
                boolean animalExiste = false;
                for (Animal animal : arrayOfAnimal) {

                    // Si un animal de la même espèce porte le même nom, on affiche un message d'erreur.
                    if (animal.getNom().equalsIgnoreCase(nomAnimal) && animal.getEspece().equalsIgnoreCase(espece)) {
                        animalExiste = true;

                        System.err.println( nomAnimal + especeMsg +" existe déja");
                        break;
                    }
                }
                // Si aucun animal de la même espèce porte le même nom, on ajoute l'animal à la liste.
                if (!animalExiste) {
                    arrayOfAnimal.add(animalAjout);
                    System.out.println( nomAnimal +" "+especeMsg+  " à été ajouté à l'enclos " + nomZone+ numZone+"."+numEnclos);
                    System.out.println(animalAjout);}
                // Demande à l'utilisateur s'il veut ajouter un nouvel animal.
                System.out.println("Voulez-vous ajoutez un nouvel animal? (O/N) : ");
                reponse = sc.next();

            } while (!reponse.equalsIgnoreCase("N"));// Si l'utilisateur repond "N" la boucle s'arrête.
        }
        // Méthode qui permet de nourrir un animal en vérifiant si le stock d'aliment est suffisant.
        public static void nourrirAnimal(ArrayList<Animal> animaux, ArrayList<Aliment> aliments){
            // On crée un Scanner pour permettre à l'utilisateur d'entrer le nom et l'espèce de l'animal à nourrir.
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrer le nom de l'animal à nourrir : ");
            String nomAnimal=sc.next();
            System.out.println("Entrer l'espèce de l'animal à nourrir : ");
            String especeAnimal=sc.next();

            // On initialise une variable booléenne i à false pour vérifier si l'animal existe dans la liste des animaux.
            boolean i=false;
            // On parcourt la liste des animaux pour trouver l'animal correspondant au nom et à l'espèce entrés par l'utilisateur.
            for (Animal animal : animaux){
                if (nomAnimal.equalsIgnoreCase(animal.getNom()) && especeAnimal.equalsIgnoreCase(animal.getEspece())){
                    i = true;

                    // Si l'animal est trouvé, on parcourt la liste des aliments pour trouver l'aliment correspondant à l'aliment que l'animal mange.
                    for (Aliment aliment:aliments){
                        if (animal.getAliment().equalsIgnoreCase(aliment.getTypeAliment())){

                            // Si la quantité d'aliment nécessaire pour nourrir l'animal est supérieure à la quantité d'aliment en stock, on affiche un message d'erreur et on arrête la méthode.
                            if (animal.getQuantiteAliment() > aliment.getStockAliment()){
                                System.err.println("Stock insuffisant pour nourrir l'animal");
                                return;}

                            // Sinon, on met à jour le stock d'aliment et on affiche un message pour indiquer que l'animal a été nourri.
                            else {aliment.setStockAliment(aliment.getStockAliment()-animal.getQuantiteAliment());
                                System.out.println("l'animal "+nomAnimal +" à été nourri.");}
                        }
                    }
                }
            }
            // Si l'animal n'a pas été trouvé dans la liste des animaux, on affiche un message d'erreur.
            if (!i){
                System.err.println("L'animal nommé "+nomAnimal+" de l'espece "+especeAnimal+" n'existe pas");
        }
    }
        // Méthode qui permet d'ajouter les employés.
        public static void ajouterEmploye(ArrayList < Gardien > arrayOfGardien, ArrayList < Nourrisseur > arrayOfNourrisseur){
            Scanner sc = new Scanner(System.in);
            String reponse;

            do {
                // Demander le nom de l'employé
                System.out.println("Entrer le nom du nouvel employé: ");
                String nomEmploye = sc.next();

                // Demander le prénom de l'employé
                System.out.println("Entrer le prenom du nouvel employé: ");
                String prenomEmploye = sc.next();

                // Afficher les choix pour le type d'employé à ajouter
                String message=("Quel type d'employé voulez-vous ajouter?\n[1] : Gardien\n[2] : Nourrisseur");
                String typeEmploye = null;

                // Lire le choix de l'utilisateur en appelant la méthode readChoix
                int choix=MyMethods.readChoix(message,1,2);

                // Utiliser le choix pour initialiser le type d'employé
                switch (choix){
                    case 1:{typeEmploye="Gardien";}
                    case 2:{typeEmploye="Nourrisseur";}
                }

                // Si l'employé à ajouter est un nourrisseur
                if (typeEmploye.equals("Nourrisseur")) {
                    // Demander le nom de la zone dont le nourrisseur sera responsable
                    System.out.println("Entrer le nom de la zone du zoo dont le nourrisseur sera responsable");
                    String nomZoneResponsable = sc.next();

                    // Demander le numéro de la zone dont le nourrisseur sera responsable
                    System.out.println("Entrer le numéro de la zone du zoo dont le nourrisseur sera responsable");
                    int numZoneResponsable = sc.nextInt();

                    // Créer un nouvel objet nourrisseur avec les informations entrées par l'utilisateur.
                    Nourrisseur nourrisseurAjout = new Nourrisseur(nomEmploye, prenomEmploye, nomZoneResponsable, numZoneResponsable);
                    arrayOfNourrisseur.add(nourrisseurAjout);// Ajouter le nourrisseur au tableau dynamique des nourrisseur.
                }
                // Si l'employé à ajouter est un gardien
                else if (typeEmploye.equals("Gardien")) {
                    // Créer un nouvel objet gardien avec les informations entrées par l'utilisateur
                    Gardien gardienAjout = new Gardien(nomEmploye, prenomEmploye);
                    // Ajouter le gardien à la liste des gardiens
                    arrayOfGardien.add(gardienAjout);
                    // Afficher le gardien ajouté
                    System.out.println(gardienAjout);
                }
                // Demander à l'utilisateur s'il veut ajouter un autre employé
                System.out.println("Voulez vous ajouter un autre employé? (O/N)");
                reponse = sc.next();
            } while (!reponse.equalsIgnoreCase("N"));// Si l'utilisateur repond "N" la boucle s'arrête.
        }
        // Méthode qui affiche tous les employés du zoo.
        public static void afficherEmploye(ArrayList <Nourrisseur> arrayOfNourrisseur,ArrayList <Gardien> arrayOfGardien){
            // Affiche tous les nourrisseurs.
            System.out.println("************************** Nourrisseur **************************");
            arrayOfNourrisseur.forEach((System.out::println));
            if (arrayOfNourrisseur.size()==0){
                System.out.println("                          -Aucun nourrisseur-                        ");
            }
            // Affiche tous les gardiens.
            System.out.println("**************************   Gardien   **************************");
            arrayOfGardien.forEach((System.out::println));
            if (arrayOfGardien.size()==0){
                System.out.println("                          -Aucun gardien-                        ");
            }
    }

        //Méthode qui permet d'ajouter des aliments dans l'inventaire.
        public static void ajouterAliment (ArrayList < Aliment > aliments) {
            String mesure, type = null;
            Scanner sc = new Scanner(System.in);

            // On demande à l'utilisateur le type d'aliment à ajouter.
            String message=("Quel type d'aliment voulez-vous ajouter?\n[1] : Viande\n[2] : Graine\n[3] : Foin\n[4] : Autre");

            // On utilise la fonction readChoix() pour s'assurer que l'utilisateur choisit une option valide.
            switch (MyMethods.readChoix(message,1,4)) {
                case 1 -> type = "Viande";
                case 2 -> type = "Graine";
                case 3 -> type = "Foin";
                case 4 -> {System.out.println("Veuillez spécifier le type d'aliment à ajouter: ");
                    type = sc.next();}
            }

            // On détermine l'unité de mesure de la quantité de l'aliment en fonction de son type.
            if (type.equals("Graine")) {mesure = "boisseau(x)";}
            else if (type.equals("Foin")) {mesure = "balle(s)";}
            else {mesure = "livre(s)";}

            // On demande à l'utilisateur la quantité de l'aliment à ajouter et on crée un objet Aliment correspondant.
            String msgQte=("Entrez la quantité de " + type + " en " + mesure + " à ajouter dans l'inventaire:");
            double quantiteAliment = MyMethods.readDouble(msgQte);
            Aliment alimentAjout = new Aliment(type, quantiteAliment, mesure);

            // On vérifie si l'aliment existe déjà dans l'inventaire et on met à jour sa quantité.
            boolean i = false;
            for (Aliment aliment : aliments) {
                if (aliment.getTypeAliment().equals(type)) {
                    i = true;
                    aliment.setStockAliment(aliment.getStockAliment() + quantiteAliment);
                }
            }// Si l'aliment n'existe pas dans l'inventaire, on l'ajoute à l'inventaire.
            if (!i) {aliments.add(alimentAjout);}
        }

        // Méthode qui permet d'afficher les aliments de l'inventaire.
        public static void afficherAliment(ArrayList < Aliment > arrayOfAliment){
            System.out.println("************************** inventaire **************************");
            // Affiche les aliments de l'inventaire.
            arrayOfAliment.forEach(System.out::println);
            if (arrayOfAliment.size()==0){
            System.out.println("                        -Inventaire vide-                        ");
            }
            }
        //Méthode qui permet d'ajouter un nouvel enclos.
        public static void ajouterEnclos (ArrayList < Enclos > enclos) {
            // On demande à l'utilisateur de choisir la zone où sera situé le nouvel enclos.
            String message=("Choissez la zone ou sera situé le nouvel enclos: \n[1] : Herbe \n[2] : Carni \n[3] : Omni");
            Scanner sc = new Scanner(System.in);
            String nomZone = null;
            int numZone, numEnclos;
            int choix = MyMethods.readChoix(message,1,3);
            switch (choix) {
                case 1 -> nomZone = "Herbe";
                case 2 -> nomZone = "Carni";
                case 3 -> nomZone = "Omni";

            }
            // Demande à l'utilisateur d'entrer le numéro de la zone et le numéro de l'enclos.
            System.out.println("Entrez le numéro de la zone oû le nouvel enclos sera situé: ");
            numZone = sc.nextInt();
            System.out.println("Entrer le numéro qui sera assigné à l'enclo : ");
            numEnclos = sc.nextInt();
            tailleEnclos taille = null;

            // Demande à l'utilisateur de choisir la taille.
            String message2=("Quel est la taille du nouvel enclos: \n[1] : Petite \n[2] : Moyenne \n[3] : Grande");


            switch (MyMethods.readChoix(message2,1,3)) {
                case 1 -> taille = tailleEnclos.Petite;
                case 2 -> taille = tailleEnclos.Moyenne;
                case 3 -> taille = tailleEnclos.Grande;
            }
            // On demande à l'utilisateur de choisir le type de l'enclos.
            String message3=("Quel est le type du nouvel enclos: \n[1] : Confinement à barreaux\n[2] : Confinement sans barreaux\n[3] : Enclos ouvert (protégé par des douves)");
            typeEnclos typeEnclos = null;
            switch (MyMethods.readChoix(message3,1,3)) {
                case 1 -> typeEnclos = typeEnclos.ConfinementBarreaux;
                case 2 -> typeEnclos = typeEnclos.Confinement;
                case 3 -> typeEnclos = typeEnclos.Ouvert;
            }
            // On crée un nouvel enclos avec les informations fournies par l'utilisateur.
            Enclos enclosAjout = new Enclos(nomZone, numZone, numEnclos, taille, typeEnclos);

            // On vérifie si l'enclos existe déjà
            boolean i = true;
            for (Enclos enclo : enclos) {
                if (enclo.Enclos().equals(nomZone + numZone + "." + numEnclos)) {
                    i = false;
                    System.err.println("L'enclos " + enclo.Enclos() + " existe déja ");//Si l'enclos existe déja, on affiche un message d'erreur.
                }
            }
            // Si l'enclos n'existe pas encore, on l'ajoute à la liste d'enclos
            if (i) {
                enclos.add(enclosAjout);
                System.out.println("L'enclos " + nomZone + numZone + "." + numEnclos + " à été ajouté aux enclos");
            }
        }

    public static void readFile(String file,ArrayList Nourrisseur,ArrayList Gardien,ArrayList Animal,ArrayList Aliment,ArrayList Enclos){try {
        File myFile=new File(file);
        Scanner myReader=new Scanner(myFile);
        char genre;
        while(myReader.hasNextLine()){
            String data = myReader.nextLine();
            String [] splitData= data.split(",",0);
            if(file.equalsIgnoreCase("listOfEmploye")&& splitData.length==4){
               Nourrisseur.add(new Nourrisseur(splitData[0],splitData[1],splitData[2],Integer.parseInt(splitData[3])));}
            if(file.equalsIgnoreCase("listOfEmploye") && splitData.length==2){
                Gardien.add(new Gardien(splitData[0],splitData[1]));}
            if(file.equalsIgnoreCase("listOfAnimals")){if (splitData[3].equalsIgnoreCase("M")){genre='m';} else {genre='f';}
                Animal.add(new Animal(splitData[0],splitData[1],splitData[2],genre,splitData[4], Double.parseDouble(splitData[5]),Integer.parseInt(splitData[6]),splitData[7],splitData[8],splitData[9],Integer.parseInt(splitData[10]),Integer.parseInt(splitData[11]),splitData[12],splitData[13]));}
            if(file.equalsIgnoreCase("listOfAliment")){
                Aliment.add(new Aliment(splitData[0],Double.parseDouble(splitData[1]),splitData[2]));}
            if(file.equalsIgnoreCase("listOfEnclos")){
                Enclos.add(new Enclos(splitData[0],Integer.parseInt(splitData[1]),Integer.parseInt(splitData[2]),tailleEnclos.valueOf(splitData[3]),typeEnclos.valueOf(splitData[4]) ));
            }
        }

        myReader.close();
    }catch (FileNotFoundException e){
        System.err.println("Une erreur est survenue: "+e);
        e.printStackTrace();
    }}
    public static void modifierAnimal(ArrayList <Animal> arrayOfAnimal,ArrayList <Enclos> arrayOfEnclos){
        Scanner sc= new Scanner(System.in);
        Domestique[]domestiques=Domestique.values();
        Exotique[]exotiques=Exotique.values();
        System.out.println("Quel animal voulez-vous modifier:");
        int i=1;
        String msg;
        for(Animal animal : arrayOfAnimal){
            if(animal.getType().equalsIgnoreCase("Domestique")){msg=Domestique.valueOf(animal.getEspece()).getMsg();}
            else{msg=Exotique.valueOf(animal.getEspece()).getMsg();}
            System.out.println("["+i+"]: "+animal.getNom()+" "+msg);
            i++;
        }int animalInt;

        animalInt=MyMethods.readChoix("Entrez votre choix : ",1,arrayOfAnimal.size());
        String message="Choisissez la propriété de l'animal que vous voulez modifier\n[1]: Nom\n[2]: Type\n[3]: Espèce \n[4]: Genre\n[5]: Alimentation\n[6]: Date de naissance\n[7]: Date d'arrivé\n[8]: Lieu de naissance\n[9]: Groupe social\n[10]: Enclos";
        switch(MyMethods.readChoix(message,1,10)){
            case 1-> {
                System.out.println("Entrez le nouveau nom de l'animal:");
                String newName= sc.next();
                arrayOfAnimal.get(animalInt-1).setNom(newName);
                System.out.println("Le nom de l'animal a été modifier pour "+newName);
            }
            case 2->{
                String msgExotic=("Selectionnez le type est l'animal :\n[1] : Exotique\n[2] : Domestique");
                String typeAnimal = null;
                switch (MyMethods.readChoix(msgExotic,1,2)){
                    // Si l'utilisateur choisit 1, le type de l'animal est Exotique.
                    case 1 -> typeAnimal = "Exotique";
                    // Si l'utilisateur choisit 2, le type de l'animal est Domestique.
                    case 2 -> typeAnimal = "Domestique";}
                    arrayOfAnimal.get(animalInt-1).setType(typeAnimal);
                System.out.println("Le type de l'animal a été modifier.");
                }
            case 3->{
                String espece;
                
                System.out.println("Quel est l'espèce de l'animal ? ");
                if (arrayOfAnimal.get(animalInt-1).getType().equalsIgnoreCase("Domestique")){
                    for (Domestique domest: domestiques){
                        System.out.println("["+ (domest.ordinal()+1)+"]: " + domest.name());}
                    System.out.print("Entrez son choix:  ");
                    int especeInt= sc.nextInt();
                    espece =domestiques[especeInt-1].name();
                }
                else{
                    for (Exotique exot: exotiques){
                        System.out.println("["+ (exot.ordinal()+1)+"]: "+ exot.name() );
                    }System.out.print("Entrez son choix:  ");
                    int especeInt= sc.nextInt();
                    espece =exotiques[especeInt-1].name();
                }
                if(arrayOfAnimal.get(animalInt-1).getType().equalsIgnoreCase("Domestique")){arrayOfAnimal.get(animalInt-1).setEspece(Domestique.valueOf(espece).getMsg());}
                else{arrayOfAnimal.get(animalInt-1).setEspece(Exotique.valueOf(espece).getMsg());}
                System.out.println("L'espèce de l'animal a été modifier.");}
            case 4->{
                char genre = 0;
                do {
                System.out.println("Entrez le genre de l'animal (M/F) : ");
                try {
                    genre = Character.toLowerCase(sc.next(".").charAt(0));
                    if (genre != 'm' && genre != 'f') {
                        throw new IllegalArgumentException("Veuillez entrer un genre valide : " + genre);
                    }
                } catch (Exception e) {
                    System.err.println("Erreur : Veuillez entrer un genre valide." );
                    sc.nextLine();
                }
            } while (genre != 'm' && genre != 'f');
            arrayOfAnimal.get(animalInt-1).setGenre(genre);
                System.out.println("Le genre de l'animal a été modifier.");}
            case 5->{
                String aliment = null;
                String msgAliment=("Entrer l'aliment qui sera principalement servi à l'animal\n[1] : Viande\n[2] : Graine\n[3] : Foin\n[4] : Autre ");
                switch (MyMethods.readChoix(msgAliment,1,4)) {
                    case 1 -> aliment = "Viande";
                    case 2 -> aliment = "Graine";
                    case 3 -> aliment = "Foin";
                    case 4 -> {
                        System.out.println("Veuillez spécifier le type d'aliment qui sera servi à l'animal : ");
                        aliment = sc.next();}}
                arrayOfAnimal.get(animalInt-1).setAliment(aliment);
                // Demande de saisi de la quantité d'aliment et de la fréquence de ration pour l'animal.
                String msgQte=("Entrez la quantité de "+aliment + " que recevera l'animal par repas : ");
                arrayOfAnimal.get(animalInt-1).setQuantiteAliment(MyMethods.readDouble(msgQte));
                String msgFreq=("Entrez le nombre de repas que l'animal recevera par jour : ");
                arrayOfAnimal.get(animalInt-1).setFrequenceRation(MyMethods.readChoix(msgFreq,1,6));
                System.out.println("Le rationnement de l'animal a été modifier.");;
            }
            case 6->{String msgDdn=("Entrez la date de naissance de l'animal (jj/mm/aaaa) : ");
                Date Ddn= (MyMethods.readDate(msgDdn));
                arrayOfAnimal.get(animalInt-1).setDdn(String.valueOf(Ddn));
                System.out.println("La date de naissance de l'animal a été modifier.");}

            case 7->{String msgArrive=("Entrer la date d'arrivée de l'animal (jj/mm/aaaa) : ");
                Date dateArrive = MyMethods.readDate(msgArrive);
                arrayOfAnimal.get(animalInt-1).setDateArrivee(String.valueOf(dateArrive));
                System.out.println("La date d'arrivé de l'animal a été modifier.");}
            case 8->{
                // Demande de saisie du lieu de naissance de l'animal.
                System.out.println("Entrez le lieu de naissance de l'animal :");
                String lieuNaissance = sc.next();
                arrayOfAnimal.get(animalInt-1).setLieuNaissance(lieuNaissance);
                System.out.println("Le lieu de naissance de l'animal a été modifier.");}
            case 9->{
                // Demande de saisie du groupe social de l'animal.
                System.out.println("Entrez le groupe social de l'animal : ");
                String groupeSocial= sc.next();
                arrayOfAnimal.get(animalInt-1).setGroupeSocial(groupeSocial);
                System.out.println("Le groupe social de l'animal a été modifier.");}
            case 10->{
                // Demande à l'utilisateur de choisir la zone où l'animal sera logé.
                String msgZone=("Choissez le nom de la zone oû l'animal sera logé: \n[1] : Herbe \n[2] : Carni \n[3] : Omni");
                String nomZone = null;

                switch (MyMethods.readChoix(msgZone,1,3)) {
                    case 1 -> nomZone = "Herbe";
                    case 2 -> nomZone = "Carni";
                    case 3 -> nomZone = "Omni";
                }

                int numZone = MyMethods.readChoix("Entrez le numéro de la zone oû l'animal sera logé : ",1,50);

                int numEnclos = MyMethods.readChoix("Entrer le numéro de l'enclo oû l'animal sera logé : ",1,100);
                boolean enclosExist=false;
                for (Enclos enclo: arrayOfEnclos)
                    if ((nomZone + numZone + "." + numEnclos).equals(enclo.getZoneName()+enclo.getZoneNum()+"."+enclo.getEnclosNum())) {
                        enclosExist = true;
                        break;
                    }
                if(!enclosExist){
                    System.err.println("Impossible d'ajouter l'animal à l'enclos: L'enclos est inexistant");
                    break;

                }

                arrayOfAnimal.get(animalInt-1).setNomZone(nomZone);
                arrayOfAnimal.get(animalInt-1).setNumZone(numZone);
                arrayOfAnimal.get(animalInt-1).setNumEnclos(numEnclos);
                System.out.println("L'enclos de "+arrayOfAnimal.get(animalInt-1).getNom()+" à été modifier pour l'enclos : "+arrayOfAnimal.get(animalInt-1).getNomZone()+arrayOfAnimal.get(animalInt-1).getNumZone()+"."+arrayOfAnimal.get(animalInt-1).getNumEnclos());}
            }
        }
}













