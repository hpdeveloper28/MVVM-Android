package mobiquity.mvvmsample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mobiquity.mvvmsample.R;
import mobiquity.mvvmsample.databinding.ActivityMainBinding;
import mobiquity.mvvmsample.view.MainActivityView;
import mobiquity.mvvmsample.viewmodel.MainActivityViewModel;

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
