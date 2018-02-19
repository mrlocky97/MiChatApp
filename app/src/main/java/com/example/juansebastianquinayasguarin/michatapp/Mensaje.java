package com.example.juansebastianquinayasguarin.michatapp;

/**
 * Created by juansebastianquinayasguarin on 8/2/18.
 */

public class Mensaje {
    private String mensaje, nombre, hora, fotoPerfil;

    public Mensaje() {
    }

    public Mensaje(String mensaje, String nombre, String hora, String fotoPerfil) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.hora = hora;
        this.fotoPerfil = fotoPerfil;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}
