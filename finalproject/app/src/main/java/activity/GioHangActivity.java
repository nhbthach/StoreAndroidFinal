package activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.text.DecimalFormat;

import adapter.GioHangAdapter;
import utils.CheckConnection;

public class GioHangActivity extends AppCompatActivity {

    ListView lvGioHang;
    TextView tvThongBao;
    static TextView tvTongTien;
    TextView tvTextTongTien;
    Button btnThanhToan, btnTiepTucMua;
    Toolbar toolbarGioHang;
    GioHangAdapter gioHangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giodunghang);
        Mapping();
        ActionToolBar();
        CheckData();
        EventUtils(); //Cập nhật tổng tiền
        CatchOnItemListViewLong(); //giu lau ->xoa
        EventButton(); // Bat su kien button
    }

    private void EventButton() {
        btnTiepTucMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.arrayGioHang.size()>0){
                    Intent intent = new Intent(getApplicationContext(), InputInfoUser.class);
                    startActivity(intent);
                }else{
                    CheckConnection.ShowToast(getApplicationContext(),"Cần có sản phẩm để thanh toán");
                }

            }
        });
    }

    private void CatchOnItemListViewLong() {
        lvGioHang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int index, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GioHangActivity.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc xóa sản phẩm này?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (MainActivity.arrayGioHang.size() <= 0) {
                            tvThongBao.setVisibility(View.VISIBLE);
                        } else {
                            MainActivity.arrayGioHang.remove(index);
                            gioHangAdapter.notifyDataSetChanged();
                            EventUtils();
                            if (MainActivity.arrayGioHang.size() <= 0) {
                                tvThongBao.setVisibility(View.VISIBLE);
                            } else {
                                tvThongBao.setVisibility(View.INVISIBLE);
                                gioHangAdapter.notifyDataSetChanged();
                                EventUtils();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        gioHangAdapter.notifyDataSetChanged();
                        EventUtils();
                    }
                });
                builder.show();
                return true;
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public static void EventUtils() {
        long tongtien =0;
        for(int i =0;i<MainActivity.arrayGioHang.size();i++){
            tongtien+=MainActivity.arrayGioHang.get(i).getGiasp();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvTongTien.setText(decimalFormat.format(tongtien)+"Đồng");
    }

    private void CheckData() {
        if(MainActivity.arrayGioHang.size()<=0){
            gioHangAdapter.notifyDataSetChanged();
            tvThongBao.setVisibility(View.VISIBLE);
            lvGioHang.setVisibility(View.INVISIBLE);
        }
        else{
            gioHangAdapter.notifyDataSetChanged();
            tvThongBao.setVisibility(View.INVISIBLE);
            lvGioHang.setVisibility(View.VISIBLE);
        }
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarGioHang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarGioHang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Mapping() {
        lvGioHang = (ListView) findViewById(R.id.id_listviewGioHang);
        tvThongBao=(TextView)findViewById(R.id.id_textviewThongBao);
        tvTongTien=(TextView) findViewById(R.id.id_textviewTongTien);
        tvTextTongTien=(TextView)findViewById(R.id.id_textviewGioHangTextTongTien);
        btnThanhToan=(Button) findViewById(R.id.id_buttonThanhToan);
        btnTiepTucMua= (Button) findViewById(R.id.id_buttonTiepTucMua);
        toolbarGioHang= (Toolbar) findViewById(R.id.id_toolbarGioHang);
        gioHangAdapter = new GioHangAdapter(GioHangActivity.this,MainActivity.arrayGioHang);
        lvGioHang.setAdapter(gioHangAdapter);
    }
}