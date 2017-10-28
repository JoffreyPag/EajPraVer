package com.example.joffr.eajpraver;


import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Mapa extends Fragment implements OnMapReadyCallback{

    //GoogleMap mGoogleMap;
    MapView mMapView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mapa, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMapView = (MapView) view.findViewById(R.id.mapao);
        if (mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        MainActivity.mGoogleMap = googleMap;
        MainActivity.mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

//        MainActivity.mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(-5.8857457,-35.3664876)).title(
//                "EAJ"));
//        CameraPosition escola = CameraPosition.builder().target(new LatLng(-5.8857457,-35.3664876)).zoom(16).bearing(0).build();
//        MainActivity.mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(escola));

    }
}
