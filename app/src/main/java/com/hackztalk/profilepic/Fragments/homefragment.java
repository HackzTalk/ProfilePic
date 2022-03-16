package com.hackztalk.profilepic.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackztalk.profilepic.Adapters.Home_Adapter;
import com.hackztalk.profilepic.Models.Home_Model;
import com.hackztalk.profilepic.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homefragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homefragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public homefragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homefragment.
     */
    // TODO: Rename and change types and number of parameters
    public static homefragment newInstance(String param1, String param2) {
        homefragment fragment = new homefragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_homefragment, container, false);


        RecyclerView rvHome;
        rvHome = v.findViewById(R.id.rvHome);

        ArrayList<Home_Model> list = new ArrayList<>();

        list.add(new Home_Model(R.drawable.frame1,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame2,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame3,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame4,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame5,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame6,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame7,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame8,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame9,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame10,R.drawable.btn));
//        list.add(new Home_Model(R.drawable.frame11,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame12,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame13,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame14,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame15,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame16,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame17,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame18,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame19,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame20,R.drawable.btn));
        list.add(new Home_Model(R.drawable.frame21,R.drawable.btn));

        Home_Adapter adapter = new Home_Adapter(list,getContext());
        rvHome.setAdapter(adapter);


        rvHome.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rvHome.setLayoutManager(gridLayoutManager);


        return v;
    }
}