package com.larriu.in3model.main.normal.incubators;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.larriu.in3model.R;

public class HomeFragment extends Fragment {

    private ListView listView;
    private IncubatorsNormalAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Configure the listView
        listView = view.findViewById(R.id.incubatorsListViewNormal);
        adapter = new IncubatorsNormalAdapter(getActivity(), false);
        listView.setAdapter(adapter);
        listView.setDivider(null);

        return view;
    }
}