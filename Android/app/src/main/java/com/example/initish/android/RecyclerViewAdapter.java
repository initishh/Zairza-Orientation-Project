package com.example.initish.android;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mnames=new ArrayList<>();
    private ArrayList<String> text=new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<String> names, ArrayList<String > text){
        mnames=names;
        this.text=text;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout
                .mainpage, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.b1.setText(mnames.get(i));
        viewHolder.des1.setText(text.get(i));
        viewHolder.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch(mnames.get(i)){
                    case "TIC-TAC-TOE":
                        Intent one = new Intent(context,Main2Activity.class);
                        context.startActivity(one);
                        break;
                    case  "KNOW YOUR WEATHER":
                        Intent two = new Intent(context,Main5Activity.class);
                        context.startActivity(two);
                        break;
                    case "CURRENCY CONVERTER":
                        Intent openThree = new Intent(context,Main7Activity.class);
                        context.startActivity(openThree);break;
                    case "BRAIN TRAINER":
                        Intent four = new Intent(context,Main6Activity.class);
                        context.startActivity(four);
                        break;
                    case "TIMER APP":
                        Intent five = new Intent(context,Main4Activity.class);
                        context.startActivity(five);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mnames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        Button b1;
        TextView des1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            b1=itemView.findViewById(R.id.b1);
            des1=itemView.findViewById(R.id.des1);
        }
    }
}
