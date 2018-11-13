package com.example.qlangeveld.friendsr;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Friend> friends = new ArrayList<>();

        Friend arya = new Friend("Arya", "A girl is Arya Stark of Winterfell, and I'm going home.", R.drawable.arya);
        Friend cersei = new Friend("Cersei", "When you play the game of thrones, you win or you die. There is no middle ground.", R.drawable.cersei);
        Friend daenerys = new Friend("Daenerys", "The world hadn't seen a dragon in centuries until my children were born.", R.drawable.daenerys);
        Friend jaime = new Friend("Jaime", "There are no men like me. Only me.", R.drawable.jaime);
        Friend jon = new Friend("Jon", "And Jon's real name...", R.drawable.jon);
        Friend jorah = new Friend("Jorah", "I wouldn't be here if I hadn't. I return to your srvice, my queen, if you'll have me", R.drawable.jorah);
        Friend margaery = new Friend("Margaery", "I've had lots of time to think about how good I was at seeming good", R.drawable.margaery);
        Friend melisandre = new Friend("Melisandre", "The night is dark and full of terrors", R.drawable.melisandre);
        Friend sansa = new Friend("Sansa", "I did what I had to do to survive, my lady. But I am a Stark, I will always be a Stark.", R.drawable.sansa);
        Friend tyrion = new Friend("Tyrion", "I'm guilty of a far more monstrous crime: I'm guilty of being a dwarf!", R.drawable.tyrion);

        friends.add(arya);
        friends.add(cersei);
        friends.add(daenerys);
        friends.add(jaime);
        friends.add(jon);
        friends.add(jorah);
        friends.add(margaery);
        friends.add(melisandre);
        friends.add(sansa);
        friends.add(tyrion);

        FriendsAdapter friendsAdapter = new FriendsAdapter(this, R.layout.grid_item, friends);

        GridView gridView = findViewById(R.id.GridView);
        gridView.setAdapter(friendsAdapter);

        gridView.setOnItemClickListener(new GridItemClickListener());
    }


    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }


}
