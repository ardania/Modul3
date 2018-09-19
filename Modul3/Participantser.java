/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ClassNotFoundException;

/**
 *
 * @author LAB_TI
 */
public class Participantser implements Serializable {

    private String firstName;
    private String lastName;
    private int age;

    public Participantser (String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void printData(){
        System.out.println("Nama\t " + firstName + " " + lastName);
        System.out.println("Usia\t " + age);
    }

    public void saveObject (Participantser Obj){
        try {
            FileOutputStream fos = new FileOutputStream("data.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject (Obj);
            oos.flush();
            oos.close();
        } catch (Exception ioe) {
            System.out.println("a problem accurent during serialize.\n "
                    + ioe.getMessage());
        }
    }

    public void readObject (Participantser Obj) throws ClassNotFoundException{
        try {
            FileInputStream fis = new FileInputStream("data.ser");
            ObjectInputStream ais = new ObjectInputStream(fis);
            Obj = (Participantser) ais.readObject();
            Obj.printData();
            fis.close();
        } catch (IOException ex) {
            System.out.println("a problem accurent during serialize.\n " + ex);
            System.exit(1);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Participantser is = new Participantser("Dee", "aja", 22);
        is.saveObject(is);
        is.readObject(is);
    }
}
