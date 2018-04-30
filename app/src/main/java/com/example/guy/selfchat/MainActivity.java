package com.example.guy.selfchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MessageFragmentListener {
    private RecyclerView mRecyclerView;
    private MessageAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Message> mDataSource;
    private Button button;
    private TextView btnTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDataSource = new ArrayList<>();
        button = (Button)findViewById(R.id.button);
        btnTxt = (TextView)findViewById(R.id.editText);
        initRecyclerView();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataSource.add(new Message("You", btnTxt.getText().toString()));
                btnTxt.setText("");
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onMessageClick(final int pos) {
        mDataSource.remove(mDataSource.get(pos));
        mAdapter.notifyDataSetChanged();
        MainActivity.super.onBackPressed();
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView666);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MessageAdapter(mDataSource, getSupportFragmentManager());
        mRecyclerView.setAdapter(mAdapter);
    }
}