package com.example.research;


import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 15:29 2019/11/13
 * @ Description：谷歌重试利器 guava retrying
 * @ Modified By：
 * @Version: $version$
 */
public class GuavaRetryingDemo {
    public Object test() throws Exception {
        //定义重试机制
        Retryer<Object> retryer = RetryerBuilder.<Object>newBuilder()
                //retryIf 重试条件
                .retryIfException()
                .retryIfRuntimeException()
                .retryIfExceptionOfType(Exception.class)
                .retryIfException(Predicates.equalTo(new Exception()))
                .retryIfResult(Predicates.equalTo(false))
                .retryIfResult(Predicates.equalTo("-1"))

                //等待策略：每次请求间隔1s
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS))

                //停止策略 : 尝试请求6次
                .withStopStrategy(StopStrategies.stopAfterAttempt(4))

                //时间限制 : 某次请求不得超过2s , 类似: TimeLimiter timeLimiter = new SimpleTimeLimiter();
                //.withAttemptTimeLimiter(AttemptTimeLimiters.fixedTimeLimit(2, TimeUnit.SECONDS))

                .build();

        //定义请求实现
        Callable<Object> callable = new Callable<Object>() {
            int times = 1;

            @Override
            public Object call() throws Exception {
                System.out.println(new Date()+"call times={}"+times);
                times++;

                if (times == 2) {
                    throw new NullPointerException();
                } else if (times == 3) {
                    return "1";
                    //throw new Exception();
                } else if (times == 4) {
                    throw new RuntimeException();
                } else if (times == 5) {
                    return false;
                } else if(times ==6){
                    return "-1";
                } else if (times==7){
                    System.out.println("zhg"+times);
                    return true;
                }else {
                    System.out.println("success"+times);
                    return true;
                }
            }
        };
        System.out.println("去重试");
        //利用重试器调用请求
        return  retryer.call(callable);
    }
    private void   tt() throws Exception {
        int a = 1;
        if(a==1){
            test();
        }
        System.out.println("运行完成！！！");
    }

    public static void main(String[] args) {
        GuavaRetryingDemo g = new GuavaRetryingDemo();
        try {
            g.tt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
