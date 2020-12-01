package com.larriu.in3model;

import android.content.Context;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Storage {

    //Este es el Singleton
    private static Storage storage = null;

    private final static String FILENAME = "storage.bin";
    private final static int VERSION = 1;
    private final static int END_FLAG = 0xA5A55A5A;

    //Data
    private List<Incubator> list;
    private User user;

    public static Storage get() {
        if (storage == null) { storage = new Storage(); }
        return storage;
    }


    private Storage() {
        init();
    }

    public void init(){
        user = new User("Andres", "andresito@gmail.com", true);
        list = new ArrayList();
        list.add(new Incubator(false, 23, 60, false));
        list.add(new Incubator(true, 24.22f, 61, false));
        list.add(new Incubator(false, 23, 62, true));
    }

    public List<Incubator> getList(){
        return list;
    }

    public User getUser() {
        return user;
    }

    public void setList(List<Incubator> list) {
        this.list = list;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // ---------------------------------------------------------------------------------

    // Metodo que hace la lectura
    private void read(DataInputStream dis) throws IOException{
        list = new ArrayList<>();
        int version = dis.readInt();
        if (version != VERSION){
            throw new IOException();
        }
        int size = dis.readInt();
        for (int i = 0; i<size; i++){
            list.add(new Incubator(dis));
        }
        int endflag = dis.readInt();
        if (endflag != END_FLAG){
            throw new IOException();
        }
    }

    // Metodo que escribe en el archivo
    private void write(DataOutputStream dos) throws IOException {
        dos.writeInt(VERSION);
        dos.writeInt(list.size());
        for (Incubator incubator: list) {
            incubator.write(dos);
        }
        dos.writeInt(END_FLAG);
    }

    // ---------------------------------------------------------------------------------

    // Metodo donde cargamos los datos, si hay conexión a internet se hará una petición al servidor
    // si no cargaremos los últimos datos que haya guardados
    public boolean load(Context context) {
        // TODO: hay que hacer la diferencia si hay o no conexión a Internet
        //Es el que crea el Stream para enlazarlo con la sd y al read le dice, chupa datos de aqui
        DataInputStream dis = null;
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            dis = new DataInputStream(fis);
            read(dis);
        } catch (IOException e) {
            init();
            return false;
        } finally {
            if (dis != null) { try { dis.close(); } catch (IOException e) { } }
        }
        return true;
    }


    public void save(Context context) {
        // TODO: primero hay que borrar los datos que hubiera en el archivo
        DataOutputStream dos = null;
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            dos = new DataOutputStream(fos);
            write(dos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) { try { dos.close(); } catch (IOException e) { } }
        }
    }

}
