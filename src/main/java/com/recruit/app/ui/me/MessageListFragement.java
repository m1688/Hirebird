package com.recruit.app.ui.me;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.recruit.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jialiang.zoujl on 14-1-9.
 */
public class MessageListFragement extends Fragment {
    private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
    private ImageView imageView;// 动画图片
    private TextView t1, t2;// 页卡头标
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View rootView = inflater.inflate(R.layout.message_list_fragment, container, false);

        imageView = (ImageView)rootView.findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_s).getWidth();// 获取图片宽度
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        offset = (screenW / 2 - bmpW) / 2;// 计算偏移量
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        imageView.setImageMatrix(matrix);// 设置动画初始位置
        // initViewPager
        mPager = (ViewPager)rootView.findViewById(R.id.vPager);
        listViews = new ArrayList<View>();

        View applyView = layoutInflater.inflate(R.layout.message_list, null);
        ListView applyListView = (ListView) applyView.findViewById(R.id.message_list);
        applyListView.setAdapter(new MessageApplyAdaptor(getActivity()));
        applyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {
                startActivity(new Intent(getActivity(), MessageActivity.class));
            }
        });
        listViews.add(applyView);

        View noteView = layoutInflater.inflate(R.layout.message_list, null);
        ListView noteListView = (ListView) noteView.findViewById(R.id.message_list);
        noteListView.setAdapter(new MessageNoteAdaptor(getActivity()));
        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {
                startActivity(new Intent(getActivity(), MessageActivity.class));
            }
        });
        listViews.add(noteView);

        mPager.setAdapter(new MessageListPageAdapter(listViews));
        mPager.setCurrentItem(0);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            int one = offset * 2 + bmpW;// 页卡1 -> 页卡2 偏移量
            int two = one * 2;// 页卡1 -> 页卡3 偏移量

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageSelected(int arg0) {
                Animation animation = new TranslateAnimation(one*currIndex, one*arg0, 0, 0);//显然这个比较简洁，只有一行代码。
                currIndex = arg0;
                animation.setFillAfter(true);// True:图片停在动画结束位置
                animation.setDuration(300);
                imageView.startAnimation(animation);
            }

        });

        return rootView;
    }

    class MessageApplyAdaptor extends BaseAdapter {

        private List<Map<String, Object>> list =  getData();

        private LayoutInflater inflater;

        public MessageApplyAdaptor(Context context){
            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = inflater.inflate(R.layout.message_apply_list_item, null);
                Map<String, Object> map = list.get(position);
                TextView senderName = (TextView)convertView.findViewById(R.id.message_sender_name);
                senderName.setText(map.get("name").toString());
                TextView postDate = (TextView)convertView.findViewById(R.id.postDate);
                postDate.setText(map.get("time").toString());
                TextView content = (TextView)convertView.findViewById(R.id.message_content);
                content.setText(map.get("content").toString());
                ImageView imageView = (ImageView)convertView.findViewById(R.id.message_list_sender_img);
                imageView.setImageDrawable(getResources().getDrawable((Integer) map.get("image")));
            }
            return convertView;
        }

    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list =new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 =new HashMap<String, Object>();
        map1.put("image", R.drawable.zhugeliang);
        map1.put("name","诸葛亮");
        map1.put("time","1分钟前");
        map1.put("content","申请高级java工程师");
        list.add(map1);
        Map<String, Object> map2 =new HashMap<String, Object>();
        map2.put("image", R.drawable.zhangfei);
        map2.put("name","张飞");
        map2.put("time","3分钟前");
        map2.put("content","申请高级产品经理");
        list.add(map2);
        Map<String, Object> map3 =new HashMap<String, Object>();
        map3.put("image", R.drawable.zhaoyun);
        map3.put("name","海宝");
        map3.put("time","4分钟前");
        map3.put("content","申请项目经理！");
        list.add(map3);
        Map<String, Object> map4 =new HashMap<String, Object>();
        map4.put("image", R.drawable.guanyu);
        map4.put("name","樱木");
        map4.put("time","1小时前");
        map4.put("content","申请当老板！");
        list.add(map4);
        Map<String, Object> map5 =new HashMap<String, Object>();
        map5.put("image", R.drawable.ic_launcher);
        map5.put("name","潇潇");
        map5.put("time","1天前");
        map5.put("content","申请当老大");
        list.add(map5);
        Map<String, Object> map6 =new HashMap<String, Object>();
        map6.put("image", R.drawable.ic_launcher);
        map6.put("name","樱桃");
        map6.put("time","10分钟前");
        map6.put("content","sgaegeifero94eureg");
        list.add(map6);
        return list;
    }

    class MessageNoteAdaptor extends BaseAdapter {

        private List<Map<String, Object>> list =  getData2();

        private LayoutInflater inflater;

        public MessageNoteAdaptor(Context context){
            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = inflater.inflate(R.layout.message_note_list_item, null);
                Map<String, Object> map = list.get(position);
                TextView senderName = (TextView)convertView.findViewById(R.id.message_sender_name);
                senderName.setText(map.get("name").toString());
                TextView postDate = (TextView)convertView.findViewById(R.id.postDate);
                postDate.setText(map.get("time").toString());
                TextView content = (TextView)convertView.findViewById(R.id.message_content);
                content.setText(map.get("content").toString());
                ImageView imageView = (ImageView)convertView.findViewById(R.id.message_list_sender_img);
                imageView.setImageDrawable(getResources().getDrawable((Integer) map.get("image")));
            }
            return convertView;
        }

    }

    private List<Map<String, Object>> getData2() {
        List<Map<String, Object>> list =new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 =new HashMap<String, Object>();
        map1.put("image", R.drawable.zhangfei);
        map1.put("name","张山");
        map1.put("time","2014-01-01 15:23:34");
        map1.put("content","这份工作条件高，工资低，加班多，放假少。。。");
        list.add(map1);
        Map<String, Object> map2 =new HashMap<String, Object>();
        map2.put("image", R.drawable.guanyu);
        map2.put("name","无边");
        map2.put("time","2014-01-01 15:42:34");
        map2.put("content","终于有一个靠谱的招聘啊....");
        list.add(map2);
        Map<String, Object> map3 =new HashMap<String, Object>();
        map3.put("image", R.drawable.zhugeliang);
        map3.put("name","海宝");
        map3.put("time","4分钟前");
        map3.put("content","好公司就在这里，赶紧的。。");
        list.add(map3);
        Map<String, Object> map4 =new HashMap<String, Object>();
        map4.put("image", R.drawable.zhaoyun);
        map4.put("name","樱木");
        map4.put("time","1小时前");
        map4.put("content","好公司就在这里，赶紧的。。");
        list.add(map4);
        Map<String, Object> map5 =new HashMap<String, Object>();
        map5.put("image", R.drawable.ic_launcher);
        map5.put("name","潇潇");
        map5.put("time","1天前");
        map5.put("content","好公司就在这里，赶紧的。。");
        list.add(map5);
        Map<String, Object> map6 =new HashMap<String, Object>();
        map6.put("image", R.drawable.zhaoyun);
        map6.put("name","樱桃");
        map6.put("time","10分钟前");
        map6.put("content","好公司就在这里，赶紧的。。");
        list.add(map6);
        Map<String, Object> map7 =new HashMap<String, Object>();
        map7.put("image", R.drawable.ic_launcher);
        map7.put("name","莉莉");
        map7.put("time","2天前");
        map7.put("content","好公司就在这里，赶紧的。。");
        list.add(map7);
        return list;
    }

}
