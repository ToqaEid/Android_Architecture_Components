package com.aboughalymotors.lifecyclearchitecturedemo.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.aboughalymotors.lifecyclearchitecturedemo.R;
import com.aboughalymotors.lifecyclearchitecturedemo.viewmodel.MinDateTimeViewMode;

public class MainActivity extends AppCompatActivity {

    private MinDateTimeViewMode viewModel;
    private TextView minDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MinDateTimeViewMode.class);
        viewModel.init();

        minDate = findViewById(R.id.min_date_txt);

        viewModel.getMinDate().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                minDate.setText(s);
                Log.d("main", "onCreate: s: " + s);

            }
        });

    }



}
