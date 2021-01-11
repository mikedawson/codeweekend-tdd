package com.ustadmobile.testdrivedevdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener{

    MainPresenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        presenter = new MainPresenter(this);
    }

    @Override
    public void onClick(View view) {
        DatePicker picker = findViewById(R.id.datePicker);
        presenter.handleClickNext(picker.getDayOfMonth(), picker.getMonth(), picker.getYear());
    }

    @Override
    public void showAdultScreen() {
        Intent startAdultScreen = new Intent(this, AdultActivity.class);
        startActivity(startAdultScreen);
    }

    @Override
    public void showChildScreen() {
        Intent startChildScreen = new Intent(this, ChildActivity.class);
        startActivity(startChildScreen);
    }
}