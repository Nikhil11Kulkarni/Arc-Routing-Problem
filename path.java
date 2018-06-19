import java.util.*;
import java.io.*;
//int totvertex--global total number of vertex

public class path {

public float totalcost;
public float totaldemand ;
public int totalrequiredserved;
public StringBuilder answerpath ; 
public Vector<Integer> answersequence;
public Vector<Boolean> isrequiredEdge ;
public Vector<Float> costsequence;
public Vector<Float> demandsequence;

public path(){
//constructor
	totalcost=0;
	totalrequiredserved=0;
	totaldemand=0;
	answerpath=new StringBuilder();//I THINK THIS IS OF NO IMPORTANT USE
	answersequence=new Vector<Integer>();
	isrequiredEdge=new Vector<Boolean>();
	costsequence=new Vector<Float>();
	demandsequence=new Vector<Float>();

}

public void combinepath(path addingpath){
	this.totalcost=this.totalcost + addingpath.totalcost ;
	this.totaldemand=this.totaldemand + addingpath.totaldemand ;
	this.totalrequiredserved=this.totalrequiredserved + addingpath.totalrequiredserved ;
	this.costsequence.addAll(addingpath.costsequence);
	this.isrequiredEdge.addAll(addingpath.isrequiredEdge);
	this.demandsequence.addAll(addingpath.demandsequence);
int k=0;
while(k<addingpath.answersequence.size()){
	if(k==0 ){
		if(k==0 && this.answersequence.get(this.answersequence.size()-1) !=addingpath.answersequence.get(k) ){
			this.answersequence.add(addingpath.answersequence.get(k));	
		}	
	}
else{
	this.answersequence.add( addingpath.answersequence.get(k));	
}

k++ ;
}
   


}


public void addvertex(int a){
	//char b=(char) a;
	// System.out.println(b+" - ");
	answerpath.append(""+a);
	answerpath.append(" - ");
	if(answersequence.size()==0) answersequence.add(a);
}

public void addremainingpath(StringBuilder ansremaining){
	answerpath.append(ansremaining);
}
public void addremainingcost(float c){
	totalcost=totalcost+c;
}
public void addremainingsequence(Vector<Integer> v1){
	answersequence.addAll(v1);
}
public void addremainingcostsequence(Vector<Float> v1){
	costsequence.addAll(v1);
}
public void addremainingISREQUIREDBOOL(int addNONrequiredbynum){
	for(int i=0;i<addNONrequiredbynum;i++){
		isrequiredEdge.add(false);
		demandsequence.add(0);
	}

}
public void updatereq(reqEdgecl ans1){
	totalcost=totalcost+ans1.cost ;
	totaldemand=totaldemand+ans1.q ;
	totalrequiredserved++ ;
	addvertex(ans1.jvertex);
	answersequence.add(ans1.jvertex);
	isrequiredEdge.add(true);
	demandsequence.add(ans1.q);
	costsequence.add(ans1.cost);
}

public void updatenonreq(nonreqEdgecl ans1){
	totalcost=totalcost+ans1.cost ;
	addvertex(ans1.jvertex);
	answersequence.add(ans1.jvertex);
	isrequiredEdge.add(false);
	demandsequence.add(0);
	costsequence.add(ans1.cost);
}


}//end of public class