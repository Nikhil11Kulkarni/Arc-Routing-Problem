import java.util.*;
import java.io.*;

public class solutionCARP {

public Vector<path> finalans ;
public int numberoftours;
public float costofsolutionCARP;
public solutionCARP arcmovingbestsol ;
public solutionCARP crossexchangebestsol ;
public solutionCARP blockexchangebestsol ;

//ADD here the bestIn neighborsolution
public removereplaceupdate(int i;int j){

//remove edge join by dijkstra
//replace it somewhere
//compare and update first and best

	finalans.get(i).removeupdate(j);

	for(int k=0;k<numberoftours;k++){
	if(k!=i){
		for(l=0;l<finalans.get(k).isrequiredEdge.size();l++){

		}
	}
		
	}

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