package com.example.p3750852.conversation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.messageList)
        RecyclerView recyclerView;

    @BindView(R.id.edit)
    EditText editMessage;

    @BindView(R.id.send)
    Button send;

CopyOnWriteArrayList<Message> messages = new CopyOnWriteArrayList<>();

    RowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messages.addAll(getDummyMessages());

        ButterKnife.bind(this);
        loadData();

    }

    @OnClick(R.id.send)
    public void send() {
        Message m = new Message();
        m.setMine(true);
        m.setMessage(editMessage.getText().toString());
        m.setSendDate(new Date());
        messages.add(m);
        adapter.notifyDataSetChanged();
        editMessage.setText("");
        recyclerView.scrollToPosition(messages.size()-1);
    }

    public void loadData() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        adapter = new RowAdapter(messages);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public List<Message> getDummyMessages () {
        List<Message> ms = new ArrayList<>();
        ms.add(Message.getRandomMessage());
        ms.add(Message.getRandomMessage());
        ms.add(Message.getRandomMessage());
        ms.add(Message.getRandomMessage());
        ms.add(Message.getRandomMessage());
        return ms;
    }
}
