package com.jandoblelim.androidchallengejanlim.app.main;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.jandoblelim.androidchallengejanlim.R;
import com.jandoblelim.androidchallengejanlim.app.App;
import com.jandoblelim.androidchallengejanlim.database.model.ApiHitCounter;
import com.jandoblelim.androidchallengejanlim.database.realm.RealmApiHitCounterRepository;
import com.jandoblelim.androidchallengejanlim.events.WeatherEvent;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainContract.View{

    //dagger 2: injecting the presenter layer
    @Inject
    MainPresenter mMainPresenter;

    //Using butterknife to bind the views
    @BindView(R.id.text_view_api_hit_counter)
    TextView mTextViewHitCounter;
    @BindView(R.id.text_view_detail_date)
    TextView mTextViewDate;
    @BindView(R.id.text_view_detail_temp)
    TextView mTextViewTemp;
    @BindView(R.id.text_view_detail_summary)
    TextView mTextViewSummary;
    @BindView(R.id.text_view_detail_windspeed)
    TextView mTextViewWindspeed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Using dagger2 here to define to the modules what the context is and injecting it.
        DaggerIMainComponent.builder()
                .iAppComponent(App.getAppComponent(getApplication()))
                .mainModule(new MainModule(this))
                .build()
                .inject(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter.onResume();

        ApiHitCounter apiHitCounter = RealmApiHitCounterRepository.getApiHitCounterById(1);

        String counter = String.format(getResources().getString(R.string.string_view_api_hit_counter), String.valueOf(apiHitCounter.getCounter()));
        mTextViewHitCounter.setText(counter);
    }

    @Override
    public void onStart() {
        super.onStart();
        mMainPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMainPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.onDestroy();
    }


    @Override
    public void showRefreshing(boolean b) {

    }

    @Override
    public void showErrorDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder
                .setMessage(R.string.something_went_wrong)
                .setPositiveButton(R.string.ok, null)
                .show();
    }

    @Override
    public void renderView(WeatherEvent weatherEvent) {
        mTextViewDate.setText(weatherEvent.getDate());
        mTextViewSummary.setText(weatherEvent.getSummary());
        mTextViewTemp.setText(weatherEvent.getTemperature() + " F");
        mTextViewWindspeed.setText(weatherEvent.getWindspeed());

        ApiHitCounter apiHitCounter = RealmApiHitCounterRepository.getApiHitCounterById(1);

        String counter = String.format(getResources().getString(R.string.string_view_api_hit_counter), String.valueOf(apiHitCounter.getCounter()));
        mTextViewHitCounter.setText(counter);
    }

}
