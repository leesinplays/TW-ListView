package com.myapplicationdev.android.tw_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Year> year;
    ArrayAdapter aaYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) this.findViewById(R.id.lvYear);

        year = new ArrayList<Year>();
        year.add(new Year("Year 1"));
        year.add(new Year("Year 2"));
        year.add(new Year("Year 3"));

        aaYear = new YearAdapter(this, R.layout.row2, year);
        lv.setAdapter(aaYear);

//        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.row2,al);
//        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Year selectedYear = year.get(position);

                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, selectedYear.getName());
                startActivity(intent);
            }
        });

    }
}
