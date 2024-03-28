import java.io.*;
import java.net.*;

class ftps{
    public static void main(String[] args) throws Exception {
        ServerSocket Sock = new ServerSocket(9000);
        Socket s = Sock.accept();
        DataInputStream cin = new DataInputStream(s.getInputStream());
        while (true) {
            String option = cin.readUTF();
            if (option.equals("SEND")) {
                System.out.println("SEND Command Received..");
                sendfile(s);
            }
            else if (option.equals("RECEIVE")) {
                System.out.println("RECEIVE Command Received..");
                receivefile(s);
            }
        }
    }
    public static void sendfile(Socket s) throws Exception {
        DataInputStream cin = new DataInputStream(s.getInputStream());
        DataOutputStream cout = new DataOutputStream(s.getOutputStream());
        String filename = cin.readUTF();
        System.out.println("Reading File " + filename);
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
        DataInputStream cin = new DataInputStream(s.getInputStream());
        String filename = cin.readUTF();
        System.out.println("Receiving File " + filename); // passed this point
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
