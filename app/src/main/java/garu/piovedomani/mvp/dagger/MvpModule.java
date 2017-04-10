package garu.piovedomani.mvp.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import garu.piovedomani.mvp.common.WeatherModel;
import garu.piovedomani.mvp.common.WeatherPresenter;
import garu.piovedomani.mvp.impl.WeatherModelOpenApi;
import garu.piovedomani.weather.retrofit.WeatherApi;

/**
 * Created by Garu on 10/04/2017.
 */

@Module
public class MvpModule {

    @Singleton
    @Provides
    public WeatherModel provideWeatherModel(Context context, WeatherApi api){
        return new WeatherModelOpenApi(context, api);
    }

    @Singleton
    @Provides
    public WeatherPresenter provideWeatherPresenter(WeatherModel model){
        return new WeatherPresenter(model);
    }

}
