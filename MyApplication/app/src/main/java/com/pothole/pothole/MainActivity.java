package com.pothole.pothole;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

  Sensor accelerometer;
  SensorManager sm;
  TextView acceleration;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    sm = (SensorManager) getSystemService(SENSOR_SERVICE);
    accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    acceleration = (TextView) findViewById(R.id.acceleration);
  }


  @Override
  public void onSensorChanged(SensorEvent event) {
    acceleration.setText("X: " + event.values[0] +
        "\nY: " + event.values[1] +
        "\nZ: " + event.values[2]);
  }

  @Override
  public void onAccuracyChanged(Sensor sensor, int accuracy) {

  }
}
