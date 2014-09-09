package app.buusk.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Edit extends Activity implements OnClickListener {
	private Button btnsubmit;
	private EditText etxt1, etxt2, etxt3, etxt4, etxt5, etxt6;
	private String txt11, txt22, txt33, txt44, txt55, txt66;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.edittext);
		super.onCreate(savedInstanceState);
		ViewMatching();
		
	}

	private void ViewMatching() {
		btnsubmit = (Button) findViewById(R.id.btn3);
		btnsubmit.setOnClickListener(this);		
		etxt1 = (EditText) findViewById(R.id.et1);
		etxt2 = (EditText) findViewById(R.id.et2);
		etxt3 = (EditText) findViewById(R.id.et3);
		etxt4 = (EditText) findViewById(R.id.et4);
		etxt5 = (EditText) findViewById(R.id.et5);
		etxt6 = (EditText) findViewById(R.id.et6);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn3:
			txt11 = (etxt1.getText().toString());
			txt22 = (etxt2.getText().toString());
			txt33 = (etxt3.getText().toString());
			txt44 = (etxt4.getText().toString());
			txt55 = (etxt5.getText().toString());
			txt66 = (etxt6.getText().toString());
			
//			txt2.setText(etxt2.getText().toString());
//			txt3.setText(etxt3.getText().toString());
//			txt4.setText(etxt4.getText().toString());
//			txt5.setText(etxt5.getText().toString());
//			txt6.setText(etxt6.getText().toString());
			Intent k = new Intent(getApplicationContext(), MainActivity.class);
			k.putExtra("txt11", txt11);
			k.putExtra("txt22", txt22);
			k.putExtra("txt33", txt33);
			k.putExtra("txt44", txt44);
			k.putExtra("txt55", txt55);
			k.putExtra("txt66", txt66);
			startActivity(k);
			break;
		default:
			break;
		}
	}

}
