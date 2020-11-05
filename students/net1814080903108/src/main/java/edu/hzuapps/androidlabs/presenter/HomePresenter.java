package edu.hzuapps.androidlabs.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;
import edu.hzuapps.androidlabs.model.ScenesModel;
import edu.hzuapps.androidlabs.view.HomeFragment;


public class HomePresenter extends BaseAdapter {
    private ScenesModel scenesModel = null;
    private HomeFragment fragment = null;
    String[] scenes = new String[0];


    public HomePresenter(HomeFragment homeFragment){
        fragment = homeFragment;
        scenesModel = ScenesModel.getInstance();
        scenes = scenesModel.getSceneNameArray();
    };

    @Override
    public int getCount() {
        return scenesModel.getCount();
    }

    @Override
    public Object getItem(int position) {
        return scenesModel;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) LayoutInflater.from(fragment.getActivity());
        convertView = layoutInflater.inflate(R.layout.item_scene, null,true);
        ImageView imageView = convertView.findViewById(R.id.homeCardImageView);
        TextView textView = convertView.findViewById(R.id.homeCardTitle);
        imageView.setImageBitmap(scenesModel.getImage(scenes[position]));
        textView.setText(scenes[position]);
        return convertView;
    }
}