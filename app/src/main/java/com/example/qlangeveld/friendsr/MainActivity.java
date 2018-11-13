package com.example.qlangeveld.friendsr;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Friend> friends = new ArrayList<>();

        Integer aryaImage = getResources().getIdentifier("arya", "photo", "arya.png");
        Integer cerseiImage = getResources().getIdentifier("cercei", "photo", "cersei.png");
        Integer daenerysImage = getResources().getIdentifier("daenerys", "photo", "daenerys.png");
        Integer jaimeImage = getResources().getIdentifier("jaime", "photo", "jaime.png");
        Integer jonImage = getResources().getIdentifier("jon", "photo", "joh.png");
        Integer jorahImage = getResources().getIdentifier("joarh", "photo", "jorah.png");
        Integer margaeryImage = getResources().getIdentifier("margaery", "photo", "margaery.png");
        Integer sansaImage = getResources().getIdentifier("sansa", "photo", "sansa.png");
        Integer tyrionImage = getResources().getIdentifier("tyrion", "photo", "tyrion.png");

        Friend arya = new Friend("Arya", "A girl is Arya Stark of Winterfell, and I'm going home.", aryaImage);
        Friend cersei = new Friend("Cersei", "When you play the game of thrones, you win or you die. There is no middle ground.", cerseiImage);
        Friend daenerys = new Friend("Daenerys", "The world hadn't seen a dragon in centuries until my children were born.", daenerysImage);
        Friend jaime = new Friend("Jaime", "There are no men like me. Only me.", jaimeImage);
        Friend jon = new Friend("Jon", "And Jon's real name...", jonImage);
        Friend jorah = new Friend("Jorah", "I wouldn't be here if I hadn't. I return to your srvice, my queen, if you'll have me", jorahImage);
        Friend margaery = new Friend("Margaery", "I've had lots of time to think about how good I was at seeming good", margaeryImage);
        Friend sansa = new Friend("Sansa", "I did what I had to do to survive, my lady. But I am a Stark, I will always be a Stark.", sansaImage);
        Friend tyrion = new Friend("Tyrion", "I'm guilty of a far more monstrous crime: I'm guilty of being a dwarf!", tyrionImage);

        friends.add(arya);
        friends.add(cersei);
        friends.add(daenerys);
        friends.add(jaime);
        friends.add(jon);
        friends.add(jorah);
        friends.add(margaery);
        friends.add(sansa);
        friends.add(tyrion);

    }



    public void goToSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
