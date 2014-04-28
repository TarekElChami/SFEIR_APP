package org.sfeirapp.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.sfeirapp.model.Monument;
import org.sfeirapp.persistence.MonumentContract;
import org.sfeirapp.persistence.MonumentDbHelper;


public class AjouterMonumentActivity extends ActionBarActivity {

    private static final String TAG = AjouterMonumentActivity.class.getSimpleName();
    private EditText titreMonument;
    private EditText lieuMonument;
    private EditText descMonument;
    private MonumentDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_monument);

        titreMonument = (EditText) findViewById(R.id.titreMonumentEdit);
        lieuMonument =  (EditText) findViewById(R.id.lieuMonumentEdit);
        descMonument = (EditText) findViewById(R.id.descMonumentEdit);

        dbHelper = new MonumentDbHelper(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ajouter_monument, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void enregistrerMonumentClick(View view){
        Log.d(TAG, "enregistrerMonumentClick");
        String[] params = new String[3];
        params[0] = titreMonument.getText().toString();
        params[1] = lieuMonument.getText().toString();
        params[2] = descMonument.getText().toString();

        new SauvegarderMonumentEnLocal().execute(params);
    }

    private class SauvegarderMonumentEnLocal extends AsyncTask<String,Void,String>{

        Context context = getBaseContext();


        @Override
        protected String doInBackground(String... params) {
            String titre = params[0];
            String lieu = params[1];
            String desc = params[2];

            SQLiteDatabase db =  dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(MonumentContract.MonumentEnty.COLUMN_NAME_MONUMENT_ID, titre + lieu);
            values.put(MonumentContract.MonumentEnty.COLUMN_NAME_TITRE, titre);
            values.put(MonumentContract.MonumentEnty.COLUMN_NAME_LIEU,lieu);
            values.put(MonumentContract.MonumentEnty.COLUMN_NAME_DESC,desc);

            long newRow;
            newRow = db.insert(MonumentContract.MonumentEnty.TABLE_NAME, null, values);
            db.close();
            return String.valueOf(" Insertion de la ligne " + newRow);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Toast.makeText(context,result,Toast.LENGTH_LONG).show();
        }
    }
}
