///////////////////////////////////////////
//
// Created by Sean M
// to solve Matt Parker's Maths Puzzles #6
//
// Please credit appropriately
// and wash your hands
//
//////////////////////////////////////////

public class MPMP6{

     public static void main(String []args){
        
        int[] fib = {0,1,1,2,3,5,8,13,21,34, 55, 89, 144, 233, 377, 610, 987, 1597,2584,4181,6765,10946,17711,28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309}; //pre-set fibanacci array
        
        ///////////////////////////////////////////
        String balance = "1000000"; //Which total bank balance you want to check
        ///////////////////////////////////////////
        
        long a = Long.parseLong(balance);
        if(a <2) System.out.println("Choose a higher number!");
        System.out.println("\nAnalysing Bank Balance of "+a+"\n");
        
        for(int i=4; i<=fib.length-1; i++){ 
            //Program limited by fibanacci Array length. There's enough there to test up to 1 trillion
            //Start at day 4, because the rest are boring (and break the code)
            
            long min3 = fib[i-3];
            long min1 = fib[i-1];
            long min2 = fib[i-2];
            long min0 = fib[i];
            
            if(i%2==0){
                //Even days
                if((long)(min3*a/min1) >= (long)((min2*a/min0)+1)){
                    /*
                    System.out.println("At i= "+i);
                    System.out.println("Checking fib[i-3]="+min3);
                    System.out.println("Checking fib[i-1]="+min1);
                    System.out.println("Checking fib[i-2]="+min2);
                    System.out.println("Checking fib[i]="+min0);
                    System.out.println("Which gives "+(long)(min3*a/min1));
                    System.out.println("Divided by "+((long)((min2*a/min0)+1)));
                    */
                    
                    long amount = ((long)(min3*a/min1) - (long)((min2*a/min0)+1) +1);
                    
                    long n = (long)(min3*a/min1);
                    long first_dep = min3*a - min1*n;
                    long sec_dep = min0*n - min2*a;
                    
                    if(amount>=2){
                        System.out.println("There are "+amount+" ways to end on day "+i+". E.g. 1st deposit of "+first_dep+", 2nd deposit of "+sec_dep);
                    } else {
                        System.out.println("There is only "+amount+" way to end on day "+i+". This is 1st deposit of "+first_dep+", 2nd deposit of "+sec_dep);
                    }
                } else {
                    //Limit has been reached
                    System.out.println("\nNo options exist for day "+i);
                    break;
                }
            } else {
                //Odd days
                //And some of the bizarre days
                if((long)(min2*a/min0) >= (long)((min3*a/min1)+1) ){
                
                    /*
                    System.out.println("At i= "+i);
                    System.out.println("Checking fib[i-2]="+min2);
                    System.out.println("Checking fib[i]="+min0);
                    System.out.println("Checking fib[i-3]="+min3);
                    System.out.println("Checking fib[i-1]="+min1);
                    System.out.println("Which gives "+(long)(min2*a/min0));
                    System.out.println("Divided by "+(long)((min3*a/min1)+1));
                    */
                    
                    long amount = ((long)(min2*a/min0) - (long)((min3*a/min1)+1) +1);
                    
                    long n = (long)(min2*a/min0);
                    long first_dep = min1*n - min3*a;
                    long sec_dep = min2*a - min0*n;
                    
                    if(amount>=2){
                        System.out.println("There are "+amount+" ways to end on day "+i+". E.g. 1st deposit of "+first_dep+", 2nd deposit of "+sec_dep);
                    } else {
                        System.out.println("There is only "+amount+" way to end on day "+i+". This is 1st deposit of "+first_dep+", 2nd deposit of "+sec_dep);
                    }
                } else {
                    //Limit has been reached
                    System.out.println("\nNo options exist for day "+i);
                    break;
                }
            }
        }
     }
}