package com.larriu.in3model.main.admin.incubators;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.larriu.in3model.R;
import com.larriu.in3model.main.normal.incubators.IncubatorsNormalAdapter;

public class IncubatorsFragment extends Fragment {

    private ListView listView;
    private IncubatorsAdminlAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_incubators, container, false);

        // Setup the ListView and the Adapter
        listView = view.findViewById(R.id.incubatorsListViewAdmin);
        adapter = new IncubatorsAdminlAdapter(getActivity(), false);
        listView.setAdapter(adapter);
        listView.setDivider(null);

        return view;
    }
}