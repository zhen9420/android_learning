package com.example.myapplication6;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private Context myContext;
    private List<ContactInfo> myContactInfo;
    public MyAdapter(Context context,List<ContactInfo> contactInfoList){
        this.myContext = context;
        this.myContactInfo = contactInfoList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(myContext,R.layout.info,null);
        MyHolder myHolder  = new MyHolder(view);
        return  myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyHolder holder, int position) {
        ContactInfo contactInfo = myContactInfo.get(position);
        holder.name.setText(contactInfo.getName());
        holder.telephoneNumber.setText(contactInfo.getTelephoneNumber());
    }

    @Override
    public int getItemCount() {
        return myContactInfo.size();
    }
    class MyHolder extends RecyclerView.ViewHolder{

        TextView name,telephoneNumber;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            telephoneNumber=itemView.findViewById(R.id.telephoneNumber);
        }
    }


}
