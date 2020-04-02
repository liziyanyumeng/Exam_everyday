package com.example.lliziyan20200320.Order0402.base;
//泛型类，绑定视图与解绑视图
public abstract class IBasePresenter<View> {
    public View view;

    public IBasePresenter() {
        initModel();
    }

    public void attachView(View view){
        this.view = view;
    }
    public void detachView(){
        if (view != null) {
            view = null;
        }
    }
    public abstract void initModel();
}
