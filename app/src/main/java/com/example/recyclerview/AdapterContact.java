package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ViewHoder> {
    List<Contact> contactList;
    OnClickContact onClickContact;

    public void OnClickContact(OnClickContact onClickContact)
    {
        this.onClickContact=onClickContact;
    }
    public AdapterContact(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public AdapterContact.ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.item_recyclerview,parent,false);
        ViewHoder viewHoder=new ViewHoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContact.ViewHoder holder, int position) {
        final Contact contact=contactList.get(position);
        holder.tvname.setText("Name :"+contact.getName());
        holder.tvnumner.setText("Phone :"+(contact.getPhone()));
        holder.tvnumner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickContact.ClickName(contact.getName());
            }
        });
        holder.tvname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickContact.ClickObj(contact);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {

        public TextView tvname,tvnumner;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.tvname);
            tvnumner=itemView.findViewById(R.id.tvnumber);
        }
    }
}
