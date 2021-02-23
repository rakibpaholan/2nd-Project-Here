package com.example.a2ndproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

import org.w3c.dom.Text;

public class Project_information extends AppCompatActivity {
    private ImageView image_view_1,imageView_2,imageView_3,imageView_4,imageView_5;
    private TextView textView_1,textView_2,textView_3,textView_4,textView_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_information);
        image_view_1 = (ImageView)findViewById(R.id.image_view_1);
        imageView_2=(ImageView)findViewById(R.id.image_view_2);
        imageView_3=(ImageView)findViewById(R.id.image_view_3);
        imageView_4=(ImageView)findViewById(R.id.image_view_4);
        imageView_5=(ImageView)findViewById(R.id.image_view_5);


        textView_1 = (TextView)findViewById(R.id.project_name_1);
        textView_2 = (TextView)findViewById(R.id.project_name_2);
        textView_3=(TextView)findViewById(R.id.project_name_3);
        textView_4=(TextView)findViewById(R.id.project_name_4);
        textView_5=(TextView)findViewById(R.id.project_name_5);




        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();

        if (bundle!= null){
            String project_full_name = bundle.getString("Key");
            setContent(project_full_name);
            Toast.makeText(getApplicationContext(),project_full_name,Toast.LENGTH_SHORT).show();
        }
    }


    public void setContent(String project_full_name){
        if (project_full_name.equals("List View With ArrayAdapter")){
            textView_1.setText(R.string.array_adapter_basic);
            image_view_1.setImageResource(R.drawable.list_view_practice_array_adapter_basic);
        }
        if (project_full_name.equals("List View With OnItemClickListener")){
            textView_1.setText("List View With OnItemClickListener");
            image_view_1.setImageResource(R.drawable.onclicklistner);
        }
        if(project_full_name.equals("List View With BaseAdapter")){
            textView_1.setText("Custom Adapter Variable Declare :");
            image_view_1.setImageResource(R.drawable.custom_adapter_variable_diclar);
            textView_2.setText("custom_adapter_inside_oncreat_method");
            imageView_2.setImageResource(R.drawable.custom_adapter_inside_oncreat_method);
            textView_3.setText("custom_adapter_constructor_view");
            imageView_3.setImageResource(R.drawable.custom_adapter_constructor_view);
            textView_4.setText("Country Detail Page Setup");
            imageView_4.setImageResource(R.drawable.country_detail_page_setup);
        }

    }
}