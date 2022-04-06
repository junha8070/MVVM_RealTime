package com.example.mvvm_realtime.model;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_realtime.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;


public class TimeModel {
    private Application application;
    private long now = System.currentTimeMillis();
    private Date date = new Date(now);
    private final SimpleDateFormat dateFormat;
    private String realTime;
    private final MutableLiveData<String> timeMutableLiveData;

    @SuppressLint("SimpleDateFormat")
    public TimeModel(Application application) {
        this.application = application;

        dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        timeMutableLiveData = new MutableLiveData<>();
    }

    public void whatTime() {
        Thread t = new Thread(() -> {
            while (true) {
                now = System.currentTimeMillis();
                date = new Date(now);
                realTime = dateFormat.format(date);
                timeMutableLiveData.postValue(realTime);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public MutableLiveData<String> getTimeMutableLiveData() {
        return timeMutableLiveData;
    }
}
