package garu.piovedomani.weather.retrofit;

import garu.piovedomani.weather.retrofit.response.WeatherForecast;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Garu on 10/04/2017.
 */

public interface WeatherApi {
    @GET("/data/2.5/forecast")
    Single<WeatherForecast> getForecast(@Query("q") String city, @Query("APPID") String apiKey);
}
