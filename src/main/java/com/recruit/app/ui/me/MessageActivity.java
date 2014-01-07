package com.recruit.app.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.recruit.R;
import com.recruit.app.domain.model.Message;
import com.recruit.app.ui.common.AbstractFragmentActivity;
import com.recruit.app.ui.common.ThrowableLoader;
import com.recruit.app.ui.main.MainActivity;
import com.recruit.app.util.JsonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

/**
 * 消息detail activity
 * <p/>
 * jyu - 12/24/13.
 */
public class MessageActivity extends AbstractFragmentActivity implements LoaderManager.LoaderCallbacks<List<Message>> {

    private ViewPager mViewPager;
    private List<Message> messageList = new ArrayList<Message>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.message_activity);

        mViewPager = (ViewPager) findViewById(R.id.message_pager);

        getSupportLoaderManager().initLoader(0, null, this);


        startService(new Intent(this, PullMessageService.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.message, menu);
        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        messageList = Arrays.asList((Message) intent.getSerializableExtra("message"));
        MessagePagerAdapter messagePagerAdapter = new MessagePagerAdapter(getSupportFragmentManager(),
                messageList);

        mViewPager.setAdapter(messagePagerAdapter);


        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MessageActivity.class);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            // This is the home button in the top left corner of the screen.
            case android.R.id.message:
                // Don't call finish! Because activity could have been started by an
                // outside activity and the home button would not operated as expected!
                final Intent homeIntent = new Intent(this, MainActivity.class);
                homeIntent.addFlags(FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(homeIntent);
                return true;
            case R.id.accept:
                acceptInterview();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void acceptInterview() {

        Message message = JsonUtils.readModel(this, "sample.json", "accept_message_sample", Message.class);

        startService(new Intent(this, MessageService.class).putExtra("message", message));
    }


    @Override
    public Loader<List<Message>> onCreateLoader(int i, Bundle bundle) {
        return new ThrowableLoader<List<Message>>(this, messageList) {

            @Override
            public List<Message> loadData() throws Exception {
                if (getContext() != null) {
                    final List<Message> messages = new ArrayList<Message>();
                    messages.add(JsonUtils.readModel(getContext(), "sample.json", "message_sample_1", Message.class));
                    messages.add(JsonUtils.readModel(getContext(), "sample.json", "message_sample_2", Message.class));
                    return messages;
                } else {
                    return Collections.emptyList();
                }
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<List<Message>> listLoader, List<Message> messages) {

        MessagePagerAdapter messagePagerAdapter = new MessagePagerAdapter(getSupportFragmentManager(), messages);

        mViewPager.setAdapter(messagePagerAdapter);
    }

    @Override
    public void onLoaderReset(Loader<List<Message>> listLoader) {
        //mViewPager.setAdapter(null);
    }
}
