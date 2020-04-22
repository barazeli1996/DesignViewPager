package com.example.designviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager pager1,pager2;
    Adapter adapter;
    Model model;
    List<Model> models;
    Integer[] colors;
          ArgbEvaluator evaluator=new ArgbEvaluator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager1=findViewById(R.id.view_pager1);
        pager2=findViewById(R.id.view_pager2);
        models=new ArrayList<>();
        models.clear();
        models.add(new Model("Ahmed ","it engineer",R.drawable.a1));
        models.add(new Model("Hamed ","Java SE",R.drawable.a2));
        models.add(new Model("Islam ","Android Dev",R.drawable.a3));
        models.add(new Model("Samir ","Flutter Dev",R.drawable.a4));
        models.add(new Model("Saad ","Kotlin Dev",R.drawable.a5));
        models.add(new Model("Farid ","Web Designer",R.drawable.a6));
        models.add(new Model("Tawfiq ","Software Engineer",R.drawable.a7));
        models.add(new Model("Shokri ","Database Administrator",R.drawable.a8));
        adapter=new Adapter(models,this);
        pager1.setAdapter(adapter);
        pager2.setAdapter(adapter);
        colors=new Integer[]
                {
                        R.color.c1,
                        R.color.c2,
                        R.color.c3,
                        R.color.c4,
                        R.color.c5,
                        R.color.c6,
                        R.color.c7,
                        R.color.c8
                };
        pager1.setPadding(30,0,30,0);
        pager2.setPadding(30,0,30,0);
     
        pager1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                      if (position<(adapter.getCount()-1)&& position<(colors.length-1)){
                          pager1.setBackgroundColor(
                                  (Integer)evaluator
                                          .evaluate(positionOffset,colors[position],colors[position+1])
                          );
                      }else {
                          pager1.setBackgroundColor(colors[colors.length-1]);
                          
                      }
            }

            @Override
            public void onPageSelected(int position) {
                int current = pager1.getCurrentItem();
                Toast.makeText(getApplicationContext(),
                        models.get(current).getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pager2.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });;
    }
}
