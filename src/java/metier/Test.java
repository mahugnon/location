/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import bean.GestionReservation;
import dao.Client;

import dao.Parc;
import dao.Voiture;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author TECHNOPC
 */
public class Test {

    public static void main(String[] args) {
        GestionReservation gr=new GestionReservation();
        Calendar c= Calendar.getInstance();
        Date d1=c.getTime();
        c.add(Calendar.DAY_OF_MONTH, 2);
        Date d2=c.getTime();
        System.out.println(d1+"  "+d2+"  "+ gr.daysBetween(d1, d2));
        
    }     
    
}
