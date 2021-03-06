package com.example.designviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter extends PagerAdapter implements View.OnClickListener {
    private List<Model> models;
    private LayoutInflater inflater;
    private Context context;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater=LayoutInflater.from(container.getContext());
                View view=inflater.inflate(R.layout.items,container,false);
        ImageView img=view.findViewById(R.id.img_page);
        TextView title=view.findViewById(R.id.title);
        TextView desc=view.findViewById(R.id.desc_);
        img.setImageResource(models.get(position).getImg());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());
        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "Hello..",
                Toast.LENGTH_SHORT).show();
    }
}
