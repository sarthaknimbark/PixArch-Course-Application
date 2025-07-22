package com.example.pixarch.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.pixarch.R;

public class info_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        // Find the ImageButton by its ID
        ImageButton i1 = view.findViewById(R.id.img1);
        ImageButton i2 = view.findViewById(R.id.img2);
        ImageButton i3 = view.findViewById(R.id.img3);
        ImageButton i4 = view.findViewById(R.id.img4);
        ImageButton i5 = view.findViewById(R.id.img5);



        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open a URL in a web browser when the button is clicked
                Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/pixarch.academy?igshid=MzRlODBiNWFlZA=="));
                startActivity(urlIntent);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/PixArch.StudioPA?mibextid=ZbWKwL"));
                startActivity(urlIntent1);
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/priyank-shah-028ba81aa"));
                startActivity(urlIntent2);
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlIntent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/@pixarchstudio5750?si=_Noviagc6XIwotqe"));
                startActivity(urlIntent3);
            }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlIntent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com/mail/u/0/?hl=en&tf=cm&fs=1&to=pixarchstudio@gmail.com"));
                startActivity(urlIntent4);
            }
        });

        return view;
    }
}
