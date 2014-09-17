package app.buusk.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
	private Button btnViewImage, btnEditText;
	private TextView txt1, txt2, txt3, txt4, txt5, txt6;
	private String show1,show2,show3,show4,show5,show6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ControlDB controldb = new ControlDB(this);
		controldb.getWritableDatabase();
		ViewMatching();

	}

	private void ViewMatching() {
		btnEditText = (Button) findViewById(R.id.btn1);
		btnViewImage = (Button) findViewById(R.id.btn2);
		btnEditText.setOnClickListener(this);
		btnViewImage.setOnClickListener(this);
		txt1 = (TextView) findViewById(R.id.age);
		txt2 = (TextView) findViewById(R.id.height);
		txt3 = (TextView) findViewById(R.id.weight);
		txt4 = (TextView) findViewById(R.id.country);
		txt5 = (TextView) findViewById(R.id.tel);
		txt6 = (TextView) findViewById(R.id.email);
		
		show1 = getIntent().getStringExtra("txt11");
		show2 = getIntent().getStringExtra("txt22");
		show3 = getIntent().getStringExtra("txt33");
		show4 = getIntent().getStringExtra("txt44");
		show5 = getIntent().getStringExtra("txt55");
		show6 = getIntent().getStringExtra("txt66");
		
		if(txt1 == null){
			txt1.setText("22");
			txt2.setText("174");
			txt3.setText("58");
			txt4.setText("Thailands");
			txt5.setText("081-7971589");
			txt6.setText("kiattisak_max@hotmail.coms");
		}
		if(show1 != null){
		txt1.setText(show1);
		txt2.setText(show2);
		txt3.setText(show3);
		txt4.setText(show4);
		txt5.setText(show5);
		txt6.setText(show6);
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn1:
			Intent i = new Intent(getApplicationContext(), Edit.class);
			startActivity(i);
			break;
		case R.id.btn2:
			Intent j = new Intent(getApplicationContext(), ImgView.class);
			startActivity(j);
			break;
		default:
			break;
		}
	}
}
