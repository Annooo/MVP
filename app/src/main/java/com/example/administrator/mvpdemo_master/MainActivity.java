package com.example.administrator.mvpdemo_master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ViewInterface, View.OnClickListener {


    private EditText content;
    private EditText author;
    private Button send;
    private Button clean;
    private ProgressBar loading;

    private PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        content = (EditText) findViewById(R.id.content);
        author = (EditText) findViewById(R.id.author);
        loading = (ProgressBar) findViewById(R.id.loading);
        send = (Button) findViewById(R.id.send);
        clean = (Button) findViewById(R.id.clean);
        send.setOnClickListener(this);
        clean.setOnClickListener(this);

        presenter = new PresenterImpl(this);
    }

    /**
     * 显示和隐藏进度条
     */
    @Override
    public void showProgressBar() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        loading.setVisibility(View.GONE);
    }

    /**
     * 发送是成功还是失败各自需要做的事情
     */
    @Override
    public void sendSuccess() {
        Toast.makeText(this,"发送成功！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendFailed() {
        Toast.makeText(this,"发送失败！",Toast.LENGTH_SHORT).show();
    }

    /**
     * 清除发送内容
     */
    @Override
    public void cleanContent() {
        content.setText("");
    }

    @Override
    public void cleanAuthor() {
        author.setText("");
    }

    /**
     * 获取内容和作者
     */
    @Override
    public String getContent() {
        return content.getText().toString().trim();
    }
    @Override
    public String getAuthor() {
        return author.getText().toString().trim();
    }

    /**
     * Called when a view has been clicked.
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch( v.getId()){
            case R.id.send:
                presenter.send();
                break;
            case R.id.clean:
                presenter.clean();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}
