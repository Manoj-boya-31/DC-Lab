import java.io.*;
import java.net.*;
import java.util.*;

class FTPC {

    public static void main(String[] args) throws Exception {
        String option;
        Scanner in = new Scanner(System.in);
        Socket s = new Socket("localhost", 9000);
        System.out.println("MENU");
        System.out.println("1.SEND");
        System.out.println("2.RECEIVE");
        while (true) {
            option = in.nextLine();
            if (option.equals("1")) {
                System.out.println("send command..");
                sendfile(s);
            }

            else if (option.equals("2")) {
                System.out.println("receive command..");
                receivefile(s);
            }

        }
    }

    public static void sendfile(Socket s) throws Exception {
        Scanner in = new Scanner(System.in);
        DataOutputStream cout = new DataOutputStream(s.getOutputStream());
        cout.writeUTF("RECEIVE");
        String filename = in.nextLine();
        System.out.println("Reading File " + filename);
        cout.writeUTF(filename);
        File f = new File(filename);
        FileInputStream fin = new FileInputStream(f);
        int ch;
        do {
            ch = fin.read();
            cout.write(ch);
        } while (ch != -1);
        fin.close();
        System.out.println("File Sent");
    }

    public static void receivefile(Socket s) throws Exception {
        Scanner in = new Scanner(System.in);
        DataInputStream cin = new DataInputStream(s.getInputStream());
        DataOutputStream cout = new DataOutputStream(s.getOutputStream());
        cout.writeUTF("SEND"); // also you can use cout.writeChars("send");
        String filename = in.nextLine();
        cout.writeUTF(filename);
        System.out.println("Receiving File " + filename);  
        File f = new File(filename);
        FileOutputStream fout = new FileOutputStream(f);
        int ch;
        while ((ch = cin.read()) != 255) {
            fout.write(ch);
        }
        System.out.println("Received File...");   
        fout.close();
    }
}