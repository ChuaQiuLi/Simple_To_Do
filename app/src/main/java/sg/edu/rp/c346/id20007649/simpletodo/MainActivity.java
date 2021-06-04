package sg.edu.rp.c346.id20007649.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTask;
    Button btnAdd;
    Button btnClear;
    Button btnDelete;
    ListView lvTask;
    Spinner spinnerItems;

    ArrayList<String> listedTask = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = findViewById(R.id.etTask);
        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);
        btnDelete = findViewById(R.id.btnDelete);
        lvTask = findViewById(R.id.listViewTask);
        spinnerItems = findViewById(R.id.spinner);





        ArrayAdapter task = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listedTask);

        lvTask.setAdapter(task);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String tasks = "";

                if (etTask != null ) {
                    tasks = etTask.getText().toString();
                    listedTask.add(tasks);
                    task.notifyDataSetChanged();
                    etTask.setText(null);


                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listedTask.clear();
                task.notifyDataSetChanged();



            }
        });

        spinnerItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0 :
                        etTask.setHint("Type in a new task here");
                        btnDelete.setEnabled(false);

                        break;


                    case 1 :
                        etTask.setHint("Type in the index of the task to be removed");
                        btnAdd.setEnabled(false);

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int position = Integer.parseInt(etTask.getText().toString());

                if (position != listedTask.size()) {
                    Toast.makeText(MainActivity.this,"Wrong index number", Toast.LENGTH_LONG).show();

                }

                else if (position == listedTask.size()) {
                    listedTask.remove(position);
                }

                else{
                    Toast.makeText(MainActivity.this,"You don't have any task to remove", Toast.LENGTH_LONG).show();

                }

            }
        });








    }
}