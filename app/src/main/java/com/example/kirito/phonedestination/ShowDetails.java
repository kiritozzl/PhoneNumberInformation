package com.example.kirito.phonedestination;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by kirito on 2016.10.06.
 */

public class ShowDetails extends AppCompatActivity {
    private String num;
    private String url = "http://apis.juhe.cn/mobile/get?phone=";
    private String s_url;

    private TextView tv_pro,tv_city,tv_code,tv_info,tv_comp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

        initView();
        num = getIntent().getStringExtra("num");
        s_url = url + num + "&key=06a4dc0fc099a28181cb410e42d4a1a4";
        LoadData load = new LoadData();
        load.setListener(new LoadData.Listener() {
            @Override
            public void setItem(Item item) {
                tv_pro.setText(item.getProvince());
                tv_city.setText(item.getCity());
                tv_code.setText(item.getAreacode());
                tv_comp.setText(item.getCompany());
                tv_info.setText(item.getCard());
            }
        });
        load.execute(s_url);
    }

    private void initView(){
        tv_city = (TextView) findViewById(R.id.city_show);
        tv_code = (TextView) findViewById(R.id.code_show);
        tv_comp = (TextView) findViewById(R.id.company_show);
        tv_info = (TextView) findViewById(R.id.info_show);
        tv_pro = (TextView) findViewById(R.id.pro_show);
    }
}
