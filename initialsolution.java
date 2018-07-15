//AFTER COMPLETIOTN OF THE INITAL SOLUTION --> INPUT1 GETS CONVERTED IN ALLL NON-REQ EDGES 
//SO INPUT1 IS CHANGING ; IF YOU NEED YOU HAVE TO CLONE() IT 

//**check in required
//if not possible or if not present
//go for not required
//add to path
//if capacity is near to reach ## else **
//##dijkstra for all edges from currvertex to depot
//add this object of path to finalans
//go for next path from ** for remaining required edges

//CONFUSION:-- this.numremaining or something else ....

import java.util.*;
import java.io.*;
import java.util.Collections;
//int totvertex--global total number of vertex

public class initialsolution {

//input1 is global
public path answer;
public int nstop ;
public float deltacapacity ;
public int currvertex ;
public Vector<path> finalans ;
public int numremaining ;
public float costofsolution ; // i think this is of no use 
public reqEdgecl ansedge; // i think this is of no use
public Vector<Vector<reqEdgecl>> reqmatrInit;
public Vector<Vector<nonreqEdgecl>> nonreqmatrInit ;
public int numberoftours;
public int[] kthvisit;
public solutionCARP intitailsol;
public datainput input1 ;


//UPDATE ALL ESSENTIALS GIVEN AT THE TOP OF THE INITIAL SOLUTION
// public int initializewithNEG11(int[][] arr){
// 	for(int p=0;p<arr.length;p++){
// 		for(int q=0;q<arr[p].length;q++){
// 			arr[p][q]=-1;
// 		}
// 	}	
// return arr ;

// }

//separate function is given for below as if it is running slower ; don't call it
// public void removedemandZerocycle(){
// 	int[][] arrc1c2=new int[input1.numvertex][input1.numvertex]; //all -1 -1
// 	boolean[] visited=new boolean[input1.numvertex];//all false
// 	Arrays.fill(visited, false);
// 	arrc1c2= initializewithNEG11(arrc1c2);//if here it gives any error try to assign it

// 	for(int i=0;i<this.finalans.size();i++){
// 		for(int j=0;j<this.finalans.get(i).isrequiredEdge.size();j++){
// 			if(this.finalans.get(i).isrequiredEdge.get(j)==false){
// 				if(visited[]==true){}//then remove and proceed
				
// 				else{
// 				visited[this.finalans.get(i).answersequence.get(j)]=true;
// 				arrc1c2[0]=j;					
// 				}
// 			}

// 			else if(this.finalans.get(i).isrequiredEdge.get(j)==true){
// 					Arrays.fill(visited,false);	
// 					arrc1c2= initializewithNEG11(arrc1c2);		
// 			}

// 		}
// 		//again alll false and all -1 -1
// 	Arrays.fill(visited,false);	
// 	arrc1c2= initializewithNEG11(arrc1c2);
// 	}
// }

public void checkinrequired(){
	boolean fits=false ;

	if(reqmatrInit.get(currvertex).size()==0){checkinNONrequired() ;}
	else{
		for(int i=0;i<reqmatrInit.get(currvertex).size();i++){
			if(reqmatrInit.get(currvertex).get(i).q + answer.totaldemand <= input1.capacity ){
				answer.updatereq(reqmatrInit.get(currvertex).get(i));
				reqmatrInit.get(currvertex).get(i).reducekerb();

				int nextvertex =reqmatrInit.get(currvertex).get(i).jvertex ;

				this.costofsolution=this.costofsolution  + reqmatrInit.get(currvertex).get(i).cost;
				if(reqmatrInit.get(currvertex).get(i).kerb==0){//transfer this to non-required
					nonreqEdgecl temp =new nonreqEdgecl();
					temp.setvertex( reqmatrInit.get(currvertex).get(i).ivertex , reqmatrInit.get(currvertex).get(i).jvertex );
					temp.setcost(reqmatrInit.get(currvertex).get(i).cost );
					nonreqmatrInit.get(currvertex).add(temp);
					reqmatrInit.get(currvertex).remove(i);
					this.numremaining--;
				}

				this.currvertex=nextvertex ;

				fits=true;
				this.nstop=0;
			break;
			}

		}
		if(fits==false){checkinNONrequired();}
	}


}

public void checkinNONrequired(){
	// make nonreqmatrInit.get(currvertex) vector sorted on the basis of COST .
	//then go to nonreqmatrInit.get(currvertex).get((kvisit % (nonreqmatrInit.get(currvertex).size()) )) and update all 
	//here make nstop++ -- try to get two functions for stopping/returning to depot 1.bynstop==50  2.by delta capacity < Q/20 (i.e. 5% ) 
	// apply dijkstra on stopping condition and return to depot without servicing anymore

///collections.sort on nonreqmatrInit.get(currvertex)

nonreqmatrInit.get(currvertex).sort(new Comparator<nonreqEdgecl>() {
	@Override
	public int compare(nonreqEdgecl o1, nonreqEdgecl o2) {
		if (o1.cost >= o2.cost) {
			return 1;
		}
		return -1;
	}
});//////////////////////YOU SHOULD NOT SORT THIS IF IT IS ALREADY SORTED ????
if(nonreqmatrInit.get(currvertex).size()==0){
	System.out.println(".."+reqmatrInit.get(currvertex).size());
dijkstra(currvertex);
finalans.add(answer);
}
else
{
int some= (this.kthvisit[currvertex])%(nonreqmatrInit.get(currvertex).size());
this.kthvisit[currvertex]++;
this.nstop ++;
answer.updatenonreq(nonreqmatrInit.get(currvertex).get(some));
this.costofsolution=this.costofsolution + nonreqmatrInit.get(currvertex).get(some).cost ;

this.currvertex=nonreqmatrInit.get(currvertex).get(some).jvertex ;

//ON THE BASIS OF THE NO. OF NON-REQUIRED TRAVERSED
if(nstop==50){
	System.out.println("$$$ 50 nstops $$$");
	dijkstra(currvertex);//gives entire path to the depot
	this.nstop=0;
}
}
//ON THE BASIS OF CAPACITY FULFILLED 7%
// if((input1.capacity*0.93) - answer.totaldemand <0){
// 	dijkstra();
// }

//ON THE BASIS OF THE COST 
// if(answer.totalcost > )

}

public  int minDistance(float dist[], Boolean sptSet[])
    {
        // Initialize min value
        float min = Float.MAX_VALUE;
        int min_index=-1;
 int V=input1.numvertex;
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }

public float findcostbetweenV(int u,int v){ // NOTE: here only we have considered the use of graph 
											// we can add the NONRequired graph+Required graph here to join and then find the path
	 boolean present=false;
	 int maxsize=Math.max(reqmatrInit.get(u).size() , nonreqmatrInit.get(u).size() );
	 //i can add here Vector minimum function so that it will give answer of minimum distance bw src and depot
	 for(int i=0; i<maxsize ; i++){
	 	if(i<nonreqmatrInit.get(u).size()){
	 		if(nonreqmatrInit.get(u).get(i).jvertex==v ){
	 		present=true ;
	 			return nonreqmatrInit.get(u).get(i).cost ; 
	 		}	 		
	 	}
	 	if(i<reqmatrInit.get(u).size()){
	 		if( reqmatrInit.get(u).get(i).jvertex==v ){
	 		present=true ;
	 			return reqmatrInit.get(u).get(i).cost ; 
	 		}	
	 	}


	 }
	 return 0;
}    

public void dijkstra( int src){
	/// make answer upto depot 
	// update all parameters of the answer path
	// update all parameters of  the Init-(i don;t think if we have to update matr )

int kh=0;
        float dist[] = new float[input1.numvertex]; // NOTE:but we won't use it whole coz we will stop loopafter getting depot
 		int V=input1.numvertex;
     	int[] prev=new int[V];
        Boolean sptSet[] = new Boolean[input1.numvertex];
        for (int i = 0; i < V; i++)
        {
            dist[i] = Float.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
		int storeprev=-1;
		prev[src]=storeprev;
        for (int count = 0; count < V; count++)
        {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
 		//System.out.println("minDistance u: "+u);
 		// System.out.println("u: "+u);
         	kh++;
        // prev[u]=storeprev;//as -1 -->src -->
        // storeprev=u;

 if(u==input1.depotindex){

            //updating answer here and going back for next path
StringBuilder remainpathstring=new StringBuilder() ; 
int examprev=u;
//char capp=(char) u;
int capp=u;
int numberofverticestraversedinbacktodepot=0;
Vector<Integer> remainingsequence=new Vector<Integer>();
Vector<Float> remainingcostsequence=new Vector<Float>();

remainingsequence.add(u);

for(int i=0;i<kh;i++){
remainpathstring.append(""+capp);
numberofverticestraversedinbacktodepot++;
remainpathstring.append(" - "); //DOUBLE -- WILL COME IF YOU HAVE APPLIED DIJKSTRA TO COME BACK TO DEPOT 
	capp= prev[examprev];
	if(capp!=(-1)) remainingcostsequence.add((dist[examprev]-dist[capp]));
	 examprev=prev[examprev];

	 if(examprev== (-1)){	remainpathstring.deleteCharAt(remainpathstring.length()-1);
	 						remainpathstring.deleteCharAt(remainpathstring.length()-1);
	 						remainpathstring.deleteCharAt(remainpathstring.length()-1);	
	 						remainpathstring.deleteCharAt(remainpathstring.length()-1);	 						 						
							 numberofverticestraversedinbacktodepot--;
							 remainingsequence.remove(remainingsequence.size()-1);
	 						break;} //REMOVING THINGS THAT I ADDED REPETEADLY
	 remainingsequence.add(examprev);

}//deleteCharAt()

		Collections.reverse(remainingcostsequence);
		Collections.reverse(remainingsequence);
		remainpathstring.reverse();
		answer.addremainingpath(remainpathstring);
		answer.addremainingcostsequence(remainingcostsequence);
		answer.addremainingcost(dist[u]);
		answer.addremainingISREQUIREDBOOL(numberofverticestraversedinbacktodepot);
        answer.addremainingsequence(remainingsequence);
         this.currvertex=u ;
         this.costofsolution=this.costofsolution+dist[u] ;
            	break;
   }

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] &&  (findcostbetweenV(u,v))!=0 &&  dist[u] != Float.MAX_VALUE && dist[u]+(findcostbetweenV(u,v)) < dist[v]){
					prev[v]=u;
                    dist[v] = dist[u] + (findcostbetweenV(u,v));

                }
                   }
        }
       // System.out.println("NO DIJKSTRA PATH FROM "+src+" to depot "+input1.depotindex);
}




public initialsolution(datainput inputtakenfrommain){
///this is a function for class toplevel
	input1=inputtakenfrommain;
	answer=new path();
	currvertex=input1.depotindex ;
 	finalans=new Vector<path>() ;
 	numremaining=input1.numreq; //Total required edges vehicle has to travel
	costofsolution=0;
	reqmatrInit= input1.reqEdgematr ;
	nonreqmatrInit= input1.nonreqEdgematr ;
	numberoftours=0;
	kthvisit=new int[input1.numvertex];
	for(int i=0;i<input1.numvertex;i++){
		kthvisit[i]=0;
	}
	nstop=0;

int checkforcomplete=0;

while(numremaining!=0){

	if (currvertex==input1.depotindex) {
			answer.addvertex(currvertex);
			numberoftours++ ; 
			}

	checkinrequired();
	checkforcomplete=0;

	if(currvertex==input1.depotindex){
		finalans.add(answer);
		answer=new path();
		checkforcomplete=1;
	}

//	System.out.print(currvertex);
}

if(checkforcomplete==0){//we have to return depot
dijkstra(currvertex);
finalans.add(answer);
//System.out.println("..."+answer.answersequence);
}

int k=0;
int totalpathsinfinalans=finalans.size();
for(int count=0;count<totalpathsinfinalans;count++){
	//if demand served by certain path is zero then remove it immediately
	if(finalans.get(k).totaldemand==0){
		this.costofsolution=this.costofsolution - finalans.get(k).totalcost;
		finalans.remove(k);
		k--; }
k++;

}

intitailsol=new solutionCARP();//This is made as final initial solutionCARP to print 
for(int i=0;i<finalans.size();i++){
	intitailsol.addanswerpath(finalans.get(i));
}


}///end of function


}
//end of public class

///////////////////////DEPICTING BELOW AS A FUNCTION////////////////////////////



