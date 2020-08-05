package com.example.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }


    //convertView 对加载好的布局进行保存
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Fruit fruit =getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view =LayoutInflater.from(getContext()).inflate(resourceId, parent,false);
            viewHolder =new ViewHolder();
            viewHolder.fruitImage =(ImageView)view.findViewById(R.id.imageView);
            viewHolder.fruitText = (TextView)view.findViewById(R.id.textView);
            view.setTag(viewHolder);//将viewholder 存储在view中
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();//重新获取viewHolder
        }


        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitText.setText(fruit.getName());
        return view;

    }

    class ViewHolder{
        ImageView fruitImage;
        TextView fruitText;
    }

}
