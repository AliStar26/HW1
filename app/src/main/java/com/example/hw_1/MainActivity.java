package com.example.hw_1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView selectedCategoryTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        selectedCategoryTextView = findViewById(R.id.selectedCategoryTextView);

        // Создаем список категорий
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(R.drawable.ic_launcher_foreground, "Фрукты"));
        categories.add(new Category(R.drawable.ic_launcher_foreground, "Овощи"));
        categories.add(new Category(R.drawable.ic_launcher_foreground, "Молочные продукты"));

        // Создаем и устанавливаем адаптер
        CategoryAdapter adapter = new CategoryAdapter(this, categories);
        spinner.setAdapter(adapter);

        // Обработка выбора элемента из Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Category selectedCategory = (Category) parent.getItemAtPosition(position);
                selectedCategoryTextView.setText("Вы выбрали: " + selectedCategory.getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedCategoryTextView.setText("Ничего не выбрано");
            }
        });
    }

}
