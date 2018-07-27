package com.example.ero.week4homework2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {

    private Context context;
    private String[] list;

    public InfoAdapter(Context context, String[] list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.info_item, parent, false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {
        Picasso.get().load(list[position]).into(holder.infoImage);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder {
        private final ImageView infoImage;

        public InfoViewHolder(View itemView) {
            super(itemView);
            infoImage = itemView.findViewById(R.id.info_img_list);
        }
    }
}
