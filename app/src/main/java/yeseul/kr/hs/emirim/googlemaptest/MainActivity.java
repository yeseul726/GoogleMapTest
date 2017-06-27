package yeseul.kr.hs.emirim.googlemaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap googleMap;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public static final int ITEM_SARELLITE=1;
    public static final int ITEM_NORMAL=2;
    public static final int ITEM_JAEHWANI=3;
    public static final int ITEM_JAEHWANII=4;

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, ITEM_SARELLITE, 0, "위성 지도");
        menu.add(0, ITEM_NORMAL, 0, "일반 지도");
        SubMenu hotMenu = menu.addSubMenu("핫플");
        hotMenu.add(0, ITEM_JAEHWANI, 0, "♥재환이와의 신혼여행지♥");
        hotMenu.add(0, ITEM_JAEHWANII, 0, "♥재환이와의 신혼집♥");

        /*menu.add(0, 3, 0, "♥재환이와의 신혼여행지♥");*/

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case ITEM_SARELLITE: googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case ITEM_NORMAL: googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case ITEM_JAEHWANI: googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(19.993654, -155.824673), 17));
                return true;
            case ITEM_JAEHWANII: googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.591057, 127.059119), 17));
                return true;
        }

        return false;
    }
}
