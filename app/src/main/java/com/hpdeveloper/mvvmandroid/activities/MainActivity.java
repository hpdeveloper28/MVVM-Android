package com.hpdeveloper.mvvmandroid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hpdeveloper.mvvmandroid.R;
import com.hpdeveloper.mvvmandroid.databinding.ActivityMainBinding;
import com.hpdeveloper.mvvmandroid.view.MainActivityView;
import com.hpdeveloper.mvvmandroid.viewmodel.MainActivityViewModel;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> implements MainActivityView, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindView(R.layout.activity_main);

        baseViewModel = new MainActivityViewModel();
        baseViewModel.attachView(this);

        dataBinding.btnPerformOperation.setOnClickListener(this);

    }

    @Override
    public void OnDataLoad(String item) {
        dataBinding.setIsLoading(false);
        startActivity(new Intent(MainActivity.this, SecondActivity.class).putExtra("result", item));
    }

    @Override
    public void OnError(Throwable throwable) {

    }

    @Override
    public void onClick(View v) {
        dataBinding.setIsLoading(true);
        baseViewModel.loadNextData();
    }
}
