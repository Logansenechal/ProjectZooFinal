package com.cp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class MyMethods {
    //Méthode qui lit et retourne un choix entier compris entre un minimum et un maximum donnés.
    public static int readChoix(String message,int min,int max) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());// Lit l'entrée de l'utilisateur et la convertit en entier
                if (result >= min && result <= max) {// Vérifie si le choix est compris entre min et max
                    return result;// Retourne le choix si valide
                } else {
                    throw new IllegalStateException("Veuillez entrer un nombre entier entre " + min + " et " + max + " : " + result);
                }
            }catch(NumberFormatException e){// Gère l'exception si l'entrée n'est pas un entier
                System.err.println("une erreur est survenue: la valeur entrée doit être un entier. ");
                System.out.println(message);
            }catch(RuntimeException e){// Gère l'exception si le choix est invalide
                System.err.println("Une erreur est survenue: Veuillez entrer un nombre entier entre " + min + " et " + max  );
                System.out.println(message);
            }
        }
    }
    //Méthode qui lit et retourne une date en s'assurant que le format soit correct et que la date sois cohérente avec la date d'aujourd'hui.
    public static Date readDate(String message) {

        // On crée un formateur de date qui va nous permettre de parser la date entrée par l'utilisateur.
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        Date date = null;
        boolean validDate = false;
        while (!validDate) {

            // On affiche le message demandant à l'utilisateur de saisir une date.
            System.out.println(message);
            // On lit la date entrée par l'utilisateur.
            String dateStr = scanner.nextLine();
            try {
                // On essaie de parser la date entrée par l'utilisateur.
                date = format.parse(dateStr);
                if (date.after(new Date())) {
                    // Si la date est postérieure à aujourd'hui, on indique à l'utilisateur qu'il doit entrer une date antérieure ou égale à aujourd'hui.
                    System.err.println("Veuillez entrer une date antérieur ou égale à aujourd'hui.");
                }else{validDate=true;}
                date = format.parse(dateStr);

            } catch (ParseException e) {
                // Si la date entrée par l'utilisateur ne peut pas être parsée, on indique à l'utilisateur le format attendu
                System.err.println("Veuillez entrer une date sous le format: jj/mm/aaaa.");
            }
        }
        // On retourne la date entrée par l'utilisateur
        return date;
    }
    //Méthode qui permet de lire et de vérifier des doubles.
    public static double readDouble(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());// Lit l'entrée de l'utilisateur et la convertit en entier
                // Si le resultat est supérieur à 0, on retourne le résultat.
                if (result > 0) {
                    return result;
                    // Sinon
                }else {
                    throw new IllegalStateException("La valeur entrée doit être supérieur à 0: " + result);
                }


            }catch(RuntimeException e){// Attrape les exceptions de type RuntimeException, affiche un message d'erreur personnalisé et affiche encore le message.
                System.err.println("Une erreur est survenue: La valeur entrée doit être supérieur à 0." );
                System.out.println(message);

            }}}
}
