package ultramodern.activity.sqlitedatabasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Login.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE user(email text primary key,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
    }
    //inserting data into database
    public boolean insert(String email, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = sqLiteDatabase.insert("user",null,contentValues);
        if (ins==-1)
            return false;
        else
            return true;
    }
    //checking if email exists
    public boolean checkemail(String email){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from user where email=?",new String[] {email});
        if (cursor.getCount()>0) return false;
        else return true;
    }

    Cursor readAllData(){
        String query = "SELECT * FROM user";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = null;
        if (sqLiteDatabase !=null){
            cursor=sqLiteDatabase.rawQuery(query,null);
        }
        return cursor;
    }
}
