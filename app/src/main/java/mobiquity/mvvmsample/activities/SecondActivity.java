package mobiquity.mvvmsample.activities;

import android.os.Bundle;

import mobiquity.mvvmsample.R;
import mobiquity.mvvmsample.databinding.ActivitySecondBinding;
import mobiquity.mvvmsample.view.MainActivityView;
import mobiquity.mvvmsample.viewmodel.SecondActivityViewModel;

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
