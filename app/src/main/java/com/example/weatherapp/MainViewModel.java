package com.example.weatherapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.api.ApiFactory;
import com.example.weatherapp.api.ApiService;
import com.example.weatherapp.data.City;
import com.example.weatherapp.data.WeatherDataBase;
import com.example.weatherapp.pojo.WeatherResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<List<WeatherResponse>> dataWeatherResponse;
    private List<WeatherResponse> weatherResponseList;
    private static WeatherDataBase dataBase;

    public List<WeatherResponse> getWeatherResponseList() {
        return weatherResponseList;
    }

    public MainViewModel(@NonNull Application application) {
        super(application);
        dataWeatherResponse =new MutableLiveData<>();
        dataBase=WeatherDataBase.getInstance(getApplication());
    }

    public LiveData<List<WeatherResponse>> getDataWeatherResponse() {
        return dataWeatherResponse;
    }

    public void loadData(List<City> citiesList)
    {
        deleteAllWeather();
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
                            insertWeatherResponse(weatherResponse);
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
    public WeatherResponse getWeatherCityByInfo(String info)
    {
        try {
            return new GetWeatherCityByInfo().execute(info).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static class GetWeatherCityByInfo extends AsyncTask<String,Void,WeatherResponse>
    {

        @Override
        protected WeatherResponse doInBackground(String... strings) {

            return dataBase.WeatherDao().getWeatherResponse(strings[0]);
        }
    }

    public List<WeatherResponse> getWeatherList()
    {
        try {
            return new GetWeatherListTask().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static class GetWeatherListTask extends AsyncTask<Void,Void,List<WeatherResponse>>
    {
        @Override
        protected List<WeatherResponse> doInBackground(Void... voids) {

            return dataBase.WeatherDao().getWeatherList();
        }
    }
    @SuppressWarnings("unchecked")
    public void insertWeatherResponseList(List<WeatherResponse> weatherResponseList)
    {
        new InsertWeatherListTask().execute(weatherResponseList);
    }
    private static class InsertWeatherListTask extends AsyncTask<List<WeatherResponse>,Void,Void>
    {

        @Override
        protected Void doInBackground(List<WeatherResponse>... lists) {
            dataBase.WeatherDao().insertWeatherList(lists[0]);
            return null;
        }
    }
    public void deleteAllWeather()
    {
        new DeleteAllWeatherTask().execute();
    }
    private static class DeleteAllWeatherTask extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {
            dataBase.WeatherDao().deleteWeatherList();
            return null;
        }
    }
    public void insertWeatherResponse(WeatherResponse weatherResponse)
    {
        new InsertWeatherResponse().execute(weatherResponse);
    }
    private static class InsertWeatherResponse extends AsyncTask<WeatherResponse,Void,Void>
    {

        @Override
        protected Void doInBackground(WeatherResponse... weatherResponses) {
            if (weatherResponses[0]!=null)
            dataBase.WeatherDao().insertWeatherResponse(weatherResponses[0]);
            return null;
        }
    }

}
