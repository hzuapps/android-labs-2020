package edu.hzuapps.androidlabs.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;
import edu.hzuapps.androidlabs.model.SchedulesModel;
import edu.hzuapps.androidlabs.view.SchedulesFragment;

public class SchedulesAdapter  extends BaseAdapter {
    private SchedulesFragment fragment = null;
    private SchedulesModel schedulesModel = null;

    public SchedulesAdapter(SchedulesFragment schedulesFragment){

        this.fragment = schedulesFragment;
        this.schedulesModel = SchedulesModel.getInstance();
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int position) {
        return SchedulesModel.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) LayoutInflater.from(fragment.getActivity());
        convertView = layoutInflater.inflate(R.layout.iteam_schedules, null,true);
        TextView textView = (TextView)convertView.findViewById(R.id.task_Text);
        Button button = (Button)convertView.findViewById(R.id.delete_Button);
        return convertView;
    }
}
