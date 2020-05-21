package com.example.saurav.cookbyown;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by saurav on 5/17/2020.
 */

public class CustomListView extends ArrayAdapter<String> {

    private String [] items;
    private String [] desc;
    private Integer[]logo;
    private Activity context;


    public CustomListView(Activity context, String [] items,String [] desc,Integer[]logo) {
        super(context, R.layout.layout_food_type,items); //bnaya hua layout ke liye

        this.context=context;
        this.desc=desc;
        this.items=items;
        this.logo=logo;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r=convertView;
        ViewHolder viewHolder=null;
        if (r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layout_food_type,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);// img ko rok ke rakhne aur daalne
        }
        else {
            viewHolder = (ViewHolder) r.getTag();
        }

        viewHolder.iv.setImageResource(logo[position]);
        viewHolder.tv1.setText(items[position]);
        viewHolder.tv2.setText(desc[position]);
        return r;

    }
    class ViewHolder{
        TextView tv1;
        TextView tv2;
        ImageView iv;
        ViewHolder(View v)
        {
         tv1= (TextView) v.findViewById(R.id.food_name);
         tv2= (TextView) v.findViewById(R.id.food_detail);
         iv= (ImageView) v.findViewById(R.id.logo);
        }
    }
}
