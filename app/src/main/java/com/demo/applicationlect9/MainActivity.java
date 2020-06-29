package com.demo.applicationlect9;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listView);

        final List<Character> alphabet = getAlphabet();

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice,
                alphabet);

        listView.setAdapter(adapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Letter: " + alphabet.get(position), Toast.LENGTH_SHORT).show();
            }
        });
//кнопка при натисканні на яку спливає тост, яка буква була вибрана в ліствю
        findViewById(R.id.btnDetail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedPosition = listView.getCheckedItemPosition();
                openDetailData(alphabet.get(checkedPosition));
            }
        });
    }

    public void openDetailData(char letter) {
        Toast.makeText(this, "Letter : " + letter, Toast.LENGTH_SHORT).show();
    }

    private List<Character> getAlphabet() {
        List<Character> list = new ArrayList<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            list.add(i);
        }
        return list;
    }
}