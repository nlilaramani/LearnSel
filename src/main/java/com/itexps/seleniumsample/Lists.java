/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.seleniumsample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author itexps
 */
public class Lists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List l1=new ArrayList();
        l1.add("Element 1");
        l1.add("Element 2");
        for(Object s:l1){
            System.out.println(s);
        }
        Map m=new HashMap();
        m.put("math", 95);
        m.put("science", 89);
        m.put("english", 85);
        System.out.println(m.get("math"));
        
        
        Date d=new Date();
        System.out.println(d);
        
        SimpleDateFormat df=new SimpleDateFormat();
        df.applyPattern("EEEE, MMMM d, yyyy ' at ' h:m:s");
        System.out.println(df.format(d));
        
        
        try {
            FileWriter writer=new FileWriter("c:\\data\\mytext.txt");
            BufferedWriter bw=new BufferedWriter(writer);
            bw.write("This is my first line\n");
            bw.write("this is sencond line\n");
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
