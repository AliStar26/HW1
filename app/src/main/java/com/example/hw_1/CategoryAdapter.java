package com.example.hw_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(Context context, ArrayList<Category> categories) {
        super(context, 0, categories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);

        Category currentCategory = getItem(position);

        if (currentCategory != null) {
            imageView.setImageResource(currentCategory.getImageResource());
            textView.setText(currentCategory.getName());
        }

        return convertView;
    }
}