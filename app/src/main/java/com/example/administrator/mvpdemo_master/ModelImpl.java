package com.example.administrator.mvpdemo_master;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/7.
 */

public class ModelImpl implements ModelInterface {

    private ExecutorService executorService ;

    public ModelImpl(){
        //获取一个线程池 根据 虚拟机可用的处理器的最大数量 +1 定义线程池大小
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);
    }


    @Override
    public void send(String content, String author,final OnSendLinterer onSendLinterer) {
        executorService.execute(new Runnable() {
            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                //模拟网络请求的耗时操作
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //随机boolean 模拟发送成功或失败
                Random random = new Random();
                if( random.nextBoolean() ){
                    onSendLinterer.sendSuccess();
                }else{
                    onSendLinterer.sendFailed();
                }
            }
        });
        //不再接受新的任务
//        executorService.shutdown();
        /*try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
    }
    public void destory(){
        executorService = null;
    }
}
