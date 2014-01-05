package com.recruit.app.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.recruit.R;
import com.recruit.app.domain.model.Message;
import com.recruit.app.ui.common.AbstractActivity;
import com.recruit.app.ui.main.MainActivity;
import com.recruit.app.util.JsonUtils;

import java.io.IOException;

import butterknife.InjectView;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

/**
 * 消息detail activity
 * <p/>
 * jyu - 12/24/13.
 */
public class MessageActivity extends AbstractActivity {

    @InjectView(R.id.message_sender_name)
    protected TextView senderName;

    @InjectView(R.id.message_title)
    protected TextView messageTitle;

    @InjectView(R.id.message_content)
    protected TextView messageContent;

    private Message message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        message = JsonUtils.readFromAsset(this, "sample.json", "message_sample", Message.class);

        setContentView(R.layout.message_activity);

        senderName.setText(message.getSenderName());
        messageTitle.setText(message.getTitle());
        messageContent.setText(message.getContent());


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.message, menu);
        return true;
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

    }
}
