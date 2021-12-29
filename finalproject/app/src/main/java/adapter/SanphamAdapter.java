package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import activity.DetailProductActivity;
import model.Sanpham;
import utils.CheckConnection;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ItemHolder> {
    Context context;
    ArrayList<Sanpham> arraySanpham;

    public SanphamAdapter(Context context, ArrayList<Sanpham> arraySanpham) {
        this.context = context;
        this.arraySanpham = arraySanpham;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView imgHinhanhsanpham;
        public TextView tvTensanpham;
        public TextView tvGiasanpham;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhanhsanpham = (ImageView) itemView.findViewById(R.id.id_imageviewSp);
            tvTensanpham = (TextView) itemView.findViewById(R.id.id_textviewTensp);
            tvGiasanpham = (TextView) itemView.findViewById(R.id.id_textviewGiasp);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailProductActivity.class);
                    intent.putExtra("thongtinsanpham",arraySanpham.get(getLayoutPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    CheckConnection.ShowToast(context,arraySanpham.get(getLayoutPosition()).getTensanpham());
                    context.startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_dong_spmoinhat, null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Sanpham sanpham = arraySanpham.get(position);
        holder.tvTensanpham.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.tvGiasanpham.setText("Giá: " + decimalFormat.format(sanpham.getGiasanpham()) + "Đồng");
        Picasso.get().load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(holder.imgHinhanhsanpham);
    }

    @Override
    public int getItemCount() {
        return arraySanpham.size();
    }
}


