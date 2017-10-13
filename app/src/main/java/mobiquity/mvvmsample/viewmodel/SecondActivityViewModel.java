package mobiquity.mvvmsample.viewmodel;

import android.content.Intent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import mobiquity.mvvmsample.view.MainActivityView;

/**
 * Created by hirenpatel on 13/10/17.
 */

public class SecondActivityViewModel extends BaseViewModel<MainActivityView> {

    public void loadResult(Intent intent) {
        getObservable(intent).delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver());

    }

    private Observable<String> getObservable(Intent intent) {
        return Observable.just(intent.getStringExtra("result"));
    }

    private Observer<String> getObserver() {
        return new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(String value) {
                view.OnDataLoad(value);
            }

            @Override
            public void onError(Throwable e) {
                view.OnError(e);
            }

            @Override
            public void onComplete() {
            }
        };

    }
}
