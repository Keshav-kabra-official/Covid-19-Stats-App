package com.example.covid_19stats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView t_about, t_about_dev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        t_about = findViewById(R.id.text_about);
        t_about_dev = findViewById(R.id.text_about_dev);

        String ss = "<b>" + "&emsp;&emsp;&emsp;&ensp;-- Covid-19 Stats -- " + "</b>";
        t_about.setText(Html.fromHtml(ss));
        t_about.append("\n\n    Application to provide the statistical data of Covid-19 in India." +
                "The 'Main Stats' button will fetch the data from internet official website.\n" +
                "    You can open the official website in app or in your browser through given buttons.\n");

        t_about_dev.append("\nDeveloped By : \n");
        String name = "<b>&emsp;&emsp;Keshav Kabra </b>";
        t_about_dev.append(Html.fromHtml(name));
        t_about_dev.append("\n        keshavkabra.official@gmail.com");
    }
}
