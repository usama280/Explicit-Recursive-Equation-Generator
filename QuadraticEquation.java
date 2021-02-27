import java.util.*;

public class QuadraticEquation{
    //creating variables
    private double a, b, c;
    
    //alternate constructor
    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    //finds roots and adds them to arraylist
    public ArrayList<Double> calcRoots(){
        //creates arraylist obj
        ArrayList<Double> list = new ArrayList<Double>();
        //calc determinant
        double determinant = (this.b * this.b) + (-4 * this.a * this.c);
        
        // condition for real and different roots
        if(determinant > 0) {
            list.add((-this.b + Math.sqrt(determinant)) / (2 * this.a));//adds root
            list.add((-this.b - Math.sqrt(determinant)) / (2 * this.a));//adds root
            return list;
            
        }//single root
        else if(determinant == 0) {
            list.add( -this.b / (2 * this.a));//adds root
            return list;
            
        }else{
            return list; //imaginary roots if above fails
        }
    }
}