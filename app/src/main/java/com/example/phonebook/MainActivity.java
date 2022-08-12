package com.example.phonebook;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> nameList = new ArrayList<>();
    private ArrayList<String> numList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 전화번호부");

        ListView list = findViewById(R.id.listView);

        CustomAdapter adapter = new CustomAdapter(this);
        list.setAdapter(adapter);

        final EditText name = findViewById(R.id.name);
        final EditText num = findViewById(R.id.num);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nameList.add(name.getText().toString());
                numList.add(num.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                nameList.remove(position);
                numList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
    private class CustomAdapter extends BaseAdapter {
        Context context;

        public CustomAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return nameList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = View.inflate(context, R.layout.item, null);
            TextView nameItem = itemView.findViewById(R.id.nameItem);
            TextView numItem = itemView.findViewById(R.id.numItem);

            nameItem.setText(nameList.get(position));
            numItem.setText(numList.get(position));
            return itemView;
        }
    }
}