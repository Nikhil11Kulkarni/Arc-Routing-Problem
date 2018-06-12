import java.util.*;
import java.io.*;


public class toplevel {

 public static int totreqE,totnonreqE,totvertex; ////////////////////////I DONT EHAT WHAT I HAVE WRITTEN HERE ./////
public  reqEdgecl requiredE[] ;
	

public static datainput input1 ;
  
  public static void main(String[] args){

 input1=new datainput(args[0]);
totreqE=input1.numreq ;
totvertex=input1.numvertex;
totnonreqE=input1.numnonreq;

System.out.println("total required is :"+totreqE );


Vector<Vector<reqEdgecl>> obj= input1.reqEdgematr ;

// int dummy;
// for(int i=0;i<totvertex;i++){
// 	dummy=obj.elementAt(i).size() ;
// 	System.out.println("size :"+i+" "+ dummy);
// 	int co=0;

// 	while(dummy!=0){
// 		System.out.println(obj.elementAt(i).get(co).ivertex +" "+obj.elementAt(i).get(co).jvertex);
// 		co++;
// 		dummy--;
// 	}

// }

initialsolution myInit =new initialsolution(input1);
//print here Init.finalans
	System.out.println("Cost of solution is: "+myInit.costofsolution);
for(int j=0;j<myInit.finalans.size();j++){
	System.out.print("Tour: "+ (j+1));
	System.out.print(" cost: "+ myInit.finalans.get(j).totalcost);
	System.out.println(" demand: "+ myInit.finalans.get(j).totaldemand);	
	String strprint=myInit.finalans.get(j).answerpath.toString();
	System.out.println(strprint);

}
System.out.println("game is NOT over");

	//first take input .txt file
 	//give that as input datainput 
 	// requiredE=new reqEdgeclass[totreqE];
// requiredE=input1.reqEdge;
//sort first the edges in reqE and nonreqE
//then go for Hashing
//then form vertex array and make succ
 	//then call initial solution

 	//call neighbourhood local search
 	//then define tabu list 
 	//call implemention of tabu search
  	//call print_result
  }

}//end of public class