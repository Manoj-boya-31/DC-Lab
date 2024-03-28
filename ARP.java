import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Scanner;

public class ARP
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("enter system name:");
            String ipaddr=sc.nextLine();
            InetAddress address=InetAddress.getByName(ipaddr);
            System.out.println("address: "+address);
            NetworkInterface ni=NetworkInterface.getByInetAddress(address);
            if(ni!=null)
            {
                byte[] mac=ni.getHardwareAddress();
                if(mac!=null)
                {
                    System.out.println("MAC address:");
                    for(int i=0;i<mac.length;i++)
                    {
                        System.out.format("%02X%s",mac[i],(i<mac.length-1)?"-":"");
                    }
                }
                else
                {
                    System.out.println("Address doesn't exit");
                }
            }
            else
            {
                System.out.println("Network interface not found");
            }
            sc.close();
        }
        catch(Exception e)
        {
            System.out.println("socket error\n");
        }
    }
}