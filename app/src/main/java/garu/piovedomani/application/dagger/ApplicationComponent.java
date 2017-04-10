package garu.piovedomani.application.dagger;

import javax.inject.Singleton;

import dagger.Component;
import garu.piovedomani.MainActivity;
import garu.piovedomani.mvp.dagger.MvpModule;
import garu.piovedomani.weather.retrofit.dagger.WeatherModule;

/**
 * Created by Garu on 12/02/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, WeatherModule.class, MvpModule.class})
public interface ApplicationComponent {
    void inject(MainActivity activity);
}
