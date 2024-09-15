package com.example.hw_1;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
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
    private ArrayList<Product> products;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);

        products = new ArrayList<>();
        products.add(new Product(R.drawable.ic_launcher_foreground, "Молоко", 1.50));
        products.add(new Product(R.drawable.ic_launcher_foreground, "Хлеб", 0.80));
        products.add(new Product(R.drawable.ic_launcher_foreground, "Яблоки", 2.30));

        adapter = new ProductAdapter(this, products);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            products.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
    }


}
