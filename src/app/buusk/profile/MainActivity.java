package app.buusk.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity  {
	private Button btnViewImage;
	private TextView ag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnViewImage = (Button) findViewById(R.id.btn2);
        ag = (TextView) findViewById(R.id.txt3);
        //ag.setText("kookkik ba mak");
        btnViewImage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),ImgView.class);
				startActivity(i);
			}
		});
        
    }
}
