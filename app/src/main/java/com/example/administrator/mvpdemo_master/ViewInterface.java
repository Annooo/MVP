package com.example.administrator.mvpdemo_master;

/**
 * Created by Administrator on 2017/2/7.
 * view 层的接口，定义view 的所有动作  view通常是指activity 让activity去实现本接口
 * view 和 presenter 互相持有引用
 */

public interface ViewInterface {

    /**
     * 显示和隐藏进度条
     */
    public void showProgressBar();
    public void hideProgressBar();

    /**
     * 发送是成功还是失败各自需要做的事情
     */
    public void sendSuccess();
    public void sendFailed();

    /**
     * 清除发送内容
     */
    public void cleanContent();
    public void cleanAuthor();

    /**
     * 获取内容和作者
     */
    public String getContent();
    public String getAuthor();
}
