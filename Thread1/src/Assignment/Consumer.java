/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo8;

/**
 *
 * @author DIVYANSHU KUMAR
 */
public class Consumer implements Runnable{
    Dummy d;
    Consumer(Dummy d){
        this.d=d;
        new Thread(this,"Consumer Thread").start();
    }
    @Override
    public void run(){
        for(int i=0; i<10 ;i++)
            d.get();
    }
}
