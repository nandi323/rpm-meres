package com.example.balintnandor.rpm_meres;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class RangeMeasureActivity extends AppCompatActivity
        implements SensorEventListener {

    FragmentManager fragmentManager = getFragmentManager();
    protected Button startTestButton;
    protected Button endTestButton;
    protected SensorManager sensorManager;
    protected Sensor proximitySensor;
    protected RelativeLayout rangeTesterLayout;
    protected Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_range_checker);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        startTestButton = (Button) findViewById( R.id.startTestButton );
        endTestButton = (Button) findViewById( R.id.stopTestButton );
        rangeTesterLayout = (RelativeLayout) findViewById( R.id.range_tester_layout );
        rangeTesterLayout.setBackgroundColor(Color.WHITE);
    }

    public void onStartTestButtonClick(View view)
    {
        sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    public void onStopTestButtonClick(View view)
    {
        sensorManager.unregisterListener(this);
        rangeTesterLayout.setBackgroundColor(Color.WHITE);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.values[0]==0)
        {
            rangeTesterLayout.setBackgroundColor(Color.GREEN);
            vibrator.vibrate(10000);
        }
        else
        {
            vibrator.cancel();
            rangeTesterLayout.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
