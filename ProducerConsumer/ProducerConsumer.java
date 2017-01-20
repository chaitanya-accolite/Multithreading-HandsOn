package ProducerConsumer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 * Producer and Consumer share a Buffer Queue. 
 * Producer produces and fills in the buffer, thus notifying the consumer otherwise waits when the buffer is full.
 * Consumer consumes and empties the buffer, thus notifying the producer otherwise waits when the buffer is empty.
 * Both Producer and Consumer threads use wait() and notify() to synchronize over 'this' object as a lock since neither 
 * thread owns the monitor to avoid IllegakMonitorStateException. 
 */

public class ProducerConsumer 
{	 
	    List<Integer> buffer = new ArrayList<>();
	    int N = 5;
	 	private Random random = new Random(); 
	 	private Object lock= new Object();

	    public void producerThread() 
	    {
	         while (true)
	         {
	             synchronized (this)
	             {
	                 while (buffer.size()==N)
	                 {
						try 
	                 	{
							System.out.println("Buffer is full. Producer waiting.. ");
							wait();
						} 
	                 	catch (InterruptedException e1) 
	                 	{
							e1.printStackTrace();
						}
	                 }
	                 
	                 //produces random value and fills the buffer
	                 int p = random.nextInt(100);
	                 System.out.println("Producer: "+ p);
	               
	                 buffer.add(p);
	
	                 notify();
	                 try 
	                 {
						Thread.sleep(2000);
					 } 
	                 catch (InterruptedException e) 
	                 {
						e.printStackTrace();
					}
	             }
	         }
	    }

     
     public void consumerThread()
     {
         while (true)
         {
             synchronized (this)
             {
                 while (buffer.size()==0)
                 {
					 try 
	                 {
						 System.out.println("Buffer is empty. Consumer waiting.. ");
						 wait();
					 } 
	                 catch (InterruptedException e1) 
	                 {
						  e1.printStackTrace();
					 }
                 }

                 //empties the buffer queue
                 int c = buffer.remove(0);

                 System.out.println("Consumer: "+ c);

                 notify();
                 
                 try 
                 {
					Thread.sleep(2000);
				 } 
                 catch (InterruptedException e) 
                 {
                	 e.printStackTrace();
				 }

             }
         }
     }

     public void main() 
     {
        Thread t1 = new Thread(new Runnable()
        {	          
            public void run()
            {
                producerThread();
            }
        });
 
        Thread t2 = new Thread(new Runnable()
        {
            public void run()
            {
 				consumerThread();			 
            }
        }); 
       
        t1.start();
        t2.start();

        try 
        {
			t1.join();
			t2.join();
		} 
        catch (InterruptedException e) 
        {		
			e.printStackTrace();
		}	   
     }
}

