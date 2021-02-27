public class SystemOfTwo{
    //creating variables
    private double c1, c2, a1, cc1, cc2, a2;
    
    //alternate constructor
    public SystemOfTwo(double c1, double c2, double a1, double a2){
        this.c1 = c1;
        this.c2 = c2;
        this.a1 = a1;
        this.a2 = a2;
    }
    
    //simultaneous equation calc.
    public Point systemCalc(){   //a + b = e and c + d = f                   //detx = de-bf  == cc2*a1 - c2*a2  -\
                                //c1 + c2 = a1   cc1 +cc2 = a2              // dety = af-ce  == c1*a2 - cc1*a1  -->  When c1 < cc1 (when c1 > ccl reverse it)
                                                                           //  det = ad-bc  == c1*cc2 - c2*cc1  -/
                                                                            
        //Checks if we have 2 distinct roots
        if (c1 != c2){
            cc1 = c1*c1;
            cc2 = c2*c2;
            
            if(Math.abs(c1) > Math.abs(cc1)){ //checks if c1 > cc1 (reverse of  c1 < ccl)
            
                double det = c2*cc1 - c1*cc2;
                double detx = c2*a2 - cc2*a1;
                double dety = cc1*a1 - c1*a2;
                
                double x = detx / det;
                double y = dety / det;
    
                return new Point(x,y); //sets vals accordingly
            }else{          //checks if c1 < cc1 
            
                double det =  c1*cc2 - c2*cc1;
                double detx = cc2*a1 - c2*a2;
                double dety = c1*a2 - cc1*a1;
                
                double x = detx / det;
                double y = dety / det;
    
                return new Point(x,y); //sets vals accordingly
            }
        }
        //Checks if we have single roots
        else if(c1 == c2){
            cc1 = c1*c1;
            cc2 = 2*c2*c2;
            
            if(Math.abs(c1) > Math.abs(cc1)){ //checks if c1 > cc1 (reverse of  c1 < ccl)
        
                double det = c2*cc1 - c1*cc2;
                double detx = c2*a2 - cc2*a1;
                double dety = cc1*a1 - c1*a2;
                
                double x = detx / det;
                double y = dety / det;
    
                return new Point(x,y); //sets vals accordingly
            }else{      //checks if c1 < cc1 
            
                double det =  c1*cc2 - c2*cc1;
                double detx = cc2*a1 - c2*a2;
                double dety = c1*a2 - cc1*a1;
                
                double x = detx / det;
                double y = dety / det;
    
                return new Point(x,y); //sets vals accordingly
            }
        }else{
            return new Point();  //sets default values
        }
    } 
    
}