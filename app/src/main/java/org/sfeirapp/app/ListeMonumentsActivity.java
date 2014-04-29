package org.sfeirapp.app;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import org.sfeirapp.model.BouchonMonuments;
import org.sfeirapp.model.Monument;
import org.sfeirapp.model.MonumentsVille;
import org.sfeirapp.persistence.MonumentContract;
import org.sfeirapp.persistence.MonumentDbHelper;


public class ListeMonumentsActivity extends ListActivity {

    private static final String TAG = ListeMonumentsActivity.class.getSimpleName();
    private MonumentsVille monumentsVille;
    private MonumentDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_monuments);
        monumentsVille = new MonumentsVille();

        dbHelper = new MonumentDbHelper(this);
        new RecupererMonumentEnLocal().execute();

        setListAdapter(new ListeMonumentsAdapter(this, monumentsVille));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.liste_monuments, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.addMonument:
                Intent intent = new Intent();
                intent.setClass(this,AjouterMonumentActivity.class);
                startActivity(intent);
                break;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent =  new Intent();
        intent.setClass(this, DetailsMonumentActivity.class);
        startActivity(intent);

    }

    private class RecupererMonumentEnLocal extends AsyncTask<Void,Monument,Void>{
        String[] projection = {
                MonumentContract.MonumentEnty.COLUMN_NAME_TITRE,
                MonumentContract.MonumentEnty.COLUMN_NAME_LIEU,
                MonumentContract.MonumentEnty.COLUMN_NAME_DESC
        };
        String sortOrder = MonumentContract.MonumentEnty.COLUMN_NAME_LIEU + " DESC";

        @Override
        protected Void doInBackground(Void... voids) {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.query(MonumentContract.MonumentEnty.TABLE_NAME,
                    projection,null,null,null,null,sortOrder);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String titre = cursor.getString(cursor.getColumnIndex(MonumentContract.MonumentEnty.COLUMN_NAME_TITRE));
                String lieu = cursor.getString(cursor.getColumnIndex(MonumentContract.MonumentEnty.COLUMN_NAME_LIEU));
                String desc = cursor.getString(cursor.getColumnIndex(MonumentContract.MonumentEnty.COLUMN_NAME_DESC));

                Monument monument = new Monument();
                monument.setNomMonument(titre);
                monument.setLieuMonument(lieu);
                monument.setDescription(desc);

                publishProgress(monument);
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
            return null;

        }

        @Override
        protected void onProgressUpdate(Monument... progress) {
            monumentsVille.add(progress[0]);
            Log.d(TAG, "ajout à la liste du monument " + progress[0].getNomMonument());
        }
    }
}
