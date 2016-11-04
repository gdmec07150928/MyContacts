package com.example.lky.mycontacts2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "添加");
        menu.add(0, 2, 0, "编辑");
        menu.add(0, 3, 0, "查看信息");
        menu.add(0, 4, 0, "删除");
        menu.add(0, 5, 0, "查询");
        menu.add(0, 6, 0, "导入到手机通讯录");
        menu.add(0, 7, 0, "退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()) {
            case 1:
                intent.setClass(this, AddcontactsActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent.setClass(this, UpdateContactsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("user_ID", Integer.parseInt(et1.getText().toString()));
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case 3:
                intent.setClass(this, ContactsMessageActivity.class);
                intent.putExtra("user_ID", Integer.parseInt(et1.getText().toString()));
                startActivity(intent);
                break;
            case 4:
                break;
            case 5:
                new FindDialog(this).show();
                break;
            case 6:
                break;
            case 7:
                finish();
                break;
            default:
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    public class FindDialog extends Dialog {

        public FindDialog(Context context) {

            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.find);
            setTitle("联系人查询");
            Button find = (Button) findViewById(R.id.find);
            Button cancel = (Button) findViewById(R.id.cancel);
            find.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    EditText value = (EditText) findViewById(R.id.value);
                    ContactsTable ct = new ContactsTable(v.getContext());
                    User[] users = ct.findUserByKey(value.getText().toString());
                    for (int i = 0; i < users.length; i++) {
                        System.out.println("姓名是：" + users[i].getName() + ",电话是：" + users[i].getMobile());
                    }
                    dismiss();
                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
    }
}