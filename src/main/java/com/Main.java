package com;

import com.models.User;
import com.service.UserDAO;
import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();

        // Inserimento di un nuovo utente
        System.out.println("Inserisci i dettagli per un nuovo utente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cognome: ");
        String cognome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        // Assumiamo che la data di registrazione sia la data corrente per semplificare
        LocalDate dataDiRegistrazione = LocalDate.now();

        User newUser = new User(0, nome, cognome, email, password, dataDiRegistrazione);
        userDAO.createUser(newUser);

        // Stampa di tutti gli utenti
        System.out.println("Utenti nel database dopo l'inserimento:");
        userDAO.printAllUsers();

        // Modifica di un utente
        System.out.print("Inserisci l'ID dell'utente da modificare: ");
        int userId = Integer.parseInt(scanner.nextLine());
        User userToModify = userDAO.readUser(userId);
        if (userToModify != null) {
            System.out.print("Nuovo nome: ");
            userToModify.setNome(scanner.nextLine());
            System.out.print("Nuovo cognome: ");
            userToModify.setCognome(scanner.nextLine());
            System.out.print("Nuova email: ");
            userToModify.setEmail(scanner.nextLine());
            System.out.print("Nuova password: ");
            userToModify.setPassword(scanner.nextLine());
            userDAO.updateUser(userToModify);

            // Ristampa di tutti gli utenti dopo la modifica
            System.out.println("Utenti nel database dopo la modifica:");
            userDAO.printAllUsers();
        } else {
            System.out.println("Utente non trovato.");
        }

        // Eliminazione di un utente
        System.out.print("Vuoi eliminare un utente? (s/n): ");
        String risposta = scanner.nextLine();
        if (risposta.equalsIgnoreCase("s")) {
            System.out.print("Inserisci l'ID dell'utente da eliminare: ");
            int idToDelete = Integer.parseInt(scanner.nextLine());
            userDAO.deleteUser(idToDelete);

            // Ristampa di tutti gli utenti dopo l'eliminazione
            System.out.println("Utenti nel database dopo l'eliminazione:");
            userDAO.printAllUsers();
        }

        scanner.close();
    }
}
