package com.example.administrator.mvpdemo_master;

import android.os.Handler;

/**
 * Created by Administrator on 2017/2/7.
 */

public class PresenterImpl implements PresenterInterface {


    ViewInterface viewInterface;
    ModelImpl model;
    private Handler mHandler = new Handler();

    public PresenterImpl() {
    }

    public PresenterImpl(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
        model = new ModelImpl();
    }

    @Override
    public void send() {
        //显示进度条
        viewInterface.showProgressBar();
        model.send(viewInterface.getContent(), viewInterface.getAuthor(), new ModelInterface.OnSendLinterer() {
            @Override
            public void sendSuccess() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        viewInterface.sendSuccess();
                        viewInterface.hideProgressBar();
                    }
                });
            }

            @Override
            public void sendFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        viewInterface.sendFailed();
                        viewInterface.hideProgressBar();
                    }
                });
            }
        });
    }

    @Override
    public void destroy() {
        viewInterface = null;
        model.destory();
        model = null;
    }


    @Override
    public void clean() {
        viewInterface.cleanAuthor();
        viewInterface.cleanContent();
    }
}
