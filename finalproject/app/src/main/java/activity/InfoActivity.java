package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class InfoActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Toolbar toolbarThongtin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        toolbarThongtin = findViewById(R.id.id_toolbarThongtin);
        ActionBar();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void ActionBar() {
        setSupportActionBar(toolbarThongtin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarThongtin.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng center = new LatLng(10.753553, 106.706529);
        mMap.addMarker(new MarkerOptions()
                .position(center)
                .title("161 Tôn Thất Thuyết, Quận 4, Tp. HCM"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center,16));
    }


}
