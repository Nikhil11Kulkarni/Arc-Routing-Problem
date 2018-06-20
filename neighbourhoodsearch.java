import java.util.*;
import java.io.*;

public class neighbourhoodsearch {

public solutionCARP currentsolution;
public solutionCARP firstbestsolution;
public solutionCARP totalbestsolution;
public boolean gotanswer ;
public datainput inputNeighbourhood;

public void arcmoving(){
	firstbestsolution=new solutionCARP();
	totalbestsolution=new solutionCARP();


}

public void crossexchange(){
	firstbestsolution=new solutionCARP();
	totalbestsolution=new solutionCARP();

}

public void blockexchange(){
	firstbestsolution=new solutionCARP();
	totalbestsolution=new solutionCARP();


for(int i=0;i<currentsolution.numberoftours;i++){
	int i1=-1;
	int i2=-1;
	for(int j=0;j<currentsolution.finalans.get(i).isrequiredEdge.size()-1;j++){

		if(currentsolution.finalans.get(i).isrequiredEdge.get(j)==false && i1==-1 && i2==-1 && currentsolution.finalans.get(i).isrequiredEdge.get(j+1)==true){
			i1=j;
		}
		else if(currentsolution.finalans.get(i).isrequiredEdge.get(j)==false && i1!=-1 && i2==-1){
			i2=j;
		}
		if(i1!=-1 && i2!=-1){
			//solutionCARP obj=currentsolution ;///HERE I NEED TO CLONE THE OBJECT IN OBJ**********************
			currentsolution.removereplaceupdate(i,i1,i2);//By this function change obj as it will be a solution with less cost than curr 
			//and if not posssible set a boolean false so that we will get to know here and move on as we should  
			i1=-1; i2=-1;
			if(currentsolution.havebetterneighbour==true) gotanswer=true ;
			
		}

		if(gotanswer==true){ firstbestsolution=currentsolution;  break;}//as it is first best
	}

	if(gotanswer==true)break;
}

}


public neighbourhoodsearch(solutionCARP currentsolutionINPUT, datainput input1here){
gotanswer=false;
inputNeighbourhood=input1here;
currentsolution=currentsolutionINPUT;
arcmoving();
if(gotanswer==false){
	currentsolution=currentsolutionINPUT;
	crossexchange();
}
if(gotanswer==false){
	currentsolution=currentsolutionINPUT;
	blockexchange();
}

}//end of the constructor


}//end of public class