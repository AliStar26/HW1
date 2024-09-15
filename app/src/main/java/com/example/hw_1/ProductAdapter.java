package com.example.hw_1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;

    }
        @Override
        public int getCount() {
            return products.size();
        }

        @Override
        public Object getItem(int position) {
            return products.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            }

            Product currentProduct = (Product) getItem(position);

            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView nameView = convertView.findViewById(R.id.textViewName);
            TextView priceView = convertView.findViewById(R.id.textViewPrice);

            imageView.setImageResource(currentProduct.getImageResource());
            nameView.setText(currentProduct.getName());
            priceView.setText(String.format("$%.2f", currentProduct.getPrice()));

            return convertView;
        }
}