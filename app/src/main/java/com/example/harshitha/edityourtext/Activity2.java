package com.example.harshitha.edityourtext;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity2 extends Activity {
    TextView text;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent i = getIntent();
        String color = i.getStringExtra("color");
        String size = i.getStringExtra("size");
        String bold = i.getStringExtra("bold");
        String italics = i.getStringExtra("italics");
        String font = i.getStringExtra("font");
        String input = i.getStringExtra("input");



        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Gotomain = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(Gotomain);
                finish();
            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*  Intent intent = new Intent(getApplicationContext(),Activity3.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);*/
                finish();
                System.exit(0);
            }
        });

        text = (TextView) findViewById(R.id.textView);
        text.setText(input);

        set_font(font);
        set_color(color);
        set_size(size);
        set_bold_or_italics(bold,italics);

    }


    private void set_color(String color) {
        if (color.equalsIgnoreCase("Red")){
            text.setTextColor(Color.parseColor("#FF0000"));}
        if (color.equalsIgnoreCase("Blue")){
            text.setTextColor(Color.parseColor("#4169E1"));}
        if (color.equalsIgnoreCase("Green")){
            text.setTextColor(Color.parseColor("#32CD32"));}
        if (color.equalsIgnoreCase("Yellow")){
            text.setTextColor(Color.parseColor("#FFD700"));}
        if (color.equalsIgnoreCase("Black")){
            text.setTextColor(Color.parseColor("#000000"));}
    }

    private void set_size(String size) {
        if (size.equalsIgnoreCase("10")){
            text.setTextSize(10);}
        if (size.equalsIgnoreCase("15")){
            text.setTextSize(15);}
        if (size.equalsIgnoreCase("20")){
            text.setTextSize(20);}
        if (size.equalsIgnoreCase("25")){
            text.setTextSize(25);}
        if (size.equalsIgnoreCase("35")){
            text.setTextSize(35);}

    }

    private void set_bold_or_italics(String bold, String italics) {
        if(bold.equals("true")&&italics.equals("true")){
            text.setTextAppearance(getApplicationContext(),R.style.Both);
        }
        if(bold.equals("true")&&italics.equals("false")){
            text.setTextAppearance(getApplicationContext(),R.style.boldText);
        }
        if(bold.equals("false")&&italics.equals("true")) {
            text.setTextAppearance(getApplicationContext(),R.style.italicText);
        }
    }

    private void set_font(String font) {
        if(font.equalsIgnoreCase("sans")){
            text.setTypeface(Typeface.SANS_SERIF);
        }
        if(font.equalsIgnoreCase("monospace")){
            text.setTypeface(Typeface.MONOSPACE);
        }
        if(font.equalsIgnoreCase("serif")) {
            text.setTypeface(Typeface.SERIF);
        }
    }

}

