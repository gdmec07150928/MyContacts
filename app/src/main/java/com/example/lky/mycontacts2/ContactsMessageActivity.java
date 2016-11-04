package com.example.lky.mycontacts2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ContactsMessageActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText mobileEdiText;
    private EditText qqEdiText;
    private EditText danweiEditText;
    private EditText addressEditText;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_message);
        setTitle("联系人信息");
        nameEditText= (EditText) findViewById(R.id.name);
        mobileEdiText = (EditText) findViewById(R.id.mobile);
        qqEdiText= (EditText) findViewById(R.id.qq);
        danweiEditText = (EditText) findViewById(R.id.danwei);
        addressEditText= (EditText) findViewById(R.id.address);
        Bundle localBundle=getIntent().getExtras();
        int id=localBundle.getInt("user_ID");
        ContactsTable ct=new ContactsTable(this);
        user=ct.getUserByID(id);
        nameEditText.setText("姓名："+user.getName());
        mobileEdiText.setText("电话："+user.getMobile());
        qqEdiText.setText("qq:"+user.getQq());
        danweiEditText.setText("单位："+user.getDanwei());
        addressEditText.setText("地址："+user.getAddress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}
