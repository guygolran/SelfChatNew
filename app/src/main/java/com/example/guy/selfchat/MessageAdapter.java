package com.example.guy.selfchat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private ArrayList<Message> mDataSource;

    public MessageAdapter(ArrayList<Message> items) {
        this.mDataSource = items;
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    public void setmDataSource(ArrayList<Message> newDataSource) {
        this.mDataSource = newDataSource;
    }

    //    @Override
//    public int getItemId(int pos) {
//        return pos;
//    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView author, msg, timeStamp;

        public ViewHolder(View view) {
            super(view);
            author = view.findViewById(R.id.li_msg_author);
            msg = view.findViewById(R.id.li_msg_content);
            timeStamp = view.findViewById(R.id.li_msg_timestamp);
        }
    }

    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.li_msg, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int pos) {
        final Message message = mDataSource.get(pos);

        holder.msg.setText(message.getMsg());
        holder.author.setText(message.getAuthor());
        holder.timeStamp.setText(message.getTimeStamp());
    }

//    @Override
//    public View getView(int pos, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//
//        if (convertView == null) {
//            convertView = mInflater.inflate(R.layout.li_msg, parent, false);
//            holder = new ViewHolder();
//            holder.author = convertView.findViewById(R.id.li_msg_author);
//            holder.msg = convertView.findViewById(R.id.li_msg_content);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//
//        Message message = getItem(pos);
//
//        holder.author.setText(message.getAuthor());
//        holder.msg.setText(message.getMsg());
//        return convertView;
//    }
}