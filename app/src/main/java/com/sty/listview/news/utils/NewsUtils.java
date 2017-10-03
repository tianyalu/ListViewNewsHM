package com.sty.listview.news.utils;

import android.content.Context;

import com.sty.listview.news.R;
import com.sty.listview.news.bean.NewsBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/17/0017.
 */

public class NewsUtils {

    public static ArrayList<NewsBean> getAllNews(Context context){
        ArrayList<NewsBean> arrayList = new ArrayList<>();

        for(int i = 0; i < 30; i++) {
            NewsBean newsBean = new NewsBean();
            newsBean.title = "谢霆锋经纪人：偷拍系侵权行为";
            newsBean.des = "称谢霆锋隐私权受到侵犯，将保留追究法律责任";
            newsBean.newsUrl = "http://www.sina.com.cn";
            newsBean.icon = context.getResources().getDrawable(R.drawable.meng2);
            arrayList.add(newsBean);

            NewsBean newsBean2 = new NewsBean();
            newsBean2.title = "知情人：王菲是谢霆锋心头最爱的人，是这样的吗？";
            newsBean2.des = "身边的人都知道谢霆锋最爱王菲，二人早有复合迹象";
            newsBean2.newsUrl = "http://www.baidu.com";
            newsBean2.icon = context.getResources().getDrawable(R.drawable.meng2);
            arrayList.add(newsBean2);

            NewsBean newsBean3 = new NewsBean();
            newsBean3.title = "热烈庆祝XX高薪就业";
            newsBean3.des = "XX平均薪资20K，其中有一哥们超过10W，这些IT精英都迎娶了白富美";
            newsBean3.newsUrl = "http://www.sohu.com";
            newsBean3.icon = context.getResources().getDrawable(R.drawable.meng2);
            arrayList.add(newsBean3);

            NewsBean newsBean4 = new NewsBean();
            newsBean4.title = "点击进入其他Adapter适配的ListView";
            newsBean4.des = "该ListView由ArrayAdapter和SimpleAdapter进行适配";
            newsBean4.newsUrl = "NewActivity";
            newsBean4.icon = context.getResources().getDrawable(R.drawable.meng2);
            arrayList.add(newsBean4);
        }

        return arrayList;
    }
}
