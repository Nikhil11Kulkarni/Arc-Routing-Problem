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

System.out.println("initial solution is: ");
printsolutionCARP printinitialsolution=new printsolutionCARP (myInit.intitailsol);

solutionCARP intialsoltop=new solutionCARP();
intialsoltop=myInit.intitailsol ;
solutionCARP currsoltop=new solutionCARP();
currsoltop=intialsoltop ;
int stoppingcondition=0;

while(stoppingcondition<=50){
	neighbourhoodsearch ansneighbourhood =new neighbourhoodsearch(currsoltop,input1);
	if(ansneighbourhood.gotanswer==false){
		System.out.println("LOCAL OPTIMUM reached here .");
		return 0;
		// tabulist.add(currsoltop) ; //as this is the LOCAL OPTIMUM
		// perturbsolution perturbedneighboursol=new perturbsolution(currsoltop);
		// ansneighbourhood.firstbestsolution=perturbsolution.leastbad ;
		// stoppingcondition++;
	}
//SOME CONDITION TO REDUCE stoppingcodition INTEGER
currsoltop=ansneighbourhood.firstbestsolution;//firstbestsolution--> this is the solutionCARP
System.out.println("first best neighbour :");
printsolutionCARP printinitialsolution=new printsolutionCARP (currsoltop);

}

//HERE THE FINAL CURRSOLTOP WILL BE THE SOLUTION OF OUR CODE ...THEN CALL PRINTSOLUTIONCARP()

  }

}//end of public class

