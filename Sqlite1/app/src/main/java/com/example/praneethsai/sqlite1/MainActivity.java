package com.example.praneethsai.sqlite1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends Activity {
    DatabaseHandler MyDatabase;
    EditText et1,et2,et3,et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDatabase = new DatabaseHandler(this);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
    }
  //  @Override
   /* public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
    public void function1(View v)
    {
        int rollno = Integer.parseInt(et1.getText().toString());
        String name = et2.getText().toString();
        String branch = et3.getText().toString();
        int marks = Integer.parseInt(et4.getText().toString());
        boolean b = MyDatabase.insertData(rollno, name, branch, marks);
        if(b)
        {
            Toast.makeText(getApplicationContext(), "Inserted",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Not Inserted",Toast.LENGTH_LONG).show();
        }
    }
    public void function2(View v)
    {
        StringBuffer buffer = new StringBuffer();
        Cursor res = MyDatabase.getAllData();
        if(res.getCount()==0)
        {
            showMessage("Oops!", "No Data Found");
        }
        else
        {
            while(res.moveToNext())
            {
                buffer.append("Rol No:"+res.getString(0)+"\n");
                buffer.append("Rol No:"+res.getString(1)+"\n");
                buffer.append("Rol No:"+res.getString(2)+"\n");
                buffer.append("Rol No:"+res.getString(3)+"\n\n");
            }
            showMessage("The Deatils:", buffer.toString());
        }
    }
    private void showMessage(String string, String string2) {
// TODO Auto-generated method stub
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setTitle(string);
        ab.setCancelable(false);
        ab.setMessage(string2);
        ab.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
// TODO Auto-generated method stub
            }
        });
        ab.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
// TODO Auto-generated method stub
            }
        });
        ab.show();
    }
    public void function3(View v)
    {
        int rollno = Integer.parseInt(et1.getText().toString());
        String name = et2.getText().toString();
        String branch = et3.getText().toString();
        int marks = Integer.parseInt(et4.getText().toString());
        boolean update = MyDatabase.updateData(rollno, name, branch, marks);
        if(update)
        {
            Toast.makeText(getApplicationContext(),
                    "Updated",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Not Updated",Toast.LENGTH_LONG).show();
        }
    }
    public void function4(View v)
    {
        int rollno = Integer.parseInt(et1.getText().toString());
        int deletedRows = MyDatabase.deleteData(rollno);
        if(deletedRows>0)
        {
            Toast.makeText(getApplicationContext(),
                    "Deleted",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Not Deleted",Toast.LENGTH_LONG).show();
        }
    }
}
