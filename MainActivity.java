package com.example.sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText onoma;
    private EditText eponimo;
    private Button button;
    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        onoma = (EditText) findViewById(R.id.onoma);
        eponimo = (EditText) findViewById(R.id.eponimo) ;
        button = findViewById(R.id.button)  ;


        dbHandler = new DBHandler(MainActivity.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = onoma.getText().toString();
                String surname = eponimo.getText().toString();

                if (name.isEmpty() && surname.isEmpty()){
                    Toast.makeText(MainActivity.this, "Γέμισε και τα δύο πεδία", Toast.LENGTH_SHORT).show();
                    return;

                    }
                    dbHandler.addNewName(name, surname);
                    Toast.makeText(MainActivity.this, "Προστέθηκε το όνομα", Toast.LENGTH_SHORT).show();
                    onoma.setText("");
                    eponimo.setText("");


            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}