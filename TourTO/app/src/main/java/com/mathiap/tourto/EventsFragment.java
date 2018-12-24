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

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {
    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final List<Attraction> attraction = new ArrayList<Attraction>();

        attraction.add(new Attraction(getString(R.string.event_one), getString(R.string.event_one_disc), getString(R.string.event_one_addr)));
        attraction.add(new Attraction(getString(R.string.event_two), getString(R.string.event_two_disc), getString(R.string.event_two_addr)));
        attraction.add(new Attraction(getString(R.string.event_three), getString(R.string.event_three_disc), getString(R.string.event_three_addr)));
        attraction.add(new Attraction(getString(R.string.event_four), getString(R.string.event_four_disc), getString(R.string.event_four_addr)));
        attraction.add(new Attraction(getString(R.string.event_five), getString(R.string.event_five_disc), getString(R.string.event_five_addr)));
        attraction.add(new Attraction(getString(R.string.event_six), getString(R.string.event_six_disc), getString(R.string.event_six_addr)));
        attraction.add(new Attraction(getString(R.string.event_seven), getString(R.string.event_seven_disc), getString(R.string.event_seven_addr)));

        AttractionsAdapter itemsAdapter = new AttractionsAdapter(getActivity(), attraction);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} created above so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(itemsAdapter);

        return rootView;
    }
}
