package com.garoto.todo_android_application;

public class ToDoPage {

    String tituloToDo, fechaToDo, descripcionToDo, keyDoes;

    public ToDoPage(String tituloToDo, String fechaToDo, String descripcionToDo, String keyDoes) {
        this.tituloToDo = tituloToDo;
        this.fechaToDo = fechaToDo;
        this.descripcionToDo = descripcionToDo;
        this.keyDoes = keyDoes;
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

    public String getKeyDoes(){
        return keyDoes;
    }

    public void setKeyDoes(String keyDoes){
        this.keyDoes = keyDoes;
    }
}
