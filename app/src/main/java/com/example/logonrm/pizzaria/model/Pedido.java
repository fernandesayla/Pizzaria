package com.example.logonrm.pizzaria.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by logonrm on 11/12/2017.
 */

public class Pedido implements Parcelable{

    private String cliente;
    private List<String> sabores;
    private String tamanho;

    public Pedido(){

    }

    protected Pedido(Parcel in) {
        cliente = in.readString();
        sabores = in.createStringArrayList();
        tamanho = in.readString();
        formaDePgto = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cliente);
        dest.writeStringList(sabores);
        dest.writeString(tamanho);
        dest.writeString(formaDePgto);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pedido> CREATOR = new Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel in) {
            return new Pedido(in);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };

    public String getFormaDePgto() {
        return formaDePgto;
    }

    public void setFormaDePgto(String formaDePgto) {
        this.formaDePgto = formaDePgto;
    }

    private String formaDePgto;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<String> getSabores() {
        return sabores;
    }

    public void setSabores(List<String> sabores) {
        this.sabores = sabores;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void addSabor(String sabor){
        if (sabores==null)
            sabores = new ArrayList<>();
        sabores.add(sabor);
    }

    public void removeSabor(String sabor){
        if (sabores!=null)
            sabores.remove(sabor);

    }
}
