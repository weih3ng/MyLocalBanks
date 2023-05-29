package sg.edu.rp.c346.id22005564.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button ButtonUOB;
    Button ButtonDBS;
    Button ButtonOCBC;

TextView textView4;
    TextView textView5;
    TextView textView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonUOB = findViewById(R.id.buttonUOB);
        ButtonDBS = findViewById(R.id.buttonDBS);
        ButtonOCBC = findViewById(R.id.buttonOCBC);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);


        registerForContextMenu(ButtonDBS);
        registerForContextMenu(ButtonOCBC);
        registerForContextMenu(ButtonUOB);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            textView4.setText("DBS:");
            textView5.setText("OCBC:");
            textView6.setText("UOB:");
            return true;
        } else if (id == R.id.chineseSelection) {
            textView4.setText("星展银行:");
            textView5.setText("华侨银行:");
            textView6.setText("大华银行:");
            return true;
        } else {
            ButtonDBS.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == ButtonDBS) {
            menu.add(0, 0, 0, "Open DBS Website");
            menu.add(0, 1, 1, "Contact DBS");
            menu.add(0, 6, 6, "Toggle Favourite");

        } else if (v == ButtonOCBC) {
            menu.add(0, 2, 2, "Open OCBC Website");
            menu.add(0, 3, 3, "Contact OCBC");
            menu.add(0, 6, 6, "Toggle Favourite");
        } else if (v == ButtonUOB) {
            menu.add(0, 4, 4, "Open UOB Website");
            menu.add(0, 5, 5, "Contact UOB");
            menu.add(0, 6, 6, "Toggle Favourite");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                openWebsite("https://www.dbs.com.sg");
                return true;
            case 1:
                contactBank("DBS", "18001111111");
                return true;
            case 2:
                openWebsite("https://www.ocbc.com");
                return true;
            case 3:
                contactBank("OCBC", "18003633333");
                return true;
            case 4:
                openWebsite("https://www.uob.com.sg");
                return true;
            case 5:
                contactBank("UOB", "18002222121");
                return true;
            case 6:
                toggleFavourite("DBS", "18001111111");
                return true;
            case 7:
                toggleFavourite("OCBC", "18003633333");
                return true;
            case 8:
                toggleFavourite("UOB", "18002222121");
                return true;


            default:
                return super.onContextItemSelected(item);
        }
    }

    private void openWebsite(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void contactBank(String bankName, String contactNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + contactNumber));
        startActivity(intent);
    }
    private void toggleFavourite(String bankName, String contactNumber) {
        int black = 0xFF000000; // Black color

        if (bankName.equals("DBS")) {
            if (textView4.getCurrentTextColor() == black) {

                textView4.setTextColor(0xFFFF0000);
                textView5.setTextColor(black);
                textView6.setTextColor(black);
            } else {
                textView4.setTextColor(black); // Red color
                textView5.setTextColor(black);
                textView6.setTextColor(black);
            }
        } else if (bankName.equals("OCBC")) {
            if (textView5.getCurrentTextColor() == black) {

                textView4.setTextColor(black);
                textView5.setTextColor(0xFFFF0000);
                textView6.setTextColor(black);
            } else {
                textView4.setTextColor(black);
                textView5.setTextColor(black); // Red color
                textView6.setTextColor(black);
            }
        } else if (bankName.equals("UOB")) {
            if (textView6.getCurrentTextColor() == black) {

                textView4.setTextColor(black);
                textView5.setTextColor(black);
                textView6.setTextColor(0xFFFF0000);
            } else {
                textView4.setTextColor(black);
                textView5.setTextColor(black);
                textView6.setTextColor(black); // Red color
            }
        }
    }





}

