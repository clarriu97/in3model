package com.larriu.in3model.main.normal.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.larriu.in3model.R;
import com.larriu.in3model.Storage;
import com.larriu.in3model.main.admin.MainActivityAdmin;

public class UserFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        ((TextView)view.findViewById(R.id.nameTextViewNormal)).setText("Name: " + Storage.get().getUser().getName() + " " + Storage.get().getUser().getSurname());
        ((TextView)view.findViewById(R.id.emailTextViewNormal)).setText("Name: " + Storage.get().getUser().getName() + " " + Storage.get().getUser().getEmail());
        ((TextView)view.findViewById(R.id.moneyDonatedTextViewNormal)).setText("Name: " + Storage.get().getUser().getName() + " " + Storage.get().getUser().getMoneyDonated());

        view.findViewById(R.id.changeAppButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivityAdmin.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}