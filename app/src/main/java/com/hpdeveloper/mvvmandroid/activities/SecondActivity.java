package com.hpdeveloper.mvvmandroid.activities;

import android.os.Bundle;

import com.hpdeveloper.mvvmandroid.R;
import com.hpdeveloper.mvvmandroid.databinding.ActivitySecondBinding;
import com.hpdeveloper.mvvmandroid.view.MainActivityView;
import com.hpdeveloper.mvvmandroid.viewmodel.SecondActivityViewModel;


public class SecondActivity extends BaseActivity<ActivitySecondBinding, SecondActivityViewModel> implements MainActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindView(R.layout.activity_second);

        baseViewModel = new SecondActivityViewModel();
        baseViewModel.attachView(this);
        dataBinding.setIsLoading(true);

        baseViewModel.loadResult(getIntent());

    }

    @Override
    public void OnDataLoad(String items) {
        dataBinding.setIsLoading(false);
        dataBinding.txtResult.setText(items);

    }

    @Override
    public void OnError(Throwable throwable) {

    }

}
