/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.seleniumsample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itexps
 */
public class Exceptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File f=new File("c:\\data\\sample2.txt");
        try{
            FileInputStream fis=new FileInputStream(f);
            char c=(char)fis.read();
        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Exceptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        int x=100;
        int y=0;
        int z=x/y;
        
    }
    
}
