package masterdetail.pxl.be.bierenapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import masterdetail.pxl.be.bierenapp.R;
import masterdetail.pxl.be.bierenapp.data.DatabaseHelper;
import masterdetail.pxl.be.bierenapp.model.Bier;

public class BierenAdapter extends BaseAdapter {

    private List<Bier> mBierenlijst;
    private Context mContext;


    public BierenAdapter(Context context) {
        this.mContext = context;
        mBierenlijst = new ArrayList<>();
        DatabaseHelper helper = new DatabaseHelper(context);

        Cursor c = helper.getAllBeers();
        while (c.moveToNext()){
            Bier myBeer= new Bier(c.getString(1), c.getString(2), c.getDouble(3), c.getString(4));
            mBierenlijst.add(myBeer);
        }

    }

    @Override
    public int getCount() {
        return mBierenlijst.size();
    }

    @Override
    public Object getItem(int position) {
        return mBierenlijst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.one_beer, parent, false);

            // Holder instellen
            holder = new ViewHolder();
            holder.mTxtBierNaam = (TextView) convertView.findViewById(R.id.txt_bier_naam);
            holder.mTxtBierSterkte = (TextView) convertView.findViewById(R.id.txt_bier_sterkte);

            // Holder items opslaan in view
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Bier bier = mBierenlijst.get(position);
        if (bier != null) {
            holder.mTxtBierNaam.setText(bier.getNaam());
            holder.mTxtBierSterkte.setText(String.valueOf(bier.getSterkte()));
        }
        return convertView;
    }

    private class ViewHolder {
        TextView mTxtBierNaam;
        TextView mTxtBierSterkte;
    }
}

