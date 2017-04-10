package garu.piovedomani;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import garu.piovedomani.application.App;
import garu.piovedomani.mvp.common.WeatherPresenter;
import garu.piovedomani.mvp.common.WeatherView;

public class MainActivity extends AppCompatActivity implements WeatherView {

    @BindView(R.id.main_image)
    ImageView mainImage;

    @BindView(R.id.main_text)
    TextView mainText;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    WeatherPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.of(this).getApplicationComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        this.presenter.setView(this);
        refresh();
    }

    @OnClick(R.id.main_image)
    void refresh() {
        this.presenter.refresh(getText(R.string.city_name).toString());
    }

    private void show(int textRes, int imageRes) {
        this.mainImage.setImageResource(imageRes);
        this.mainText.setText(getText(textRes));
        this.mainImage.setVisibility(View.VISIBLE);
        this.mainText.setVisibility(View.VISIBLE);
        this.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRain() {
        this.show(R.string.yes, R.drawable.ic_rain);
    }

    @Override
    public void showSun() {
        this.show(R.string.no, R.drawable.ic_sun);
    }

    @Override
    public void showError(String message) {
        this.show(R.string.idk, R.drawable.ic_face_neutral);
    }

    @Override
    public void showLoading() {
        this.mainImage.setVisibility(View.GONE);
        this.mainText.setVisibility(View.GONE);
        this.progressBar.setVisibility(View.VISIBLE);
    }
}
