package cit352.oaklandassist.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import cit352.oaklandassist.R;

public class EngineeringCenterFragment extends Fragment {

    ListView listView;
    TextView engineeringCenterTitle;
    TextView engineeringCenterName;
    TextView engineeringCenterDescription;
    Button btnMapEngineeringCenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.engineeringcenter_layout, container, false);


        listView = (ListView) rootView.findViewById(R.id.listViewBuilding);

/**        listView.setAdapter(new SouthFoundationAdapter(this.getActivity(), engineeringCenterTitle, engineeringCenterName, engineeringCenterDescription));

 @Override
 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

 buildingView(position);
 }
 });

 **/



        engineeringCenterTitle = (TextView) rootView.findViewById(R.id.textViewEngineeringCenterTitle);
        engineeringCenterName = (TextView) rootView.findViewById(R.id.textViewEngineeringCenterName);
        engineeringCenterDescription = (TextView) rootView.findViewById(R.id.textViewEngineeringCenterDescription);
        btnMapEngineeringCenter = (Button) rootView.findViewById(R.id.btnMapEngineeringCenter);

        btnMapEngineeringCenter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fragment fragment = null;
                switch (view.getId()) {
                    case R.id.btnMapEngineeringCenter:
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
}
