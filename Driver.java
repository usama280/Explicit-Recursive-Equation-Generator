import java.lang.Math; 
import java.util.*;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        //declaring variables
        LHD2Recurrence obj;
        Scanner sc = new Scanner(System.in);
        double r1,r2,a1,a2;
        
        
        //getting user inputs
        System.out.print("Enter r1 (The constant on a(n-1) term: ");
        r1 = sc.nextDouble();
        
        System.out.print("Enter r2 (The constant on a(n-2) term: ");
        r2 = sc.nextDouble();
        
        System.out.print("Enter the first term in the seq: ");
        a1 = sc.nextDouble();
        
        System.out.print("Enter the second term in the seq: ");
        a2 = sc.nextDouble();
        
        //initializing obj of LHD2Recurrence
        obj = new LHD2Recurrence(r1,r2,a1,a2);
        obj.explicitEquation(); //creating explicit equation
        
        
        //try the following code
        try{
            //explicit equation output
            for(int i=1; i<=10; i++){
                System.out.println("a("+i+") = " + Math.round(obj.explicitMethod(i)));
            }
        }catch(Exception e){ // catches excepetion for complex roots
            System.out.println("\n\n" + obj.explicit0Print()+"\n--------------------------------------");
        }
        
        //recursive output
        System.out.println("\n\n"+obj.recursivePrint()+"\n--------------------------------------");
        for(int i=1; i<=10; i++){
            System.out.println("a("+i+") = " + Math.round(obj.recursiveMethod(i)));
        }
        
    }
}
