package mehwish.com.lab4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Toolbar toolbar;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.lv);
        final ArrayList<String> listItem = new ArrayList<String>();
        for (int i = 1; i < 51; i++) {
            listItem.add("Mobile Programming" + i);
        }
        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick( AdapterView<?> adapterView, View view, int position, long id ) {
                String value = listView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final AlertDialog.Builder alertBox = new AlertDialog.Builder(MainActivity.this);
                alertBox.setTitle("Delete");
                alertBox.setMessage("Sure you want to delete this item ?");
                final  int pos = position;
                alertBox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listItem.remove(pos);
                        adapter.notifyDataSetChanged();

                        Toast.makeText(MainActivity.this, "Item has been deleted", Toast.LENGTH_LONG).show();
                    }
                });
                alertBox.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alertBox.show();

                return true;
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_home) {

            Toast.makeText(this, "Home page selected", Toast.LENGTH_LONG).show();
            return true;

        }
        if (id == R.id.action_about) {

            Toast.makeText(this, "Welcome to About Us page", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.action_contact) {

            Toast.makeText(this, "mishayy.wordpress.com", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
