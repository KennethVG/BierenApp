package masterdetail.pxl.be.bierenapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BierenDetailFragment extends Fragment {

    private TextView mTxtNaam;
    private TextView mTxtSterkte;
    private TextView mTxtSoort;
    private TextView mTxtInfo;

    public BierenDetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bieren_detail, container, false);

        mTxtNaam = (TextView) view.findViewById(R.id.txt_naam);
        mTxtInfo = (TextView) view.findViewById(R.id.txt_info);
        mTxtSoort = (TextView) view.findViewById(R.id.txt_soort);
        mTxtSterkte = (TextView) view.findViewById(R.id.txt_sterkte);

        return view;
    }

}
