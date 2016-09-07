package PhoneBook;

import javax.swing.*;
import java.io.*;

/**
 * Created by Юрий on 07.09.2016.
 */
public class ContactSync extends Thread {

    private boolean alive =true;

    @Override
    public void run() {
           try {
               File inputFile = new File("contacts.txt");
               String line, s;
               line = "";
               BufferedReader readerFromFile = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
               while ((s = readerFromFile.readLine()) != null) {
                   line += s + '\n';
               }
               System.out.println(line);
               readerFromFile.close();
           } catch (IOException ex) {}
       }

    public void stopThread() {
        alive = false;

    }

}

