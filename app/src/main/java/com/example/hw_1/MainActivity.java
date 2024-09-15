package com.example.hw_1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> names;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        names = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            String name = editText.getText().toString();
            if (!name.isEmpty()) {
                names.add(name);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
    }
}