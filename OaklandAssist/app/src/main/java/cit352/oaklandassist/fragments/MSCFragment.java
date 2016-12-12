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


public class MSCFragment extends Fragment {


    ListView listView;
    TextView mscTitle;
    TextView mscName;
    TextView mscDescription;
    Button btnMapMSC;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.msc_layout, container, false);


        listView = (ListView) rootView.findViewById(R.id.listViewBuilding);

/**        listView.setAdapter(new SouthFoundationAdapter(this.getActivity(), engineeringCenterTitle, engineeringCenterName, engineeringCenterDescription));

 @Override
 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

 buildingView(position);
 }
 });

 **/



        mscTitle = (TextView) rootView.findViewById(R.id.textViewMSCTitle);
        mscName = (TextView) rootView.findViewById(R.id.textViewMSCName);
        mscDescription = (TextView) rootView.findViewById(R.id.textViewMSCDescription);
        btnMapMSC = (Button) rootView.findViewById(R.id.btnMapMSC);

        btnMapMSC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fragment fragment = null;
                switch (view.getId()) {
                    case R.id.btnMapMSC:
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
