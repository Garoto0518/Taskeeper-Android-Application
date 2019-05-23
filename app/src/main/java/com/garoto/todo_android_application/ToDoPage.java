package com.garoto.todo_android_application;

public class ToDoPage {

    String tituloToDo, fechaToDo, descripcionToDo;

    public ToDoPage(String tituloToDo, String fechaToDo, String descripcionToDo) {
        this.tituloToDo = tituloToDo;
        this.fechaToDo = fechaToDo;
        this.descripcionToDo = descripcionToDo;
    }

    public String getTituloToDo() {
        return tituloToDo;
    }

    public void setTituloToDo(String tituloToDo) {
        this.tituloToDo = tituloToDo;
    }

    public String getFechaToDo() {
        return fechaToDo;
    }

    public void setFechaToDo(String fechaToDo) {
        this.fechaToDo = fechaToDo;
    }

    public String getDescripcionToDo() {
        return descripcionToDo;
    }

    public void setDescripcionToDo(String descripcionToDo) {
        this.descripcionToDo = descripcionToDo;
    }
}
