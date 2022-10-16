import java.util.Scanner;

public class MinimumSpanningTree {


    public int prims(int n,int G[][],int spanning[][])
    {
        int no_of_edges,i,min_cost,j,u,v=0,min_distance,infinity=9999;

        int[][] cost = new int[20][20];
        int[] distance = new int[20];
        int[] from = new int[20];
        int[] visited =  new int[20];

        //create cost[][] matrix,spanning[][]
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
            {
                if(G[i][j]==0)
                    cost[i][j]=infinity;
                else
                    cost[i][j]=G[i][j];

                spanning[i][j]=0;
            }
        //initialise visited[], distance[] and from[]
        distance[0]=0;
        visited[0]=1;

        for(i=1;i<n;i++)
        {
            distance[i]=cost[0][i];
            from[i]=0;
            visited[i]=0;
        }

        min_cost=0; //cost of spanning tree
        no_of_edges=n-1; //no. of edges to be added

        while(no_of_edges>0)
        {
            //find the vertex at minimum distance from the tree
            min_distance=infinity;
            for(i=1;i<n;i++)
                if(visited[i]==0 && distance[i]<min_distance)
                {
                    v=i;
                    min_distance=distance[i];
                }
            u=from[v];
            //insert the edge in spanning tree
            spanning[u][v]=distance[v];
            spanning[v][u]=distance[v];
            no_of_edges--;
            visited[v]=1;
            //updated the distance[] array
            for(i=1;i<n;i++)
                if(visited[i]==0&&cost[i][v]<distance[i])
                {
                    distance[i]=cost[i][v];
                    from[i]=v;
                }
            min_cost=min_cost+cost[u][v];
        }
        return(min_cost);//because its a symmetric matrix we can divide by 2
    }



    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int i,j,total_cost,n,G[][],spanning[][];

        G = new int[20][20];
        spanning = new int[20][20];

        System.out.println("Enter no. of vertices:");
        n = sc.nextInt();

        for(i=0;i<n;i++) {
            for (j = 0; j < n; j++) {
                System.out.print("Enter Value Of Edge From " + (i ) + " to " + (j) + ":");
                G[i][j] = sc.nextInt();
            }
        }

        MinimumSpanningTree pa = new MinimumSpanningTree();

        total_cost=pa.prims(n,G,spanning);

        System.out.println("\nspanning tree matrix:\n");

        for(i=0;i<n;i++)
        {
            System.out.println("\n");
            for(j=0;j<n;j++)
                System.out.print("\t"+spanning[i][j]);
        }
        System.out.print("\n\nTotal cost of spanning tree="+total_cost);
     
    }
}