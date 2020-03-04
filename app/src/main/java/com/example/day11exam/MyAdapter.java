package com.example.day11exam;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class MyAdapter extends BaseAdapter {
    Context context; List<Bean.ResultBean.RxxpBean.CommodityListBean> list;
    public MyAdapter(Context context, List<Bean.ResultBean.RxxpBean.CommodityListBean> list) {
        this.context=context;
        this.list=list;
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
            convertView=View.inflate(context,R.layout.item,null);
            hadnler.img=convertView.findViewById(R.id.img);
            hadnler.txt=convertView.findViewById(R.id.txt);
            convertView.setTag(hadnler);
        }else{
            hadnler= (ViewHadnler) convertView.getTag();
        }
        Bean.ResultBean.RxxpBean.CommodityListBean commodityListBean = list.get(position);
        String commodityName = commodityListBean.getCommodityName();
        String masterPic = commodityListBean.getMasterPic();
        Glide.with(context).load(masterPic).into(hadnler.img);
        hadnler.txt.setText(commodityName);
        return convertView;
    }
    public class ViewHadnler{
        ImageView img;
        TextView txt;
    }
}
