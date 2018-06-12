import java.util.*;
import java.io.*;

public class neighbourhoodsearch {

public solutionCARP currentsolution;
public solutionCARP firstbestsolution;
public solutionCARP totalbestsolution;
public boolean gotanswer ;


public void arcmoving(){
	firstbestsolution=new solutionCARP();
	totalbestsolution=new solutionCARP();
for(int i=0;i<currentsolution.numberoftours;i++){
	for(int j=0;j<currentsolution.finalans.get(i).isrequiredEdge.size();j++){
		if(currentsolution.finalans.get(i).isrequiredEdge.get(j)==true && j!=0 && j!=(currentsolution.finalans.get(i).isrequiredEdge.size()-1)){
			solutionCARP obj=currentsolution;
			obj.removereplaceupdate(i,j);	//on ith path remove jth edge and update all the solution		

		}
	}

}

}

public void crossexchange(){
	firstbestsolution=new solutionCARP();
	totalbestsolution=new solutionCARP();

}

public void blockexchange(){
	firstbestsolution=new solutionCARP();
	totalbestsolution=new solutionCARP();

}


public neighbourhoodsearch(solutionCARP currentsolutionINPUT){
gotanswer=false;

currentsolution=currentsolutionINPUT;
arcmoving();
if(gotanswer=false){
	currentsolution=currentsolutionINPUT;
	crossexchange();
}
if(gotanswer=false){
	currentsolution=currentsolutionINPUT;
	blockexchange();
}

}//end of the constructor


}//end of public class