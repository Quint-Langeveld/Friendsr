package com.example.qlangeveld.friendsr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;

    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        Friend current_friend = friends.get(position);

        ((ImageView) convertView.findViewById(R.id.photo)).setImageResource(current_friend.getDrawableId());
        ((TextView) convertView.findViewById(R.id.name)).setText(current_friend.getName());
        return convertView;
    }
}
