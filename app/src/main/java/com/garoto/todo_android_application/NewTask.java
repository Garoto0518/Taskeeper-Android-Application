package com.garoto.todo_android_application;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Type;
import java.util.Random;

public class NewTask extends AppCompatActivity {


    TextView tituloToDoPagina, agregarTitulo, agregarDescription , agregarTimeline;
    EditText tituloToDo, descriptionToDo, timelineToDo;
    Button btnSaveTask, btnCancel;
    DatabaseReference reference;
    Integer todoNum = new Random().nextInt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);


        tituloToDoPagina = findViewById(R.id.titlePage);

        agregarTitulo = findViewById(R.id.addtitleToDo);
        agregarDescription = findViewById(R.id.addDescriptionToDo);
        agregarTimeline = findViewById(R.id.addTimelineToDo);

        tituloToDo = findViewById(R.id.tituloToDo);
        descriptionToDo = findViewById(R.id.descriptionToDo);
        timelineToDo = findViewById(R.id.timelineToDo);

        btnSaveTask = findViewById(R.id.btnSaveTask);
        btnCancel = findViewById(R.id.btnCancelTask);


        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //Insert data to datababse
                reference = FirebaseDatabase.getInstance().getReference().child("ToDoOverall").child("ToDo" + todoNum);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("tituloDeAplication").setValue(tituloToDo.getText().toString());
                        dataSnapshot.getRef().child("descriptionToDo").setValue(descriptionToDo.getText().toString());
                        dataSnapshot.getRef().child("fechaToDoApp").setValue(timelineToDo.getText().toString());

                        Intent newToDo = new Intent(NewTask.this, HomePage.class);
                        startActivity(newToDo);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        Typeface mediumLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface mediumMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");

        tituloToDoPagina.setTypeface(mediumMedium);
        agregarTitulo.setTypeface(mediumLight);
        tituloToDo.setTypeface(mediumMedium);

        agregarDescription.setTypeface(mediumLight);
        descriptionToDo.setTypeface(mediumMedium);

        agregarTimeline.setTypeface(mediumLight);
        timelineToDo.setTypeface(mediumMedium);
    }
}
