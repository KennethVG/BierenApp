package masterdetail.pxl.be.bierenapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import masterdetail.pxl.be.bierenapp.adapter.BierenCursorAdapter;
import masterdetail.pxl.be.bierenapp.data.DatabaseHelper;

public class MainActivityFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mLstBieren;
    //    private BierenAdapter adapter;
    private BierenCursorAdapter cursorAdapter;
    private OnBeerSelected mListener;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mLstBieren = (ListView) view.findViewById(R.id.lst_bieren);
        //adapter = new BierenAdapter(getActivity());

        DatabaseHelper helper = new DatabaseHelper(getActivity());
        cursorAdapter = new BierenCursorAdapter(getActivity(), helper.getAllBeers());
        mLstBieren.setAdapter(cursorAdapter);
        mLstBieren.setOnItemClickListener(this);

        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (getActivity().getResources().getBoolean(R.bool.twoPaneMode)) {
            mListener.positionOfBeer(position);
        } else {
            Fragment bierenDetail = new BierenDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            bierenDetail.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.container, bierenDetail).addToBackStack(null).commit();
        }
    }

    public interface OnBeerSelected {
        void positionOfBeer(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // ACTIVITY MUST IMPLEMENT INTERFACE!
        if (context instanceof OnBeerSelected) {
            mListener = (OnBeerSelected) context;
        } else {
            throw new ClassCastException(getActivity().toString() + " must implement MainActivityFragment.OnBeerSelected");
        }
    }
}
