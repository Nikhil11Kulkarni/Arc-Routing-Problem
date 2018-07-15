import java.util.*;
import java.io.*;


public class toplevel {


public static datainput input1 ;
public static Vector<solutionCARP> tabulist ;//trying tenuretabu as 10
public static int checkforlocalOPT ;
public static solutionCARP bestsolutionGLOBAL ; //changed whnever we reach better local optimum than previous


public static void main(String[] args){
	
	long starttime = System.currentTimeMillis();
	input1=new datainput(args[0]);
	checkforlocalOPT=0;//"1" for local optimum then we will take first feasible neighbour solution
	bestsolutionGLOBAL=new solutionCARP();
initialsolution myInit =new initialsolution(input1);
System.out.println("initial solution is: ");
printsolutionCARP printinitialsolution=new printsolutionCARP (myInit.intitailsol);

solutionCARP intialsoltop=new solutionCARP();
intialsoltop=myInit.intitailsol ;
solutionCARP currsoltop=new solutionCARP();
currsoltop=intialsoltop.clone() ;
int stoppingcondition=0;
int tenuretabu=10;
tabulist=new Vector<solutionCARP>();
tabulist.setSize(tenuretabu);

bestsolutionGLOBAL= currsoltop.clone();

while(stoppingcondition<=50){
	neighbourhoodsearch ansneighbourhood =new neighbourhoodsearch(currsoltop,input1);
	if(ansneighbourhood.gotanswer==false){
		System.out.println("\n\nLOCAL OPTIMUM reached here-stoppingcondition: "+stoppingcondition+"\n\n");
		if((currsoltop.costofsolutionCARP < bestsolutionGLOBAL.costofsolutionCARP) ){
			bestsolutionGLOBAL=currsoltop.clone() ;
			stoppingcondition=0;
		}

		checkforlocalOPT=1;
		 ansneighbourhood =new neighbourhoodsearch(currsoltop,input1);
		checkforlocalOPT=0;
		stoppingcondition++;
	}
//SOME CONDITION TO REDUCE stoppingcodition INTEGER
currsoltop=ansneighbourhood.firstbestsolution;//firstbestsolution--> this is the solutionCARP
tabulist.add(0,currsoltop.clone());
System.out.println("first best neighbour :");
printsolutionCARP printcurr=new printsolutionCARP (currsoltop);

}
System.out.println("\n\n\n\n\n\n\n\n\nbest solution :");
printsolutionCARP printcurr=new printsolutionCARP (bestsolutionGLOBAL);

//solutionchecker invoked here
System.out.println("\n\n\n\n\n\n\n\n\nchecker for global is invoked :");
solutionchecker checkglobal=new solutionchecker(bestsolutionGLOBAL,args[0]);

try {//prev code written at last
	PrintWriter out = new PrintWriter(new FileWriter("globaloutput.txt"));
out.println(bestsolutionGLOBAL.numberoftours);
out.println(bestsolutionGLOBAL.costofsolutionCARP);
for(int i=0;i<bestsolutionGLOBAL.finalans.size();i++){
	for(int j=0;j<bestsolutionGLOBAL.finalans.get(i).demandsequence.size();j++){
		if(bestsolutionGLOBAL.finalans.get(i).demandsequence.get(j)>0){
					out.print(bestsolutionGLOBAL.finalans.get(i).answersequence.get(j));
					out.print(" ");
					out.println(bestsolutionGLOBAL.finalans.get(i).answersequence.get(j+1));
				}
	}
	// out.println("");
}
out.close();

}
catch(IOException e){
System.out.println("error in printwriter");
}


long duration = System.currentTimeMillis()-starttime;
System.out.println("Run Time: "+duration);
  }

}//end of public class





////CODE FOR PRINTWRITER
// 	PrintWriter out = new PrintWriter(new FileWriter("globaloutput.txt"));
// out.println(bestsolutionGLOBAL.numberoftours);
// out.println(bestsolutionGLOBAL.costofsolutionCARP);
// for(int i=0;i<bestsolutionGLOBAL.finalans.size();i++){
// 	for(int j=0;j<bestsolutionGLOBAL.finalans.get(i).answersequence.size();j++){
// 		out.print(bestsolutionGLOBAL.finalans.get(i).answersequence.get(j));
// 		out.print(" ");
// 	}
// 	out.println("");
// }
// out.close();