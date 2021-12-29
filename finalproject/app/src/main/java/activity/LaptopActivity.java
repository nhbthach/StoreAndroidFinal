package activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import adapter.LaptopAdapter;
import model.Sanpham;
import utils.CheckConnection;
import utils.Server;

public class LaptopActivity extends AppCompatActivity {
    Toolbar toolbarLaptop;
    ListView lvLaptop;
    LaptopAdapter laptopAdapter;
    ArrayList<Sanpham> arrayLaptop;
    int idLaptop=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop);

        Mapping();
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            GetIdLoaisp();
            ActionToolBar();
            GetData();
            ClickOnItem();
        } else {
            CheckConnection.ShowToast(getApplicationContext(),"Hãy kiểm tra lại kết nối Internet");
            finish();
        }


    }
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

    private void ClickOnItem() {
        lvLaptop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(getApplicationContext(),DetailProductActivity.class);
                intent.putExtra("thongtinsanpham", arrayLaptop.get(i));
                startActivity(intent);
            }
        });
    }

    private void GetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest  = new JsonArrayRequest(Server.DuongdanLaptop, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null){
                    int Id=0;
                    String Tenlaptop="";
                    int Gialaptop=0;
                    String Hinhanhlaptop="";
                    String Motalaptop="";
                    int IdsanphamLaptop=0;
                    for(int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            Id = jsonObject.getInt("id");
                            Tenlaptop = jsonObject.getString("tensanpham");
                            Gialaptop = jsonObject.getInt("giasanpham");
                            Hinhanhlaptop = jsonObject.getString("hinhanhsanpham");
                            Motalaptop = jsonObject.getString("motasanpham");
                            IdsanphamLaptop = jsonObject.getInt("idsanpham");
                            arrayLaptop.add(new Sanpham(Id,Tenlaptop,Gialaptop,Hinhanhlaptop,Motalaptop,IdsanphamLaptop));
                            laptopAdapter.notifyDataSetChanged();
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

    private void ActionToolBar() {
        setSupportActionBar(toolbarLaptop);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarLaptop.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void GetIdLoaisp() {
        idLaptop = getIntent().getIntExtra("idsanpham",-1);
        Log.d("giatrinhanbiet", idLaptop+"");
    }

    private void Mapping() {
        toolbarLaptop = (Toolbar) findViewById(R.id.id_toolbarLaptop);
        lvLaptop = (ListView) findViewById(R.id.id_listviewLaptop);
        arrayLaptop = new ArrayList<>();
        laptopAdapter = new LaptopAdapter(getApplicationContext(),arrayLaptop);
        lvLaptop.setAdapter(laptopAdapter);
    }
}