package com.example.couponbazar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link buyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class buyFragment extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference reference;
    SecondAdapter adapter;
    ArrayList<Buy> list;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public buyFragment() {
        // Required empty public constructor
    }

    public static buyFragment newInstance(String param1, String param2) {
        buyFragment fragment = new buyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_buy, container, false);
        recyclerView=v.findViewById(R.id.rview2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        reference= FirebaseDatabase.getInstance().getReference("Sales2");
        list=new ArrayList<Buy>();
        adapter=new SecondAdapter(list);
        recyclerView.setAdapter(adapter);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Buy m=dataSnapshot.getValue(Buy.class);
                    list.add(m);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        return v;
    }
}