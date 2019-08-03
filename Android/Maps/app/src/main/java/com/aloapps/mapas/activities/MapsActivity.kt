package com.aloapps.mapas.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aloapps.mapas.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        val marcador: MarkerOptions?
        mMap = googleMap

        // Add a marker in Merida and move the camera
        val merida = LatLng(20.986706793443215, -89.58572761562505)
        //mMap.addMarker(MarkerOptions().position(merida).title("Marker in Mérida, Yuc.").draggable(true))

        //mMap.setMinZoomPreference(6.0f)
        //mMap.setMaxZoomPreference(14.0f)

        marcador = MarkerOptions()
        marcador.position(merida)
        marcador.title("Este es mi marcador")
        marcador.snippet("Aqui puedes poner algún dato de localización")
        marcador.icon(BitmapDescriptorFactory.fromResource(android.R.drawable.arrow_up_float))
        marcador.draggable(true)

        mMap.addMarker(marcador)

        val camara = CameraPosition.Builder()
                .target(merida)
                //.zoom(17f)
                .bearing(0f)
                .tilt(0f)
                .build()

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camara))

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(merida))

        mMap.setOnMapClickListener{latLng ->
            Toast.makeText(this, "Las coordenadas son: \n" +
                    "Latitud: " + latLng.latitude + "\n" +
                    "Longitud: " + latLng.longitude,
                    Toast.LENGTH_SHORT).show()
        }

        mMap.setOnMapLongClickListener{latLng ->
            Toast.makeText(this, "--Las coordenadas son: \n" +
                    "Latitud: " + latLng.latitude + "\n" +
                    "Longitud: " + latLng.longitude,
                    Toast.LENGTH_SHORT).show()
        }

        mMap.setOnMarkerDragListener(object: GoogleMap.OnMarkerDragListener{
            override fun onMarkerDragEnd(marker: Marker?) {
                Toast.makeText(this@MapsActivity, "Drag: Las coordenadas son: \n" +
                        "Latitud: " + marker!!.position.latitude + "\n" +
                        "Longitud: " + marker!!.position.longitude,
                        Toast.LENGTH_SHORT).show()
            }

            override fun onMarkerDragStart(p0: Marker?) {
            }

            override fun onMarkerDrag(p0: Marker?) {
            }
        })
    }
}
