package com.kinghoo.user.charbotfive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList=new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        inputText=findViewById(R.id.main_text);
        send=findViewById(R.id.main_send);
        msgRecyclerView=findViewById(R.id.main_recycle);
        LinearLayoutManager layoutmanager=new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutmanager);
        adapter=new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=inputText.getText().toString();
                if(!"".equals(text)){

                    Msg msg1=new Msg(text,Msg.TYPE_SENT);
                    msgList.add(msg1);
                    adapter.notifyItemInserted(msgList.size()-1);
                    msgRecyclerView.scrollToPosition(msgList.size()-1);
                    inputText.setText("");
                }
            }
        });
    }

    private void initMsgs(){
        Msg msg1=new Msg("helloone",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("hellotwo",Msg.TYPE_SENT);
        msgList.add(msg1);
        Msg msg3=new Msg("hellothree",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
    }
}
