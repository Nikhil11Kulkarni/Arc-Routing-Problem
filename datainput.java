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
public reqEdgecl[] reqEdge ;
public nonreqEdgecl[] nonreqEdge ; 
public Vector<Vector<reqEdgecl>> reqEdgematr ;
public Vector<Vector<nonreqEdgecl>> nonreqEdgematr ;


public datainput (String filename){

try{

FileInputStream fstream =new FileInputStream( filename );
Scanner scan =  new Scanner (fstream) ;
numvertex = scan.nextInt();
depotindex=scan.nextInt();
numreq=scan.nextInt();
numnonreq=scan.nextInt();
capacity=scan.nextFloat();


reqEdgematr=new Vector<Vector<reqEdgecl>> ();
nonreqEdgematr=new Vector<Vector<nonreqEdgecl>>() ;
reqEdgematr.setSize(numvertex);
nonreqEdgematr.setSize(numvertex);

int i1,j1,cost1,demand1,way1,kerb1;
	
	reqEdge=  new reqEdgecl[numreq] ;
	nonreqEdge=  new nonreqEdgecl[numnonreq] ;


	for(int i=0;i<numvertex;i++){
Vector<reqEdgecl> temp=new Vector<reqEdgecl>();
reqEdgematr.set(i,temp);	
	}
	for(int i=0;i<numvertex;i++){
Vector<nonreqEdgecl> temp1=new Vector<nonreqEdgecl>();
nonreqEdgematr.set(i,temp1);	
	}

	for(int i=0;i<numreq;i++){

reqEdge[i]= new reqEdgecl();

i1=scan.nextInt();
j1=scan.nextInt();
cost1=scan.nextInt();
demand1=scan.nextInt();
way1=scan.nextInt();
kerb1=scan.nextInt();
if(capacity < demand1){
	System.out.println("\n\n\n CAPACITY IS LESS THAN DEMAND OF EDGE: ("+i1+","+j1+")\n NO Solution\n Please give correct dataset");
	System.exit(0);
}

reqEdge[i].setvertex(i1,j1);
reqEdge[i].setcost(cost1);
reqEdge[i].setdemand(demand1);
reqEdge[i].setway(way1);
reqEdge[i].setkerb(kerb1);



reqEdgematr.elementAt(i1).add(reqEdge[i]); //HERE EXACT CLASS OBJECT IS BEING ADDED
	}



for(int i=0;i<numnonreq;i++){

nonreqEdge[i]= new nonreqEdgecl();

i1=scan.nextInt();
j1=scan.nextInt();
cost1=scan.nextInt();
way1=scan.nextInt();

nonreqEdge[i].setvertex(i1,j1);
nonreqEdge[i].setcost(cost1);
nonreqEdge[i].setway(way1);

nonreqEdgematr.elementAt(i1).add(nonreqEdge[i]); //HERE EXACT CLASS OBJECT IS BEING ADDED

	}

}

catch(FileNotFoundException e){
  System.out.println("file is not here bruh !");
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