package com.example.rohan.bottomnavigationhach;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllDocFragment extends Fragment {
    RecyclerView recyclerView;
    View v;
    ArrayList<profile> list1;
    MyAdapter adapter;

    public static final String PAGE_TITLE = "All doc";
    public AllDocFragment() {
        // Required empty public constructor
    }

    public static AllDocFragment newInstance() {
        AllDocFragment fragment = new AllDocFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_all_doc, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.v = view;

        recyclerView = (RecyclerView) v.findViewById(R.id.my_recycle_view_all);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list1 = new ArrayList<profile>();

//        loaddata();
//        init();


        Toast.makeText(getActivity(), "loading..", Toast.LENGTH_LONG).show();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Profile");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
list1.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    profile p = dataSnapshot1.getValue(profile.class);

                    list1.add(p);

                    //
                }
                adapter = new MyAdapter(getActivity(), list1);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


}