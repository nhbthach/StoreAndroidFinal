package activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import model.GioHang;
import model.Sanpham;

public class DetailProductActivity extends AppCompatActivity {
    Toolbar toolbarChitiet;
    ImageView imgChitiet;
    TextView tvTen,tvGia,tvMota;
    Spinner spinner;
    Button btnMua;

    int id=0;
    String Tenchitiet="";
    String Hinhanhchitiet="";
    String Motachitiet="";
    int Giachitiet=0;
    int Idsanpham=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsp);
        Mapping();
        ActionToolBar();
        GetInfo();
        CatchEvenSpinner();
        EventButton();

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


    private void EventButton() {
        btnMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.arrayGioHang.size()>0){
                    int sl = Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean existed=false;
                    for(int i =0;i<MainActivity.arrayGioHang.size();i++){
                        if(MainActivity.arrayGioHang.get(i).getIdsp()==id){
                            MainActivity.arrayGioHang.get(i).setSoluong(
                                    MainActivity.arrayGioHang.get(i).getSoluong()+sl); //ton tai sp => cong don vao
                            if(MainActivity.arrayGioHang.get(i).getSoluong()>=10) { //so luong san pham day >10 => set ve 10
                                MainActivity.arrayGioHang.get(i).setSoluong(10);
                            }
                            MainActivity.arrayGioHang.get(i).setGiasp(Giachitiet*MainActivity.arrayGioHang.get(i).getSoluong());
                            existed = true;
                        }
                    }
                    if(existed==false){
                        int soluong= Integer.parseInt(spinner.getSelectedItem().toString());
                        long Giamoi=soluong*Giachitiet;
                        MainActivity.arrayGioHang.add(new GioHang(id,Tenchitiet,Giamoi,Hinhanhchitiet,soluong));
                    }
                }else{
                    int soluong= Integer.parseInt(spinner.getSelectedItem().toString());
                    long Giamoi=soluong*Giachitiet;
                    MainActivity.arrayGioHang.add(new GioHang(id,Tenchitiet,Giamoi,Hinhanhchitiet,soluong));
                }
                Intent intent = new Intent(getApplicationContext(),GioHangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void CatchEvenSpinner() {
        Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter =new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,soluong);
        spinner.setAdapter(arrayAdapter);
    }

    private void GetInfo() {

        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("thongtinsanpham");
        id=sanpham.getID();
        Tenchitiet=sanpham.getTensanpham();
        Hinhanhchitiet=sanpham.getHinhanhsanpham();
        Motachitiet=sanpham.getMotasanpham();
        Giachitiet=sanpham.getGiasanpham();
        Idsanpham=sanpham.getIDsanpham();
        tvTen.setText(Tenchitiet);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvGia.setText("Giá: "+decimalFormat.format(Giachitiet)+" Đồng");
        tvMota.setText(Motachitiet);
        Picasso.get().load(Hinhanhchitiet).placeholder(R.drawable.noimage).error(R.drawable.error).into(imgChitiet);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarChitiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarChitiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Mapping() {
        toolbarChitiet = (Toolbar)findViewById(R.id.id_toolbarChitietsp);
        imgChitiet = (ImageView) findViewById(R.id.id_imageviewChitiet);
        tvTen=(TextView)findViewById(R.id.id_textviewTenChitietsp);
        tvGia=(TextView)findViewById(R.id.id_textviewGiaChitietsp);
        tvMota=(TextView)findViewById(R.id.id_textviewMotaChitietsp);
        btnMua=(Button)findViewById(R.id.id_buttonAdd);
        spinner= (Spinner) findViewById(R.id.id_SpinnerChitiet);
    }

}