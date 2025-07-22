package com.example.pixarch.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.example.pixarch.R;
import com.example.pixarch.course.autocad;
import com.example.pixarch.course.corona;
import com.example.pixarch.course.dsmax;
import com.example.pixarch.course.lumion;
import com.example.pixarch.course.sketchup;
import com.example.pixarch.course.vray;

public class home_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView i2 = view.findViewById(R.id.fhautocade);
        ImageView i3 = view.findViewById(R.id.fhsketchup);
        ImageView i4 = view.findViewById(R.id.fhlumion);
        ImageView i5 = view.findViewById(R.id.fh3dsmax);
        ImageView i6 = view.findViewById(R.id.fhvray);
        ImageView i7 = view.findViewById(R.id.fhcorona);

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ic1 = new Intent(getContext(), autocad.class);
                startActivity(ic1);
                Toast.makeText(getContext(), "AUTODESK IS OPEN", Toast.LENGTH_SHORT).show();
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ic2 = new Intent(getContext(), sketchup.class);
                startActivity(ic2);
                Toast.makeText(getContext(), "SKETCHUP IS OPEN", Toast.LENGTH_SHORT).show();
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ic3 = new Intent(getContext(), lumion.class);
                startActivity(ic3);
                Toast.makeText(getContext(), "LUMION IS OPEN", Toast.LENGTH_SHORT).show();
            }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ic4 = new Intent(getContext(), dsmax.class);
                startActivity(ic4);
                Toast.makeText(getContext(), "3DSMAX IS OPEN", Toast.LENGTH_SHORT).show();
            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ic5 = new Intent(getContext(), vray.class);
                startActivity(ic5);
                Toast.makeText(getContext(), "VRAY IS OPEN", Toast.LENGTH_SHORT).show();
            }
        });
        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ic6 = new Intent(getContext(), corona.class);
                startActivity(ic6);
                Toast.makeText(getContext(), "CORONA IS OPEN", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
