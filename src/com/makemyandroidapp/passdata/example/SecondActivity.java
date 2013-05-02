package com.makemyandroidapp.passdata.example;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class SecondActivity extends Activity {

	EditText nameTxt;
	EditText wordTxt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		int colorPos = this.getIntent().getIntExtra("color", 0);
		
		RelativeLayout back = (RelativeLayout)findViewById(R.id.backgorund);
		if(colorPos == 0){
			back.setBackgroundColor(Color.RED);
		}else if (colorPos == 1){
			back.setBackgroundColor(Color.BLUE);
		}else if (colorPos == 2){
			back.setBackgroundColor(Color.GREEN);
		}
		
		
		nameTxt = (EditText)findViewById(R.id.nameTxt);
		wordTxt = (EditText)findViewById(R.id.wordTxt);
		
		Button doneBtn = (Button)findViewById(R.id.doneBtn);
		Button cancelBtn = (Button)findViewById(R.id.cancelBtn);
		
		doneBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent resultIntent = new Intent();
				MyDataObject data = new MyDataObject();
				data.setName(nameTxt.getText().toString());
				data.setFavoriteWord(wordTxt.getText().toString());
				resultIntent.putExtra("data", data);
				setResult(RESULT_OK,resultIntent);
				finish();
			}
			
		});
		cancelBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setResult(RESULT_CANCELED);
				finish();
			}
			
		});
		
		
	}



}
