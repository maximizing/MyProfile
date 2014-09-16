package app.buusk.profile;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ControlDB extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "Profile488";
	private static final String TABLE_PROFILE = "myprofile";
	private static final int DATABASE_VERSION = 1;

	public ControlDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " 
				+ TABLE_PROFILE 
				+ "(Profile_ID INTEGER PRIMARY KEY AUTOINCREMENT," 
				+ "Age INTRGER(4),"
				+ "Height INTEGER(4),"
				+ "Weight INTEGER(4),"
				+ "Country VARCHAR(50),"
				+ "Tel VARCHAR(10),"
				+ "Email TEXT(100));");
		Log.d("CREATE TABLE", "Create Table Successfully");
		
	}
	public long InsertData(String strAge, String strHeight, String strWeight, String strCountry, String strTel, String strEmail){
		try{
			SQLiteDatabase db;
			db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("Age", strAge);
			values.put("Height", strHeight);
			values.put("Weight", strWeight);
			values.put("Country", strCountry);
			values.put("Tel", strTel);
			values.put("Email", strEmail);
			long l = db.insert(TABLE_PROFILE, null, values);
			db.close();
			return l;
		}catch (Exception e){
			return -1;
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_PROFILE);
		onCreate(db);
		
	}
	

}
