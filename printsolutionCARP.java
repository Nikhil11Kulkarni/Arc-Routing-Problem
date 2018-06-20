import java.util.*;
import java.io.*;

public class printsolutionCARP {

//ADD here the bestIn neighborsolution

public printsolutionCARP(solutionCARP asol){
	System.out.println("numberoftours : "+asol.numberoftours);
	System.out.println("costofsolutionCARP : "+asol.costofsolutionCARP);

int pathnumber;	
	for(int i=0;i<asol.numberoftours;i++){
		pathnumber=i+1;
	System.out.println("path "+pathnumber+": "+asol.finalans.get(i).answersequence);
}

}



}//end of public class