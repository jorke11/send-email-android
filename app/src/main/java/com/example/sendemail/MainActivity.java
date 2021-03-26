package com.example.sendemail;

import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText mEmail;
    public EditText mSubject;

    public EditText mMessage;
    public Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.mailID);
        mMessage = findViewById(R.id.messageID);
        mSubject = findViewById(R.id.subjectID);

        btn_send = findViewById(R.id.btn_send);

        Log.d("JORGE", String.valueOf(getFilesDir()+"/CIRCULAR.pdf"));

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });

    }


    private void sendMail() {

        String mail = mEmail.getText().toString().trim();
        String message = mMessage.getText().toString();
        String subject = mSubject.getText().toString().trim();

        //Send Mail
        JavaMailAPI javaMailAPI = new JavaMailAPI(this,mail,subject,message);

        javaMailAPI.execute();

    }

}
