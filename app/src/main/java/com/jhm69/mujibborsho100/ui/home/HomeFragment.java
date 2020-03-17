package com.jhm69.mujibborsho100.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.jhm69.mujibborsho100.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView result = root.findViewById(R.id.result);
        final TextView mont = root.findViewById(R.id.month);
        final TextView dae = root.findViewById(R.id.day);
        final Button res = root.findViewById(R.id.res);
        final int days[]={31,28,31,30,31,30,31,31,30,31,30,31};
        final int mujib_days[]={31,30,31,30,31,31,30,31,30,31,31,28};
        final String month_name[]={"Shadhinota","Shopoth","Betarjuddho","Juddho","Shok","Koushol-juddho","Akash_juddho","Jail-hotta","Bijoy","Fire-asha","Nobojatra","Vasha"},buffer;

        res.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int month,day,cnv_month=0,mujib_day=0,total_days=0;
                String mon =mont.getText().toString();
                month = new Integer(mon).intValue();

                if(!(month<=12 && month>0)){
                    Toast.makeText(getActivity().getApplicationContext(), "INVALID MONTH", Toast.LENGTH_LONG).show();
                }

                String da =dae.getText().toString();
                day = new Integer(da).intValue();

                if(!(day>=0 || day<=days[month-1])){
                    Toast.makeText(getActivity().getApplicationContext(), "INVALID DATE", Toast.LENGTH_LONG).show();
                }
                for(int i=0;i<month-1;i++){
                    total_days+=days[i];
                }
                total_days+=day;

                total_days -=75;
                if(total_days<=0)total_days+=365;

                int i=0;
                while(total_days>mujib_days[i]){
                    total_days-=mujib_days[i];
                    cnv_month++;
                    i++;

                }

                result.setText(month_name[cnv_month] + " " + total_days);

            }
        });
        return root;
    }
}