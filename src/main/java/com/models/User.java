package com.models;

import java.time.LocalDate;

public class User {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private LocalDate dataDiRegistrazione;

    // Costruttore
    public User(int id, String nome, String cognome, String email, String password, LocalDate dataDiRegistrazione) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.dataDiRegistrazione = dataDiRegistrazione;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public LocalDate getDataDiRegistrazione() { return dataDiRegistrazione; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setDataDiRegistrazione(LocalDate dataDiRegistrazione) { this.dataDiRegistrazione = dataDiRegistrazione; }
}
