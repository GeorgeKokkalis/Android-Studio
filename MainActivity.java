package com.example.movebutton;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button koumpaki;
    private TextView panoKeimeno;
    private Integer thesi;
    private Integer metritis = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        koumpaki = (Button)findViewById(R.id.koumpi);
        panoKeimeno = (TextView) findViewById(R.id.keimeno);

        koumpaki.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                thesi = (int) (Math.random()*550)+50;

                RelativeLayout.LayoutParams thesiKoumpiou =
                        new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.MATCH_PARENT);
                thesiKoumpiou.addRule(RelativeLayout.CENTER_HORIZONTAL);
                thesiKoumpiou.width = 100;
                thesiKoumpiou.height = 100;
                thesiKoumpiou.topMargin = (thesi + 100);
                koumpaki.setLayoutParams(thesiKoumpiou);
                
                metritis++;
                panoKeimeno.setText(String.valueOf(metritis));

            }
        }));



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}