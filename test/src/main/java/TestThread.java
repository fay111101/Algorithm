import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class CustomThreadPoolExecutor{
    private ThreadPoolExecutor pool=null;
    public void init(){
        pool=new ThreadPoolExecutor(10,30,30, TimeUnit.MINUTES,new
                ArrayBlockingQueue<Runnable>(10),new CustomThreadFactory(),
                new CustomRejectedExecutionHandler());
    }
    public void destroy(){
        if(pool!=null){
            pool.shutdownNow();
        }
    }
    public ExecutorService getCustomThreadPoolExecutor(){
        return this.pool;
    }
    private class CustomThreadFactory implements ThreadFactory{
        private AtomicInteger count=new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            Thread t=new Thread(runnable);
            String threadName=CustomThreadPoolExecutor.class.getName()+count
                    .addAndGet(1);
            System.out.println(threadName);
            t.setName(threadName);
            return t;
        }
    }
    private class CustomRejectedExecutionHandler implements
            RejectedExecutionHandler{

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            System.out.println("error");
        }
    }
}
public class TestThread {
    public static void main(String[] args){
        CustomThreadPoolExecutor exec=new CustomThreadPoolExecutor();
        exec.init();
        ExecutorService pool=exec.getCustomThreadPoolExecutor();
        for(int i=1;i<100;i++){
            System.out.println("提交第"+i+"个任务");
            pool.execute(new Runnable() {
                public void run() {
                    try{
                        Thread.sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("Running.....");
                }
            });
        }


        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        BlockingQueue q=new LinkedBlockingQueue() ;
    }
}
