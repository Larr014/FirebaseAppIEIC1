package com.example.firebaseappieic1.Modelo;

public class Alumno {
    public String id;
    public String nombre;
    public String apellido;
    public int edad;

    public Alumno() {
    }

    public Alumno(String id,String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
