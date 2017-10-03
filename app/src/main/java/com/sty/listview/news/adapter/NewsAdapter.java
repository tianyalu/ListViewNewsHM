package com.sty.listview.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sty.listview.news.R;
import com.sty.listview.news.bean.NewsBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/17/0017.
 */

public class NewsAdapter extends BaseAdapter {
    private ArrayList<NewsBean> list;
    private Context context;

    public NewsAdapter(Context context, ArrayList<NewsBean> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        //1.复用convertView优化ListView,创建一个view作为getView的返回值用来显示一个条目
        if(convertView != null){
            view = convertView;
        }else{
            //context:上下文 resource:要转换称view对象的layout的id root:将layout用root(ViewGroup)
            //包一层作为getView的返回值，一般传null
            view = View.inflate(context, R.layout.item_news_layout, null);  //[Layout填充的三种方式]

            //通过LayoutInflater将布局转换为view对象
            //view = LayoutInflater.from(context).inflate(R.layout.item_news_layout, null);

            //通过Context获取系统服务得到一个LayoutInflater,通过LayoutInflater将一个布局转换为view对象
            //LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //view = layoutInflater.inflate(R.layout.item_news_layout, null);
        }
        //2.获取view上的子控件对象
        ImageView itemImgIcon = (ImageView) view.findViewById(R.id.item_img_icon);
        TextView itemTvTitle = (TextView) view.findViewById(R.id.item_tv_title);
        TextView itemTvDes = (TextView) view.findViewById(R.id.item_tv_des);
        //3.获取条目对应的list集合中的新闻数据，Bean对象
        NewsBean newsBean = list.get(position);
        //4.将数据设置给这些子控件显示
        itemImgIcon.setImageDrawable(newsBean.icon); //设置imageView的图片
        itemTvTitle.setText(newsBean.title);
        itemTvDes.setText(newsBean.des);

        return view;
    }
}
