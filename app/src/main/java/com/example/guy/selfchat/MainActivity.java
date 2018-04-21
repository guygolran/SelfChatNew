package com.example.guy.selfchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
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
//        mDataSource = initData();
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

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView666);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MessageAdapter(mDataSource);
        mRecyclerView.setAdapter(mAdapter);
    }

    private static ArrayList<Message> initData() {
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message("Arthur", "Hey DW"));
        messages.add(new Message("DW", "STFU"));
        messages.add(new Message("Buster", "WAT"));
        messages.add(new Message("Binky", "Banana"));
        messages.add(new Message("Yo Yo Wat", "YO YO MA"));
        messages.add(new Message("Binky (band)", "Binky rules"));
        messages.add(new Message("Reference", "You running out of us"));
        messages.add(new Message("Arthur", "Bye"));
        messages.add(new Message("DW", "Bye"));
        messages.add(new Message("Buster", "Bye"));
        messages.add(new Message("Binky", "Bye"));
        messages.add(new Message("Reference", "Bye"));
        return messages;
    }
}