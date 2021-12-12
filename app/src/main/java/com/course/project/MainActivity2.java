package com.course.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        final MyAdapter adapter = new MyAdapter();

        adapter.addItem(new Products("코트","20만","색깔: 검정, 파랑 / 사이즈: 95,100,105",R.drawable.coat));
        adapter.addItem(new Products("청바지","10만","색깔: 진청, 연청 / 사이즈: 28,29,30",R.drawable.jean));
        adapter.addItem(new Products("니트","15만","색깔: 갈색, 검정 / 사이즈: 95,100,105",R.drawable.knit));
        adapter.addItem(new Products("롱패딩","20만","색깔: 검정, 하양 / 사이즈: 95,100,105",R.drawable.longp));
        adapter.addItem(new Products("숏패딩","15만","색깔: 검정, 회색 / 사이즈: 95,100,105",R.drawable.shortp));
        adapter.addItem(new Products("후드","20만","색깔: 검정, 파랑 / 사이즈: 95,100,105",R.drawable.hood));
        adapter.addItem(new Products("맨투맨","7만","색깔: 검정, 회색 / 사이즈: 95,100,105",R.drawable.mtm));
        adapter.addItem(new Products("정장","30만","색깔: 검정, 회색 / 사이즈: 95,100,105",R.drawable.suit));
        adapter.addItem(new Products("슬렉스","8만","색깔: 검정, 회색 / 사이즈: 28,29,30",R.drawable.slacks));
        adapter.addItem(new Products("셔츠","8만","색깔: 검정, 하양 / 사이즈: 95,100,105",R.drawable.shirt));

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnProductItemClickListener(){
            public void onItemClick(MyAdapter.ViewHolder holder, View view, int position){
                Products item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "이름 : " + item.getName() + "\n 가격 : " + item.getCost() +
                        "\n 설명 : " + item.getNote(),Toast.LENGTH_LONG).show();
            }
        });
    }
}