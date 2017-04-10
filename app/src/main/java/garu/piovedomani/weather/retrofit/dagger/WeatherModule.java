package garu.piovedomani.weather.retrofit.dagger;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import garu.piovedomani.weather.retrofit.WeatherApi;
import garu.piovedomani.weather.retrofit.WeatherApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Garu on 10/04/2017.
 */

@Module
public class WeatherModule {

    @Provides
    @Singleton
    @Named("RetrofitLogLevel")
    HttpLoggingInterceptor.Level provideRetrofitLogLevel() {
        return HttpLoggingInterceptor.Level.BODY;
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(@Named("RetrofitLogLevel") HttpLoggingInterceptor.Level logLevel) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(logLevel);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    @Singleton
    @Named("Endpoint")
    String provideEndpoint() {
        return "http://api.openweathermap.org";
    }

    @Provides
    @Singleton
    WeatherApi provideWeatherApi(OkHttpClient client, @Named("Endpoint") String endpoint) {
        return new WeatherApiService(client, endpoint).getApi();
    }


}
