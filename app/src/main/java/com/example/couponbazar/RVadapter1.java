package com.example.couponbazar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVadapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ArrayList<ManageSales2> list= new ArrayList<>();

//    public void setItems(ArrayList<ManageSales2> m){
//        list.addAll(m);
//    }


    public RVadapter1(Context ctx, ArrayList<ManageSales2> list1) {
        this.context = ctx;
        this.list = list1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.sales_item,parent,false);
        return new ManageSalesVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
      ManageSalesVH vh=(ManageSalesVH) holder;
        ManageSales2 ms= list.get(position);
        vh.couprice.setText(ms.ggetPrice());
        vh.couben.setText(ms.ggetBenefits());
        vh.coubrand.setText(ms.ggetBrand());
        vh.coucode.setText(ms.ggetCode());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ManageSalesVH extends RecyclerView.ViewHolder {
        TextView coubrand,couprice,couben,coucode;
        ImageView del;
        public ManageSalesVH(@NonNull View itemView) {
            super(itemView);
            couben=itemView.findViewById(R.id.couben);
            coubrand=itemView.findViewById(R.id.coubrand);
            couprice=itemView.findViewById(R.id.couprice);
            coucode=itemView.findViewById(R.id.coucode);
            del=itemView.findViewById(R.id.delImage);
        }
    }

}
