package com.example.recyclerview;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rc;
    List<Contact> contactList;
    AdapterContact adapterContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rc= findViewById(R.id.recyclerviewdanhba);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);
        final Contact contact=new Contact("Nguyen Xuan Loc","0399155522");
        Contact contact1=new Contact("Lien Xinh Gai","0934633868");
        contactList=new ArrayList<>();
        contactList.add(contact);
        contactList.add(contact1);
        adapterContact =new AdapterContact(contactList);
        adapterContact.OnClickContact(new OnClickContact() {
            @Override
            public void ClickName(String name) {
                Toast.makeText(getBaseContext(),name,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void ClickObj(Contact o) {
                Intent intent=new Intent(getBaseContext(),Send_Item.class);
                intent.putExtra("object",o);
            }
        });
        rc.setLayoutManager(layoutManager);
        rc.setAdapter(adapterContact);
    }
}