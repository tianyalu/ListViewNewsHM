package com.sty.listview.news;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.sty.listview.news.adapter.NewsAdapter;
import com.sty.listview.news.bean.NewsBean;
import com.sty.listview.news.utils.NewsUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private static final String TAG = MainActivity.class.getSimpleName();

    private Context mContext;
    private ListView lvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        initViews();
    }

    private void initViews(){
        //1.找到ListView
        lvNews = (ListView) findViewById(R.id.lv_news);
        //2.获取新闻数据，用List封装
        ArrayList<NewsBean> allNews = NewsUtils.getAllNews(mContext);
        //3.创建一个adapter设置给ListView
        NewsAdapter newsAdapter = new NewsAdapter(mContext, allNews);
        lvNews.setAdapter(newsAdapter);
        //4.设置ListView条目的点击事件
        lvNews.setOnItemClickListener(this);
    }

    /**
     * ListView的条目点击时会调用该方法
     * @param parent: 代表listview
     * @param view: 点击的条目上的那个view对象
     * @param position: 条目的位置
     * @param id: 条目的ID
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //需要获取条目上bean对象中url作跳转
        NewsBean bean = (NewsBean) parent.getItemAtPosition(position);

        String url = bean.newsUrl;

        if(url.equals("NewActivity")){
            //启动新的Activity
            Intent intent = new Intent(MainActivity.this, OtherAdapterActivity.class);
            startActivity(intent);
        }else {
            //跳转浏览器
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }

    }
}
