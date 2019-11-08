package com.bawie.movie.view.interfaces;

import com.bawie.movie.model.bean.ComingMovieBean;
import com.bawie.movie.model.bean.HotMovieBean;
import com.bawie.movie.model.bean.ReleaseMovieBean;

public interface IHomeView {

    //正在上映
    interface IRelease extends IBaseView{
        void releas(ReleaseMovieBean releaseMovieBean);
    }

    interface release extends IPresenter{
        void zheng(IRelease iRelease);
    }

    //即将上映
    interface IComint extends IBaseView{
        void comint(ComingMovieBean comingMovieBean);
    }

    interface commint extends IPresenter{
        void shang(IComint iComint);
    }

    //热门电影
    interface IBase extends IBaseView{
        void ok(HotMovieBean hotMovieBean);
    }

    interface IHome extends IPresenter{
        void load(IBase iBase);
    }

}
