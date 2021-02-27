import java.text.DecimalFormat;
import java.util.*;
import java.lang.Math; 

public class LHD2Recurrence{
    //declaring variables
    private double r1, r2, a1, a2, u, v, s1, s2;
    private ArrayList<Double> list;

    DecimalFormat df = new DecimalFormat("##");
    
    //alternate constructor
    public LHD2Recurrence(double r1, double r2, double a1, double a2){
        df.setMinimumFractionDigits(2); //sets min decimals
        df.setMaximumFractionDigits(2); //sets max decimals
        this.r1 = r1;
        this.r2 = r2;
        this.a1 = a1;
        this.a2 = a2;
    }
    
    //if imaginary numbers generated (No formula)
    public String explicit0Print(){
        return "Explicit sequence: Complex root - no formula generated";
    }
    
    //if single root generated (formula)
    public String explicit1Print(){
        return "Explicit sequence: " + "a(n) = " +df.format(u)+ "(" +df.format(s1)+ "^n) + " +df.format(v)+ "(n)(" +df.format(s2)+ "^n)";
    }
    
    //if 2 roots generated (formula)
    public String explicit2Print(){
        return "Explicit sequence: " + "a(n) = " +df.format(u)+ "(" +df.format(s1)+ "^n) + " +df.format(v)+ "(" +df.format(s2)+ "^n)";
    }
    
    //recurive formula
    public String recursivePrint(){
        return "Recursive sequence: " + "a(n) = " +df.format(r1)+ "a(n-1) + " +df.format(r2)+ "a(n-2)   where a(1) = " +df.format(a1)+ " and a(2) = " + df.format(a2);  
    }
    
    //recursive method
    public double recursiveMethod(int a){
        if(a == 1){// base case
            return this.a1;
        }
        else if(a == 2){// base case
            return this.a2;
        }
        
        return this.r1*(recursiveMethod(a-1)) + this.r2*(recursiveMethod(a-2)) ; //recursive
    }
    
    //explicit method
    public double explicitMethod(int n)throws Exception{
        if(this.list.size() == 2){ //2 root formula 
            return (this.u*Math.pow(this.s1,n)) + (this.v*Math.pow(this.s2,n));
            
        }else if(this.list.size() == 1){ //single root formula
            return (this.u*Math.pow(this.s1,n)) + (this.v*n*Math.pow(this.s2,n));
            
        }else{//complex root exception
            throw new Exception();
        }            
    }
    
    //calc explicit form of recursive equation
    public void explicitEquation(){
        //creating QuadraticEquation obj            
        QuadraticEquation quadObj = new QuadraticEquation(1, -r1, -r2);//must be neg because carrying value over from one side of the equation to the other
        this.list = quadObj.calcRoots(); //initialzing arraylist    
        
        // 2 roots
        if(list.size() == 2){
            //sets vals
            this.s1 = list.get(0);
            this.s2 = list.get(1);
            
            //initiates SystemOfTwo obj
            SystemOfTwo sys2 = new SystemOfTwo(this.s1, this.s2, this.a1, this.a2);
            //calc u and v
            Point p = sys2.systemCalc();
            
            //sets vals accordingly
            this.u = p.getX();
            this.v = p.getY();
            
            //prints equation
            System.out.println("\n\n" + this.explicit2Print());
            System.out.println("--------------------------------------");
            
        // single root
        }else if(list.size() == 1){
            //sets vals
            this.s1 = list.get(0);
            this.s2 = list.get(0);
            
            //initiates SystemOfTwo obj
            SystemOfTwo sys2 = new SystemOfTwo(this.s1, this.s2, this.a1, this.a2);
            //calc u and v
            Point p = sys2.systemCalc();
            
            //sets vals accordingly
            this.u = p.getX();
            this.v = p.getY();
            
            //prints equation
            System.out.println("\n\n" + this.explicit1Print());
            System.out.println("--------------------------------------");
            
        }
    }
}