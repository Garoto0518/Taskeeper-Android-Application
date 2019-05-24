package com.garoto.todo_android_application;

import android.graphics.Typeface;
import android.media.MediaMetadata;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    TextView tituloDeAplicacion, subTituloDeAplicacion, endPage;

    DatabaseReference reference;
    RecyclerView ourDoes;
    ArrayList<ToDoPage> list;
    ToDoAdapter toDoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        tituloDeAplicacion = findViewById(R.id.tituloDeAplicacion);
        subTituloDeAplicacion = findViewById(R.id.subTituloDeAplicacion);
        endPage = findViewById(R.id.subTituloDeAplicacion);

        //Font
        Typeface mediumLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MM.ttf");

        tituloDeAplicacion.setTypeface(MMedium);
        subTituloDeAplicacion.setTypeface(mediumLight);
        endPage.setTypeface(mediumLight);

        //Working with data
        ourDoes = findViewById(R.id.ourDoes);
        ourDoes.setLayoutManager(new LinearLayoutManager( this));
        list = new ArrayList<ToDoPage>();

        //Get Data from Firebase
        reference = FirebaseDatabase.getInstance().getReference().child("ToDoOverall");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Set Code to retrieve data and replace layout
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    ToDoPage p = dataSnapshot1.getValue(ToDoPage.class);
                    list.add(p);
                }

                toDoAdapter = new ToDoAdapter(HomePage.this, list);
                ourDoes.setAdapter(toDoAdapter);
                toDoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Set Code to show an error
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
