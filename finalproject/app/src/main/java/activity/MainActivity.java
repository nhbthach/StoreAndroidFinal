package activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import adapter.LoaispAdapter;
import adapter.SanphamAdapter;
import model.GioHang;
import model.Loaisp;
import model.Sanpham;
import okhttp3.Cookie;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import utils.CheckConnection;
import utils.Server;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    //ListView
    ListView lvMainActivity;
    ArrayList<Loaisp> arrayLoaisp;
    LoaispAdapter  loaispAdapter;
    //RecyclerView
    RecyclerView rvMainActivity;
    ArrayList<Sanpham> arraySanpham;
    SanphamAdapter sanphamAdapter;
    int id=0;
    String tenloaisp ="";
    String hinhanhloaisp="";

    //
    public static ArrayList<GioHang> arrayGioHang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
            GetDuLieuLoaisp();
            GetDuLieuSpMoiNhat();
            CatchOnItemListView();
            
        } //Neu dieu kien co mang internet => Doc du lieu nay
        else {
            CheckConnection.ShowToast(getApplicationContext(),"Hãy kiểm tra lại kết nối Internet");
            finish();
        }
    }

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_menuGioHang:
                Intent intent = new Intent(getApplicationContext(),GioHangActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



    private void CatchOnItemListView() {
        lvMainActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent (MainActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast(getApplicationContext(),"Hãy kiểm tra lại kết nối Internet");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent (MainActivity.this, PhoneActivity.class);
                            //gui id loai san pham sang man hinh khac (1)
                            intent.putExtra("idsanpham", arrayLoaisp.get(i).getId());
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast(getApplicationContext(),"Hãy kiểm tra lại kết nối Internet");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent (MainActivity.this, LaptopActivity.class);
                            //gui id loai san pham sang man hinh khac (2)
                            intent.putExtra("idsanpham", arrayLoaisp.get(i).getId());
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast(getApplicationContext(),"Hãy kiểm tra lại kết nối Internet");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent (MainActivity.this, ContactActivity.class);
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast(getApplicationContext(),"Hãy kiểm tra lại kết nối Internet");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent (MainActivity.this, InfoActivity.class);
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast(getApplicationContext(),"Hãy kiểm tra lại kết nối Internet");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }

    private void GetDuLieuSpMoiNhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdansanphammoinhat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null){
                    int ID=0;
                    String Tensanpham="";
                    int Giasanpham=0;
                    String Hinhanhsanpham="";
                    String Motasanpham="";
                    int IDsanpham=0;
                    for(int i=0; i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID= jsonObject.getInt("id");
                            Tensanpham=jsonObject.getString("tensanpham");
                            Giasanpham = jsonObject.getInt("giasanpham");
                            Hinhanhsanpham = jsonObject.getString("hinhanhsanpham");
                            Motasanpham = jsonObject.getString("motasanpham");
                            IDsanpham = jsonObject.getInt("idsanpham");
                            arraySanpham.add(new Sanpham(ID,Tensanpham,Giasanpham,Hinhanhsanpham,Motasanpham,IDsanpham));
                            sanphamAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void GetDuLieuLoaisp() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanloaisp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null){
                    for(int i =0;i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id=jsonObject.getInt("id");
                            tenloaisp = jsonObject.getString("tenloaisp");
                            hinhanhloaisp = jsonObject.getString("hinhanhloaisanpham");
                            arrayLoaisp.add(new Loaisp(id,tenloaisp,hinhanhloaisp));
                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    arrayLoaisp.add(0,new Loaisp(0,"Trang chính",
                            "https://www.pinclipart.com/picdir/middle/198-1980058_after-working-out-you-dont-have-to-hop.png"));
                    lvMainActivity.setAdapter(loaispAdapter);
                    arrayLoaisp.add(3,new Loaisp(0,"Liên hệ",
                            "https://cdn0.iconfinder.com/data/icons/flat-color-1/100/sqi2016-flat-go-42-512.png"));
                    arrayLoaisp.add(4, new Loaisp(0,"Thông tin",
                            "https://www.iconfinder.com/data/icons/social-messaging-ui-color-and-shapes-3/177800/129-512.png"));

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void ActionViewFlipper() {
        ArrayList<String> arrayAd = new ArrayList<>();
        arrayAd.add("https://vietart.co/blog/wp-content/uploads/2015/08/quang-cao-doc-dao-heineken-02.jpg");
        arrayAd.add("https://nganhangphapluat.thukyluat.vn/Images/uploaded/Nganhang/coca.png");
        arrayAd.add("https://i.ytimg.com/vi/tnTcVxqEiwI/maxresdefault.jpg");
        arrayAd.add("https://www.brandsvietnam.com/upload/forum/1_tiger5.jpg");
        for(int i=0;i<arrayAd.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(arrayAd.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));
    }

    private void Mapping() {
        toolbar = (Toolbar) findViewById(R.id.id_toolbarMainPage);
        viewFlipper = (ViewFlipper) findViewById(R.id.id_viewflipper);
        rvMainActivity = (RecyclerView) findViewById(R.id.id_recycleview);
        navigationView = (NavigationView) findViewById(R.id.id_navigationView);
        lvMainActivity = (ListView) findViewById(R.id.id_listviewMainPage);
        drawerLayout = (DrawerLayout) findViewById(R.id.id_drawerMenu);
        //ListView
        arrayLoaisp = new ArrayList<>();
        loaispAdapter = new LoaispAdapter(arrayLoaisp,getApplicationContext());

        //RecyclerView
        arraySanpham=new ArrayList<>();
        sanphamAdapter=new SanphamAdapter(getApplicationContext(),arraySanpham);
        rvMainActivity.setHasFixedSize(true);
        rvMainActivity.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        rvMainActivity.setAdapter(sanphamAdapter);
        if(arrayGioHang!=null){

        }else{
            arrayGioHang=new ArrayList<>();
        }
    }
}