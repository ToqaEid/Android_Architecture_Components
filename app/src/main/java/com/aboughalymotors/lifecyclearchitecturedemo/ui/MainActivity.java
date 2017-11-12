package com.aboughalymotors.lifecyclearchitecturedemo.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.aboughalymotors.lifecyclearchitecturedemo.R;
import com.aboughalymotors.lifecyclearchitecturedemo.viewmodel.MinDateTimeViewMode;

public class MainActivity extends AppCompatActivity {

    ////UI REFERENCES
    private TextView minDate;

    ////VARIABLES
    private MinDateTimeViewMode viewModel;


    ////METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initViewModel();

        observeMinDateData();

    }

    /*================================== PRIVATE HELPFUL METHODS ==============================*/
    private void initView() {
        minDate = findViewById(R.id.min_date_txt);
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MinDateTimeViewMode.class);
        viewModel.init();
    }

    private void observeMinDateData() {
        viewModel.getMinDate().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                minDate.setText(s);

            }
        });
    }

}
