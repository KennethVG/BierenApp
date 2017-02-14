package masterdetail.pxl.be.bierenapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import masterdetail.pxl.be.bierenapp.data.DatabaseHelper;

public class MainActivity extends AppCompatActivity implements MainActivityFragment.OnBeerSelected {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (!getResources().getBoolean(R.bool.twoPaneMode)) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new MainActivityFragment()).commit();
        }

        // COPY DB FROM ASSETS FOLDER into internal memory of smartphone:
        File file = getDatabasePath("beer.db");

        if (!file.exists()) {
            DatabaseHelper helper = new DatabaseHelper(this);
            try {
                helper.copyDB(this.getAssets().open("beer.db"), new FileOutputStream(getDatabasePath("beer.db")));
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        /******* SOME SIMPLE EXAMPLES OF OTHER WAYS OF DATA STORAGE **********/

        // SIMPLE USE OF SHAREDPREFERENCES. --> xml is saved internal memory of smartphone (like databases)
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor edi = prefs.edit();
        edi.putString("MyString", "Hallo Wereld!");
        edi.apply();

        // SIMPLE USE OF PREFERENCES --> Check SettingsActivity, SettingsFragment and RES/XML/myprefs.xml
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Toast.makeText(this, "Value of Checkbox: " + preferences.getBoolean("check_box_pref", true), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Value of EditText: " + preferences.getString("edit_text_pref", "Android"), Toast.LENGTH_SHORT).show();

        // Store TXT file into internal memory of smartphone.
        try {
            FileOutputStream outputstream = openFileOutput("myFile.txt", MODE_APPEND);
            OutputStreamWriter writer = new OutputStreamWriter(outputstream);
            writer.write(prefs.getString("MyString", "Default"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void positionOfBeer(int position) {
        BierenDetailFragment detailFragment = (BierenDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        if (detailFragment != null && detailFragment.isInLayout()) {
            detailFragment.setText(position);
        }
    }
}
