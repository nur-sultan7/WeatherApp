package com.example.weatherapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.api.ApiFactory;
import com.example.weatherapp.api.ApiService;
import com.example.weatherapp.data.City;
import com.example.weatherapp.pojo.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<List<WeatherResponse>> dataWeatherResponse;
    private List<WeatherResponse> weatherResponseList;

    public List<WeatherResponse> getWeatherResponseList() {
        return weatherResponseList;
    }

    public MainViewModel(@NonNull Application application) {
        super(application);
        dataWeatherResponse =new MutableLiveData<>();
    }

    public LiveData<List<WeatherResponse>> getDataWeatherResponse() {
        return dataWeatherResponse;
    }

    public void loadData(List<City> citiesList)
    {
        weatherResponseList = new ArrayList<>();
        ApiFactory apiFactory = new ApiFactory();
        ApiService apiService = apiFactory.getApiService();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        for(final City city: citiesList)
        {

            Disposable disposable = apiService.getWhether(city.getLat(),city.getLon())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<WeatherResponse>() {
                        @Override
                        public void accept(WeatherResponse weatherResponse) throws Exception {
                            weatherResponse.getInfo().getTzinfo().setName(city.getName());
                            weatherResponseList.add(weatherResponse);
                            dataWeatherResponse.setValue(weatherResponseList);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                        }
                    });
            compositeDisposable.add(disposable);
        }


    }
}
