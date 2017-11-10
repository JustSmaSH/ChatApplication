package com.example.user.chatapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static int SIGN_IN_REQUEST_CODE = 1;
    RelativeLayout activity_main;
    FloatingActionButton fab;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_sign_out){
            Snackbar.make(activity_main,"You have successfully signed out.", Snackbar.LENGTH_SHORT).show();
            finish();
    }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    //Code Request
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        resultCode = RESULT_OK;
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity_main = (RelativeLayout)findViewById(R.id.rlayout);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = (EditText)findViewById(R.id.input);
                //Database required
                input.setText("");
            }
        });

        displayChatMessage();
    }

    private void displayChatMessage() {

        ListView listOfMessage = (ListView)findViewById(R.id.list_of_message);
        ArrayList<ChatMessage> messageArray = new ArrayList<>();

        ChatMessage chat = new ChatMessage("Hello!", "Andrew");
        ChatMessage chat1 = new ChatMessage("Hi!", "You");
        ChatMessage chat2 = new ChatMessage("Hello James, today I went to the mountains and found a dead chicken, then I decided to cook it and eat it.", "Andrew");

        messageArray.add(chat);
        messageArray.add(chat1);
        messageArray.add(chat2);

        MessageAdapter messageAdapter = new MessageAdapter(this, messageArray);

        listOfMessage.setAdapter(messageAdapter);

    }
}
