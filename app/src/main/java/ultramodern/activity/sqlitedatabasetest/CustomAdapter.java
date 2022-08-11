package ultramodern.activity.sqlitedatabasetest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.content.Context;
import android.widget.TextView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList email,password;
    private Context context;

    public CustomAdapter(ArrayList email,ArrayList password, Context context) {
        this.email = email;
        this.context = context;
        this.password= password;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerrow,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.email.setText(String.valueOf(email.get(position)));
        holder.password.setText(String.valueOf(password.get(position)));
    }

    @Override
    public int getItemCount() {
        return email.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView email,password;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            email=itemView.findViewById(R.id.email);
            password=itemView.findViewById(R.id.pass);
        }
    }
}
