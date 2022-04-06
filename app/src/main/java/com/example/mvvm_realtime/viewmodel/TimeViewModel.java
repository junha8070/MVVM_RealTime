package com.example.mvvm_realtime.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_realtime.model.TimeModel;

public class TimeViewModel extends AndroidViewModel{

    private TimeModel timeModel;
    private MutableLiveData<String> timeMutableLiveData;

    public TimeViewModel(@NonNull Application application) {
        super(application);

        timeModel = new TimeModel(application);
        timeMutableLiveData = timeModel.getTimeMutableLiveData();
    }

    public void whatTime(){
        timeModel.whatTime();
    }

    public MutableLiveData<String> getTimeMutableLiveData() {
        return timeMutableLiveData;
    }
}
