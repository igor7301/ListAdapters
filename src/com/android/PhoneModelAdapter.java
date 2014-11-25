package com.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by v-ikomarov on 11/17/2014.
 */
public class PhoneModelAdapter extends BaseAdapter {

    private List<PhoneModel> phoneModels;
    private  LayoutInflater layoutInflater;

    public PhoneModelAdapter(Context context, List<PhoneModel> phoneModels) {
        this.phoneModels = phoneModels;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return phoneModels.size();
    }

    @Override
    public Object getItem(int i) {
        return phoneModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        }


        TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
        TextView textViewModel = (TextView) view.findViewById(R.id.textViewModel);
        TextView textViewPrice = (TextView) view.findViewById(R.id.textViewPrice);
        textViewName.setText(phoneModels.get(position).getName());
        textViewModel.setText(phoneModels.get(position).getModel());
        textViewPrice.setText(phoneModels.get(position).getPrice());
        return view;
    }
}
