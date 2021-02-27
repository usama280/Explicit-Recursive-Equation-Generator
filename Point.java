public class Point{
    //declaring variables
    private double x, y;
    
    //defualt constructor
    public Point(){
        this.x = 0.0;
        this.y = 0.0;
    }
    
    //alternate constructor
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    //returns x val
    public double getX(){
        return x;
    }
    
    //return y val
    public double getY(){
        return y;
    }
    
    //set x val
    public void setX(double x){
        this.x = x;
    }
    
    //set y val
    public void setY(double y){
        this.y = y;
    }
}