import java.util.*;
import java.io.*;
//int totvertex--global total number of vertex

public class reqEdgeclass {


int way, kerb;
int ivertex,jvertex ;
boolean isServiced;
float q; //DEMAND
float cost;


public reqEdgeclass() {

 
 isServiced=false;
 q=0.0;
 cost=0.0;
 
}

public void setvertex(int i1,int j1){ivertex=i1; jvertex=j1;}
public void setway(int way1){way=way1;}
public void setkerb(int kerb1){kerb=kerb1;}
public void setdemand(float demand1){q=demand1;}
public void setcost(float cost1){cost=cost1;}

}//end of public class