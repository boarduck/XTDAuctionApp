package com.example.xtdauctionapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.xtdauctionapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;  
import android.view.View; 

public class MainActivity extends Activity {
	private ListView list = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		  list = (ListView) findViewById(R.id.MyListView);
	        
	        //组织数据源
	        List<HashMap<String, Object>> mylist = new ArrayList<HashMap<String, Object>>();
//	        for(int i=0;i<6;i++) {
//	            HashMap<String, Object> map = new HashMap<String, Object>();	            
//	            map.put("imageView",R.drawable.goods1);
//	            map.put("itemTitle", "拍卖会2014000" + (i+1) );	          
//	            map.put("itemText", "拍卖会详情");
//	            mylist.add(map);
//	        }
	        HashMap<String, Object> map = new HashMap<String, Object>();	            
            map.put("imageView",R.drawable.goods1);
            map.put("itemTitle", "拍卖会20140001");	          
            map.put("itemText", "红酒一批");
            mylist.add(map);
            map = new HashMap<String, Object>();	            
            map.put("imageView",R.drawable.goods2);
            map.put("itemTitle", "拍卖会20140002");	          
            map.put("itemText", "手机一批");
            mylist.add(map);
            map = new HashMap<String, Object>();	            
            map.put("imageView",R.drawable.goods3);
            map.put("itemTitle", "拍卖会20140003");	          
            map.put("itemText", "雪茄一批");
            mylist.add(map);
            map = new HashMap<String, Object>();	            
            map.put("imageView",R.drawable.goods4);
            map.put("itemTitle", "拍卖会20140004");	          
            map.put("itemText", "手表一批");
            mylist.add(map);
            map = new HashMap<String, Object>();	            
            map.put("imageView",R.drawable.goods5);
            map.put("itemTitle", "拍卖会20140005");	          
            map.put("itemText", "钻石一批");
            mylist.add(map);
            map = new HashMap<String, Object>();	            
            map.put("imageView",R.drawable.goods6);
            map.put("itemTitle", "拍卖会20140006");	          
            map.put("itemText", "洋酒一批");
            mylist.add(map);
            
	        //配置适配器
	        SimpleAdapter adapter = new SimpleAdapter(this, 
	                                                  mylist,//数据源 
	                                                  R.layout.my_listitem,//显示布局
	                                                  new String[] {"imageView","itemTitle", "itemText"}, //数据源的属性字段
	                                                  new int[] {R.id.imageView,R.id.itemTitle,R.id.itemText}); //布局里的控件id
	        //添加并且显示
	        list.setAdapter(adapter);
	        
	        list.setOnItemClickListener(new OnItemClickListener() {  
	        	  
	            @Override  
	            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,  
	                    long arg3) {  
	            	
	                Intent intent = new Intent(arg0.getContext(), AuctionDetail.class);   
	                intent.putExtra("AuctionID", arg2);  
	                startActivity(intent); 
	            }  
	        });  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch (item.getItemId()) {
		case R.id.action_settings:		
		return true;
		case R.id.action_exit:
		finish();
		return true;		
		default:
		return false;
		}

	}

}
