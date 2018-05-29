import java.util.*;
import java.io.*;


public class toplevel {

  int totreqE,totnonreqE; 
  reqEdgeclass[] requiredE ;
	vertex vertexarr ;
  
  public static void main(String[] args){



	//first take input .txt file
 	//give that as input datainput 
datainput input1=new datainput(args[0]);
totreqE=input1.numreq ;
totnonreqE=input1.numnonreq;
requiredE=new reqEdgeclass[totreqE];
requiredE=input1.reqEdge;


//sort first the edges in reqE and nonreqE
for (int i=0;i<totreqE;i++){
requiredE[i].iverttex ;/*HERE I WILL USE INBUILT HASMAPS FOR EVERY IVERTEX AND HASH(IVERTEX) SHOULD POINT TO A  ARRAY OF VERTEX(IVERTEX,LAMBDA)*/
} 

//then go for Hashing

vertexarr=new vertex[input1.numvertex];

for(int i=0;i<input1.numvertex;i++){
vertexarr[i].setindex(i);
vertexarr[i].setnumsucc(/*get size of hashmap corresponding ith index*/);

// public void setnumsucc(int kerb1){numsucc=kerb1;}
// public void setkvisit(int k1){kvisit=k1;}
// public void setsucc(reqEdgeclass[] k1){succ=k1;}

}

//then form vertex array and make succ
 	//then call initial solution
 	//call neighbourhood local search
 	//then define tabu list 
 	//call implemention of tabu search
  	//call print_result
  }

}//end of public class