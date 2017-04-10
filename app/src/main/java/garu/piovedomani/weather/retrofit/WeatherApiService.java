package garu.piovedomani.weather.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Garu on 10/04/2017.
 */

public class WeatherApiService {

    private WeatherApi api;

    public WeatherApiService(OkHttpClient client, String endpoint){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(endpoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.api = retrofit.create(WeatherApi.class);
    }

    public WeatherApi getApi() {
        return api;
    }
}
