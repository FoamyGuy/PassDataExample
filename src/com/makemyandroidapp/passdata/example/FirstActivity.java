package com.makemyandroidapp.passdata.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends Activity {

	Spinner colorSpn;
	Button enterBtn;
	TextView label;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		enterBtn = (Button)findViewById(R.id.enterBtn);
		colorSpn = (Spinner)findViewById(R.id.colorSpn);
		label = (TextView)findViewById(R.id.colorPickLbl);
		
		enterBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent secondActivityIntent = new Intent(v.getContext(), SecondActivity.class);
				secondActivityIntent.putExtra("color", colorSpn.getSelectedItemPosition());
				startActivityForResult(secondActivityIntent, 42);
				
			}
			
		});
	}
	
	
	@Override
	public void onActivityResult( int requestCode ,int resultCode, Intent data){
		if(requestCode == 42){
			if(resultCode == RESULT_OK){
				MyDataObject dat = data.getParcelableExtra("data");

				String greeting = "Hello " + dat.getName() + " your favorite word is: " + dat.getFavoriteWord();
				label.setText(greeting);
			}else if (resultCode == RESULT_CANCELED){
				Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
			}
		}

	}



}
