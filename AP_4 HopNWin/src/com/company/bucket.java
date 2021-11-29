package com.company;
import java.util.ArrayList;
public class bucket{
    private ArrayList<tiles> store;
    public bucket()
    {
        store= new ArrayList<>();
    }

    public void addToy(tiles t)
    {
        tiles carpet_tile=t.clone();
        store.add(carpet_tile);
    }

    public tiles getTile(int idx)
    {
        return store.get(idx-1);
    }

    public ArrayList<tiles> getStore() {
        return store;
    }

}

