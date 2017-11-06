package com.example.machenike.myapplicationad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

/**
 * Created by Machenike on 2017/11/5.
 */

public class MyAdpter extends BaseAdapter {
    private List<Map<String,Object>> ListMap;
    private Context context;
    public MyAdpter(Context context,List<Map<String,Object>> ListMap){
        this.context = context;
        this.ListMap = ListMap;
    }
    @Override
    public int getCount() {
        return ListMap.size();
    }

    @Override
    public Object getItem(int i) {
        return ListMap.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       // 节省空间，防止创建过多的对象
        if (view==null){
            view = LayoutInflater.from(context).inflate(R.layout.list,null);
        }

        final Map<String,Object> map = ListMap.get(i); //当前位置的map

        //获取listview布局中的 所有组件
        TextView tv_price = (TextView)view.findViewById(R.id.tv_price);
        TextView tv_title = (TextView)view.findViewById(R.id.tv_title);
        TextView tv_major_material = (TextView)view.findViewById(R.id.tv_major_material);
        TextView tv_minor_material = (TextView)view.findViewById(R.id.tv_minor_material);
        ImageView img_menu = (ImageView) view.findViewById(R.id.img_menu);
        final CheckBox cb_pick = (CheckBox)view.findViewById(R.id.cb_pick);

        //把map中的key对应的值设置到组件里
        tv_price.setText(map.get("price").toString());
        tv_title.setText(map.get("title").toString());
        tv_major_material.setText(map.get("major").toString());
        tv_minor_material.setText(map.get("minor").toString());
        img_menu.setImageResource((int)map.get("image"));
        //添加checkbox的监听方法
        cb_pick.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cb_pick.isChecked()){
                    Toast.makeText(context,"选中了"+map.get("title").toString(),Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context,"取消了"+map.get("title").toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
