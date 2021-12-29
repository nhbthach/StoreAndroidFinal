package adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import model.Sanpham;

public class LaptopAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayLaptop;

    public LaptopAdapter(Context context, ArrayList<Sanpham> arrayLaptop) {
        this.context = context;
        this.arrayLaptop = arrayLaptop;

    }

    @Override
    public int getCount() {
        return arrayLaptop.size();
    } //

    @Override
    public Object getItem(int i) {
        return arrayLaptop.get(i);
    } // lay thuoc tinh trong mang

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        public TextView tvTenLaptop;
        public TextView tvGiaLaptop;
        public TextView tvMotaLaptop;
        public ImageView imgLaptop;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_dong_laptop,null);
            viewHolder.tvTenLaptop=(TextView) view.findViewById(R.id.id_textviewTenLaptop);
            viewHolder.tvGiaLaptop=(TextView) view.findViewById(R.id.id_textviewGiaLaptop);
            viewHolder.tvMotaLaptop=(TextView) view.findViewById(R.id.id_textviewMotaLaptop);
            viewHolder.imgLaptop=(ImageView) view.findViewById(R.id.id_imageviewLaptop);
            view.setTag(viewHolder);
        } else{
            viewHolder= (ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHolder.tvTenLaptop.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.tvGiaLaptop.setText("Giá: " + decimalFormat.format(sanpham.getGiasanpham()) + "Đồng");
        viewHolder.tvMotaLaptop.setMaxLines(2);
        viewHolder.tvMotaLaptop.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.tvMotaLaptop.setText(sanpham.getMotasanpham());
        Picasso.get().load(sanpham.getHinhanhsanpham()).placeholder(R.drawable.noimage).error(R.drawable.error)
                .into(viewHolder.imgLaptop);
        return view;
    }
}

