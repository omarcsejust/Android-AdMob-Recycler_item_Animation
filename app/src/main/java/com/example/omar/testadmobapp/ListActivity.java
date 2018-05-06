package com.example.omar.testadmobapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ListModel> listModelArrayList;  // Country is a Pojo (Model) Class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        int img=R.drawable.omar;

        recyclerView=findViewById(R.id.recycler_view);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        listModelArrayList=new ArrayList<>();

        ListModel listModel1=new ListModel(img);
        listModelArrayList.add(listModel1);

        ListModel listModel2=new ListModel(img);
        listModelArrayList.add(listModel2);

        ListModel listModel3=new ListModel(img);
        listModelArrayList.add(listModel3);

        ListModel listModel4=new ListModel(img);
        listModelArrayList.add(listModel4);

        ListModel listModel5=new ListModel(img);
        listModelArrayList.add(listModel5);

        initRecyclerView();

    }

    private void initRecyclerView(){

        LayoutAnimationController controller=null;
        Context context=recyclerView.getContext();

        controller=AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation_slide_from_bottom);

        adapter=new ListAdapter(this,listModelArrayList);  // "this" is a contect of current activity....

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}
