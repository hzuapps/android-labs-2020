package edu.hzuapps.androidlabs.myView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.hzuapps.androidlabs.R;
import edu.hzuapps.androidlabs.myContreller.MyTools;

public class readFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = (ViewGroup) inflater.inflate( R.layout.read_item_fragment, container, false);
        TextView textView = (TextView)view.findViewById(R.id.readTextView);
        int id = getArguments().getInt("id");
        MyTools.init();
        textView.setText(""+id+"\n"+MyTools.getText(id));
        return this.view;
    }
}
