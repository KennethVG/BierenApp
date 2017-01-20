package masterdetail.pxl.be.bierenapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import masterdetail.pxl.be.bierenapp.data.TestData;
import masterdetail.pxl.be.bierenapp.model.Bier;

/**
 * Created by vangike on 20/01/2017.
 */

public class BierenAdapter extends BaseAdapter {

    private List<Bier> bierenlijst;

    public BierenAdapter() {
        // Testdata in lijst plaatsen
        TestData data = new TestData();
        bierenlijst = new ArrayList<>(data.getBieren());
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
