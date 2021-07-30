package com.example.couponbazar;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class contactUsFragment extends Fragment {


    private EditText edt_subject,edt_message;
    private Button btn_send;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contact_us, container, false);

        edt_subject=view.findViewById(R.id.edt_subject);
        edt_message=view.findViewById(R.id.edt_message);
        btn_send=view.findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmail();
            }
        });

        return view;
    }

    private void sendmail() {
        String sub=edt_subject.getText().toString();
        String msg=edt_message.getText().toString();
        String to="vishal206ani@gmail.com";
        String[] to2=to.split(",");
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,to2);
        intent.putExtra(Intent.EXTRA_SUBJECT,sub);
        intent.putExtra(Intent.EXTRA_TEXT,msg);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose and email client"));
    }
}