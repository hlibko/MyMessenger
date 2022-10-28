package dev.hlib.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void onSendMessage(View view) {
        EditText editText = findViewById(R.id.message);
        String messageText = editText.getText().toString();
//        Intent intent = new Intent(this, ReceiveMessageActivity.class);
//        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, messageText);

        String chooserTitle = getString(R.string.send_message_via);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        //startActivity(chosenIntent);
    }
}