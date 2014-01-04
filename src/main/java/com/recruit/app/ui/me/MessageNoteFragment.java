package com.recruit.app.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.recruit.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jialiang.zoujl on 14-1-2.
 */
public class MessageNoteFragment extends Fragment {
    private ListView listView ;
    private SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(R.layout.message_list,container,false);
        adapter =new SimpleAdapter(getActivity(), getData(), R.layout.message_list_item,
                new String[] { "image", "content"}, new int[] { R.id.msg_image,R.id.message_list_content});

        listView = (ListView) rootView.findViewById(android.R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {
                startActivity(new Intent(getActivity(), MessageActivity.class));
        }});

        return rootView;
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list =new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 =new HashMap<String, Object>();
        map1.put("image", R.drawable.ic_launcher);
        map1.put("name","香香");
        map1.put("time","1分钟前");
        map1.put("content","这是粉色金佛就是多几分感慨很多功课还是客观是个");
        list.add(map1);
        Map<String, Object> map2 =new HashMap<String, Object>();
        map2.put("image", R.drawable.ic_launcher);
        map2.put("name","永恒");
        map2.put("time","3分钟前");
        map2.put("content","今天天气真好，心情也舒畅！！！");
        list.add(map2);
        Map<String, Object> map3 =new HashMap<String, Object>();
        map3.put("image", R.drawable.ic_launcher);
        map3.put("name","海宝");
        map3.put("time","4分钟前");
        map3.put("content","能否从开始技术规范设计的感觉开始");
        list.add(map3);
        Map<String, Object> map4 =new HashMap<String, Object>();
        map4.put("image", R.drawable.ic_launcher);
        map4.put("name","樱木");
        map4.put("time","1小时前");
        map4.put("content","而他神色间若非他嗨哟对人体打发时间通融密瑞吉斯");
        list.add(map4);
        Map<String, Object> map5 =new HashMap<String, Object>();
        map5.put("image", R.drawable.ic_launcher);
        map5.put("name","潇潇");
        map5.put("time","1天前");
        map5.put("content","一直很高兴，天天开心");
        list.add(map5);
        Map<String, Object> map6 =new HashMap<String, Object>();
        map6.put("image", R.drawable.ic_launcher);
        map6.put("name","樱桃");
        map6.put("time","10分钟前");
        map6.put("content","sgaegeifero94eureg");
        list.add(map6);
        Map<String, Object> map7 =new HashMap<String, Object>();
        map7.put("image", R.drawable.ic_launcher);
        map7.put("name","莉莉");
        map7.put("time","2天前");
        map7.put("content","每天有什么事都说出来，这样感觉会很轻松，烦恼更少、幸福更多");
        list.add(map7);
        return list;
    }
}
