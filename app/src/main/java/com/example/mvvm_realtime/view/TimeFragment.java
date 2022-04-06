package com.example.mvvm_realtime.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvvm_realtime.R;
import com.example.mvvm_realtime.viewmodel.TimeViewModel;

public class TimeFragment extends Fragment {

    private TextView tv_time;

    TimeViewModel timeViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        timeViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(TimeViewModel.class);
        timeViewModel.getTimeMutableLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_time.setText(s);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_time, container, false);

        // 요소 초기화
        init(view);

        timeViewModel.whatTime();

        return view;
    }

    // 요소 초기화 함수
    private void init(View view){
        tv_time = view.findViewById(R.id.tv_time);
    }
}