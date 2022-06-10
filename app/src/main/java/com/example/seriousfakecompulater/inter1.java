package com.example.seriousfakecompulater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.seriousfakecompulater.databinding.FragmentInter1VideoBinding;
import com.example.seriousfakecompulater.databinding.FragmentInterPhotoBinding;
import com.example.seriousfakecompulater.databinding.FragmentInterSettingBinding;

public class inter1 extends FragmentActivity implements View.OnClickListener {
        private Button photo , video , setting;
        private FragmentManager fmgr ;
        private inter1_video fmgrvideo;
        private inter_photo fmgrphoto;
        private inter_setting fmgrsetting;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_inter1);
                fmgr = getSupportFragmentManager();
                inintinter1();

        }

        private void inintinter1() {
                fmgrvideo = new inter1_video();
                fmgrphoto = new inter_photo();
                fmgrsetting = new inter_setting();
                FragmentTransaction transcation = fmgr.beginTransaction();
                transcation.add(R.id.contain,fmgrphoto).commit();

                photo = findViewById(R.id.photo);
                photo.setOnClickListener(this);

                video = findViewById(R.id.video);
                video.setOnClickListener(this);

                setting = findViewById(R.id.setting);
                setting.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                    case R.id.photo:
                              FragmentTransaction transaction = fmgr.beginTransaction();
                              transaction.replace(R.id.contain,fmgrphoto).commit();
                              break;
                    case R.id.video:
                            transaction = fmgr.beginTransaction();
                            transaction.replace(R.id.contain,fmgrvideo).commit();
                            break;
                    case R.id.setting:
                            Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                            transaction = fmgr.beginTransaction();
                            transaction.replace(R.id.contain,fmgrsetting).commit();
                            break;


//                            Intent intent = new Intent();
//                            intent.setType("image/*");
//                            intent.setAction(Intent.ACTION_GET_CONTENT);
//                            startActivityForResult(intent, 1);

            }
        }

}