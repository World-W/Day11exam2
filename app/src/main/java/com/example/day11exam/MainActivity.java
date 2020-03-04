package com.example.day11exam;

import android.view.View;

import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;


import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;


import java.util.ArrayList;
import java.util.List;



public class MainActivity extends BaseActivity {


    private ListView listView;
    private XBanner xb;
    private ListView listView1;
    private GridView gridView;
    List<Bean.ResultBean>data=new ArrayList<>();
    private CucesToact ct;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void iniView() {

        listView = findViewById(R.id.listView);
        xb = findViewById(R.id.xbn);
        listView1 = findViewById(R.id.listView1);
        gridView = findViewById(R.id.listView2);
        ct = findViewById(R.id.ct);
    }

    @Override
    protected void getData() {

        String str="http://mobile.bwstudent.com/small/commodity/v1/bannerShow";
        NutilsVolley.getInstance().doGet(str, new NutilsVolley.Cobllack() {
            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();
                Xbanner xBanner = gson.fromJson(json, Xbanner.class);
                final List<Xbanner.ResultBean> result = xBanner.getResult();
                xb.setBannerData(result);
                xb.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Xbanner.ResultBean resultBean = result.get(position);
                        String imageUrl = resultBean.getImageUrl();
                        Glide.with(MainActivity.this).load(imageUrl).into((ImageView)view);
                    }
                });
            }

            @Override
            public void onFialues(String msg) {

            }
        });

            ct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            String url="http://mobile.bwstudent.com/small/commodity/v1/commodityList";
           NutilsVolley.getInstance().doGet(url, new NutilsVolley.Cobllack() {
               @Override
               public void onSuccess(String json) {
                   Gson gson = new Gson();
                   Bean bean = gson.fromJson(json, Bean.class);
                   Bean.ResultBean result = bean.getResult();
                   Bean.ResultBean.RxxpBean rxxp = result.getRxxp();
                  List<Bean.ResultBean.RxxpBean.CommodityListBean> commodityList = rxxp.getCommodityList();

                   MyAdapter myAdapter = new MyAdapter(MainActivity.this,commodityList);
                   listView.setAdapter(myAdapter);
                   Bean.ResultBean.MlssBean mlss = result.getMlss();
                   List<Bean.ResultBean.MlssBean.CommodityListBeanXX> commodityList2 = mlss.getCommodityList();
                   MyAdapter1 myAdapter1 = new MyAdapter1(MainActivity.this,commodityList2);
                   listView1.setAdapter(myAdapter1);
                   Bean.ResultBean.PzshBean pzsh = result.getPzsh();
                   List<Bean.ResultBean.PzshBean.CommodityListBeanX> commodityList1 = pzsh.getCommodityList();
                   MyAdapter2 myAdapter2 = new MyAdapter2(MainActivity.this, commodityList1);
                    gridView.setAdapter(myAdapter2);
               }

               @Override
               public void onFialues(String msg) {

               }
           });
    }


}
