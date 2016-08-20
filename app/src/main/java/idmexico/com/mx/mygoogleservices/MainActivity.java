package idmexico.com.mx.mygoogleservices;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int PLACE_PICKER_REQUEST = 1;

    //Button location,maps,admob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.location).setOnClickListener(this);
        findViewById(R.id.maps).setOnClickListener(this);
        findViewById(R.id.admob).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.location:
                try {
                    startActivityForResult(new PlacePicker.IntentBuilder().build(MainActivity.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.maps:
                startActivity(new Intent(this,MapsActivity.class));
                break;
            case R.id.admob:
                startActivity(new Intent(this,AdmobActivity.class));
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==PLACE_PICKER_REQUEST){
            if (data !=null){
                Place place = PlacePicker.getPlace(MainActivity.this,data);
                //Snackbar.make(this.findViewById(android.R.id.content) ,place.getAddress(),Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}
