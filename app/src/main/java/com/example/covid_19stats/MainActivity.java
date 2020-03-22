package com.example.covid_19stats;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {

    TextView t_main_stats;
    Button b_main_stats;
    ProgressDialog mProgressDialog; // dialog-box while data is loaded from internet
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t_main_stats = findViewById(R.id.textView);
        b_main_stats = findViewById(R.id.button);
        t_main_stats.setVisibility(View.GONE);

        b_main_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t_main_stats.setVisibility((t_main_stats.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
                if(t_main_stats.getVisibility() == View.VISIBLE) {
                    boolean xx = isNetworkAvailable();
                    if(xx) {
                        new MainStats().execute();
                    }else {
                        t_main_stats.setText("");
                        Toast.makeText(MainActivity.this, "Failed to Connect with Internet!", Toast.LENGTH_SHORT).show();
                    }
                    b_main_stats.setText("Hide Stats");
                }
                else{
                    b_main_stats.setText("Show Main Stats\n (From Internet)");
                }
            }
        });
    }


    // 'Other Stats' Button functionality
    // Static Data will be shown on next activity
    public void stateData(View obj){
        Intent i = new Intent(MainActivity.this, StateData.class);
        startActivity(i);
    }


    // 'Fetch Main Stats' Button functionality
    // Fetch data from the website and display it in the app -- WEB SCRAPING
    // uses Jsoup for Web-Scraping
    public class MainStats extends AsyncTask<Void, Void, String>{

        Elements header;
        String[] head = new String[5];
        Elements main_head1, second_head1, cases1, info1;
        Elements main_head2, second_head2, cases2, info2;
        Elements main_head3, second_head3, cases3, info3;
        Elements main_head4, second_head4, cases4, info4;
        Elements main_head5, second_head5, cases5, info5;
        String ss = null;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("COVID-19 Stats");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {
                Document doc = Jsoup.connect("https://covidout.in").get();

                header = doc.select("div[class=card-title]");
                int i = 0;
                for(Element e : header)
                {
                    head[i] = e.text();
                    i++;
                }
                ss=  head[0];

                main_head1 = doc.select("div[class=card-body status-confirmed]");
                second_head1 = main_head1.select("div[class=cases-container]");
                cases1 = second_head1.select("h2[class=case]");
                info1 = second_head1.select("span[class=info]");

                main_head2 = doc.select("div[class=card-body status-hospitalized]");
                second_head2 = main_head2.select("div[class=cases-container]");
                cases2 = second_head2.select("h2[class=case]");
                info2 = second_head2.select("span[class=info]");

                main_head3 = doc.select("div[class=card-body status-icu]");
                second_head3 = main_head3.select("div[class=cases-container]");
                cases3 = second_head3.select("h2[class=case]");
                info3 = second_head3.select("span[class=info]");

                main_head4 = doc.select("div[class=card-body status-recovered]");
                second_head4 = main_head4.select("div[class=cases-container]");
                cases4 = second_head4.select("h2[class=case]");
                info4 = second_head4.select("span[class=info]");

                main_head5 = doc.select("div[class=card-body status-died]");
                second_head5 = main_head5.select("div[class=cases-container]");
                cases5 = second_head5.select("h2[class=case]");
                info5 = second_head5.select("span[class=info]");

            } catch (Exception e){
                e.printStackTrace();

            }
            return ss;
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            StringBuilder tt = new StringBuilder();

            if(aVoid != null) {
                tt.append(head[0] + " -- ");
                tt.append(cases1.text());
                tt.append(" ( ");
                tt.append(info1.text());
                tt.append(" )\n\n");
                ///
                tt.append(head[1] + " -- ");
                tt.append(cases2.text());
                tt.append(" ( ");
                tt.append(info2.text());
                tt.append(" )\n\n");
                ///
                tt.append(head[2] + " -- ");
                tt.append(cases3.text());
                tt.append(" ( ");
                tt.append(info3.text());
                tt.append(" )\n\n");
                ///
                tt.append(head[3] + " -- ");
                tt.append(cases4.text());
                tt.append(" ( ");
                tt.append(info4.text());
                tt.append(" )\n\n");
                ///
                tt.append(head[4] + " -- ");
                tt.append(cases5.text());
                tt.append(" ( ");
                tt.append(info5.text());
                tt.append(" )\n");
                ///
                t_main_stats.setText(tt.toString());
            }
            else
                Toast.makeText(MainActivity.this, "Failed to Connect with Internet!", Toast.LENGTH_SHORT).show();
            mProgressDialog.dismiss();
        }
    }



    // 'Open Website(covidout.in)(In App)' Button functionality
    // opens website 'covidout.in/' in App itself
    public void cov_in_app(View obj){
        boolean xx = isNetworkAvailable();
        if(xx){
            Intent i = new Intent(MainActivity.this, WebInApp.class);
            startActivity(i);
        }else
            Toast.makeText(MainActivity.this, "Failed to Connect with Internet!", Toast.LENGTH_SHORT).show();
    }


    // 'Open Website(covidout.in)(In Browser)' Button functionality
    // opens website 'covidout.in/' in Browser
    public void cov_in_browser(View obj){
        boolean xx = isNetworkAvailable();
        if(xx) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://covidout.in/"));
            startActivity(i);
        }else
            Toast.makeText(MainActivity.this, "Failed to Connect with Internet!", Toast.LENGTH_SHORT).show();
    }


    // 'Open Website(coronavirus.app)(In Browser)' Button functionality
    // opens website 'coronavirus.app/map' in Browser
    public void cov2_in_browser(View obj){
        boolean xx = isNetworkAvailable();
        if(xx) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://coronavirus.app/map"));
            startActivity(i);
        }else
            Toast.makeText(MainActivity.this, "Failed to Connect with Internet!", Toast.LENGTH_SHORT).show();
    }


    // checks for Internet Connection in mobile phone (return true or false)
    // used by all buttons that uses Internet for their working
    private boolean isNetworkAvailable(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ac = null;
        if (cm != null) {
            ac = cm.getActiveNetworkInfo();
        }
        return ac!=null && ac.isConnected();
    }


    // 'About-App' Button functionality
    // shows details of app
    public void about_app(View obj){
        Intent i = new Intent(MainActivity.this, About.class);
        startActivity(i);
    }
}


/*
    Made By : Keshav Kabra
            (keshavkabra.official@gmail.com)
*/