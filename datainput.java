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
public reqEdgeclass[] reqEdge ;
public nonreqEdgeclass[] nonreqEdge ; 


public datainput(String filename){
FileInputStream fstream =new FileInputStream( filename );
Scanner scan =  new Scanner (fstream) ;
numvertex = scan.nextInt();
depotindex=scan.nextInt();
numreq=scan.nextInt();
numnonreq=scan.nextInt();
capacity=scan.nextFloat();

int i1,j1,cost1,demand1,way1,kerb1;
	
	reqEdge=  new reqEdgeclass[numreq] ;
	nonreqEdge=  new nonreqEdgeclass[numnonreq] ;

	for(int i=0;i<numreq;i++){

reqEdge[i]= new reqEdgeclass();

i1=scan.nextInt();
j1=scan.nextInt();
cost1=scan.nextInt();
demand1=scan.nextInt();
way1=scan.nextInt();
kerb1=scan.nextInt();


reqEdge[i].setvertex(i1,j1);
reqEdge[i].setcost(cost1);
reqEdge[i].setdemand(demand1);
reqEdge[i].setway(way1);
reqEdge[i].setkerb(kerb1);


	}



for(int i=0;i<numnonreq;i++){

nonreqEdge[i]= new nonreqEdgeclass();

i1=scan.nextInt();
j1=scan.nextInt();
cost1=scan.nextInt();
way1=scan.nextInt();

nonreqEdge[i].setvertex(i1,j1);
nonreqEdge[i].setcost(cost1);
nonreqEdge[i].setway(way1);

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