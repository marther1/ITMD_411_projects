public class Fraction
{
    int num, den; 

    //default constructor
    public Fraction()
    {
        num = 1;
        den = 1;
    }
    //overloaded constructor 
    public Fraction(int n, int d)
    {
        num = n;
        if (d==0) 
        {
            System.out.println( "error- division by zero");
            System.exit(0); // termimate program if division by 0  
        }
        else
            den = d;
    }
    public Fraction Sum(Fraction someFraction)
    {
        int n = someFraction.den+someFraction.num*den;
        int d = den*someFraction.den;
        return new Fraction(n/gcd(n,d),d/gcd(n,d));  //return refreshed member values 
    }


    public Fraction Difference(Fraction someFraction)
    { int n = someFraction.den-someFraction.num*den;
    int d = den*someFraction.den;
    return new Fraction(n/gcd(n,d),d/gcd(n,d)); 
     //code function definition
    }
    public Fraction Multiply(Fraction someFraction)
    { int n = someFraction.num*someFraction.num*num;
    int d = den*someFraction.den;
    return new Fraction(n/gcd(n,d),d/gcd(n,d)); 
     //code function definition
    }
    public Fraction Division(Fraction someFraction)
    { int n = someFraction.den*someFraction.num*num;
    int d = den/someFraction.num;
    return new Fraction(n/gcd(n,d),d/gcd(n,d)); 
     //code function definition 
    }

    //find and return greatest common denominator
    public int gcd(int n, int d)
    {
        int remainder;
        while (d != 0)
        {
            remainder = n % d;
            n = d;
            d = remainder;
        }
        return n;
    }
    public void display() // Display method
    {
    	System.out.println(num + "/" + den);   	 
    }

    public static void main(String [] args)
    {
 
    Fraction frac1 = new Fraction(1,2);
    Fraction frac2 = new Fraction(1,4);
    Fraction fracResult = new Fraction();
    Fraction fracResult1 = new Fraction();
    Fraction fracResult2 = new Fraction();
    Fraction fracResult3 = new Fraction();
    
    fracResult = frac1.Sum(frac2); // Result sb 3/4
    fracResult.display();  
    fracResult1 = frac1.Difference(frac2);     
    fracResult1.display();            
    fracResult2 = frac1.Multiply(frac2);     
    fracResult2.display();           
    fracResult3 = frac1.Division(frac2);     
    fracResult3.display();     
    
    //finish coding to call the Difference, Multiply and division functions
    
    //include also the call to the display function for additional results

    }//end main
}//end class
