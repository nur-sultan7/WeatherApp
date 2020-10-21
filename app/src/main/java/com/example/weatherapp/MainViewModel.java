package com.example.weatherapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.api.ApiFactory;
import com.example.weatherapp.api.ApiService;
import com.example.weatherapp.pojo.WeatherResponse;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<WeatherResponse> DataWeatherResponse;

    public MainViewModel(@NonNull Application application) {
        super(application);
        DataWeatherResponse =new MutableLiveData<>();
    }

    public LiveData<WeatherResponse> getDataWeatherResponse() {
        return DataWeatherResponse;
    }

    public void loadData()
    {
        ApiFactory apiFactory = new ApiFactory();
        ApiService apiService = apiFactory.getApiService();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable disposable = apiService.getWhether(51.5085300,-0.1257400)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherResponse>() {
                    @Override
                    public void accept(WeatherResponse weatherResponse) throws Exception {
                        DataWeatherResponse.postValue(weatherResponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        compositeDisposable.add(disposable);

    }
}
