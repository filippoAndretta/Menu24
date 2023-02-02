package com.netcetera.menu24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText menu, inhalt, price;
    private Button addMenuBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        menu = findViewById(R.id.idMenu);
        inhalt = findViewById(R.id.idInhalt);
        price = findViewById(R.id.idPrice);
        addMenuBtn = findViewById(R.id.idBtnAddMenu);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        addMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String menuName = menu.getText().toString();
                String menuInhalt = inhalt.getText().toString();
                String menuPrice = price.getText().toString();

                // validating if the text fields are empty or not.
                if (menuName.isEmpty() && menuInhalt.isEmpty() && menuPrice.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(menuName, menuInhalt, menuPrice);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                menu.setText("");
                inhalt.setText("");
                price.setText("");
            }
        });
    }
}