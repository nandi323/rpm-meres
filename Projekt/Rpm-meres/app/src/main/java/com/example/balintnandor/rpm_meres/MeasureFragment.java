package com.example.balintnandor.rpm_meres;

import android.app.Fragment;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MeasureFragment extends Fragment implements SensorEventListener {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.measure_main, container, false);
        return myView;
    }

    //cycle 0 -> save start time
    //cycle 1 -> measure one full rotation

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /**
        This method returns the current time in milliseconds.
     */
    public long getCurrentTime()
    {
        return System.currentTimeMillis();
    }

    /**
     * This method returns the time of one rotation.
        @param numberOfPeaks represents the number of "close" reads during one rotation
     */
    public void measureOneCycleTime( final int numberOfPeaks )
    {

    }



}
