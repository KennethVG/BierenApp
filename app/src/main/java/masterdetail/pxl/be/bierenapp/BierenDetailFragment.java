package masterdetail.pxl.be.bierenapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import masterdetail.pxl.be.bierenapp.data.TestData;
import masterdetail.pxl.be.bierenapp.model.Bier;

public class BierenDetailFragment extends Fragment {

    private TextView mTxtNaam;
    private TextView mTxtSterkte;
    private TextView mTxtSoort;
    private TextView mTxtInfo;

    private int pos;
    private List<Bier> bieren;

    public BierenDetailFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        if (b != null) {
            pos = b.getInt("position");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bieren_detail, container, false);

        mTxtNaam = (TextView) view.findViewById(R.id.txt_naam);
        mTxtInfo = (TextView) view.findViewById(R.id.txt_info);
        mTxtSoort = (TextView) view.findViewById(R.id.txt_soort);
        mTxtSterkte = (TextView) view.findViewById(R.id.txt_sterkte);

        setTextViews(pos);

        return view;
    }

    public void setText(int pos) {
        setTextViews(pos);
    }

    private void setTextViews(int pos) {
        bieren = new ArrayList<>(new TestData().getBieren());
        Bier mijnBier = bieren.get(pos);
        mTxtNaam.setText(mijnBier.getNaam());
        mTxtInfo.setText(mijnBier.getInfo());
        mTxtSterkte.setText(String.valueOf(mijnBier.getSterkte()));
        mTxtSoort.setText(mijnBier.getSoort().name());

    }

}
