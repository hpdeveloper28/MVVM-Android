package com.hpdeveloper.mvvmandroid.activities;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;

import com.hpdeveloper.mvvmandroid.viewmodel.BaseViewModel;

/**
 * Created by hirenpatel on 13/10/17.
 */

public abstract class BaseActivity<B extends ViewDataBinding, T extends BaseViewModel> extends AppCompatActivity {

    protected B dataBinding;
    protected T baseViewModel;

    protected void bindView(int layoutId) {
        dataBinding = DataBindingUtil.setContentView(this, layoutId);
    }

    @Override
    protected void onDestroy() {
        baseViewModel.detachView();
        super.onDestroy();
    }
}
