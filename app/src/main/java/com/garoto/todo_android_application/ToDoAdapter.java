package com.garoto.todo_android_application;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ToDoAdapter extends RecyclerView.Adapter <ToDoAdapter.MyViewHolder>{

    Context context;
    ArrayList<ToDoPage> toDoPages;

    public ToDoAdapter(Context contexto, ArrayList<ToDoPage> listado){
        context = contexto;
        toDoPages = listado;
    }

    @NonNull
    @Override
    public MyViewHolder  onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_todo,viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tituloToDo.setText(toDoPages.get(i).getTituloToDo());
        myViewHolder.descripcionToDo.setText(toDoPages.get(i).getDescripcionToDo());
        myViewHolder.fechaToDo.setText(toDoPages.get(i).getFechaToDo());
      //  myViewHolder.keydoes.setText(toDoPages.get(i).getKeyDoes());

        final String getTituloToDo = toDoPages.get(i).getTituloToDo();
        final String getDescripcionToDo = toDoPages.get(i).getDescripcionToDo();
        final String getFechaToDo = toDoPages.get(i).getFechaToDo();
        final String getKeyDoes = toDoPages.get(i).getTituloToDo();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editTask = new Intent(context,EditTaskDesk.class);
                editTask.putExtra("titulotodo",  getTituloToDo);
                editTask.putExtra("descripciontodo", getDescripcionToDo);
                editTask.putExtra("fechatodo", getFechaToDo);
                editTask.putExtra("keydoes",getKeyDoes);

                context.startActivity(editTask);
            }
        });
    }

    @Override
    public int getItemCount() {
        return toDoPages.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tituloToDo, descripcionToDo, fechaToDo, keydoes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloToDo = (TextView) itemView.findViewById(R.id.tituloToDo);
            descripcionToDo = (TextView) itemView.findViewById(R.id.descriptionToDo);
            fechaToDo = (TextView) itemView.findViewById(R.id.timelineToDo);
          //  keydoes = (TextView) itemView.findViewById(R.id.)
        }
    }
}
