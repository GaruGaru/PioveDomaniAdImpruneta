package garu.piovedomani.mvp.common;

import io.reactivex.Single;

/**
 * Created by Garu on 10/04/2017.
 */

public interface WeatherModel {
    Single<Boolean> rainObservable(String city);
}
