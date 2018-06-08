package com.kinghoo.user.charbotfive;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class Main2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Msg> list;

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftlayout;
        LinearLayout rightllayout;
        TextView leftmsg;
        TextView rightmsg;

        public ViewHolder(View view){
            super(view);
            leftlayout=view.findViewById(R.id.left_layout);
            rightllayout=view.findViewById(R.id.right_layout);
            leftmsg=view.findViewById(R.id.left_msg);
            rightmsg=view.findViewById(R.id.right_msg);
        }
    }

    public Main2Adapter(List<Msg> list){
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Msg msg=list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
