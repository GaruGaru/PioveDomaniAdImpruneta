package garu.piovedomani.mvp.common;

/**
 * Created by Garu on 10/04/2017.
 */

public interface WeatherView {

    void showRain();

    void showSun();

    void showError(String message);

    void showLoading();

}
