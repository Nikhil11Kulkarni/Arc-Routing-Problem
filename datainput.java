import java.util.*;
import java.io.*;

// float[][] q= new float[totvertex][totvertex];
// float[][] cost=new float[totvertex][totvertex];

public class datainput {

public int numvertex;
public int depotindex;
public int numreq;
public int numnonreq;
public float capacity ;

public datainput(String filename){
FileInputStream fstream =new FileInputStream( args[0]) ;
Scanner scan =  new Scanner (fstream) ;
numvertex = scan.nextInt();
depotindex=scan.nextInt();
numreq=scan.nextInt();
numnonreq=scan.nextInt();
capacity=scan.nextFloat();

reqEdgeclass[] reqEdge=new reqEdgeclass[numreq];
int i1,j1,cost1,demand1;

	for(int i=0;i<numreq;i++){

i1=scan.nextInt();
j1=scan.nextInt();
cost1=scan.nextInt();
demand1=scan.nextInt();

reqEdge[i].setvertex(i1,j1);
reqEdge[i].setcost(cost1);
reqEdge[i].setdemand(demand1);
	}



for(int i=0;i<numnonreq;i++){

i1=scan.nextInt();
j1=scan.nextInt();
cost1=scan.nextInt();
// demand1=scan.nextInt();

reqEdge[i].setvertex(i1,j1);
reqEdge[i].setcost(cost1);
// reqEdge[i].setdemand(demand1);
	}




}

// public static void main (String[] args){
// 	try{
// // numvertex
// // depotindex
// // numreq
// // numnonreq
// // Q
// 	}
// catch(FileNotFoundException e){
// 	System.out.println(" Please give input/dataset file");
// }	
// }//end of main	

}			//end of public class