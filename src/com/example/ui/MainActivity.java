package com.example.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class MainActivity extends TitleActivity  {
    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // 图片
    private int[] icon = { R.drawable.search, R.drawable.add,
            R.drawable.edit, R.drawable.delete, R.drawable.my,
            R.drawable.tongji, R.drawable.analysis, R.drawable.settings,
            R.drawable.help };
    private String[] iconName = { "成绩查询", "成绩添加", "修改成绩", "删除成绩", "我的成绩", "统计成绩", "成绩分析",
            "设置", "帮助" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        setTitle("成绩管理");
        showBackwardView(R.string.text_back,true);
        showForwardView(R.string.text_forward, true);
        
        gview = (GridView) findViewById(R.id.gview);
        data_list = new ArrayList<Map<String, Object>>();
        getData();
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.griditem, from, to);
        gview.setAdapter(sim_adapter);
    }

    
    
    public List<Map<String, Object>> getData(){        
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
            
        return data_list;
    }
    

}