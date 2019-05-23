package com.garoto.todo_android_application;

import android.content.Context;
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_todo,viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return toDoPages.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloToDo = (TextView) itemView.findViewById(R.id.tituloDeAplicacion);
            descripcion = (TextView) itemView.findViewById(R.id.tituloDeAplicacion);
            tituloToDo = (TextView) itemView.findViewById(R.id.tituloDeAplicacion);

        }
    }
}