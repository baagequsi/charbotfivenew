package com.kinghoo.user.charbotfive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private List<Msg> list=new ArrayList<Msg>();
    private RecyclerView mains_recycle;
    private TextView mains_text;
    private Button mains_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mains_recycle=findViewById(R.id.mains_recycle);
        mains_send=findViewById(R.id.mains_send);
        mains_text=findViewById(R.id.mains_text);
        mains_send.setOnClickListener(onclick);
        //https://git-for-windows.github.io/
        LinearLayoutManager manager=new LinearLayoutManager(this);
        mains_recycle.setLayoutManager(manager);
    }

    View.OnClickListener onclick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String text=mains_text.getText().toString();
            switch(view.getId()){
                case R.id.mains_send:
                    if(!"".equals(text)){
                        Msg msg=new Msg(text,Msg.TYPE_RECEIVED);
                        list.add(msg);
                    }
                    break;
            }
        }
    };
}
