package com.larriu.in3model.main.admin.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.larriu.in3model.R;
import com.larriu.in3model.main.normal.MainActivityNormal;

public class UserFragmentAdmin extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_admin, container, false);

        view.findViewById(R.id.changeAppButtonAdmin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivityNormal.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}