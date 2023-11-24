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
public class AdministrarUser {

    private ArrayList<User> listaUsers = new ArrayList();
    private File archivo = null;

    public AdministrarUser(String path) {
        archivo = new File(path);
    }

    public ArrayList<User> getListaUsers() {
        return listaUsers;
    }

    public void setListaUsers(ArrayList<User> listaUsers) {
        this.listaUsers = listaUsers;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setUser(User p) {
        this.listaUsers.add(p);
    }

    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (User t : listaUsers) {
                bw.write("[" + "nombre: " + t.getNombre() + "," + "usuario: " + t.getUser() + "," + "contra: " + t.getContra() + "," + "saldo: " + t.getSaldo() + "]\n");
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        listaUsers = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                String token = "";
                token += sc.next();
                token = token.replace("[", "");
                token = token.replace("nombre: ", "");
                token = token.replace("usuario: ", "");
                token = token.replace("contra: ", "");
                token = token.replace("saldo: ", "");
                token = token.replace("]", "");
                String[] arr = token.split(",");
                while (sc.hasNext()) {
                    listaUsers.add(new User(arr[0], arr[1], arr[2]));
                }
            } catch (Exception ex) {
            }
            sc.close();
        }
    }
}
