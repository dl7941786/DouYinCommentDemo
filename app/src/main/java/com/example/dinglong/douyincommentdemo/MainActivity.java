package com.example.dinglong.douyincommentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CommentDialogFragment.Listener {

    private CommentDialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.hello).setOnClickListener(this);
        findViewById(R.id.bye).setOnClickListener(this);
        dialogFragment = CommentDialogFragment.newInstance(100);
        dialogFragment.setItemClickedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hello:
                dialogFragment.show(getSupportFragmentManager(), "dialog");
                break;
            case R.id.bye:
                dialogFragment.dismiss();
                break;
        }
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, "position " + position, Toast.LENGTH_SHORT).show();
    }
}
