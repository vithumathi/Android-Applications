package com.mathiap.tourto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AttractionsFragment extends Fragment {
    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final List<Attraction> attraction = new ArrayList<Attraction>();

        attraction.add(new Attraction(getString(R.string.cn_tower), getString(R.string.cn_tower_disc), getString(R.string.cn_tower_addr), R.drawable.cn_tower_));
        attraction.add(new Attraction(getString(R.string.royal_ontario_museum), getString(R.string.royal_ontario_museum_disc), getString(R.string.royal_ontario_museum_addr), R.drawable.rom));
        attraction.add(new Attraction(getString(R.string.gooderham_building), getString(R.string.gooderham_building_disc), getString(R.string.gooderham_building_addr), R.drawable.gooderham));
        attraction.add(new Attraction(getString(R.string.casa_loma), getString(R.string.casa_loma_disc), getString(R.string.casa_loma_addr), R.drawable.casa_loma));
        attraction.add(new Attraction(getString(R.string.aquarium), getString(R.string.aquarium_disc), getString(R.string.aquarium_addr), R.drawable.ripley));

        AttractionsAdapter itemsAdapter = new AttractionsAdapter(getActivity(), attraction);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} created above so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(itemsAdapter);

        return rootView;
    }
}
