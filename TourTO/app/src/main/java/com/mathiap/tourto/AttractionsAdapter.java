package com.mathiap.tourto;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * {@link AttractionsAdapter} is an {@link RecyclerView.Adapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Attraction} objects.
 */
public class AttractionsAdapter extends RecyclerView.Adapter<AttractionsAdapter.ViewHolder> {
    private Context context;
    private List<Attraction> attractions;

    public AttractionsAdapter(Context context, List<Attraction> mAttractions) {
        this.context = context;
        this.attractions = mAttractions;
        ;
    }

    @Override
    public AttractionsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(context)
                        .inflate(R.layout.list_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Attraction currentAttraction = attractions.get(position);
        holder.attrName.setText(currentAttraction.getmAttrName());
        holder.attrDisc.setText(currentAttraction.getmAttrDisc());
        holder.attrAddr.setText(currentAttraction.getmAttrAddr());
        if (currentAttraction.hasImage()) {
            holder.image.setImageResource(currentAttraction.getmAttrImage());
            holder.image.setVisibility(View.VISIBLE);
        } else {
            holder.image.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return this.attractions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView attrName;
        private TextView attrDisc;
        private TextView attrAddr;
        private ImageView image;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.attrName = (TextView) view.findViewById(R.id.attraction_name_text_view);
            this.attrDisc = (TextView) view.findViewById(R.id.attraction_disc_text_view);
            this.attrAddr = (TextView) view.findViewById(R.id.attraction_addr_text_view);
            this.image = (ImageView) view.findViewById(R.id.image);
        }
    }
}
