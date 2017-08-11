package test.com.thread.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
* ThreadPoolCatchTest Tester. 
* 
* @author <Authors name> 
* @since <pre>八月 11, 2017</pre> 
* @version 1.0 
*/ 
public class ThreadPoolCatchTest {

@Before
public void before() throws Exception {
} 

@After
public void after() throws Exception { 
}
    @Test
    public void test1()
    {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("hello world !");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.out.println(" ===> main Thread execute here ! " );
    }


} 
