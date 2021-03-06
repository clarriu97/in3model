package com.larriu.in3model.main.admin.favincubators;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.larriu.in3model.R;
import com.larriu.in3model.main.admin.incubators.IncubatorsAdapterAdmin;

public class IncubatorsFavFragmentAdmin extends Fragment {

    private ListView listView;
    private IncubatorsAdapterAdmin adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_incubators_fav_admin, container, false);

        // Setup the ListView and the Adapter
        listView = view.findViewById(R.id.incubatorsFavsListViewAdmin);
        adapter = new IncubatorsAdapterAdmin(getActivity(), true);
        listView.setAdapter(adapter);
        listView.setDivider(null);

        return view;
    }
}