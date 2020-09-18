package com.larriu.in3model.main.normal.favs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.larriu.in3model.R;
import com.larriu.in3model.main.normal.incubators.IncubatorsNormalAdapter;


public class FavsFragment extends Fragment {

    private ListView listView;
    private IncubatorsNormalAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favs, container, false);

        listView = view.findViewById(R.id.incubatorsFavsListViewNormal);
        adapter = new IncubatorsNormalAdapter(getActivity(), true);
        listView.setAdapter(adapter);
        listView.setDivider(null);

        return view;
    }
}