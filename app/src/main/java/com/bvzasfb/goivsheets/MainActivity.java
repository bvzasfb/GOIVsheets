package com.bvzasfb.goivsheets;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the intent that started this activity
        Intent intent = getIntent();
        // Get the action of the intent
        String action = intent.getAction();
        // Get the type of intent (Text or Image)
        String type = intent.getType();
        // When Intent's action is 'ACTION+SEND' and Type is not null
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            // Added differentiation for future development
            if ("text/plain".equals(type)) {
                handleSendText(intent); // Handle text being sent
            } else if (type.startsWith("application/pokemon-stats")) { //
                handleSendText(intent); // Handle text being sent
            }
        }

    }

    /**
     * Method to hanlde incoming text data
     * @param intent
     */
    private void handleSendText(Intent intent) {
        // Get the text from intent
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        // When Text is not null
        if (sharedText != null) {
            // Show the text as Toast message
            Toast.makeText(this, sharedText, Toast.LENGTH_LONG).show();
            TextView t = (TextView)findViewById(R.id.testtext);
            t.setText(sharedText);
        }
    }

}
