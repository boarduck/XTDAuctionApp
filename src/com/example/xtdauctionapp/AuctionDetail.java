package com.example.xtdauctionapp;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AuctionDetail extends Activity {
	ImageView imgView = null;
	TextView goodDesc = null;
	Button autoBids = null;
	Button bidByHands = null;
	TextView currentPrice = null;
	EditText bidPrice = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auction_detail);

		imgView = (ImageView) findViewById(R.id.imgGoods);
		goodDesc = (TextView) findViewById(R.id.goodsDesc);
		autoBids = (Button) findViewById(R.id.autoBids);
		bidByHands = (Button) findViewById(R.id.bidByHands);
		currentPrice = (TextView) findViewById(R.id.currentPrice);
		bidPrice = (EditText) findViewById(R.id.bidPrice);
		
		int id=getIntent().getIntExtra("AuctionID",0);
		switch(id)
		{
			case 0:
				imgView.setImageResource(R.drawable.goods1);
				goodDesc.setText("红酒一批");
				setTitle("拍卖会20140001");
				break;
			case 1:
				imgView.setImageResource(R.drawable.goods2);
				goodDesc.setText("手机一批");
				setTitle("拍卖会20140002");
				break;
			case 2:
				imgView.setImageResource(R.drawable.goods3);
				goodDesc.setText("雪茄一批");
				setTitle("拍卖会20140003");
				break;
			case 3:
				imgView.setImageResource(R.drawable.goods4);
				goodDesc.setText("手表一批");
				setTitle("拍卖会20140004");
				break;
			case 4:
				imgView.setImageResource(R.drawable.goods5);
				goodDesc.setText("钻石一批");
				setTitle("拍卖会20140005");
				break;
			case 5:
				imgView.setImageResource(R.drawable.goods6);
				goodDesc.setText("洋酒一批");
				setTitle("拍卖会20140006");
				break;
			default:
					break;
		}
				
		autoBids.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
            	currentPrice.setText("当前价格:30,100,000");
            }  
        });  
		
		bidByHands.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
            	int iprice=0;
            	String price = bidPrice.getText() == null?"":bidPrice.getText().toString();
            	if(price == "" || price == "0" || 100000%Integer.parseInt(price) != 0)
            	{
            		new  AlertDialog.Builder(v.getContext())
            						.setTitle("手工出价" )  
            		                .setMessage("您的出价必须是阶梯价" )  
            		                .setPositiveButton("确定" ,  null ) 
            		                .show();  
            	}
            	else {
            	iprice = Integer.parseInt(price);
            	currentPrice.setText("当前价格:" + (3000000 + iprice));
            	}
            }  
        }); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.auction_detail, menu);
		return true;
	}

}
