package com.example.transpose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editKey;
    private TextView txtResult, txtTranspose;
    private Button btnUp, btnDown, btnReset, btnScale;
    public static List<String> key = new ArrayList<>();
    boolean isDefined = false;
    static int listSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editKey = findViewById(R.id.edit_key);
        txtResult = findViewById(R.id.txt_result);
        txtTranspose = findViewById(R.id.txt_transpose);
        btnUp = findViewById(R.id.btn_up);
        btnDown = findViewById(R.id.btn_down);
        btnReset = findViewById(R.id.btn_reset);
        btnScale = findViewById(R.id.goto_sc);
        if (!isDefined){
            key.add("C");
            key.add("C#");
            key.add("D");
            key.add("D#");
            key.add("E");
            key.add("F");
            key.add("F#");
            key.add("G");
            key.add("G#");
            key.add("A");
            key.add("A#");
            key.add("B");
            listSize = key.size();
            isDefined=true;
        }
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editKey.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Isi dulu inputnya", Toast.LENGTH_SHORT).show();
                } else {
                    String keyToTranspose = editKey.getText().toString().toUpperCase();
                    int index;
                    if (txtResult.getText().toString().equalsIgnoreCase("")){
                        index = key.indexOf(keyToTranspose);
                    } else {
                        index = key.indexOf(txtResult.getText().toString());
                    }
                    if (index==-1){
                        Toast.makeText(MainActivity.this, "Inputnya yg bener dong", Toast.LENGTH_SHORT).show();
                    } else {
                        txtTranspose.setText(String.valueOf(Integer.parseInt(txtTranspose.getText().toString())+1));
                        index++;
                        txtResult.setText(key.get(index%listSize));
                    }

                }

            }
        });
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editKey.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Isi dulu inputnya", Toast.LENGTH_SHORT).show();
                } else {
                    String keyToTranspose = editKey.getText().toString().toUpperCase();
                    int index;
                    if (txtResult.getText().toString().equalsIgnoreCase("")){
                        index = key.indexOf(keyToTranspose);
                    } else {
                        index = key.indexOf(txtResult.getText().toString());
                    }
                    if (index==-1){
                        Toast.makeText(MainActivity.this, "Inputnya yg bener dong", Toast.LENGTH_SHORT).show();
                    } else {
                        txtTranspose.setText(String.valueOf(Integer.parseInt(txtTranspose.getText().toString())-1));
                        index--;
                        if (index<0){
                            index = index + (listSize-index);
                            txtResult.setText(key.get(index-1));
                        } else {
                            txtResult.setText(key.get((index)%listSize));
                        }
                    }

                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editKey.setText("");
                txtResult.setText("");
                txtTranspose.setText("0");
            }
        });
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScaleCalculator.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
