package cit352.oaklandassist.adapters;


import android.app.usage.UsageEvents;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import cit352.oaklandassist.R;

public class EventsAdapter extends ArrayAdapter {

    Context context;
    LayoutInflater inflater;
    private String[] BuildingEventName;
    private String[] EventTime;
    private String[] BuildingEventDetails;
    private String[] EventSpecificLocation;
    private String[] BuildingEventTitle;

    public EventsAdapter(Context context, String[] BuildingEventTitle, String[] EventTime, String[] BuildingEventName, String[] EventSpecificLocation, String[] BuildingEventDetails) {

        super(context, R.layout.events_cell_layout, BuildingEventName);

        this.context = context;
        this.BuildingEventTitle = BuildingEventTitle;
        this.BuildingEventName = BuildingEventName;
        this.EventTime = EventTime;
        this.EventSpecificLocation = EventSpecificLocation;
        this.BuildingEventDetails = BuildingEventDetails;

        inflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.events_cell_layout, parent, false);
        }

        TextView textViewBuildingTitle = (TextView) convertView.findViewById(R.id.textViewBuildingTitle);
        TextView textViewBuildingName = (TextView) convertView.findViewById(R.id.textViewBuildingName);
        TextView textViewEventTime = (TextView) convertView.findViewById(R.id.textViewEventTime);
        TextView textViewEventSpecificLocation = (TextView) convertView.findViewById(R.id.textViewEventSpecificLocation);
        TextView textViewBuildingDescription = (TextView) convertView.findViewById(R.id.textViewBuildingDescription);
        textViewBuildingTitle.setText(BuildingEventTitle[position]);
        textViewBuildingName.setText(BuildingEventName[position]);
        textViewEventTime.setText(EventTime[position]);
        textViewEventSpecificLocation.setText(EventSpecificLocation[position]);
        textViewBuildingDescription.setText(BuildingEventDetails[position]);

        return convertView;
    }

}
