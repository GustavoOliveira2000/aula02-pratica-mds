/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagement;

/**
 *
 * @author gustavooliveira
 */

public class Hospedes 
{
    private int id; // Identificador único do hóspede
    private String nome; // Nome do hóspede
    private String email; // Email do hóspede
    private String contacto; // Contato do hóspede

    // Construtor
    public Hospedes(int id, String nome, String email, String contacto) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.contacto = contacto;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }


    @Override
    public String toString() {
        return "Hospedes {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", contacto='" + contacto + '\'' +
                '}';
    }
}
