package com.example.transpose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ScaleCalculator extends AppCompatActivity {

    private TextView scaleName, sharp2, sharp3, sharp4, sharp5, sharp6, sharp7;
    private TextView flat2, flat3, flat4, flat5, flat6, flat7;
    static String one = "1";
    static String two = "2";
    static String three = "3";
    static String four = "4";
    static String five = "5";
    static String six = "6";
    static String seven = "7";
    Button btnTranspose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_calculator);
        scaleName = findViewById(R.id.scale_name);
        sharp2 = findViewById(R.id.sharp2);
        sharp3 = findViewById(R.id.sharp3);
        sharp4 = findViewById(R.id.sharp4);
        sharp5 = findViewById(R.id.sharp5);
        sharp6 = findViewById(R.id.sharp6);
        sharp7 = findViewById(R.id.sharp7);
        flat2 = findViewById(R.id.flat2);
        flat3 = findViewById(R.id.flat3);
        flat4 = findViewById(R.id.flat4);
        flat5 = findViewById(R.id.flat5);
        flat6 = findViewById(R.id.flat6);
        flat7 = findViewById(R.id.flat7);
        btnTranspose = findViewById(R.id.goto_tp);

        scaleName.setText("Ionian (Major)");

        btnTranspose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScaleCalculator.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        sharp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sharp2.getAlpha()<1){
                    setActive(sharp2);
                    setInactive(flat2);
                    two = "#2";

                } else {
                    setInactive(sharp2);
                    two = "2";
                }
                cariScaleJson(mergeID());
            }
        });
        flat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flat2.getAlpha()<1){
                    setActive(flat2);
                    setInactive(sharp2);
                    two = "b2";

                } else {
                    setInactive(flat2);
                    two = "2";
                }
                cariScaleJson(mergeID());
            }

        });
        sharp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sharp3.getAlpha()<1){
                    setActive(sharp3);
                    setInactive(flat3);
                    three = "#3";

                } else {
                    setInactive(sharp3);
                    three = "3";
                }
                cariScaleJson(mergeID());
            }
        });
        flat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flat3.getAlpha()<1){
                    setActive(flat3);
                    setInactive(sharp3);
                    three = "b3";

                } else {
                    setInactive(flat3);
                    three = "3";
                }
                cariScaleJson(mergeID());
            }

        });
        sharp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sharp4.getAlpha()<1){
                    setActive(sharp4);
                    setInactive(flat4);
                    four = "#4";

                } else {
                    setInactive(sharp4);
                    four = "4";
                }
                cariScaleJson(mergeID());
            }
        });
        flat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flat4.getAlpha()<1){
                    setActive(flat4);
                    setInactive(sharp4);
                    four = "b4";

                } else {
                    setInactive(flat4);
                    four = "4";
                }
                cariScaleJson(mergeID());
            }

        });
        sharp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sharp5.getAlpha()<1){
                    setActive(sharp5);
                    setInactive(flat5);
                    five = "#5";

                } else {
                    setInactive(sharp5);
                    five = "5";
                }
                cariScaleJson(mergeID());
            }
        });
        flat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flat5.getAlpha()<1){
                    setActive(flat5);
                    setInactive(sharp5);
                    five = "b5";

                } else {
                    setInactive(flat5);
                    five = "5";
                }
                cariScaleJson(mergeID());
            }

        });
        sharp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sharp6.getAlpha()<1){
                    setActive(sharp6);
                    setInactive(flat6);
                    six = "#6";

                } else {
                    setInactive(sharp6);
                    six = "6";
                }
                cariScaleJson(mergeID());
            }
        });
        flat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flat6.getAlpha()<1){
                    setActive(flat6);
                    setInactive(sharp6);
                    six = "b6";

                } else {
                    setInactive(flat6);
                    six = "6";
                }
                cariScaleJson(mergeID());
            }

        });
        sharp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sharp7.getAlpha()<1){
                    setActive(sharp7);
                    setInactive(flat7);
                    seven = "#7";

                } else {
                    setInactive(sharp7);
                    seven = "7";
                }
                cariScaleJson(mergeID());
            }
        });
        flat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flat7.getAlpha()<1){
                    setActive(flat7);
                    setInactive(sharp7);
                    seven = "b7";

                } else {
                    setInactive(flat7);
                    seven = "7";
                }
                cariScaleJson(mergeID());
            }

        });
    }

    private void setActive(TextView textView){
        textView.setTextColor(Color.parseColor("#00c853"));
        textView.setAlpha(1);
    }

    private void setInactive(TextView textView){
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setAlpha(0.38f);
    }

    private String mergeID (){
        return one+two+three+four+five+six+seven;
    }

    private void cariScaleJson (String id){
        String json;
        boolean found = false;
        try {
            InputStream inputStream = getAssets().open("scale_list.json");
            int size=inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json= new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.getString("id").equals(id)){
                    scaleName.setText(obj.getString("name"));
                    found = true;
                }
            }
        } catch (IOException e){

        } catch (JSONException e){

        }
        if (!found){
            scaleName.setText("Sorry, I didn't know that :(");
        }
    }
}