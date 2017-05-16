package com.mvit.mihajlo.jelovnik.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.mvit.mihajlo.jelovnik.R;
import com.mvit.mihajlo.jelovnik.fragments.DetailFragment;
import com.mvit.mihajlo.jelovnik.fragments.MainFragment;

/**
 * Created by Mihajlo on 16-May-17.
 */

public class MainActivity extends Activity implements MainFragment.OnItemSelectedListener {

    boolean landscape = false;

    // onCreate method is a lifecycle method called when he activity is starting
    @Override
    protected void onCreate(Bundle savedInstanceState) 	{

        // Each lifecycle method should call the method it overrides
        super.onCreate(savedInstanceState);

        // Draws layout
        setContentView(R.layout.activity_main);

        // If the activity is started for the first time create master fragment
        if (savedInstanceState == null) {
            // FragmentTransaction is a set of changes (e.g. adding, removing and replacing fragments) that you want to perform at the same time.
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            MainFragment masterFragment = new MainFragment();
            ft.add(R.id.master_view, masterFragment, "Master_Fragment_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

        // If the device is in the landscape mode and the detail fragment is null create detail fragment
        if (findViewById(R.id.detail_view) != null) {
            landscape = true;
            getFragmentManager().popBackStack();

            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
            if (detailFragment == null) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                detailFragment = new DetailFragment();
                ft.replace(R.id.detail_view, detailFragment, "Detail_Fragment_1");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }
    }

    @Override
    public void onItemSelected(int position) {

        // Shows a toast message (a pop-up message)
        Toast.makeText(getBaseContext(), "FirstActivity.onItemSelected()", Toast.LENGTH_SHORT).show();

        if (landscape) {
            // If the device is in the landscape mode updates detail fragment's content.
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
            detailFragment.updateContent(position);
        } else {
            // If the device is in the portrait mode sets detail fragment's content and replaces master fragment with detail fragment in a fragment transaction.
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setContent(position);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.master_view, detailFragment, "Detail_Fragment_2");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

}
