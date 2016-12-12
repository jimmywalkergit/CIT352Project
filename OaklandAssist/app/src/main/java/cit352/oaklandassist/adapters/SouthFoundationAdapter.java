package cit352.oaklandassist.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import cit352.oaklandassist.R;

public class SouthFoundationAdapter extends ArrayAdapter {

    Context context;
    LayoutInflater inflater;
    private String[] SouthFoundationEventName;
    private String[] SouthFoundationEventDetails;
    private String[] SouthFoundationEventTitle;

    public SouthFoundationAdapter(Context context, String[] SouthFoundationEventTitle, String[] SouthFoundationEventName, String[] SouthFoundationEventDetails) {

        super(context, R.layout.events_cell_layout, SouthFoundationEventName);

        this.context = context;
        this.SouthFoundationEventTitle = SouthFoundationEventTitle;
        this.SouthFoundationEventName = SouthFoundationEventName;
        this.SouthFoundationEventDetails = SouthFoundationEventDetails;

        inflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.events_cell_layout, parent, false);
        }

        TextView textViewSouthFoundationTitle = (TextView) convertView.findViewById(R.id.textViewSouthFoundationTitle);
        TextView textViewSouthFoundationName = (TextView) convertView.findViewById(R.id.textViewSouthFoundationName);
        TextView textViewSouthFoundationDescription = (TextView) convertView.findViewById(R.id.textViewSouthFoundationDescription);

        return convertView;
    }

}
