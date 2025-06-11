package com.example.sqlite;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class viewOnomata extends AppCompatActivity {
    private ArrayList <onomaModal> onomaModalArrayList;
    private DBHandler dbHandler;
    private onomaRVadapter onomaRVadapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_onomata);

        onomaModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(viewOnomata.this);
        onomaModalArrayList = dbHandler.diavaseOnomata();
        onomaRVadapter = new onomaRVadapter(onomaModalArrayList, viewOnomata.this);
        recyclerView = findViewById(R.id.onomataRView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewOnomata.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(onomaRVadapter);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}