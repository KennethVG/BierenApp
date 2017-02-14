package masterdetail.pxl.be.bierenapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import masterdetail.pxl.be.bierenapp.R;
import masterdetail.pxl.be.bierenapp.model.Bier;

/**
 * Created by vangike on 13/02/2017.
 */

public class BierenCursorAdapter extends CursorAdapter {

    public BierenCursorAdapter(Context context, Cursor c) {
        super(context, c, FLAG_REGISTER_CONTENT_OBSERVER);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.one_beer, parent, false);
        // Holder instellen
        ViewHolder holder = new ViewHolder();
        holder.mTxtBierNaam = (TextView) view.findViewById(R.id.txt_bier_naam);
        holder.mTxtBierSterkte = (TextView) view.findViewById(R.id.txt_bier_sterkte);

        // Holder items opslaan in view
        view.setTag(holder);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ViewHolder holder = (ViewHolder) view.getTag();

        Bier bier = new Bier(cursor.getString(1), cursor.getString(2), cursor.getDouble(3), cursor.getString(4));
        holder.mTxtBierNaam.setText(bier.getNaam());
        holder.mTxtBierSterkte.setText(String.valueOf(bier.getSterkte()));

    }

    private class ViewHolder {
        TextView mTxtBierNaam;
        TextView mTxtBierSterkte;
    }
}

