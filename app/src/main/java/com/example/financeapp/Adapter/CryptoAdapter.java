package com.example.financeapp.Adapter;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.example.financeapp.Domain.domain;
import com.example.financeapp.R;
import com.majorik.sparklinelibrary.SparkLineLayout;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.Viewholder> {
ArrayList<domain> dataList;
DecimalFormat formatter;

    @NonNull
    @Override
    public CryptoAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View inflate =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_crypto,parent,false);

        return null;
    }

    @Override
    public  void onBindViewHolder(@NonNull CryptoAdapter.Viewholder holder, int position)
    {
        holder.NameTxt.setText(dataList.get(position).getName());
        holder.priceTxt.setText("$" + formatter.format(dataList.get(position).getPrice()));
        holder.changePercentTxt.setText(dataList.get(position).getChangePercent()+"%");
        holder.propertySizeTxt.setText(dataList.get(position).getPropertySize()+dataList.get(position).getSymbol());
        holder.propertyAmountTxt.setText("$" + formatter.format(dataList.get(position).getPropertyAmount()));
        holder.lineChart.setData(dataList.get(position).getLineData());

        if(dataList.get(position).getChangePercent()>0)
        {
            holder.changePercentTxt.setTextColor(Color.parseColor("#12c737"));
            holder.lineChart.setSparkLineColor(Color.parseColor("#12c737"));
        }
        else if(dataList.get(position).getChangePercent()<0)
        {
            holder.changePercentTxt.setTextColor(Color.parseColor("#fc0000"));
            holder.lineChart.setSparkLineColor(Color.parseColor("#fc0000"));

        }
        else{
            holder.changePercentTxt.setTextColor(Color.parseColor("#fffff"));
            holder.lineChart.setSparkLineColor(Color.parseColor("#fffff"));
        }

        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(dataList.get(position).getName(), "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.logo);

    }

    public CryptoAdapter(ArrayList<domain> dataList) {
        this.dataList = dataList;
        formatter =new DecimalFormat("###,###,###,###.##");
    }

    public int getItemCount()
    {
        return dataList.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder{

        TextView NameTxt, priceTxt, changePercentTxt, propertySizeTxt, propertyAmountTxt;
        ImageView logo;
        SparkLineLayout lineChart;

        public Viewholder(@NonNull View itemView)
        {
            super(itemView);
            NameTxt = itemView.findViewById(R.id.cryptoNameTxt);
            priceTxt = itemView.findViewById(R.id.cryptoPriceTxt);
            changePercentTxt = itemView.findViewById(R.id.changePercentTxt);
            propertyAmountTxt = itemView.findViewById(R.id.propertyAmountTxt);
            propertySizeTxt = itemView.findViewById(R.id.propertySizeTxt);
            logo = itemView.findViewById(R.id.logoImg);
            lineChart = itemView.findViewById(R.id.sparkLineLayout);


        }
    }

}
