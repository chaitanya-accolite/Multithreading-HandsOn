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

public class AppMain{
    public static void main(String[] args) {
        Dummy d= new Dummy();
        new Producer(d);
        new Consumer(d);
    }    
}
