package com.bawie.movie.view.interfaces;

import com.bawie.movie.model.bean.CinemaBean;
import com.bawie.movie.model.bean.ComingMovieBean;
import com.bawie.movie.model.bean.DetailsBean;
import com.bawie.movie.model.bean.FindBean;
import com.bawie.movie.model.bean.HotMovieBean;
import com.bawie.movie.model.bean.RecomBean;
import com.bawie.movie.model.bean.RegionBean;
import com.bawie.movie.model.bean.ReleaseMovieBean;

import java.util.Map;

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

    //电影详情
    interface IDeta extends IBaseView{
        void deta(DetailsBean detailsBean);
    }

    interface IDetails extends IPresenter{
        void detas(IDeta iDeta);
    }

    //电影详情
    interface IFind extends IBaseView{
        void find(FindBean findBean);
    }

    interface IFinds extends IPresenter{
        void finds(IFind iFind);
    }

    //推荐影院
    interface IRecom extends IBaseView{
        void recom(RecomBean recomBean);
    }

    interface Irecoms extends IPresenter{
        void recoms(IRecom irecom);
    }

    //区域
    interface IRegiog extends IBaseView{
        void iregi(RegionBean regionBean);
    }
    interface IRegions extends IPresenter{
        void iregion(IRegiog iRegiog);
    }

    //查询影院
    interface ICinema extends IBaseView{
        void cinem(CinemaBean cinemaBean);
    }
    interface ICinemas extends IPresenter{
        void icinema(ICinema iCinema);
    }

    interface doGuild extends IBaseView{
        void doGuilds(Map<String,String> map);
    }

}
