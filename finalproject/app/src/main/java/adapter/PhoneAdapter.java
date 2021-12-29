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

public class PhoneAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayPhone;

    public PhoneAdapter(Context context, ArrayList<Sanpham> arrayPhone) {
        this.context = context;
        this.arrayPhone = arrayPhone;

    }

    @Override
    public int getCount() {
        return arrayPhone.size();
    } //

    @Override
    public Object getItem(int i) {
        return arrayPhone.get(i);
    } // lay thuoc tinh trong mang

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        public TextView tvTenPhone;
        public TextView tvGiaPhone;
        public TextView tvMotaPhone;
        public ImageView imgPhone;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_dong_phone,null);
            viewHolder.tvTenPhone=(TextView) view.findViewById(R.id.id_textviewPhone);
            viewHolder.tvGiaPhone=(TextView) view.findViewById(R.id.id_textviewGiaPhone);
            viewHolder.tvMotaPhone=(TextView) view.findViewById(R.id.id_textviewMotaPhone);
            viewHolder.imgPhone=(ImageView) view.findViewById(R.id.id_imageviewPhone);
            view.setTag(viewHolder);
        } else{
            viewHolder= (ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHolder.tvTenPhone.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.tvGiaPhone.setText("Giá: " + decimalFormat.format(sanpham.getGiasanpham()) + "Đồng");
        viewHolder.tvMotaPhone.setMaxLines(2);
        viewHolder.tvMotaPhone.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.tvMotaPhone.setText(sanpham.getMotasanpham());
        Picasso.get().load(sanpham.getHinhanhsanpham()).placeholder(R.drawable.noimage).error(R.drawable.error)
                .into(viewHolder.imgPhone);
        return view;
    }
}
