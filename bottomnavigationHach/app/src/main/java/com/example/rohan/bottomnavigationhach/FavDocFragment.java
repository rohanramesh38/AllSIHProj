package com.example.rohan.bottomnavigationhach;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavDocFragment extends Fragment {

    public static final String PAGE_TITLE = "Fav Doc";
    public FavDocFragment() {
        // Required empty public constructor
    }

    public static FavDocFragment newInstance() {
        FavDocFragment fragment = new FavDocFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_doc, container, false);
    }
}
