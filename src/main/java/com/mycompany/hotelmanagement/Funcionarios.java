/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagement;

/**
 *
 * @author marianasilva
 */


public class Funcionarios {
    private int id;
    private String nome;
    private String cargo;

    // Construtor
    public Funcionarios(int id, String nome, String cargo) 
    {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }
        // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


   
}