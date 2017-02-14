package masterdetail.pxl.be.bierenapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import masterdetail.pxl.be.bierenapp.model.Bier;

/**
 * Created by vangike on 13/02/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "beer.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "beer";
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "naam";
    private static final String KEY_SOORT = "soort";
    private static final String KEY_STERKTE = "sterkte";
    private static final String KEY_INFO = "info";

    private SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void copyDB(InputStream inputStream, OutputStream outputStream) throws IOException {
        int length;

        while ((length = inputStream.read()) != -1) {
            outputStream.write(length);
        }
        inputStream.close();
        outputStream.close();
    }

    public Cursor getAllBeers() {

       // Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
       // return c;
        return db.query(TABLE_NAME, null, null, null, null, null, null);

    }

    public Cursor getBeer(long rowID) {
        Cursor c = db.query(true, TABLE_NAME, null, KEY_ID + "= " + rowID, null, null, null, null, null);

        if (c != null) {
            c.moveToFirst();
        }
        return c;


    }

    public long insertBeer(Bier bier) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, bier.getNaam());
        values.put(KEY_STERKTE, bier.getSterkte());
        values.put(KEY_INFO, bier.getInfo());
        values.put(KEY_SOORT, bier.getSoort().name());

        // Android does not allow emmpty CONTENTVALUES --> If values is empty they need to insert null in a columns thats allowed it.
        return db.insert(TABLE_NAME, KEY_INFO, values);
    }
}
