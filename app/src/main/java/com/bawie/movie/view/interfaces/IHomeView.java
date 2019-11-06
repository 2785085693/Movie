package com.bawie.movie.view.interfaces;

import com.bawie.movie.model.bean.Bean;

public interface IHomeView {

    interface IBase extends IBaseView{
        void ok(Bean bean);
    }

    interface IHome extends IPresenter{
        void load(IBase iBase);
    }


}
