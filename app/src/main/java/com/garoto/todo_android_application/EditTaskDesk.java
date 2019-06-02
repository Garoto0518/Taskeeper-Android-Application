package com.garoto.todo_android_application;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditTaskDesk extends AppCompatActivity {

    EditText titleToDo, descripcionToDo, fechaToDo;
    Button btnSaveUpdate, btnDelete;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task_desk);
        titleToDo = findViewById(R.id.tituloToDo);
        descripcionToDo = findViewById(R.id.descriptionToDo);
        fechaToDo = findViewById(R.id.timelineToDo);

        btnSaveUpdate = findViewById(R.id.btnSaveUpdate);
        btnDelete = findViewById(R.id.btnDeleteTask);

        //Get value from previous page
        titleToDo.setText(getIntent().getStringExtra("titulotodo"));
        descripcionToDo.setText(getIntent().getStringExtra("descripciontodo"));
        fechaToDo.setText(getIntent().getStringExtra("fechatodo"));

        //Make event for button
        final String keyToDo = getIntent().getStringExtra("keydoes");

        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference().child("ToDoOverall").child("ToDo" + keyToDo);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("titulotodo").setValue(titleToDo.getText().toString());
                        dataSnapshot.getRef().child("descripciontodo").setValue(descripcionToDo.getText().toString());
                        dataSnapshot.getRef().child("fechatodo").setValue(fechaToDo.getText().toString());
                        dataSnapshot.getRef().child("keyDoes").setValue(keyToDo);


                        Intent updatedScreen = new Intent(EditTaskDesk.this, HomePage.class);
                        startActivity(updatedScreen);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
