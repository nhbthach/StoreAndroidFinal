package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import activity.GioHangActivity;
import activity.MainActivity;
import model.GioHang;

public class GioHangAdapter extends BaseAdapter {
    Context context;
    ArrayList<GioHang> arrayGioHang;

    public GioHangAdapter(Context context, ArrayList<GioHang> arrayGioHang) {
        this.context = context;
        this.arrayGioHang = arrayGioHang;
    }

    @Override
    public int getCount() {
        return arrayGioHang.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayGioHang.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class ViewHolder{
        public TextView tvTenGioHang,tvGiaGioHang;
        public ImageView imgGioHang;
        public Button btndecrease, btnval,btnincrease;
    }
    ViewHolder viewHolder = null;

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_dong_giohang,null);
            viewHolder.tvTenGioHang=(TextView) view.findViewById(R.id.id_textviewTenGioHang);
            viewHolder.tvGiaGioHang=(TextView) view.findViewById(R.id.id_textviewGiaGioHang);
            viewHolder.imgGioHang = (ImageView) view.findViewById(R.id.id_imageviewGioHang);
            viewHolder.btndecrease=(Button) view.findViewById(R.id.id_buttondecrease);
            viewHolder.btnval=(Button)view.findViewById(R.id.id_buttonValues);
            viewHolder.btnincrease=(Button)view.findViewById(R.id.id_buttonincrease);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        GioHang gioHang = (GioHang) getItem(i);
        viewHolder.tvTenGioHang.setText(gioHang.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.tvGiaGioHang.setText(decimalFormat.format(gioHang.getGiasp())+"Đồng");
        Picasso.get().load(gioHang.getHinhanh()).placeholder(R.drawable.noimage).error(R.drawable.error).into(viewHolder.imgGioHang);
        viewHolder.btnval.setText(gioHang.getSoluong()+"");
        int sl = Integer.parseInt(viewHolder.btnval.getText().toString());
        if(sl>=10){
            viewHolder.btnincrease.setVisibility(View.INVISIBLE);
            viewHolder.btndecrease.setVisibility(View.VISIBLE);
        } else if(sl<=1){
            viewHolder.btndecrease.setVisibility(View.INVISIBLE);
        } else if(sl>=1){
            viewHolder.btndecrease.setVisibility(View.VISIBLE);
            viewHolder.btnincrease.setVisibility(View.VISIBLE);
        }
        viewHolder.btnincrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slmoinhat = Integer.parseInt(viewHolder.btnval.getText().toString())+1;
                int slhientai = MainActivity.arrayGioHang.get(i).getSoluong();
                long giahientai=MainActivity.arrayGioHang.get(i).getGiasp();
                MainActivity.arrayGioHang.get(i).setSoluong(slmoinhat);
                long giamoinhat = ((giahientai*slmoinhat)/slhientai);
                MainActivity.arrayGioHang.get(i).setGiasp(giamoinhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                viewHolder.tvGiaGioHang.setText(decimalFormat.format(giamoinhat)+"Đồng");
                if(slmoinhat>9) //da co 1, click 9 lan nua = 10
                {
                    viewHolder.btnincrease.setVisibility(View.INVISIBLE);
                    viewHolder.btndecrease.setVisibility(View.VISIBLE);
                    viewHolder.btnval.setText(String.valueOf(slmoinhat));
                } else {
                    viewHolder.btndecrease.setVisibility(View.VISIBLE);
                    viewHolder.btnincrease.setVisibility(View.VISIBLE);
                    viewHolder.btnval.setText(String.valueOf(slmoinhat));
                }
                GioHangActivity.EventUtils();
            }
        });
        viewHolder.btndecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slmoinhat = Integer.parseInt(viewHolder.btnval.getText().toString())-1;
                int slhientai = MainActivity.arrayGioHang.get(i).getSoluong();
                long giahientai=MainActivity.arrayGioHang.get(i).getGiasp();
                MainActivity.arrayGioHang.get(i).setSoluong(slmoinhat);
                long giamoinhat = ((giahientai*slmoinhat)/slhientai);
                MainActivity.arrayGioHang.get(i).setGiasp(giamoinhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                viewHolder.tvGiaGioHang.setText(decimalFormat.format(giamoinhat)+"Đồng");
                if(slmoinhat<2){
                    viewHolder.btndecrease.setVisibility(View.INVISIBLE);
                    viewHolder.btnincrease.setVisibility(View.VISIBLE);
                    viewHolder.btnval.setText(String.valueOf(slmoinhat));
                } else {
                    viewHolder.btndecrease.setVisibility(View.VISIBLE);
                    viewHolder.btnincrease.setVisibility(View.VISIBLE);
                    viewHolder.btnval.setText(String.valueOf(slmoinhat));
                }
                GioHangActivity.EventUtils();
            }
        });
        return view;
    }

}
