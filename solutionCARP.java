import java.util.*;
import java.io.*;

public class solutionCARP {

public boolean havebetterneighbour ;
public Vector<path> finalans ;
public int numberoftours;
public float costofsolutionCARP;
public solutionCARP arcmovingbestsol ;
public solutionCARP crossexchangebestsol ;
public solutionCARP blockexchangebestsol ;

//ADD here the bestIn neighborsolution
public removereplaceupdate(int i,int i1,int i2){

				////CLONING
	//MAKKE A COPY PF THIS SOLUTIONCARP HERE......AND USE IT AT 2 PLACES
	//1.BEFORE 2JOINING
	//2.IF NO BEST SOLUTION THEN GET BACK TO COPY
	solutionCARP currcopy=new solutionCARP();
	currcopy.numberoftours=this.numberoftours;
	currcopy.costofsolutionCARP=this.costofsolutionCARP;
	currcopy.havebetterneighbour=false;
		for(int a=0;a<this.finalans.size();a++){
			currcopy.finalans.set(a,finalans.get(a).clone());
		}




	havebetterneighbour=false;

//remove edge join by dijkstra
//replace it somewhere
//compare and update first and best

path removedreqE=new path();//this has to be join in another path (**full of required Edges) 

for(int k=i1;k<=i2;k++){

	float costminus = finalans.get(i).costsequence.get(i1);
	finalans.get(i).costsequence.remove(i1);
	finalans.get(i).totalcost=finalans.get(i).totalcost - costminus ; 



	float demandminus = finalans.get(i).demandsequence.get(i1);
	finalans.get(i).demandsequence.remove(i1);
	finalans.get(i).totaldemand = finalans.get(i).totaldemand - demandminus ;


	if(finalans.get(i).isrequiredEdge.get(i1)==true){ 
		finalans.get(i).totalrequiredserved --;

		removedreqE.totalrequiredserved++;
		removedreqE.isrequiredEdge.add(finalans.get(i).isrequiredEdge.get(i1));
		removedreqE.totalcost=removedreqE.totalcost+costminus;
		removedreqE.costsequence.add(costminus);

	removedreqE.totaldemand=removedreqE.totaldemand+demandminus;
	removedreqE.demandsequence.add(demandminus);

	}

	finalans.get(i).isrequiredEdge.remove(i1);
	if(k!=i1){
		removedreqE.answersequence.add(finalans.get(i).answersequence.get(i1+1));
		finalans.get(i).answersequence.remove(i1+1);
	} 

}



dijkstraCARP pathjoinI1I2=new dijkstraCARP (finalans.get(i).answersequence.get(i1),finalans.get(i).answersequence.get(i1+1));

finalans.get(i).totalcost = finalans.get(i).totalcost + pathjoinI1I2.pathsrctodest.totalcost;
//finalans.get(i).totaldemand = finalans.get(i).totaldemand + pathjoinI1I2.totaldemand;
// as required added is equial to zero so no change in totaldemand and total required
	int p=i1;
for(int int k=0;k<pathjoinI1I2.pathsrctodest.costsequence.size() ;k++){


finalans.get(i).costsequence.add(p, pathjoinI1I2.pathsrctodest.costsequence.get(k));
finalans.get(i).demandsequence.add(p ,pathjoinI1I2.pathsrctodest.demandsequence.get(k) );
finalans.get(i).isrequiredEdge.add( p, pathjoinI1I2.pathsrctodest.isrequiredEdge.get(k));

if(k==0 || k==(pathjoinI1I2.pathsrctodest.costsequence.size()-1)){
	if(k==0 && finalans.get(i).answersequence.get(p) !=pathjoinI1I2.pathsrctodest.answersequence.get(k) ){
			finalans.get(i).answersequence.add(p+1 ,pathjoinI1I2.pathsrctodest.answersequence.get(k));	
	}
	if(k==(pathjoinI1I2.pathsrctodest.costsequence.size()-1) && finalans.get(i).answersequence.get(p+1) !=pathjoinI1I2.pathsrctodest.answersequence.get(k)){
		finalans.get(i).answersequence.add(p+1 ,pathjoinI1I2.pathsrctodest.answersequence.get(k));			
	}	
}
else{
	finalans.get(i).answersequence.add(p+1 ,pathjoinI1I2.pathsrctodest.answersequence.get(k));	
}   
	
 

p++;
}


//apply dijkstra between (vertex i1)i1 to (vertex i2+1)i1+1 
// join it correctly in solutionCARP obj
// now i have required path "removedreqE" updated	//we are now at this step
//apply dijkatr between its j1 to 1st and last to j2 
//again join all 3 correcty
//re-calculate cost and compare 

///HERE I HAVE TWO OPTIONS TO REMOVE NONREQ EDGE WHTHER REMOVE 3 OR REMOVE WHOLE BLOCK 
////TRYING OPTION 1 :-REMOVE 3 NONREQEDGES
for(int k=0;k<numberoftours;k++){
	if(k!=i){	
		int numnonreq=0;
		for(l=0;l<finalans.get(k).isrequiredEdge.size();l++){
				if(finalans.get(k).isrequiredEdge.get(l)==false){
					numnonreq++;
					if(numnonreq==3){


						deletebetweenI1I2(k,l-2 , l+1);
						int dummyfornow=removedreqE.answersequence.size() - 1;
						dijkstraCARP pathjoin1=new dijkstraCARP (finalans.get(k).answersequence.get(l-2),removedreqE.answersequence.get(0));//check here for n Vertices and n+1 Edges
						dijkstraCARP pathjoin2=new dijkstraCARP (removedreqE.answersequence.get(dummyfornow) , finalans.get(k).answersequence.get(l+1)); 
					//i have to join (pathjoin1.path + removedreqE + pathjoin2.path) from "l-2"
						pathjoin1.pathsrctodest.combinepath(removedreqE);//just addAll
						pathjoin1.pathsrctodest.combinepath(pathjoin2.pathsrctodest);
						path pathjoincombined=pathjoin1.pathsrctodest ;
						int numaddingvertices=pathjoincombined.isrequiredEdge.size();//COMPLETE
						joindijkstrapathI1I2(k ,l-2 , l-2+numaddingvertices , pathjoincombined) ;
							float oldcostCARP=this.costofsolutionCARP ;
							this.costofsolutionCARP=0;	
							this.numberoftours=0;
						int p=0;
						for(int pq=0;pq<finalans.size();pq++){
							if(finalans.get(p).totalrequiredserved==0 && finalans.get(p).totaldemand==0){finalans.remove(p); p--;}
							else{this.costofsolutionCARP=this.costofsolutionCARP+finalans.get(p).totalcost ;
									this.numberoftours++;
								} 
							p++;
						}

						if(oldcostCARP>this.costofsolutionCARP){havebetterneighbour=true ;}
						else{
							//get our obj back 2nd cloning need
							//and again try for re-joiing double path combine 
						}
						//delete stuff between l-2 and l+1 vertices 
						//add new dijkstra between l-2 to removedreqE(0) &&& removedreqE(end) to l+1
						//update costofsolutionCARP for object by adding all
						//if good make bool=true and break
						//else keep this going
					}
				}
				else{
					numnonreq=0;
				}
				if(havebetterneighbour==true){break;}

		}
	}
			if(havebetterneighbour==true){break;}	
		
}
//if i don't get a single space to replace OR
//i don't get a single good solution than current
//then make bool false 


}

public void deletebetweenI1I2(int i,int i1,int i2){ /// i1 and i2 should be the vertex of the same path
	//remove edges from i1 to i2-1
	//remove vertex from i1+1 to i2-1 **removing an edge more than vertices 
	//so for joining add one edge more than vertices you add

	for(int k=(i1);k<(i2);k++){

	float costminus = finalans.get(i).costsequence.get(i1);
	finalans.get(i).costsequence.remove(i1);
	finalans.get(i).totalcost=finalans.get(i).totalcost - costminus ; 



	float demandminus = finalans.get(i).demandsequence.get(i1);
	finalans.get(i).demandsequence.remove(i1);
	finalans.get(i).totaldemand = finalans.get(i).totaldemand - demandminus ;


	if(finalans.get(i).isrequiredEdge.get(i1)==true){ 
		finalans.get(i).totalrequiredserved --;
		System.out.println("you are removing requiterd edge without storing it somewhere to re-add");
	}
	finalans.get(i).isrequiredEdge.remove(i1);

	if(k!=i1){
		finalans.get(i).answersequence.remove(i1+1);//correct
	} 

}

}

public void joindijkstrapathI1I2(int i,int i1, int i2, path pathtobejoin){
	finalans.get(i).totalcost = finalans.get(i).totalcost + pathtobejoin.pathsrctodest.totalcost;
finalans.get(i).totaldemand = finalans.get(i).totaldemand + pathtobejoin.totaldemand;

//here it will be   l-2(present) so add from place l-1 in vertices
//in edges add from l-2

	int p=i1;	//l-2
for(int int k=0; k<pathtobejoin.pathsrctodest.costsequence.size() ;k++){

finalans.get(i).costsequence.add(p, pathtobejoin.pathsrctodest.costsequence.get(k));
finalans.get(i).demandsequence.add(p ,pathtobejoin.pathsrctodest.demandsequence.get(k) );
finalans.get(i).isrequiredEdge.add( p, pathtobejoin.pathsrctodest.isrequiredEdge.get(k));
	if(pathtobejoin.pathsrctodest.isrequiredEdge.get(k)==true)	totalrequiredserved++;

if(k==0 || k==(pathtobejoin.pathsrctodest.costsequence.size()-1)){
	if(k==0 && finalans.get(i).answersequence.get(p) !=pathtobejoin.pathsrctodest.answersequence.get(k) ){
			finalans.get(i).answersequence.add(p+1 ,pathtobejoin.pathsrctodest.answersequence.get(k));	
	}
	if(k==(pathtobejoin.pathsrctodest.costsequence.size()-1) && finalans.get(i).answersequence.get(p+1) !=pathtobejoin.pathsrctodest.answersequence.get(k)){
		finalans.get(i).answersequence.add(p+1 ,pathtobejoin.pathsrctodest.answersequence.get(k));			
	}	
}
else{
	finalans.get(i).answersequence.add(p+1 ,pathtobejoin.pathsrctodest.answersequence.get(k));	
}   
	
 

p++;
}
//updates all 7 properties of particular pathS
}



public solutionCARP(){
costofsolutionCARP=0;
numberoftours=0;
finalans=new Vector<path>();
}

public void addanswerpath(path ans1){
numberoftours++;
finalans.add(ans1);
costofsolutionCARP=costofsolutionCARP+ans1.totalcost ;
}

public void addarcmovingbestsol(solutionCARP sol1){
arcmovingbestsol=sol1;
}
public void addcrossexchangebestsol(solutionCARP sol1){
crossexchangebestsol=sol1;
}
public void addblockexchangebestsol(solutionCARP sol1){
blockexchangebestsol=sol1;
}

}//end of public class