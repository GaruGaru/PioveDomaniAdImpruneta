package garu.piovedomani.mvp.common;

import garu.piovedomani.mvp.impl.Presenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Garu on 10/04/2017.
 */

public class WeatherPresenter extends Presenter<WeatherModel, WeatherView> {

    public WeatherPresenter(WeatherModel model) {
        super(model);
    }

    public void refresh(String city) {
        getView().showLoading();
        getModel().rainObservable(city)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        response -> {
                            if (response)
                                getView().showRain();
                            else
                                getView().showSun();
                        },
                        error -> {
                            error.printStackTrace();
                            getView().showError("Network error");
                        }
                );
    }


}
