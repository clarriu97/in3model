package com.larriu.in3model.main.admin.incubators;

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

public class IncubatorsAdminlAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private boolean fav;

    public IncubatorsAdminlAdapter(Activity activity, boolean fav) {
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
        if(view == null){
            view = inflater.inflate(R.layout.incubator_item_admin, viewGroup, false);
        }
        // configure the view given
        ((TextView)view.findViewById(R.id.isActiveAdminTextView)).setText("isActive: " + getList().get(i).isActive());
        ((TextView)view.findViewById(R.id.temperatureAdminTextView)).setText("Temperature: " + getList().get(i).isActive());
        ((TextView)view.findViewById(R.id.ppmAdminTextView)).setText("PPM: " + getList().get(i).isActive());
        ((TextView)view.findViewById(R.id.isFavAdminTextView)).setText("isFav: " + getList().get(i).isActive());

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
