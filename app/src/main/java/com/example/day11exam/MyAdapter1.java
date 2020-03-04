package com.example.day11exam;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class MyAdapter1 extends BaseAdapter {
    Context context; List<Bean.ResultBean.MlssBean.CommodityListBeanXX> list;

    public MyAdapter1(Context context, List<Bean.ResultBean.MlssBean.CommodityListBeanXX> list) {
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
            convertView=View.inflate(context,R.layout.item1,null);
            hadnler.img1=convertView.findViewById(R.id.img1);
            hadnler.txt1=convertView.findViewById(R.id.txt1);
            convertView.setTag(hadnler);
        }else{
            hadnler= (ViewHadnler) convertView.getTag();
        }
        Bean.ResultBean.MlssBean.CommodityListBeanXX commodityListBeanXX = list.get(position);
        String commodityName = commodityListBeanXX.getCommodityName();
        String masterPic = commodityListBeanXX.getMasterPic();
        Glide.with(context).load(masterPic).into(hadnler.img1);
        hadnler.txt1.setText(commodityName);
        return convertView;
    }
    public class ViewHadnler{
        ImageView img1;
        TextView txt1;
    }
}
