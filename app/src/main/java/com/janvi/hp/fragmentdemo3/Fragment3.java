package com.janvi.hp.fragmentdemo3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f3,container,false);
        TextView txt1=(TextView)view.findViewById(R.id.txt_name);
        TextView txt2=(TextView)view.findViewById(R.id.txt_sem);
        String s1=getArguments().getString("key1");
        String s2=getArguments().getString("key2");
        txt1.setText(s1);
        txt2.setText(s2);
        Button b=(Button)view.findViewById(R.id.btn1_frg3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fm.popBackStack();
                ft.commit();
            }
        });
        return view;
    }
}
