package garu.piovedomani.mvp.impl;

import android.content.Context;

import garu.piovedomani.R;
import garu.piovedomani.mvp.common.WeatherModel;
import garu.piovedomani.weather.retrofit.WeatherApi;
import io.reactivex.Single;

/**
 * Created by Garu on 10/04/2017.
 */

public class WeatherModelOpenApi implements WeatherModel {

    private WeatherApi api;

    private String apiKey;

    public WeatherModelOpenApi(Context context, WeatherApi api) {
        this.api = api;
        this.apiKey = context.getString(R.string.openweather_api_key);
    }

    @Override
    public Single<Boolean> rainObservable(String city) {
         return api.getForecast(city, apiKey)
                .map(response -> response.list[0])
                  .map(day -> day.weather[0])
                  .map(weather -> weather.main)
                  .map(main -> main.equals("rain"));
    }
}
