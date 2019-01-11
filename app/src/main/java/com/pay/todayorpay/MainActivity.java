package com.pay.todayorpay;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.pay.todayorpay.fragment.FragmentAddCard;
import com.pay.todayorpay.fragment.FragmentCharity;
import com.pay.todayorpay.fragment.FragmentEnterAmount;
import com.pay.todayorpay.fragment.FragmentEnterGoal;
import com.pay.todayorpay.fragment.FragmentProgress;
import com.pay.todayorpay.fragment.FragmentSubmitGoal;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FrameLayout fragmentContainer;
    FragmentEnterAmount fragmentEnterAmount;
    FragmentEnterGoal fragmentEnterGoal;
    FragmentAddCard fragmentAddCard;
    FragmentSubmitGoal fragmentSubmitGoal;
    FragmentCharity fragmentCharity;
    FragmentProgress fragmentProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setupFragments();

//        inflateFragmentWithTag(fragmentEnterGoal, FragmentEnterGoal.TAG);
//        inflateFragmentWithTag(fragmentAddCard, FragmentAddCard.TAG);
//        inflateFragmentWithTag(fragmentEnterAmount, FragmentEnterAmount.TAG);
//        inflateFragmentWithTag(fragmentSubmitGoal, FragmentSubmitGoal.TAG);
//        inflateFragmentWithTag(fragmentCharity, FragmentCharity.TAG);
        inflateFragmentWithTag(fragmentProgress, FragmentProgress.TAG);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    private void setupFragments(){
        if(fragmentContainer != null) {
            if(fragmentEnterAmount == null) fragmentEnterAmount = new FragmentEnterAmount();
            if(fragmentEnterGoal == null) fragmentEnterGoal = new FragmentEnterGoal();
            if(fragmentAddCard == null) fragmentAddCard = new FragmentAddCard();
            if(fragmentSubmitGoal == null) fragmentSubmitGoal = new FragmentSubmitGoal();
            if(fragmentCharity == null) fragmentCharity = new FragmentCharity();
            if(fragmentProgress == null) fragmentProgress = new FragmentProgress();

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void inflateFragmentWithTag(Fragment fragment, String TAG) {
        try {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment, TAG);
                transaction.commitAllowingStateLoss();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
