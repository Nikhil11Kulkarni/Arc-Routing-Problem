import java.util.*;
import java.io.*;


public class toplevel {

public static int totreqE,totnonreqE,totvertex; 
public static datainput input1 ;
  
public static void main(String[] args){

input1=new datainput(args[0]);
totreqE=input1.numreq ;
totvertex=input1.numvertex;
totnonreqE=input1.numnonreq;
//System.out.println("total required is :"+totreqE );

initialsolution myInit =new initialsolution(input1);

printsolutionCARP printinitialsolution=new printsolutionCARP (myInit.intitailsol);

solutionCARP intialsoltop=new solutionCARP();
intialsoltop=myInit.intitailsol ;
solutionCARP currsoltop=new solutionCARP();
currsoltop=intialsoltop ;
int stoppingcondition=0;

while(stoppingcondition<=50){
	neighbourhoodsearch firstans =new neighbourhoodsearch(currsoltop);
	if(firstans.gotanswer==false){
		// tabulist.add(currsoltop) ;
		// firstans=perturbsolution(currsoltop);
		// stoppingcondition++;
	}
//SOME CONDITION TO REDUCE stoppingcodition INTEGER
currsoltop=firstans;
}

//HERE THE FINAL CURRSOLTOP WILL BE THE SOLUTION OF OUR CODE ...THEN CALL PRINTSOLUTIONCARP()

  }

}//end of public class

////////////////////////////////COMMENTS:-

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

////////////////////PRINT SOLUTION 
// System.out.println("Cost of solution is: "+myInit.costofsolution);
// for(int j=0;j<myInit.finalans.size();j++){
// 	System.out.print("Tour: "+ (j+1));
// 	System.out.print(" cost: "+ myInit.finalans.get(j).totalcost);
// 	System.out.println(" demand: "+ myInit.finalans.get(j).totaldemand);	
// 	String strprint=myInit.finalans.get(j).answerpath.toString();
// 	System.out.println(strprint);

// }
// System.out.println("game is NOT over");
