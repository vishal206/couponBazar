package com.example.couponbazar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.MyViewHolderr>{
    Context context;
    ArrayList<Buy> list;

    public SecondAdapter( ArrayList<Buy> list) {
//        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buy_sales,parent,false);
        return new MyViewHolderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SecondAdapter.MyViewHolderr holder, int position) {
        Buy b = list.get(position);
        holder.cou_ben.setText(b.getBenefits());
        holder.cou_brand.setText(b.getBrand());
        holder.cou_name.setText(b.getName());
        holder.cou_pno.setText(b.getPhoneNo());
        holder.cou_price.setText(b.getPrice());

}

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyViewHolderr extends RecyclerView.ViewHolder{
        TextView cou_brand,cou_ben,cou_price,cou_pno,cou_name;


        public MyViewHolderr(@NonNull View itemView) {
            super(itemView);
            cou_pno=itemView.findViewById(R.id.pno);
            cou_brand=itemView.findViewById(R.id.brandd);
            cou_ben=itemView.findViewById(R.id.bene);
            cou_price=itemView.findViewById(R.id.pricee);
            cou_name=itemView.findViewById(R.id.namee);

        }
    }
}
