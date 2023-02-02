package com.netcetera.menu24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.netcetera.menu24.DBHandler.DBHandler;
import com.netcetera.menu24.View.ViewMenus;


public class MainActivity extends AppCompatActivity {

    private EditText menu, inhalt, price;
    private Button addMenuBtn, readMenuBtn;
    private DBHandler dbHandler;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.idMenu);
        inhalt = findViewById(R.id.idInhalt);
        price = findViewById(R.id.idPrice);
        addMenuBtn = findViewById(R.id.idBtnAddMenu);
        readMenuBtn = findViewById(R.id.idBtnReadMenu);

        dbHandler = new DBHandler(MainActivity.this);

        addMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String menuName = menu.getText().toString();
                String menuInhalt = inhalt.getText().toString();
                String menuPrice = price.getText().toString();

                if (menuName.isEmpty() && menuInhalt.isEmpty() && menuPrice.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewCourse(menuName, menuInhalt, menuPrice);

                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                menu.setText("");
                inhalt.setText("");
                price.setText("");
            }
        });

        readMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewMenus.class);
                startActivity(i);
            }
        });

        Button cameraButton = findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }
}