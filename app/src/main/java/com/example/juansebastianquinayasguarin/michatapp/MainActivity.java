package com.example.juansebastianquinayasguarin.michatapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private CircleImageView fotoPerfil;
    private RecyclerView listaMensajes;
    private EditText txtMensaje;
    private TextView tvNombre;
    private Button btnenviar;


    private AdapterMensaje adaptador;
    private DatabaseReference databaseReference;

    private FirebaseDatabase database;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fotoPerfil = (CircleImageView) findViewById(R.id.foto);
        listaMensajes = (RecyclerView) findViewById(R.id.lvMensajes);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        btnenviar = (Button) findViewById(R.id.btnEnviar);

        database = FirebaseDatabase.getInstance();//hacer referencia al nuestro nodo principal
        databaseReference = database.getReference("chat");//sala de chat

        adaptador = new AdapterMensaje(this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaMensajes.setLayoutManager(llm);
        listaMensajes.setAdapter(adaptador);

        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hora = llamarHora();
                databaseReference.push().setValue(new Mensaje(txtMensaje.getText().toString(), tvNombre.getText().toString(), hora, ""));
                //para que cada vez que le de enviar se vacie el editText
                txtMensaje.setText("");
            }
        });
        //para que la pantalla se valla siempre para abajo
        adaptador.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                pantallaAbajo();
            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Mensaje m = dataSnapshot.getValue(Mensaje.class);
                adaptador.añadirMensaje(m);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private String llamarHora() {
        String shora,sminutos,ssegundos,horaTotal;

        Calendar calendarNow = new GregorianCalendar(TimeZone.getTimeZone("Europe/Madrid"));
        //int dia =calendarNow.get(Calendar.DAY_OF_MONTH);
        //int mes = calendarNow.get(Calendar.MONTH);
        int hora = calendarNow.get(Calendar.HOUR);
        int minutos = calendarNow.get(Calendar.MINUTE);
        //int segundos = calendarNow.get(Calendar.SECOND);
        shora = String.valueOf(hora);
        sminutos = String.valueOf(minutos);
        //ssegundos = String.valueOf(segundos);
        horaTotal = shora+":"+sminutos;
        System.out.println(horaTotal);
        return horaTotal;
    }

    //coje la lista y la lleva a la ultima posicion
    private void pantallaAbajo() {
        listaMensajes.scrollToPosition(adaptador.getItemCount() - 1);
    }
}