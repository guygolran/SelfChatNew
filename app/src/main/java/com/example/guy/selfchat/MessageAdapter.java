package com.example.guy.selfchat;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private ArrayList<Message> mDataSource;
    public android.support.v4.app.FragmentManager mFragmentManager;

    public MessageAdapter(ArrayList<Message> items, android.support.v4.app.FragmentManager fragmentManager) {
        this.mDataSource = items;
        this.mFragmentManager = fragmentManager;
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    public void setmDataSource(ArrayList<Message> newDataSource) {
        this.mDataSource = newDataSource;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView author, msg, timeStamp;
        public View view;

        public ViewHolder(View view) {
            super(view);
            author = view.findViewById(R.id.li_msg_author);
            msg = view.findViewById(R.id.li_msg_content);
            timeStamp = view.findViewById(R.id.li_msg_timestamp);
            this.view = view;
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

        holder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                MessageFragment messageFragment = MessageFragment.newInstance(message.getAuthor(), message.getMsg(), message.getTimeStamp(), pos);
                mFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.main_activity, messageFragment).commit();
                return true;
            }
        });
    }
}