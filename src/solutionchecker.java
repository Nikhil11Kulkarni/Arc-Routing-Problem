//check cost addition
// ""********inp-- add removekerb only when demnad!=0

import java.util.*;
import java.io.*;

public class solutionchecker {

public static datainput input10 ;


public solutionchecker(solutionCARP solution1,String filename){
	input10=new datainput(filename);
float totdemand=0;//AS GIVEN BY INPUT
int totalreqnum=0;//total required serving number of required edges
for(int i=0;i<input10.reqEdge.length;i++){
	totdemand=totdemand+((input10.reqEdge[i].q)*(input10.reqEdge[i].kerb));
	totalreqnum=totalreqnum+input10.reqEdge[i].kerb;
}


if(solution1.numberoftours!=solution1.finalans.size())System.out.println(" solution1.numberoftours!=solution1.finalans.size()");

float costcheck=0,demandcheck=0,checkpathcost=0;

for(int i=0;i<solution1.finalans.size();i++){
	checkpathcost=checkpathcost+solution1.finalans.get(i).totalcost;
	for(int j=0;j<solution1.finalans.get(i).costsequence.size();j++){
		costcheck=costcheck+solution1.finalans.get(i).costsequence.get(j);
		demandcheck=demandcheck+solution1.finalans.get(i).demandsequence.get(j);
	}
}
if(demandcheck!=totdemand) System.out.println("demandcheck: "+demandcheck+" totdemand: "+totdemand);
if(costcheck!=solution1.costofsolutionCARP) System.out.println("costcheck: "+costcheck+" solution1.costofsolutionCARP: "+solution1.costofsolutionCARP+" checkpathcost:"+checkpathcost);

float x,y;
for(int i=0;i<solution1.finalans.size();i++){
	for(int j=0;j<solution1.finalans.get(i).answersequence.size()-1;j++){
x=solution1.finalans.get(i).answersequence.get(j);
y=solution1.finalans.get(i).answersequence.get(j+1);
	if(x==y){
		System.out.println("same vertex edge path:"+i+" :x,y: "+x+","+y+";;;;;;;;;");
	}
	for(int p=0;p<input10.reqEdge.length;p++){
		if(input10.reqEdge[p].ivertex==x && input10.reqEdge[p].jvertex==y){
			input10.reqEdge[p].reducekerb();
			if(input10.reqEdge[p].kerb<=0){
				System.out.println("reqEdge: "+x+","+y+" is done");
			}
		}
	}

}
}

for(int k=0;k<input10.reqEdge.length;k++){
	if(input10.reqEdge[k].kerb>0){
		System.out.println("reqEdge: "+input10.reqEdge[k].ivertex+","+input10.reqEdge[k].jvertex+" NOT done for: ");
	}
}



}

}//end of public class


//traverse edfe bt edfe and ca;cu;ate cost and demans total and compate 
//give bool fir ebetu paramaeter