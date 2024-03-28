import java.util.*;
import java.io.*;
import java.net.*;

class Server {
    public static void main(String[] args) throws Exception 
    {
        ServerSocket Sock = new ServerSocket(9000);
        Socket s = Sock.accept();
        DataInputStream cin = new DataInputStream(s.getInputStream());
        receivefile(s);
    }
    public static void receivefile(Socket s) throws Exception 
    {
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
