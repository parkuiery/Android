package com.example.outopompomme;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.media.audiofx.Visualizer;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class HomeFragment extends Fragment {

    //Millisecond 형태의 하루(24시간)
    private final int ONE_DAY = 24 * 60 * 60 * 1000;

    private Calendar mCalender;

    private TextView mTvResult;

    //DatePicker 에서 날짜 선택 시 호출
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            //D-day 계산 결과 출력
            mTvResult.setText(getDay(year, month,dayOfMonth));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main_menu_home);


    }

    private String getToday(){
        final String strFormat = getString(R:string.format_today);
        SimpleDateFormat CurDateFormat = new SimpleDateFormat(strFormat);
        return CurDateFormat.format(mCalender.getTime());
    }

    private String getDay(int year, int month, int dayOfMonth) {

        final Calendar ddayCalendr Calendar.getInstance();
        ddayCalendr.set(year,month,dayOfMonth);


        final long dday = ddayCalendr.getTimeInMillis() / ONE_DAY;
        final long today = Calendar.getInstance().getTimeInMillis() / ONE_DAY;
        long result = dday - today;

        final String strFormat;
        if(result>0){
            strFormat = "D+%d";
        } else if (result==0) {
            strFormat = "D-Day";
        } else{
            result *=-1;
            strFormat = "D+%d";
        }

        final String strCount = (String.format(strFormat, result));
        return strCount;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedinstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_menu_home, container, false);

        //D-day 보여주기
        mTvResult = rootView.findViewByld(R.id.tv_result);

        //한국어 설정
        Locale.setDefault(Locale.KOREAN);

        //현재 날짜를 알기 위해 사용
        mCalender = new GregorianCalendar();

        //Today 보여주기
        TextView tvDate = container.findViewById(R.id.tv_date);
        tvDate.setText(getToday());



        View.OnClickListener clickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int year = mCalender.get((Calendar.YEAR));
                final int month = mCalender.get(Calendar.MONTH);
                final int day = mCalender.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(HomeFragment.this, mDateSetListener, year,month,day);
                dialog.show();
            }
        };
        findViewByldId(R.id.btn_input_date).setOnclickListener(clickListener);
        return
    }
}