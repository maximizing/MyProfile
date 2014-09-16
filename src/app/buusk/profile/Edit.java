package app.buusk.profile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
			save();
			txt11 = (etxt1.getText().toString());
			txt22 = (etxt2.getText().toString());
			txt33 = (etxt3.getText().toString());
			txt44 = (etxt4.getText().toString());
			txt55 = (etxt5.getText().toString());
			txt66 = (etxt6.getText().toString());
			

			Intent k = new Intent(getApplicationContext(), MainActivity.class);
			k.putExtra("txt11", txt11);
			k.putExtra("txt22", txt22);
			k.putExtra("txt33", txt33);
			k.putExtra("txt44", txt44);
			k.putExtra("txt55", txt55);
			k.putExtra("txt66", txt66);
			startActivity(k);
			//finish();
			break;
		default:
			break;
		}
	}

	public boolean save() {
		final AlertDialog .Builder adb = new AlertDialog.Builder(this);
		AlertDialog ad = adb.create();
		if(etxt1.getText().length() == 0){
			ad.setMessage("Please input age");
			etxt1.requestFocus();
			return false;
		}
		if(etxt2.getText().length() == 0){
			ad.setMessage("Please input height");
			etxt2.requestFocus();
			return false;
		}
		if(etxt3.getText().length() == 0){
			ad.setMessage("Please input weight");
			etxt3.requestFocus();
			return false;
		}
		if(etxt4.getText().length() == 0){
			ad.setMessage("Please input country");
			etxt4.requestFocus();
			return false;
		}
		if(etxt5.getText().length() == 0){
			ad.setMessage("Please input tel");
			etxt5.requestFocus();
			return false;
		}
		if(etxt6.getText().length() == 0){
			ad.setMessage("Please input email");
			etxt6.requestFocus();
			return false;
		}
		ControlDB dbclass = new ControlDB(this);
		long savedata = dbclass.InsertData(etxt1.getText().toString(), etxt2.getText().toString(), etxt3.getText().toString(), etxt4.getText().toString(), etxt5.getText().toString(), etxt6.getText().toString());
		if(savedata <= 0){
			ad.setMessage("Error !!!");
			ad.show();
			return false;
		}
		Toast.makeText(getApplicationContext(),"Add Data Successfully", Toast.LENGTH_SHORT).show();
		return true;
	}

}
