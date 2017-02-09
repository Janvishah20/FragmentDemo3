package com.janvi.hp.fragmentdemo3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f2, container, false);
        Button btn1 = (Button) view.findViewById(R.id.btn1_frg2);
        Button btn2 = (Button) view.findViewById(R.id.btn2_frg2);
        final EditText ed = (EditText) view.findViewById(R.id.editTextSem);

       // Log.d("tag",s);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String s = getArguments().getString("key");
                Fragment3 f3 = new Fragment3();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                Bundle bundle = new Bundle();
                String st = ed.getText().toString();
                Log.d("tag",st);
                bundle.putString("key1", s);
                bundle.putString("key2", st);
                f3.setArguments(bundle);
                ft.replace(R.id.l1,f3);
                ed.setText("");
                ft.addToBackStack("");
                ft.commit();
            }
        });
       btn1.setOnClickListener(new View.OnClickListener() {
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
