package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    public String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajit Sasta", "Hospital Address : Pimpri", "Exp: 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name :Prasad Pawar", "Hospital Address : Nigdi", "Exp: 15yrs", "Mobile No: 7654223598", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No: 9432987643", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp: 6yrs", "Mobile No: 9432789543", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj", "Exp: 7yrs", "Mobile No: 8976543245", "800"},

            };
    public String[][] doctor_details2 =
            {
                    {"Doctor Name : Ajit Sasta", "Hospital Address : Pimpri", "Exp: 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name :Prasad Pawar", "Hospital Address : Nigdi", "Exp: 15yrs", "Mobile No: 7654223598", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No: 9432987643", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp: 6yrs", "Mobile No: 9432789543", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj", "Exp: 7yrs", "Mobile No: 8976543245", "800"},

            };
    public String[][] doctor_details3 =
            {
                    {"Doctor Name : Ajit Sasta", "Hospital Address : Pimpri", "Exp: 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name :Prasad Pawar", "Hospital Address : Nigdi", "Exp: 15yrs", "Mobile No: 7654223598", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No: 9432987643", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp: 6yrs", "Mobile No: 9432789543", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj", "Exp: 7yrs", "Mobile No: 8976543245", "800"},

            };
    public String[][] doctor_details4 =
            {
                    {"Doctor Name : Ajit Sasta", "Hospital Address : Pimpri", "Exp: 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name :Prasad Pawar", "Hospital Address : Nigdi", "Exp: 15yrs", "Mobile No: 7654223598", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No: 9432987643", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp: 6yrs", "Mobile No: 9432789543", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj", "Exp: 7yrs", "Mobile No: 8976543245", "800"},

            };
    public String[][] doctor_details5 =
            {
                    {"Doctor Name : Ajit Sasta", "Hospital Address : Pimpri", "Exp: 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name :Prasad Pawar", "Hospital Address : Nigdi", "Exp: 15yrs", "Mobile No: 7654223598", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp: 8yrs", "Mobile No: 9432987643", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp: 6yrs", "Mobile No: 9432789543", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj", "Exp: 7yrs", "Mobile No: 8976543245", "800"},

            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.DD_title);
        btn = findViewById(R.id.DD_Back);

        Intent in = getIntent();
        String title = in.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

           btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
               }
           });

            list = new ArrayList();
            for(int i=0; i<doctor_details.length; i++){
                item = new HashMap<String, String>();
                item.put("line1", doctor_details[i][0]);
                item.put("line2", doctor_details[i][1]);
                item.put("line3", doctor_details[i][2]);
                item.put("line4", doctor_details[i][3]);
                item.put("line5", "Cons Fees:" +doctor_details[i][4]+"/-");
                list.add(item);
            }
            sa = new SimpleAdapter(this,list,
                    R.layout.multi_lines,
                    new String[]{"line1", "line2","line3", "line4","line5",},
                    new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                    );
        ListView lst = findViewById(R.id.Lv_DD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                in.putExtra("text1",title);
                in.putExtra("text2",doctor_details[i][0]);
                in.putExtra("text3",doctor_details[i][1]);
                in.putExtra("text4",doctor_details[i][3]);
                in.putExtra("text5",doctor_details[i][4]);
                startActivity(in);
            }
        });
    }
}