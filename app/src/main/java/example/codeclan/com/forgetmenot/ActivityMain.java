package example.codeclan.com.forgetmenot;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 22/01/2017.
 */

public class ActivityMain extends AppCompatActivity {

    ViewPager pager;
    PagerTabStrip pagerTabStrip;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.pager_header);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        pager.setAdapter(fragmentAdapter);


    }

}
