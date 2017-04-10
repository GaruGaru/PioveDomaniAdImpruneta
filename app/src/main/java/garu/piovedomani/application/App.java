package garu.piovedomani.application;

import android.app.Application;
import android.content.Context;

import garu.piovedomani.R;
import garu.piovedomani.application.dagger.ApplicationComponent;
import garu.piovedomani.application.dagger.ApplicationModule;
import garu.piovedomani.application.dagger.DaggerApplicationComponent;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Garu on 12/02/2017.
 */

public class App extends Application {

    public ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();


        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static App of(Context context){
        return (App) context.getApplicationContext();
    }

}
