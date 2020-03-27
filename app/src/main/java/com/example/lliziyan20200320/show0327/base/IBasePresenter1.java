package com.example.lliziyan20200320.show0327.base;

public abstract class IBasePresenter1<View> {
    public View view;

    public IBasePresenter1() {
        initPresenter();
    }

    public void attachView(View view){
        this.view = view;
    }
    public void detachView(){
        if (view != null) {
            view = null;
        }
    }
    public abstract void initPresenter();
}
