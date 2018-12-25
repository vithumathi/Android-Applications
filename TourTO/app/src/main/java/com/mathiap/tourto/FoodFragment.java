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

public class FoodFragment extends Fragment {
    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.attraction_list, container, false);
        final List<Attraction> attraction = new ArrayList<Attraction>();
        attraction.add(new Attraction(getString(R.string.res_one), getString(R.string.res_one_disc), getString(R.string.res_one_addr), R.drawable.wilbur_mexicana));
        attraction.add(new Attraction(getString(R.string.res_two), getString(R.string.res_two_disc), getString(R.string.res_two_addr), R.drawable.cactus_club));
        attraction.add(new Attraction(getString(R.string.res_three), getString(R.string.res_three_disc), getString(R.string.res_three_addr), R.drawable.naan_kabob));
        attraction.add(new Attraction(getString(R.string.res_four), getString(R.string.res_four_disc), getString(R.string.res_four_addr), R.drawable.drake_one_fifty));
        attraction.add(new Attraction(getString(R.string.res_five), getString(R.string.res_five_disc), getString(R.string.res_five_addr), R.drawable.pai));
               RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        recyclerView.setAdapter(new AttractionsAdapter(getActivity(), attraction));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }
}
