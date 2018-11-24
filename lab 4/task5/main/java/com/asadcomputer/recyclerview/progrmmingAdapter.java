package com.asadcomputer.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.AccessController;

import static com.asadcomputer.recyclerview.R.id.imgicon;

public class progrmmingAdapter extends RecyclerView.Adapter<progrmmingAdapter.programmingViewHolder>{

    private String[] data;
    private ViewGroup parent;

    public progrmmingAdapter(String[] languages){
        this.data=data;
    }
    @NonNull
    @Override
    public programmingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout,parent, false);
        return new programmingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull programmingViewHolder holder, int position) {
        String title=data[position];
        holder.txtTitle.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class programmingViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView txtTitle;
        public programmingViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon=itemView.findViewById(R.id.imgicon);
            txtTitle=itemView.findViewById(R.id.txtTitle);

        }
    }
}
