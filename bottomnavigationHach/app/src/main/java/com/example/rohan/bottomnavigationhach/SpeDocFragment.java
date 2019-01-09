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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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
public class SpeDocFragment extends Fragment {
    public static final String PAGE_TITLE = "Specialized";
String S="Others";

    RecyclerView recyclerView;
    View v;
    ArrayList<profile> list1;
    MyAdapter adapter;

    public SpeDocFragment() {
        // Required empty public constructor
    }

    public static SpeDocFragment newInstance() {
        SpeDocFragment fragment = new SpeDocFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_spe_doc, container, false);

        String[] values = {"Others", "Pediatrician", "ornithologist", "General", "Dermatologist","Neurotherapist"};
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


               S=values[(int) parent.getItemIdAtPosition(position)];
               if(!S.equals("Others"))
               {loaddata();}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return v;
    }






    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.v = view;

        recyclerView = (RecyclerView) v.findViewById(R.id.my_recycle_view_spe);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list1 = new ArrayList<profile>();

        loaddata();


//        init();


//        Toast.makeText(getActivity(), "load", Toast.LENGTH_LONG).show();

    }

    private void loaddata()
    {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Profile");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    profile p = dataSnapshot1.getValue(profile.class);
                    if(S.equals("Others")) {
                        list1.add(p);
                    }
                    else
                    if(S.equals(p.getEmail()))
                    {
                        list1.add(p);
                    }
                    //
                }
                adapter = new MyAdapter(getActivity(), list1);
                recyclerView.setAdapter(adapter);

                if(list1.size()==0)
                {
                    Toast.makeText(getActivity(), "No "+S+" Found", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }


}