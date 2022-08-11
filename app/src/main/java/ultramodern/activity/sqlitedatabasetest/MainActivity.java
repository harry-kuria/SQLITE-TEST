package ultramodern.activity.sqlitedatabasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1,e2,e3;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DatabaseHelper(this);
        e1=findViewById(R.id.email);
        e2=findViewById(R.id.pass);
        e3=findViewById(R.id.cpass);
        b1=findViewById(R.id.registerButton);
        b2=findViewById(R.id.viewdata);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                
                if (s1.equals("") || (s2.equals("")) || (s3.equals(""))){
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (s2.equals(s3)){
                        Boolean checkemail = db.checkemail(s1);
                        if (checkemail==true){
                            Boolean insert = db.insert(s1,s2);
                            if (insert == true){
                                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Email already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
//                        Toast.makeText(MainActivity.this, "Your passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                    
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AllData.class);
                startActivity(intent);
            }
        });
    }
}