package com.mathiap.tourto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SportsFragment extends Fragment {
    public SportsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.attraction_list, container, false);
        final List<Attraction> attraction = new ArrayList<Attraction>();
        attraction.add(new Attraction(getString(R.string.blue_jays), getString(R.string.blue_jays_disc), getString(R.string.blue_jays_addr), R.drawable.blue_jays));
        attraction.add(new Attraction(getString(R.string.raptors), getString(R.string.raptors_disc), getString(R.string.raptors_addr), R.drawable.raptors));
        attraction.add(new Attraction(getString(R.string.leafs), getString(R.string.leafs_disc), getString(R.string.leafs_addr), R.drawable.leafs));
        attraction.add(new Attraction(getString(R.string.tfc), getString(R.string.tfc_disc), getString(R.string.tfc_addr), R.drawable.tfc));
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        recyclerView.setAdapter(new AttractionsAdapter(getActivity(), attraction));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }
}
