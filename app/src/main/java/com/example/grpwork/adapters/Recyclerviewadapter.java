package com.example.grpwork.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.grpwork.R;


public class Recyclerviewadapter extends RecyclerView.Adapter<Recyclerviewadapter.ViewHolder>{

    String[] values;
    public  Context context1;

    public Recyclerviewadapter(Context context2, String[] values2){

        values = values2;

        context1 = context2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View v){

            super(v);

            textView = (TextView) v.findViewById(R.id.textview1);
            imageView  = (ImageView) v.findViewById(R.id.imageview);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

//            Glide.with(context1)
//                    .load("https://know.mego.com.bd/wp-content/uploads/2020/06/shutterstock_1384554629-898x505-1.jpg")
//                    .into(imageView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view1 = LayoutInflater.from(context1).inflate(R.layout.items,parent,false);

        ViewHolder viewHolder1 = new ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder Vholder, int position){

        Vholder.textView.setText(values[position]);

//        Vholder.textView.setBackgroundColor(Color.CYAN);

//        Vholder.textView.setTextColor(Color.BLUE);

    }

    @Override
    public int getItemCount(){

        return values.length;
    }
}