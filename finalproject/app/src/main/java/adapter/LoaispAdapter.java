package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.Loaisp;

public class LoaispAdapter extends BaseAdapter {
    ArrayList<Loaisp> arrayListLoaisp;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> arrayListLoaisp, Context context) {
        this.arrayListLoaisp = arrayListLoaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListLoaisp.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListLoaisp.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder{
        TextView tvTenLoaisp;
        ImageView imgLoaisp;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_dong_loaisp,null);
            viewHolder.tvTenLoaisp = view.findViewById(R.id.id_textviewLoaisp);
            viewHolder.imgLoaisp = view.findViewById(R.id.id_imageviewLoaisp);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Loaisp loaisp = (Loaisp) getItem(i);
        viewHolder.tvTenLoaisp.setText(loaisp.getTenloaisp());
        Picasso.get().load(loaisp.getHinhanhloaisp()).placeholder(R.drawable.noimage).error(R.drawable.error).into(viewHolder.imgLoaisp);

        return view;
    }
}
