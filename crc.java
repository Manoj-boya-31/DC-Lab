import java.util.*;
public class crc
{
    private static int gp[]={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
    void div(int a[],int k)
    {
        int count=0;
        for(int i=0;i<k;i++)
        {
            if(a[i]==gp[0])
            {
                for(int j=i;j<gp.length+i;j++)
                {
                    a[j]=a[j]^gp[count++];
                }
                count=0;
            }
        }
    }
public static void main(String args[])
{
    int a[]=new int[50];
    int b[]=new int[50];
    int len,k;
    crc ob=new crc();
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the length of frame:");
    len=sc.nextInt();
    System.out.println("enter the message");
    for(int i=0;i<len;i++)
    {
        a[i]=sc.nextInt();
    }
    for(int i=0;i<gp.length-1;i++)
    {
        a[len++]=0;
    }
    k=len-(gp.length-1);
    for(int i=0;i<len;i++)
    {
        b[i]=a[i];
    }
    ob.div(a,k);
    for(int i=0;i<len;i++)
    {
        a[i]=a[i]^b[i];
    }
    System.out.println("data to be transmitted:");
    for(int i=0;i<len;i++)
    {
        System.out.print(a[i]+" ");
    }
    System.out.println();
    System.out.println("enter received data");
    for(int i=0;i<len;i++)
    {
        a[i]=sc.nextInt();
    }
    int flag=0;
    ob.div(a,k);
    for(int i=0;i<len;i++)
    {
        if(a[i]!=0)
        {
            flag=1;
            break;
        }
    }
    if(flag==1)
    System.out.println("error in data");
    else
    System.out.println("no error");

    sc.close();
}
}