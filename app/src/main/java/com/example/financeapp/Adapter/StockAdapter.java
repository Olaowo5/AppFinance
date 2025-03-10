package com.example.financeapp.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.financeapp.Domain.domain;
import com.example.financeapp.R;
import com.majorik.sparklinelibrary.SparkLineLayout;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.Viewholder> {
ArrayList<domain> dataList;
DecimalFormat formatter;

    @NonNull
    @Override
    public StockAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View inflate =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_stock,parent,false);

        return new Viewholder(inflate);
    }

    @Override
    public  void onBindViewHolder(@NonNull StockAdapter.Viewholder holder, int position)
    {
        holder.NameTxt.setText(dataList.get(position).getName());
        holder.priceTxt.setText("$" + formatter.format(dataList.get(position).getPrice()));
        holder.changePercentTxt.setText(dataList.get(position).getChangePercent()+"%");

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



        if(position == 0)
        {
            holder.mainLayout.setBackgroundResource(R.drawable.blue_bg);
            holder.NameTxt.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.white));
            holder.priceTxt.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.white));
            holder.changePercentTxt.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.white));

        }

        String picName="";
        switch (dataList.get(position).getName()){
            case "NASDAQ100":{
                picName="stock_1";
                break;
            }
            case "S&P 500":{
                picName="stock_2";
                break;
            }
            case "Dow Jones":{
                picName="stock_3";
                break;
            }
            case "OLa Stocks":{
                picName="stock_4";
                break;
            }
        }

        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(picName, "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.logo);

    }

    public StockAdapter(ArrayList<domain> dataList) {
        this.dataList = dataList;
        formatter =new DecimalFormat("###,###,###,###.##");
    }

    public int getItemCount()
    {
        return dataList.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder{

        TextView NameTxt, priceTxt, changePercentTxt;
        ImageView logo;
        SparkLineLayout lineChart;
        ConstraintLayout mainLayout;


        public Viewholder(@NonNull View itemView)
        {
            super(itemView);
            NameTxt = itemView.findViewById(R.id.cryptoNameTxt);
            priceTxt = itemView.findViewById(R.id.cryptoPriceTxt);
            changePercentTxt = itemView.findViewById(R.id.changePercentTxt);

            logo = itemView.findViewById(R.id.logoImg);
            lineChart = itemView.findViewById(R.id.sparkLineLayout);

            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }

}
