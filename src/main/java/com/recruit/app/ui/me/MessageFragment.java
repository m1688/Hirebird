package com.recruit.app.ui.me;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recruit.R;
import com.recruit.app.domain.model.Message;
import com.recruit.app.ui.Injector;
import com.recruit.app.util.JsonUtils;

import butterknife.InjectView;

/**
 * jyu - 1/6/14.
 */
public class MessageFragment extends Fragment {

    private Message message;

    public MessageFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(
                R.layout.message_detail, container, false);

        Bundle argument = getArguments();

        message = JsonUtils.readFromAsset(getActivity(), "sample.json", "message_sample_"
                + argument.getInt("message"), Message.class);

        TextView senderName = (TextView)rootView.findViewById(R.id.message_sender_name);
        senderName.setText(message.getSenderName());

        TextView messageTitle = (TextView)rootView.findViewById(R.id.message_title);
        messageTitle.setText(message.getTitle());

        TextView messageContent = (TextView)rootView.findViewById(R.id.message_content);
        messageContent.setText(message.getContent());

        return rootView;
    }
}
