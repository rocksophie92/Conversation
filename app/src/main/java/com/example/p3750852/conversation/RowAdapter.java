package com.example.p3750852.conversation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by P3750852 on 2017.08.23..
 */

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.ViewHolder>{

    private final CopyOnWriteArrayList<Message> mDataset;
    private View v;
    private static final int OTHER = 0;
    private static final int MAIN = 1;
    private SimpleDateFormat dateFormat;

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView message;
        private TextView date;
        private ImageView image;


        ViewHolder(final View v) {
            super(v);
            message = (TextView) v.findViewById(R.id.message);
            image = (ImageView) v.findViewById(R.id.image);
            date = (TextView) v.findViewById(R.id.date);

        }
    }

    public RowAdapter(CopyOnWriteArrayList<Message> data) {

        mDataset = data;

        dateFormat = new SimpleDateFormat("HH:mm");
    }

    @Override
    public RowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == MAIN) {
        this.v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_main, parent, false);
        }

        else {
            this.v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_other, parent, false);
        }

        return new ViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {

        if (mDataset.get(position).isMine()) {
            return MAIN;
        }
        return OTHER;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Message c = mDataset.get(position);
        if (c == null) {
            return;
        }
        holder.message.setText(c.getMessage());
        holder.date.setText(dateFormat.format(c.getSendDate()));
        if (!c.isMine()) {

            Picasso.with(holder.image.getContext()).load(c.getUrl()).into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
