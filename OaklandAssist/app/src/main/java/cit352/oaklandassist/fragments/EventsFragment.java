package cit352.oaklandassist.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import cit352.oaklandassist.R;
import cit352.oaklandassist.adapters.EventsAdapter;

public class EventsFragment extends Fragment {

    ListView listView;

    EditText buildingNameEditText, eventTimeEditText, eventSpecificLocationEditText, eventDetailsEditText;

    String[] buildingEventTitle = {
            "South Foundation Hall",
            "Engineering Center",
            "Math and Science Center"
    };

    String[] buildingEventName = {
            "Event Name 1",
            "Event Name 2",
            "Event Name 3"
    };

    String[] eventTime = {
            "Event Time/Date 1",
            "Event Time/Date 2",
            "Event Time/Date 3"
    };

    String[] eventSpecificLocation = {
            "Specific Location 1",
            "Specific Location 2",
            "Specific Location 3"
    };

    String[] buildingEventDescription = {
            "Event Description 1 wooo!",
            "Event Description 2 woooo!",
            "Event Description 3 wooooo!"
    };

    //FloatingActionButton floatingActionButtonCreateEvent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.events_layout, container, false);


        Button btnCreateEvent = (Button) rootView.findViewById(R.id.btnCreateEvent);
        listView = (ListView) rootView.findViewById(R.id.listViewBuilding);
        listView.setAdapter(new EventsAdapter(this.getActivity(), buildingEventTitle, buildingEventName, eventTime, eventSpecificLocation, buildingEventDescription));

        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
                                                               @Override
                                                               public void onClick(View view) {
                                                                   Dialog dialog = new Dialog(getActivity());
                                                                   dialog.setTitle("Create Event!");
                                                                   dialog.setContentView(R.layout.event_dialog_layout);


                                                                   final Spinner spinner = (Spinner) dialog.findViewById(R.id.buildingSpinner);
                                                                   // Create an ArrayAdapter using the string array and a default spinner layout
                                                                   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                                                                           R.array.buildings, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
                                                                   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
                                                                   spinner.setAdapter(adapter);
                                                                   buildingNameEditText = (EditText) dialog.findViewById(R.id.eventNameEditText);
                                                                   eventTimeEditText = (EditText) dialog.findViewById(R.id.eventTimeEditText);
                                                                   eventSpecificLocationEditText = (EditText) dialog.findViewById(R.id.eventSpecificLocationEditText);
                                                                   eventDetailsEditText = (EditText) dialog.findViewById(R.id.eventDetailsEditText);
                                                                   Button acceptBtn = (Button) dialog.findViewById(R.id.acceptBtn);

                                                                   acceptBtn.setOnClickListener(new View.OnClickListener() {
                                                                       @Override
                                                                       public void onClick(View v) {

                                                                           Toast.makeText(getActivity(), "Event Created!", Toast.LENGTH_SHORT).show();

                                                                       }
                                                                   });

                                                                   dialog.show();
                                                               }
                                                           });





                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                buildingView(position);
            }
        });

        return rootView;
    }


    private void buildingView(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new SouthFoundationFragment();
                break;
            case 1:
                fragment = new EngineeringCenterFragment();
                break;
            case 2:
                fragment = new MSCFragment();
                break;

            default:
                break;

        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_layout, fragment).addToBackStack(null).commit();
        }
        else {
            Toast.makeText(this.getActivity(), "Failed to Open Event!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();
    }

    @Override
    public void onStart()
    {
        super.onStart();
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();
    }

}
