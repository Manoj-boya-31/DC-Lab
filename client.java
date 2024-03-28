import java.io.*;
import java.net.*;
import java.util.*;
class Client 
{
    public static void main(String[] args) throws Exception 
    {
        String option;
        Scanner in = new Scanner(System.in);
        Socket s = new Socket("localhost", 9000);
        System.out.println("MENU");
        System.out.println("1.SEND");
        System.out.println("2.EXIT");
        while (true) 
        {
            option = in.nextLine();
            if (option.equals("1")) 
            {
                sendfile(s);
            }
            else if (option.equals("2")) 
            {
                System.exit(0);
            }

        }
    }
    public static void sendfile(Socket s) throws Exception 
    {
        Scanner in = new Scanner(System.in);
        DataOutputStream cout = new DataOutputStream(s.getOutputStream());
        String filename = in.nextLine();
        System.out.println("Reading File " + filename);
        cout.writeUTF(filename);
        File f = new File(filename);
        FileInputStream fin = new FileInputStream(f);
        int ch;
        do {
            ch = fin.read();
            cout.write(ch);
            } 
        while (ch != -1);
        fin.close();
        System.out.println("File Sent");
    }
}