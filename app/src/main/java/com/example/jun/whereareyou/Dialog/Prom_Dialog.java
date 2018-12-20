package com.example.jun.whereareyou.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.jun.whereareyou.Data.ListViewChatItem;
import com.example.jun.whereareyou.R;

public class Prom_Dialog extends Dialog implements View.OnClickListener{
    private static final int LAYOUT = R.layout.prom_dialog;

    public interface MyDialogListener {
        public void onPositiveClicked(ListViewChatItem item);
        public void onNegativeClicked();
    }
    private MyDialogListener dialogListener;

    private Context context;

    private TextInputEditText nameEt;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private TextView place;
    private TextView cancelTv;
    private TextView searchTv;
    private Button placeBtn;
    //private Button addFriendsBtn;

    private String name;

    public Prom_Dialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public Prom_Dialog(Context context,String name){
        super(context);
        this.context = context;
        this.name = name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        nameEt = (TextInputEditText) findViewById(R.id.promdia_title_edit);
        datePicker = findViewById(R.id.promdia_datepicker);
        timePicker = findViewById(R.id.promdia_timepicker);
        place = findViewById(R.id.promdia_place_text);
        cancelTv = (TextView) findViewById(R.id.findPwDialogCancelTv);
        searchTv = (TextView) findViewById(R.id.findPwDialogFindTv);

        cancelTv.setOnClickListener(this);
        searchTv.setOnClickListener(this);

        if(name != null){
            nameEt.setText(name);
        }

        placeBtn = (Button) findViewById(R.id.promdia_place_btn);

        placeBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                //나중에 여기로
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.findPwDialogCancelTv:
                cancel();
                break;
            case R.id.findPwDialogFindTv:
                String time = "" + datePicker.getYear() + "/" + datePicker.getMonth() + "/'" +
                        datePicker.getDayOfMonth() + " " + timePicker.getHour() + ":" +
                        timePicker.getMinute();
                ListViewChatItem item = new ListViewChatItem(nameEt.getText().toString(), place.getText().toString(),time);
                dialogListener.onPositiveClicked(item);
                dismiss();
                break;
        }
    }
    public void setDialogListener(MyDialogListener dialogListener){
        this.dialogListener = dialogListener;
    }


}