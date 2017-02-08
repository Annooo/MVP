package com.example.administrator.mvpdemo_master;

/**
 * Created by Administrator on 2017/2/7.
 *
 * 数据层，做的事情就是为Presenter层提供数据
 */

public interface ModelInterface {


    interface OnSendLinterer{
        void sendSuccess();
        void sendFailed();
    }
    public void send(String content, String author, OnSendLinterer onSendLinterer);
}
