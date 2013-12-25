package com.recruit.app.ui.me;

import android.os.Bundle;
import android.view.Menu;

import com.recruit.R;
import com.recruit.app.ui.common.AbstractActivity;
import com.squareup.picasso.Picasso;

/**
 * jyu - 12/24/13.
 */
public class MessageActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.message_activity);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
