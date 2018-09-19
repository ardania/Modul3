package Modul3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Nomer3 {
    public static void main(String[] args) throws ClassNotFoundException,IOException {
        List<Participant> participants = new ArrayList<Participant>();

        System.out.println("masukkan nama awal ");
        InputStream input=System.in;
        InputStreamReader reader =new InputStreamReader(input);
        BufferedReader bufred=new BufferedReader(reader);
        String firstName=bufred.readLine();
        System.out.println("masukkan nama akhir");
         String lastName=bufred.readLine();
        System.out.println("masukkan usia");
        int usia=Integer.parseInt(bufred.readLine());

        participants.add(new Participant(firstName, lastName, usia));

        System.out.println("Participants :\n" + participants + "\n");

        SerializationDemo demo=new SerializationDemo();
        demo.serialize(participants, "participantData.ser");
        System.out.println("Serialization is Done");

        System.out.println("Deserialization object...");
        List<Participant> newList=demo.deserialize("participantData.ser");
        System.out.println("new list :"+newList);
    }
}
