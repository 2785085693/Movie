package com.bawie.movie.presenter;

import com.bawie.movie.view.interfaces.IBaseView;

public class BasePresenter <V extends IBaseView>{

    private V v;

    public V getV() {
        return v;
    }

    public void attach(V v){
        this.v = v;
    }

    public void detach(){
        this.v = null;
    }
}
