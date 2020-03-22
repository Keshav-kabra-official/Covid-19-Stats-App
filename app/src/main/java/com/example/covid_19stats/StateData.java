package com.example.covid_19stats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StateData extends AppCompatActivity {

    Button b_state, b_nationality, b_trans_source;
    TextView t_state, t_nationality, t_trans_source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_data);

        b_state = findViewById(R.id.button_state);
        t_state = findViewById(R.id.text_state);
        t_state.setVisibility(View.GONE);

        b_nationality = findViewById(R.id.button_nationality);
        t_nationality = findViewById(R.id.text_nationality);
        t_nationality.setVisibility(View.GONE);

        b_trans_source = findViewById(R.id.button_trans_source);
        t_trans_source = findViewById(R.id.text_trans_source);
        t_trans_source.setVisibility(View.GONE);

        b_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t_state.setVisibility((t_state.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
                if(t_state.getVisibility() == View.VISIBLE) {
                    b_state.setText("Hide Stats");
                    t_state.setText("");
                    t_state.append("  Andhra Pradesh - 5  \n");
                    t_state.append("  Arunachal Pradesh - 0  \n");
                    t_state.append("  Assam - 0 \n");
                    t_state.append("  Bihar - 0  \n");
                    t_state.append("  Chhattisgarh - 1  \n");
                    t_state.append("  Goa - 0  \n");
                    t_state.append("  Gujarat - 14  \n");
                    t_state.append("  Haryana - 18  \n");
                    t_state.append("  Himachal Pradesh - 2  \n");
                    t_state.append("  Jharkhand - 0  \n");
                    t_state.append("  Karnataka - 19  \n");
                    t_state.append("  Kerala - 52  \n");
                    t_state.append("  Madhya Pradesh - 4  \n");
                    t_state.append("  Maharashtra - 72  \n");
                    t_state.append("  Manipur - 0  \n");
                    t_state.append("  Meghalaya - 0  \n");
                    t_state.append("  Mizoram - 0  \n");
                    t_state.append("  Nagaland - 0  \n");
                    t_state.append("  Odisha - 2  \n");
                    t_state.append("  Punjab - 13  \n");
                    t_state.append("  Rajasthan - 23  \n");
                    t_state.append("  Sikkim - 0  \n");
                    t_state.append("  Tamil Nadu - 6  \n");
                    t_state.append("  Telangana - 21  \n");
                    t_state.append("  Tripura - 0  \n");
                    t_state.append("  Uttarakhanda - 3  \n");
                    t_state.append("  Uttar Pradesh - 26  \n");
                    t_state.append("  West Bengal - 4  \n");
                    t_state.append("  Andaman & Nicobar - 0  \n");
                    t_state.append("  Chandigarh - 5  \n");
                    t_state.append("  Daman & Diu - 0  \n");
                    t_state.append("  Delhi - 26  \n");
                    t_state.append("  Jammu & Kashmir - 4  \n");
                    t_state.append("  Ladakh - 13  \n");
                    t_state.append("  Lakshadweep - 0  \n");
                    t_state.append("  Puducherry - 1  ");
                }
                else{
                    b_state.setText("Show State-wise Data");
                }
            }
        });

        b_nationality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t_nationality.setVisibility((t_nationality.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
                if(t_nationality.getVisibility() == View.VISIBLE) {
                    b_nationality.setText("Hide Stats");
                    t_nationality.setText("");
                    t_nationality.append("  Indian - 293 (88%) \n");
                    t_nationality.append("  Foreign National - 41 (12%)");
                }
                else{
                    b_nationality.setText("Show Nationality-wise Data");
                }
            }
        });

        b_trans_source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t_trans_source.setVisibility((t_trans_source.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
                if(t_trans_source.getVisibility() == View.VISIBLE) {
                    b_trans_source.setText("Hide Stats");
                    t_trans_source.setText("");
                    t_trans_source.append("  Imported - 161 (48%)\n");
                    t_trans_source.append("  Local - 151 (45%)\n");
                    t_trans_source.append("  Not Sure yet - 22 (7%)\n");
                }
                else{
                    b_trans_source.setText("Show Transmission-Source Data");
                }
            }
        });

    }
}