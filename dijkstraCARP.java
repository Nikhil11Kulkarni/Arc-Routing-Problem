import java.util.*;
import java.io.*;

public class dijkstraCARP {

public path pathsrctodest ;
public Vector<Vector<reqEdgecl>> reqmatrInit;
public Vector<Vector<nonreqEdgecl>> nonreqmatrInit ;

public  int minDistance(float dist[], Boolean sptSet[])
    {
        // Initialize min value
        float min = Float.MAX_VALUE;
        int min_index=-1;
 int V=input1.numvertex;
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }



public float findcostbetweenV(int u,int v){ // NOTE: here only we have considered the use of graph 
                                            // we can add the NONRequired graph+Required graph here to join and then find the path
     boolean present=false;
     int maxsize=Math.max(reqmatrInit.get(u).size() , nonreqmatrInit.get(u).size() );
     //i can add here Vector minimum function so that it will give answer of minimum distance bw src and depot
     for(int i=0; i<maxsize ; i++){
        if(i<nonreqmatrInit.get(u).size()){
            if(nonreqmatrInit.get(u).get(i).jvertex==v ){
            present=true ;
                return nonreqmatrInit.get(u).get(i).cost ; 
            }           
        }
        if(i<reqmatrInit.get(u).size()){
            if( reqmatrInit.get(u).get(i).jvertex==v ){
            present=true ;
                return reqmatrInit.get(u).get(i).cost ; 
            }   
        }


     }
     return 0;
}    



public void dijkstraCARP( int src , int dest){// i want input1 here
    pathsrctodest =new path();
    /// make answer upto depot 
    // update all parameters of the answer path
    // update all parameters of  the Init-(i don;t think if we have to update matr )

reqmatrInit=toplevel.input1.reqEdgematr;
nonreqmatrInit=toplevel.input1.nonreqEdgematr ;

int kh=0;
        float dist[] = new float[input1.numvertex]; // but we won't use it whole coz we will stop loopafter getting depot
        int V=input1.numvertex;
        int[] prev=new int[V];
        Boolean sptSet[] = new Boolean[input1.numvertex];
        for (int i = 0; i < V; i++)
        {

            dist[i] = Float.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        int storeprev=-1;
        
        for (int count = 0; count < V; count++)
        {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
        // System.out.println("currvertex: "+currvertex);
        // System.out.println("u: "+u);
            kh++;
        prev[u]=storeprev;
        storeprev=u;

        if(u==dest){/////////////////////////

int examprev=u;
int capp=u;
int numberofverticestraversedinbacktodepot=0; //basically equal to nuber of edges added in between src to dest
//number of vertices added in between is "numberofverticestraversedinbacktodepot - 1"
Vector<Integer> remainingsequence=new Vector<Integer>();
Vector<Float> remainingcostsequence=new Vector<Float>();
remainingsequence.add(u);

    for(int i=0;i<kh;i++){

    numberofverticestraversedinbacktodepot++;
    capp= prev[examprev];
    if(capp!=(-1)) remainingcostsequence.add((dist[examprev]-dist[capp]));
     examprev=prev[examprev];

     if(examprev== (-1)){    numberofverticestraversedinbacktodepot--;
                             remainingsequence.remove(remainingsequence.size()-1);
                            break;} //REMOVING THINGS THAT I ADDED REPETEADLY
     remainingsequence.add(examprev);
}
        Collections.reverse(remainingcostsequence);    
        Collections.reverse(remainingsequence);

        for(int k=0;k<numberofverticestraversedinbacktodepot;k++){
            pathsrctodest.demandsequence.add(0);
            pathsrctodest.isrequiredEdge.add(false);
        }

pathsrctodest.totaldemand=0;
pathsrctodest.totalrequiredserved=0;
pathsrctodest.totalcost=dist[dest];
pathsrctodest.answersequence = remainingsequence ;//included dest but not src
pathsrctodest.costsequence=remainingcostsequence;
                break;
//THIS IS GENERATING A PATH WITH "n+1" VERTICES AND "n+1" (EDGES INCLUDING DEST)
//    "-@-@-@-@" = PATH            

   }

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] &&  (findcostbetweenV(u,v))!=0 &&  dist[u] != Float.MAX_VALUE && dist[u]+(findcostbetweenV(u,v)) < dist[v])
                    dist[v] = dist[u] + (findcostbetweenV(u,v));
                }
        }
}


}//end of public class

