/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7p2_diegolara;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class AdministrarRes {

    private ArrayList<Res> listaRest = new ArrayList();
    private File archivo = null;

    public AdministrarRes(String path) {
        archivo = new File(path);
    }

    public ArrayList<Res> getListaRest() {
        return listaRest;
    }

    public void setListaRest(ArrayList<Res> listaRest) {
        this.listaRest = listaRest;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setRes(Res p) {
        this.listaRest.add(p);
    }

    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Res t : listaRest) {
                bw.write("[" + "nombre: " + t.getNombre() + "," + "ubicacion: " + t.getUbicacion() + "," + "productos: " + t.getListaProd() + "," + "saldo: " + t.getSaldo() + "]\n");
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        listaRest = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                String token = "";
                token += sc.next();
                token = token.replace("[", "");
                token = token.replace("nombre: ", "");
                token = token.replace("ubicacion: ", "");
                token = token.replace("productos: ", "");
                token = token.replace("saldo: ", "");
                token = token.replace("]", "");
                String[] arr = token.split(",");
                while (sc.hasNext()) {
                    listaRest.add(new Res(arr[0], arr[1]));
                }
            } catch (Exception ex) {
            }
            sc.close();
        }
    }
}
