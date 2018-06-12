import java.util.*;
import java.io.*;
//int totvertex--global total number of vertex

public class path {

public float totalcost;
public float totaldemand ;
public int totalrequiredserved;
public StringBuilder answerpath ; 
public Vector<Integer> answersequence;


public path(){
//constructor
	totalcost=0;
	totalrequiredserved=0;
	totaldemand=0;
	answerpath=new StringBuilder();
	answersequence=new Vector<Integer>();
}

public void addvertex(int a){
	//char b=(char) a;
	// System.out.println(b+" - ");
	answerpath.append(""+a);
	answerpath.append(" - ");
}

public void addremainingpath(StringBuilder ansremaining){
	answerpath.append(ansremaining);
}
public void addremainingcost(float c){
	totalcost=totalcost+c;
}
public void updatereq(reqEdgecl ans1){
	totalcost=totalcost+ans1.cost ;
	totaldemand=totaldemand+ans1.q ;
	totalrequiredserved++ ;
	addvertex(ans1.jvertex);
	answersequence.add(ans1.jvertex);
}

public void updatenonreq(nonreqEdgecl ans1){
	totalcost=totalcost+ans1.cost ;
	addvertex(ans1.jvertex);
	answersequence.add(ans1.jvertex);
}

}//end of public class