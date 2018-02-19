package com.example.juansebastianquinayasguarin.michatapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by juansebastianquinayasguarin on 8/2/18.
 */

public class HolderMensaje extends RecyclerView.ViewHolder {

    private TextView nombre, hora, mensaje;
    private ImageView imagenMensaje;

    public HolderMensaje(View itemView) {
        super(itemView);
        nombre = (TextView) itemView.findViewById(R.id.tvNombreMensaje);
        hora = (TextView) itemView.findViewById(R.id.tvHoraMensaje);
        mensaje = (TextView) itemView.findViewById(R.id.tvMensajeMensaje);
        imagenMensaje = (ImageView) itemView.findViewById(R.id.fotoMensaje);
    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getHora() {
        return hora;
    }

    public void setHora(TextView hora) {
        this.hora = hora;
    }

    public TextView getMensaje() {
        return mensaje;
    }

    public void setMensaje(TextView mensaje) {
        this.mensaje = mensaje;
    }

    public ImageView getImagenMensaje() {
        return imagenMensaje;
    }

    public void setImagenMensaje(ImageView imagenMensaje) {
        this.imagenMensaje = imagenMensaje;
    }
}
