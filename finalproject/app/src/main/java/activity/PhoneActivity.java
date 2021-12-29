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

import adapter.PhoneAdapter;
import model.Sanpham;
import utils.CheckConnection;
import utils.Server;

public class PhoneActivity extends AppCompatActivity {
    Toolbar toolbarPhone;
    ListView lvPhone;
    PhoneAdapter phoneAdapter;
    ArrayList<Sanpham> arrayPhone;
    int idPhone=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

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
        lvPhone.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(getApplicationContext(),DetailProductActivity.class);
                intent.putExtra("thongtinsanpham", arrayPhone.get(i));
                startActivity(intent);
            }
        });

    }

    private void GetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest  = new JsonArrayRequest(Server.DuongdandPhone, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null){
                    int Id=0;
                    String Tenphone="";
                    int Giaphone=0;
                    String Hinhanhphone="";
                    String Motaphone="";
                    int IdsanphamPhone=0;
                    for(int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            Id = jsonObject.getInt("id");
                            Tenphone = jsonObject.getString("tensanpham");
                            Giaphone = jsonObject.getInt("giasanpham");
                            Hinhanhphone = jsonObject.getString("hinhanhsanpham");
                            Motaphone = jsonObject.getString("motasanpham");
                            IdsanphamPhone = jsonObject.getInt("idsanpham");
                            arrayPhone.add(new Sanpham(Id,Tenphone,Giaphone,Hinhanhphone,Motaphone,IdsanphamPhone));
                            phoneAdapter.notifyDataSetChanged();
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
        setSupportActionBar(toolbarPhone);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarPhone.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void GetIdLoaisp() {
        idPhone = getIntent().getIntExtra("idsanpham",-1);
    }

    private void Mapping() {
        toolbarPhone = (Toolbar) findViewById(R.id.id_toolbarPhone);
        lvPhone = (ListView) findViewById(R.id.id_listviewPhone);
        arrayPhone = new ArrayList<>();
        phoneAdapter = new PhoneAdapter(getApplicationContext(),arrayPhone);
        lvPhone.setAdapter(phoneAdapter);
    }
}