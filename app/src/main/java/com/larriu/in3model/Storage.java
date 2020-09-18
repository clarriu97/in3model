package com.larriu.in3model;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    //Este es el Singleton
    private static Storage storage = null;

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
}
