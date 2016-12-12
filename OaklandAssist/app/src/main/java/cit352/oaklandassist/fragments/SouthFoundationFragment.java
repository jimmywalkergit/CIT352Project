package cit352.oaklandassist.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import cit352.oaklandassist.R;
import cit352.oaklandassist.adapters.SouthFoundationAdapter;


public class SouthFoundationFragment extends Fragment {




    ListView listView;
    TextView southFoundationTitle;
    TextView southFoundationName;
    TextView southFoundationDescription;
    Button btnMapSouthFoundation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.southfoundation_layout, container, false);


        listView = (ListView) rootView.findViewById(R.id.listViewBuilding);

/**        listView.setAdapter(new SouthFoundationAdapter(this.getActivity(), southFoundationTitle, southFoundationName, southFoundationDescription));

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            buildingView(position);
        }
    });

        **/



        southFoundationTitle = (TextView) rootView.findViewById(R.id.textViewSouthFoundationTitle);
        southFoundationName = (TextView) rootView.findViewById(R.id.textViewSouthFoundationName);
        southFoundationDescription = (TextView) rootView.findViewById(R.id.textViewSouthFoundationDescription);
        btnMapSouthFoundation = (Button) rootView.findViewById(R.id.btnMapSouthFoundation);

        btnMapSouthFoundation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fragment fragment = null;
                switch (view.getId()) {
                    case R.id.btnMapSouthFoundation:
                        fragment = new OaklandMapFragment();

                        break;

                    default:
                        break;
                }

                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_layout, fragment).addToBackStack(null).commit();


                    //OaklandMapFragment.class.getResource("southFoundation");


                   // startActivityForResult(new Intent(OaklandMapFragment.this, SouthFoundationFragment));
                   // Intent intent = new Intent(getContext(), OaklandMapFragment.class);


                    OaklandMapFragment southFoundation = new OaklandMapFragment();
                    OaklandMapFragment map = new OaklandMapFragment();





                }
                else {
                    Toast.makeText(getActivity(), "Failed to Open Event!", Toast.LENGTH_SHORT).show();
                }
            }



        });




        return rootView;
    }



    public void markerIntentButtonShow(Marker southFoundation) {
        Intent intent = new Intent(getActivity(), OaklandMapFragment.class);
        intent.putExtra("marker_snippet", southFoundation.getPosition());
        startActivity(intent);
    }


}
