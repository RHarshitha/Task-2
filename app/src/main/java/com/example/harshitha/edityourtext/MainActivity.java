package com.example.harshitha.edityourtext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;


public class MainActivity extends Activity {
    Spinner color;
    Spinner size;
    CheckBox bold;
    CheckBox italics;
    EditText input;
    ListView fonts;

        String fontvalue;
        String colorvalue;
        String sizevalue;
        String boldvalue;
        String italicsvalue;


    String [] fonts_array ={"sans","monospace","serif"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color=(Spinner)findViewById(R.id.spinner3);
        size=(Spinner)findViewById(R.id.spinner4);

        color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                colorvalue = String.valueOf(parent.getItemAtPosition(position));
                Log.d("color", colorvalue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                colorvalue="Black";
            }
        });
        size.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sizevalue = String.valueOf(parent.getItemAtPosition(position));
                Log.d("size",sizevalue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                sizevalue="15";
            }
        });


        bold=(CheckBox)findViewById(R.id.checkBox);
        boldvalue="false";
        bold.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                { boldvalue = "true";}
            }
        });

        italics=(CheckBox)findViewById(R.id.checkBox2);
       italicsvalue="false";
        italics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                {italicsvalue = "true";}
            }
        });

        input=(EditText)findViewById(R.id.editText);

        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fonts_array);
        fonts=(ListView)findViewById(R.id.listView);
        fonts.setAdapter(adapter);
        fonts.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fontvalue=(String)parent.getItemAtPosition(position);
                Intent Gotosecond = new Intent(getApplicationContext(),Activity2.class);
                Gotosecond.putExtra("color",colorvalue);
                Gotosecond.putExtra("size",sizevalue);
                Gotosecond.putExtra("bold",boldvalue);
                Gotosecond.putExtra("italics",italicsvalue);
                Gotosecond.putExtra("font",fontvalue);
                Gotosecond.putExtra("input",input.getText().toString());
                startActivity(Gotosecond);
                finish();

            }
        });


    }



}
