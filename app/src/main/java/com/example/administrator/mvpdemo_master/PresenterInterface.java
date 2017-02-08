package com.example.administrator.mvpdemo_master;

/**
 * Created by Administrator on 2017/2/7.
 *
 * 控制 业务层，处理所有的业务逻辑，连接view 和 model
 */

public interface PresenterInterface {

    public void send();
    public void destroy();
    public void clean();
}
