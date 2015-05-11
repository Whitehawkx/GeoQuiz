package com.jonathansteadman.android.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jonathan on 5/8/15.
 */
public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE = "com.jonathansteadman.android.geoquiz" +
            ".answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.jonathansteadman.android.geoquiz" +
            ".answer_shown";
    public static final String EXTRA_TEXTVIEW = "com.jonathansteadman.android.extra_textview";

    private boolean mAnswerIsTrue;

    private TextView mAnswerTextView;
    private Button mShowAnswer;

    private TextView mApiTextView;

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    private void apiLevel(int api) {
        mApiTextView = (TextView) findViewById(R.id.api_level_text_view);
        mApiTextView.setText("API Level " + api);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);

        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });

        if (savedInstanceState != null) {
            String storedAnswer = savedInstanceState.getString(EXTRA_TEXTVIEW);
            mAnswerTextView.setText(storedAnswer);
            setAnswerShownResult(true);
        } else { // When CheatActivity initially launches
            // Answer will not be shown until the user presses the button
            setAnswerShownResult(false);
        }

        apiLevel(Build.VERSION.SDK_INT);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(EXTRA_TEXTVIEW, mAnswerTextView.getText().toString());
    }
}
