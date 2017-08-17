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
public class Dummy{
    int var = 0;
    boolean enable = false;
    public synchronized void set(int var){
        if(!enable){
            this.var=var;
            System.out.println("Produces : #"+this.var);
            enable=true;
            try{
                wait();
                notify();
            }catch(Exception e){}
        }
    }
    public synchronized void get(){
        if(enable){
            System.out.println("Consumes : #"+this.var);
            enable=false;
            notify();
            try{
                wait();
            }catch(Exception e){}
            
        }
    }
}
