package com.mathiap.tourto;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * {@link AttractionsAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Attraction} objects.
 */
public class AttractionsAdapter extends ArrayAdapter<Attraction> {
    public AttractionsAdapter(Activity context, List<Attraction> mAttractions) {
        super(context, 0, mAttractions);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The AdapterView position that is requesting a view
     * @param convertView The Recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation
     * @return The view for the position in the AdapterView
     */
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get the {@link Attraction} object located at this position in the list
        Attraction currentAttr = getItem(position);
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView attrName = (TextView) listItemView.findViewById(R.id.attraction_name_text_view);
        attrName.setText(currentAttr.getmAttrName());
        TextView attrDisc = (TextView) listItemView.findViewById(R.id.attraction_disc_text_view);
        attrDisc.setText(currentAttr.getmAttrDisc());
        TextView attrAddr = (TextView) listItemView.findViewById(R.id.attraction_addr_text_view);
        attrAddr.setText(currentAttr.getmAttrAddr());
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if(currentAttr.hasImage()){
            image.setImageResource(currentAttr.getmAttrImage());
            image.setVisibility(View.VISIBLE);
        }else{
            image.setVisibility(View.GONE);
        }
        // Return the whole list item layout (containing 3 TextViews, and an ImageView) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
