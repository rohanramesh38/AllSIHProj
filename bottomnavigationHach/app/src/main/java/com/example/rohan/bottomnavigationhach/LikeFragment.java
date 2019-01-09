package com.example.rohan.bottomnavigationhach;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LikeFragment extends Fragment {


int num,crdate;
    String s="",daykey="",selectedDoctor ="Sai",patientName="barath123@gmail";
TextView tvcalendar;
String timeString[];
    Spinner sp;
    EditText ename,enumber,eage;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("in_patients").child("Appointments");

    public LikeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_like, container, false);
num=0;
        String[] values = {"None selected", "Head Ache","Fever","Body Pain","Throat Pain"};


        Spinner spinner = (Spinner) v.findViewById(R.id.spinnersel);
tvcalendar=(TextView)v.findViewById(R.id.textcal);
sp=(Spinner)v.findViewById(R.id.spinnertime);
ename=(EditText)v.findViewById(R.id.editTextName);
        enumber=(EditText)v.findViewById(R.id.editTextPhone);
        eage=(EditText)v.findViewById(R.id.editTextAge);
        tvcalendar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {



        AlertDialog.Builder dialogBuilder =new AlertDialog.Builder(getContext());

        LayoutInflater inflater=getLayoutInflater();
        final View dialogView=inflater.inflate(R.layout.candelar,null);

        dialogBuilder.setView(dialogView);
        final AlertDialog  alertDialog= dialogBuilder.create();
        alertDialog.show();
        Calendar calendar = Calendar.getInstance();
        CalendarView cv = (CalendarView) dialogView.findViewById(R.id.CalendarView);
        Calendar calen = Calendar.getInstance();

        Date now=new Date();

        //noinspection deprecation
        crdate=now.getDate();

        //noinspection deprecation
        cv.setMinDate(calendar.getTimeInMillis());
        calen.add(calen.DATE,30);
        cv.setMaxDate(calen.getTimeInMillis());
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                s=dayOfMonth+"-"+ (month+1)+"-"+year;
              daykey=dayOfMonth+"_"+ (month+1)+"_"+year;
                tvcalendar.setText(s);
                num=dayOfMonth;

                Calendar calenTime = Calendar.getInstance();

                Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();

                Calendar calenlast = Calendar.getInstance();

                int lastDate = calenlast.getActualMaximum(Calendar.DATE);
                calenlast.set(Calendar.DATE, lastDate);


                calenTime.add(calenTime.DATE,num-crdate);
                calenTime.getTime();



                //noinspection deprecation
                if (calenTime.getTime().getDate() == now.getDate()) {

                    //noinspection deprecation
                    Toast.makeText(getActivity(), " date="+ now.getDate()+"  ,Time= "+ now.getHours()+":"+now.getMinutes(), Toast.LENGTH_LONG).show();


                    List<String> va=new  ArrayList<String>();
//noinspection deprecation
                    int b=now.getHours();
                    String time=" A.M";
                    if(b>=12)
                    {
                        time=" P.M";
                    }
                    for(int i=b;i<24;i++)
                    {
                        va.add(" "+(i+1)+" :"+"00"+time);
                        if(i!=23) {
                            va.add(" " + (i + 1) + " :" + "15" + time);
                            va.add(" " + (i + 1) + " :" + "30" + time);
                            va.add(" " + (i + 1) + " :" + "45" + time);
                        }
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, va);
                    adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                    sp.setAdapter(adapter);

                    sp.setSystemUiVisibility(View.VISIBLE);

                }
                else
                {
                    //noinspection deprecation
                  //  Toast.makeText(getActivity(), " date="+  calenTime.getTime().getDate()+"  ,Time"+"00:00", Toast.LENGTH_LONG).show();

                    List<String> va=new  ArrayList<String>();

                    //noinspection deprecation

                    String time=" A.M";


                    for(int i=0;i<25;i++)
                    {

                        if(i>=12)
                        {
                            time=" P.M";
                        }

                        va.add(" "+(i)+" :"+"00"+time);
                        if(i!=24) {
                            va.add(" " + (i) + " :" + "15" + time);
                            va.add(" " + (i) + " :" + "30" + time);
                            va.add(" " + (i) + " :" + "45" + time);
                        }


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, va);
                    adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                    sp.setAdapter(adapter);

                    sp.setSystemUiVisibility(View.VISIBLE);
                }


                //noinspection unused

                alertDialog.dismiss();
            }
        });




    }
});

        ArrayList<StateVO> listVOs = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            StateVO stateVO = new StateVO();
            stateVO.setTitle(values[i]);
            stateVO.setSelected(false);
            listVOs.add(stateVO);
        }
        SpinnerAdapter adapter = new SpinnerAdapter(this.getActivity(), 0, listVOs);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);





       // Toast.makeText(getActivity(), " "+listVOs.get(1).getTitle()+" "+listVOs.get(0).isSelected(), Toast.LENGTH_LONG).show();
//String tos=" ";

        Button bt=(Button) v.findViewById(R.id.buttonappoi);

        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String pname,page,pnumber;
                String appointmentfin="";
                for(int i=1;i<listVOs.size();i++)
                {
                    if(listVOs.get(i).isSelected())
                    {
                        appointmentfin+=" "+listVOs.get(i).getTitle();
                    }





                }


                pname=ename.getText().toString().trim();
                page=eage.getText().toString();
                pnumber=enumber.getText().toString();


                if(TextUtils.isEmpty(page) ||TextUtils.isEmpty(pname)||TextUtils.isEmpty(pnumber) || TextUtils.isEmpty(daykey) || TextUtils.isEmpty(appointmentfin))
                {

                    ename.setError("all feilds necessary");
                    eage.setError("all feilds necessary");
                    enumber.setError("all feilds necessary");
                }
                else {

                    inpatients user = new inpatients(pname,page,appointmentfin,pnumber);
                    myRef.child(daykey).child(selectedDoctor).child(patientName).setValue(user);
                    Toast.makeText(getActivity(), " appointmentfixed ", Toast.LENGTH_LONG).show();


                }


                Toast.makeText(getActivity(), " "+appointmentfin+" ", Toast.LENGTH_LONG).show();
            }
        });

return v;
    }

}
