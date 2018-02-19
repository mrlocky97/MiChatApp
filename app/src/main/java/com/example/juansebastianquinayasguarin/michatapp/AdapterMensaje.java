package com.example.juansebastianquinayasguarin.michatapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by juansebastianquinayasguarin on 6/2/18.
 */

public class AdapterMensaje extends RecyclerView.Adapter<HolderMensaje> {

    private List<Mensaje> listaMensaje = new ArrayList<>();
    private Context contexto;

    public AdapterMensaje(Context contexto) {
        this.contexto = contexto;
    }

    public void añadirMensaje(Mensaje mensaje) {
        listaMensaje.add(mensaje);
        //size por que siempre se va a insertar el ultimo elemento de nuestralista
        notifyItemInserted(listaMensaje.size());
    }

    @Override
    public HolderMensaje onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(contexto).inflate(R.layout.card_view_mensajes, parent, false);
        return new HolderMensaje(vista);
    }

    @Override
    public void onBindViewHolder(HolderMensaje holder, int position) {
        holder.getNombre().setText(listaMensaje.get(position).getNombre());
        holder.getMensaje().setText(listaMensaje.get(position).getMensaje());
        holder.getHora().setText(listaMensaje.get(position).getHora());
    }

    @Override
    public int getItemCount() {
        return listaMensaje.size();
    }
}
