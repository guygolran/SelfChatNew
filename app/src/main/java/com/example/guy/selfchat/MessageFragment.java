package com.example.guy.selfchat;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MessageFragment extends Fragment {
    private static final String ARGS_MESSAGE = "args_message";
    private static final String ARGS_AUTHOR = "args_author";
    private static final String ARGS_TIMESTAMP = "args_timestamp";
    private static final String ARGS_POS = "args_pos";
    private MessageFragmentListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_msg, container, false);
        View layout = view.findViewById(R.id.frg_msg_layout);
        TextView messageTextView = view.findViewById(R.id.frg_text);
        TextView authorTextView = view.findViewById(R.id.frg_author);
        TextView timeStampTextView = view.findViewById(R.id.frg_timestamp);
        layout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        final String msg = getArguments().getString(ARGS_MESSAGE);
        final String aut = getArguments().getString(ARGS_AUTHOR);
        final String time = getArguments().getString(ARGS_TIMESTAMP);
        final int pos = getArguments().getInt(ARGS_POS);
        messageTextView.setText(msg);
        authorTextView.setText(aut);
        timeStampTextView.setText(time);
        Button removeButton = view.findViewById(R.id.frg_delete_btn);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onMessageClick(pos);
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MessageFragmentListener) {
            listener = (MessageFragmentListener) context;
        }
    }

    public static MessageFragment newInstance(String author, String msg, String timestamp, int pos) {
        MessageFragment messageFragment = new MessageFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGS_MESSAGE, msg);
        bundle.putString(ARGS_AUTHOR, author);
        bundle.putString(ARGS_TIMESTAMP, timestamp);
        bundle.putInt(ARGS_POS, pos);
        messageFragment.setArguments(bundle);
        return messageFragment;
    }
}