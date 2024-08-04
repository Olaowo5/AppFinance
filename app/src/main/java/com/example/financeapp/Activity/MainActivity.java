package com.example.financeapp.Activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.financeapp.Adapter.CryptoAdapter;
import com.example.financeapp.Adapter.StockAdapter;
import com.example.financeapp.Domain.domain;
import com.example.financeapp.R;
import com.example.financeapp.databinding.ActiveMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActiveMainBinding binding;

    ArrayList<Integer> lineData = new ArrayList<>();
    ArrayList<Integer> lineData2 = new ArrayList<>();
    ArrayList<Integer> lineData3 = new ArrayList<>();
    ArrayList<Integer> lineData4 = new ArrayList<>();

    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
       super.onCreate(savedInstanceState);


        binding = ActiveMainBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());

       // setContentView(R.layout.active_main);
       setData();
        recyclerViewCrypto();
        recyclerViewStock();
    }

    private void setData()
    {
        //this is sample data to enter
        //will use Api for live services
        lineData.add(2000);
        lineData.add(2200);
        lineData.add(1200);
        lineData.add(2100);

        lineData2.add(1100);
        lineData2.add(2700);
        lineData2.add(1500);
        lineData2.add(800);

        lineData3.add(900);
        lineData3.add(3200);
        lineData3.add(1400);
        lineData3.add(1570);

        lineData4.add(6100);
        lineData4.add(3400);
        lineData4.add(2300);
        lineData4.add(1770);
    }

    private void recyclerViewCrypto()
    {
        binding.cryptoView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        ArrayList<domain> domainArrayList = new ArrayList<>();
        domainArrayList.add(new domain("bitcoin","BTX",
                1234.32,2.13,lineData,1234.12,0.1234));
        domainArrayList.add(new domain("etheruem","ETH",
                2134.21,-1.13,lineData2,6545.65,0.12345));
        domainArrayList.add(new domain("trox","ROX",
                6543.21,0.73,lineData3,31234.12,0.02154));
        domainArrayList.add(new domain("olcoin","OLA",
                624.32,0.03,lineData4,674.12,0.034));

        binding.cryptoView.setAdapter(new CryptoAdapter(domainArrayList));
    }

    private void recyclerViewStock()
    {
        binding.cryptoView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        //this is sample data to enter
        //will use Api for live services
        ArrayList<domain> domainArrayList = new ArrayList<>();
        domainArrayList.add(new domain("NASDAQ100","BTX",
                1234.32,2.13,lineData,1234.12,0.1234));
        domainArrayList.add(new domain("S&P 500","ETH",
                2134.21,-1.13,lineData2,6545.65,0.12345));
        domainArrayList.add(new domain("Dow Jones","ROX",
                6543.21,0.73,lineData3,31234.12,0.02154));
        domainArrayList.add(new domain("OLa Stocks","OLA",
                624.32,0.03,lineData4,674.12,0.034));

        binding.stockView.setAdapter(new StockAdapter(domainArrayList));
    }
}
