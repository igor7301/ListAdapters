package com.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;

    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView  = (ListView) findViewById(R.id.listView);

        List<PhoneModel> phoneModels = createPhones();

       // BaseAdapter listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, new String[]{"Lg", "Samsung"});

        PhoneModelAdapter listAdapter = new PhoneModelAdapter(this,phoneModels);


        listView.setAdapter(listAdapter);
        setListViewHeightBasedOnChildren(listView);

    }

    private List<PhoneModel> createPhones() {
        List<PhoneModel> phones = new ArrayList<PhoneModel>();
        phones.add(new PhoneModel("Lg", "125", "110$"));
        phones.add(new PhoneModel("Samsung", "S", "450$"));
        phones.add(new PhoneModel("iPhone", "5C", "500$"));
        phones.add(new PhoneModel("TX", "125", "180$"));
        phones.add(new PhoneModel("Motorolla", "RZ", "500$"));
        phones.add(new PhoneModel("Lg", "125", "110$"));
        phones.add(new PhoneModel("Samsung", "S", "450$"));
        phones.add(new PhoneModel("iPhone", "5C", "500$"));
        phones.add(new PhoneModel("TX", "125", "180$"));
        phones.add(new PhoneModel("Motorolla", "RZ", "500$"));

        return phones;


    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
