public class AreaVol {
    
    static double pi = 22.0/7.0;
    public static double areaParallelogram(double base, double height){
        return base*height;
    }
    
    public static double areaRhombus(double diagonal1, double diagonal2){
        return 0.5*diagonal1*diagonal2;
    }

    public static double areaTrapezium(float base1, float base2,float height){
        return ((base1+base2)*height)/2;
    }

    public static double areaCone(double radius, double height){
        double area = pi*radius*(radius+Math.sqrt(radius*radius+height*height));
        return area;
    }

    public static double volCone(double radius,double height){
        return (pi*radius*height*radius/3);
    }

    public static double areaCuboid(double l, double b, double h){
        return (2*(l*b + b*h + h*l));
    }

    public static double volCuboid(double l, double b, double h){
        return l*b*h;
    }

    public static double areaSphere(double radius){
        return 4*pi*radius*radius;
    }

    public static double volSphere(double radius){
        return (4/3)*pi*radius*radius;
    }
}
