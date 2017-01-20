package masterdetail.pxl.be.bierenapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import masterdetail.pxl.be.bierenapp.data.TestData;

/**
 * Created by vangike on 20/01/2017.
 */

public class BierenAdapter extends BaseAdapter {

    private TestData data;

    public BierenAdapter() {
        data = new TestData();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
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
