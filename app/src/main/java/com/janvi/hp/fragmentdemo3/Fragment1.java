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
import android.widget.EditText;

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f1,container,false);
        Button btn=(Button)view.findViewById(R.id.btn1_frg1);
        final EditText ed=(EditText)view.findViewById(R.id.editTextName);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment2 f2=new Fragment2();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                String str=ed.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("key",str);
                f2.setArguments(bundle);
                ft.replace(R.id.l1,f2);
                ed.setText("");
                ft.addToBackStack(null);
                ft.commit();

            }
        });
        return view;
    }
}
