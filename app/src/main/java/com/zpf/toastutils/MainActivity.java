package com.zpf.toastutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.zpf.toastutils.view.PieData;
import com.zpf.toastutils.view.PieView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toast.makeText(this,"Hello Word",Toast.LENGTH_SHORT).show();

        ArrayList<PieData> pieDataArrayList = new ArrayList<>();
        PieData pieData = new PieData("ONE",30);
        PieData pieData2 = new PieData("TWO",50);
        PieData pieData3 = new PieData("THREE",90);
        PieData pieData4 = new PieData("FOUR",20);
        PieData pieData5 = new PieData("FIVE",60);
        pieDataArrayList.add(pieData);
        pieDataArrayList.add(pieData2);
        pieDataArrayList.add(pieData3);
        pieDataArrayList.add(pieData4);
        pieDataArrayList.add(pieData5);
        PieView pieView = findViewById(R.id.pv_show);
        pieView.setData(pieDataArrayList);

    }
}
