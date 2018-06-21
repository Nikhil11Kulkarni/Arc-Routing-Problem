import java.util.*;
import java.io.*;

public class printsolutionCARP {

//ADD here the bestIn neighborsolution

public printsolutionCARP(solutionCARP asol){

//temporary code
float td=0;
	for(int p=0;p<asol.finalans.size();p++){
		td=td+asol.finalans.get(p).totaldemand ;
	}
//temporary code
	System.out.println("numberoftours : "+asol.numberoftours);
	System.out.println("costofsolutionCARP : "+asol.costofsolutionCARP+"  demandS: "+td);

int pathnumber;	
if(asol.finalans.size()!=asol.numberoftours){System.out.println("############################");}
	for(int i=0;i<asol.finalans.size();i++){
		pathnumber=i+1;
	System.out.println("path "+pathnumber+": "+"demand: "+asol.finalans.get(i).totaldemand+"cost: "+asol.finalans.get(i).totalcost );
	System.out.println("route:( "+asol.finalans.get(i).answersequence.size()+") :"+asol.finalans.get(i).answersequence);
	System.out.println("costS:( "+asol.finalans.get(i).costsequence.size()+") :"+asol.finalans.get(i).costsequence);
	System.out.println("deman:( "+asol.finalans.get(i).demandsequence.size()+") :"+asol.finalans.get(i).demandsequence);
	
	
}

	System.out.println("\n ");

}



}//end of public class