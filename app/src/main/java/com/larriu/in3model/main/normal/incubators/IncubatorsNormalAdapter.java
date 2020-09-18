package com.larriu.in3model.main.normal.incubators;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.larriu.in3model.Incubator;
import com.larriu.in3model.R;
import com.larriu.in3model.Storage;

import java.util.ArrayList;
import java.util.List;

public class IncubatorsNormalAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private boolean fav;

    public IncubatorsNormalAdapter(Activity activity, boolean fav) {
        inflater = activity.getLayoutInflater();
        this.fav = fav;
    }

    @Override
    public int getCount() {
        return getList().size();
    }

    @Override
    public Object getItem(int i) {
        return getList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = inflater.inflate(R.layout.incubator_item_normal, viewGroup, false);
        }

        // Configure the view
        ((TextView)view.findViewById(R.id.isActiveNormalTextView)).setText("isActive: " + getList().get(i).isActive());
        ((TextView)view.findViewById(R.id.temperatureNormalTextView)).setText("Temperature: " + getList().get(i).getTemp());
        ((TextView)view.findViewById(R.id.ppmNormalTextView)).setText("PPM: " + getList().get(i).getPpm());
        ((TextView)view.findViewById(R.id.isFavNormalTextView)).setText("isFav: " + getList().get(i).isFav());

        return view;
    }

    private List<Incubator> getList(){

        // Configure if the list given is the normal one or only with the favs
        if (fav){
            List list = new ArrayList();
            for(Incubator incubator: Storage.get().getList()){
                if (incubator.isFav()){ list.add(incubator);}
            }
            return list;
        }

        return Storage.get().getList();
    }
}
