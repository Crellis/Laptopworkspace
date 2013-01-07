package shopping.list;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.net.Uri;
import android.database.Cursor;
import android.provider.Contacts.People;



public class ShoppingListActivity extends Activity {
	Uri addUri = null;
	Uri changeUri = null;
    /** Called when the activity is first created. */
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button queryButton = (Button)findViewById(R.id.queryButton);
        queryButton.setOnClickListener(new OnClickListener() {
        	public void onClick(View view) {
        	queryContactPhoneNumber();
        	}
        	});
    }
	
	private void queryContactPhoneNumber() {
		String[] cols = new String[] {People.NAME, People.NUMBER};
		Uri myContacts = People.CONTENT_URI;
		Cursor mqCur = managedQuery(myContacts,cols,null,null,null);
		if (mqCur.moveToFirst()) {
			String myname = null;
			String mynumber = null;
			do {
				myname = mqCur.getString(mqCur.getColumnIndex(People.NAME));
				mynumber = mqCur.getString(mqCur.getColumnIndex(People.NUMBER));
				Toast.makeText(this, myname + " " + mynumber, Toast.LENGTH_SHORT).show();
			} while (mqCur.moveToNext());
		}
	}
}