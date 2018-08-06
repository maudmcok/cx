package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Database {

    private Connection connection;
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String CLUE = "clue";
    public static final String HORIZONTAL = "horizontal";
    public static final String ROW = "row";
    public static final String COLUMN = "column";
    public static final String SOLUTION = "solution";
    public String passDB = "";
    public String nameDB = "crossword";

    public static final String PUZZLE_NUMBER = "puzzleNumber";
    public String userDB = "root";
    Random rand = new Random();

    //creation du HashMap
    public HashMap<String, Object> maph = new HashMap<String, Object>();
    //creation de l'arraylist
    public ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();


    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/crossword", "root", "");

            System.out.println("Debut de la connexion");
         //  this.close();
        } catch (ClassNotFoundException e) {
            System.err.println(" Erreur Localisation BD #AccesError ");
        } catch (SQLException e) {
            System.err.println(" Erreur Localisation BD #ConnexionError ");
        }
    }

    public ArrayList<HashMap<String, Object>> getClues(int puzzleNumber) {



        // faire un selecte pour recuperer tous les elements du niveau puzzleNumber
        System.out.println("Debut de l'importation des donnees ");
        try {
            Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://localhost/crossword", "root", "");
            System.out.println(" 002154 ");

            String sqlk = "SELECT *  FROM mot_croises WHERE num_grille= ?";
            PreparedStatement instructions = connection.prepareStatement(sqlk);
            instructions.setString(1, "" + puzzleNumber);
            ResultSet resultat = instructions.executeQuery();

            while (resultat.next()) {

                // metre ces elements dans un ArrayList

                // boucle pour recupere les element un a un
                int row = Integer.parseInt(resultat.getString("ligne"))-1 ;
                int column = Integer.parseInt(resultat.getString("colonne"))-1 ;

                maph.put(CLUE, resultat.getString("definition"));
                maph.put(HORIZONTAL, resultat.getString("horizontal"));
                maph.put(ROW, ""+row);
                maph.put(COLUMN, ""+column);
                maph.put(SOLUTION, resultat.getString("solution"));

                // Ajout du HashMap au Array

                list.add((HashMap<String, Object>) maph.clone());
                System.out.println(maph.toString());
              //  System.out.println(list.toString());
             //   System.out.println(maph.toString());
                maph.clear();

            }
          //  System.out.println("fin  de l'importation des donnees ");
           // System.out.println(list.toString());
             return list;
            //  connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println(" Erreur Localisation BD");
        } catch (SQLException e) {
            System.out.println(" Erreur Localisation BD");
        }

     //   System.out.println(list.toString());
        return list;
    }


    public void close() {
        try {
            System.err.println(" Initialisatio de la deconnexion TY  ");
            connection.close();

        } catch (SQLException e) {
            System.err.println(" Erreur Localisation BD 2 ");
        }

    }

    public int getRandomPuzzleNumber() {
        return rand.nextInt(10)+1; //a terminer
    }


}
