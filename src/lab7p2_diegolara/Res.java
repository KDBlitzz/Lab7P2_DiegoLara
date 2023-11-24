/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7p2_diegolara;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Res {

    private String nombre;
    private String ubicacion;
    private ArrayList<Producto> listaProd = new ArrayList();
    private double saldo = 0;

    public Res() {
    }

    public Res(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Producto> getListaProd() {
        return listaProd;
    }

    public void setListaProd(ArrayList<Producto> listaProd) {
        this.listaProd = listaProd;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
