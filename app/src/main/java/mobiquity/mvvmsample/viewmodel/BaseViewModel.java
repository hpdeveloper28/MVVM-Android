package mobiquity.mvvmsample.viewmodel;

import mobiquity.mvvmsample.view.IView;

/**
 * Created by hirenpatel on 13/10/17.
 */

public class BaseViewModel<T extends IView> {

    public T view;

    public void attachView(T view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }
}
