package com.example.recyclerview;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class Send_Item extends AppCompatActivity {
    TextView tvname,tvphone;
    Contact contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_item);

        tvname=findViewById(R.id.tvsendname);
        tvphone=findViewById(R.id.tvsendphone);

        Intent intent=getIntent();
        contact= (Contact) intent.getSerializableExtra("object");

        tvname.setText(contact.getPhone());
        tvphone.setText(contact.getName());

    }
}
