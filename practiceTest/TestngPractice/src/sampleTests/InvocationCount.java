package sampleTests;


import org.testng.annotations.Test;
import java.util.concurrent.atomic.AtomicInteger;
public class InvocationCount {
  //  AtomicInteger sequence = new AtomicInteger(0);
 int sequence =1;
    @Test(invocationCount = 5, threadPoolSize = 2)
    public void test1(){
       // int count= sequence.addAndGet(1);
        int count =sequence++;
        System.out.println("Test Run Number  "+
                count + " run by Thread  " + Thread.currentThread().getId());
    }
}
