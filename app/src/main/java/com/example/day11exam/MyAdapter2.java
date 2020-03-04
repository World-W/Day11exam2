package com.example.day11exam;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class MyAdapter2 extends BaseAdapter {
    Context context;List<Bean.ResultBean.PzshBean.CommodityListBeanX> list;

    public MyAdapter2(Context context, List<Bean.ResultBean.PzshBean.CommodityListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHadnler hadnler=null;
        if(convertView==null){
            hadnler=new ViewHadnler();
            convertView=View.inflate(context,R.layout.item3,null);
            hadnler.img3=convertView.findViewById(R.id.img3);
            hadnler.txt3=convertView.findViewById(R.id.txt3);
            convertView.setTag(hadnler);
        }else{
            hadnler= (ViewHadnler) convertView.getTag();
        }
        Bean.ResultBean.PzshBean.CommodityListBeanX commodityListBeanX = list.get(position);
        String commodityName1 = commodityListBeanX.getCommodityName();
        String masterPic = commodityListBeanX.getMasterPic();
        hadnler.txt3.setText(commodityName1);
        Glide.with(context).load(masterPic).into(hadnler.img3);
        return convertView;
    }
    public class ViewHadnler{
        ImageView img3;
        TextView txt3;
    }
}
