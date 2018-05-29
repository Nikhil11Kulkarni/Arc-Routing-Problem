import java.util.*;
import java.io.*;

public class vertex {


int index ;
int kvisit;
int numsucc;
reqEdgeclass[] succ ;


public vertex() {

 kvisit=0;
numsucc=0;
}

public void setindex(int ind1){index=ind1;}
public void setnumsucc(int kerb1){numsucc=kerb1;}
public void setkvisit(int k1){kvisit=k1;}
public void setsucc(reqEdgeclass[] k1){succ=k1;}


}//end of public class