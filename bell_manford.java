import java.util.Scanner; 
public class bell_manford 
{ 
    public static class node 
        { 
             public int[] dist = new int[20]; 
             public int[] from = new int[20]; 
        } 
        public static void main(String args[]) 
        { 
            node[] routetable = new node[10]; 
            Scanner Read = new Scanner(System.in); 
            int[][] costmat = new int[20][20]; 
            int nodes,count=0; 
            System.out.print("Enter the number of nodes : "); 
            nodes = Read.nextInt(); 
            for(int i=0;i<nodes;i++) 
                routetable[i] = new node(); 
            System.out.print("Enter the cost matrix :\n"); 
            for(int i=0;i<nodes;i++) 
            { 
                for(int j=0;j<nodes;j++) 
                { 
                    costmat[i][j] = Read.nextInt(); 
                } 
            } 
             for(int i=0;i<nodes;i++) 
            { 
                for(int j=0;j<nodes;j++) 
                { 
                   routetable[i].dist[j] = costmat[i][j]; 
                   routetable[i].from[j] = j; 
                } 
            }             
            do 
            { 
                count=0; 
                for(int i=0;i<nodes;i++) 
                {  
                    for(int j=0;j<nodes;j++) 
                    { 
                        for(int k=0;k<nodes;k++) 
                            if(routetable[i].dist[j]>costmat[i][k]+routetable[k].dist[j]) 
                                { 
                                    routetable[i].dist[j]=routetable[i].dist[k]+routetable[k].dist[j]; 
                                    routetable[i].from[j]=k; 
                                    count++;           
                                } 
                    }           
                } 
            }
            while(count!=0); 
            for(int i=0;i<nodes;i++) 
            { 
                System.out.print("\n\n Final Table for router "+(i+1)+"\n"); 
                System.out.print("+--------------------+\n"); 
                System.out.print("Dest    Dist  Hop \n"); 
                System.out.print("+------+-------+----- \n"); 
                for(int j=0;j<nodes;j++) 
                { 
                     System.out.printf("%d%d%d\n",j+1,routetable[i].dist[j],routetable[i].from[j]+1); 
                } 
                System.out.print("+--------------------+\n"); 
            } 
        } 
    }