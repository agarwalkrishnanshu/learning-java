package MultiThreading.ThreadPool;

import java.util.concurrent.ThreadFactory;

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r){
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);

        return th;
    }
}
