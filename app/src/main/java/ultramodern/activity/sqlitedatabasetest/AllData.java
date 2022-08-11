package ultramodern.activity.sqlitedatabasetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class AllData extends AppCompatActivity {

    DatabaseHelper db;
    ArrayList<String> email,password;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_data);

        recyclerView = findViewById(R.id.recyclerview);


        db=new DatabaseHelper(this);

        email=new ArrayList<>();
        password=new ArrayList<>();

        storedatainarrays();

        customAdapter = new CustomAdapter(email,password,AllData.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);
    }
    void storedatainarrays(){
        Cursor cursor = db.readAllData();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                email.add(cursor.getString(0));
                password.add(cursor.getString(1));

            }
        }
    }
}