package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import utils.CheckConnection;
import utils.Server;

public class InputInfoUser extends AppCompatActivity {
    EditText edtTenKH;
    EditText edtEmailKH;
    EditText edtSdtKH;
    Button btnXacNhan, btnTroVe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_user_purchase);

        Mapping();
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            EventButton();//Su kien click on buttonXacNhan
        }else{
            CheckConnection.ShowToast(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
        }
    }

    private void EventButton() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String ten = edtTenKH.getText().toString().trim();//bo di khoang trang
                final String sdt = edtSdtKH.getText().toString().trim();
                final String email = edtEmailKH.getText().toString().trim();
                if(ten.length()>0&&sdt.length()>0&&email.length()>0){
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdandonhang, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String madonhang) {
                            if(Integer.parseInt(madonhang)>0){
                                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                                StringRequest request = new StringRequest(Request.Method.POST, Server.Duongdanchitietdonhang, new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                            MainActivity.arrayGioHang.clear();
                                            CheckConnection.ShowToast(getApplicationContext(),"Bạn đã thêm dữ liệu giỏi hàng thành công!");
                                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                            startActivity(intent);
                                            CheckConnection.ShowToast(getApplicationContext(),"Mời bạn tiếp tục mua hàng");
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                    }
                                }){
                                    @Override
                                    protected Map<String, String> getParams() throws AuthFailureError {
                                        JSONArray jsonArray = new JSONArray();
                                        for(int i =0;i<MainActivity.arrayGioHang.size();i++){
                                            JSONObject jsonObject = new JSONObject();
                                            try {
                                                jsonObject.put("madonhang",madonhang);
                                                jsonObject.put("masanpham",MainActivity.arrayGioHang.get(i).getIdsp());
                                                jsonObject.put("tensanpham",MainActivity.arrayGioHang.get(i).getTensp());
                                                jsonObject.put("giasanpham",MainActivity.arrayGioHang.get(i).getGiasp());
                                                jsonObject.put("soluongsanpham",MainActivity.arrayGioHang.get(i).getSoluong());

                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                            jsonArray.put(jsonObject);
                                        }
                                        HashMap<String,String> hashMap = new HashMap<>();
                                        hashMap.put("json",jsonArray.toString());
                                        return hashMap;
                                    }
                                };
                                queue.add(request);
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String,String> hashMap = new HashMap<>();
                            hashMap.put("tenkhachhang",ten);
                            hashMap.put("sodienthoai", sdt);
                            hashMap.put("email",email);
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);

                }else{
                    CheckConnection.ShowToast(getApplicationContext(),"Bạn hãy kiểm tra lại dữ liệu");
                }

            }
        });
    }

    private void Mapping() {
        edtTenKH = findViewById(R.id.id_edittextNameUser);
        edtEmailKH = findViewById(R.id.id_edittextEmailUser);
        edtSdtKH = findViewById(R.id.id_edittextSDTUser);
        btnXacNhan=findViewById(R.id.id_buttonXacNhan);
        btnTroVe=findViewById(R.id.id_buttonTroVe);
    }
}