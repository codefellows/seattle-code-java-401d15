package com.zork.zork_demo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zork.zork_demo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SuperFurBoyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
// TODO: Step 1-6: Make a Fragment class for the RecyclerView ViewHolders
    // Comment out everything to do with params
public class SuperFurBoyFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

//    private String mParam1;
//    private String mParam2;

    public SuperFurBoyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SuperFurBoyFragment.
     */
    public static SuperFurBoyFragment newInstance(String param1, String param2) {
        SuperFurBoyFragment fragment = new SuperFurBoyFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_super_fur_boy, container, false);
    }
}