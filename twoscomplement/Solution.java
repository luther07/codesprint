import java.io.*;
public class Solution {
  public static void main(String [] args){
    int trials = 0;
    String s;
    String trialData = new String();
    String first = new String();
    String rest = new String();
    int indx = 0;
    int a;
    int b;
    int ones;
    int runningTotal;

    try{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       s = br.readLine();
       trials = Integer.parseInt(s);
       System.out.println("Number is: " + trials);
       for(int i = 1; i <= trials; i++) {
         s = br.readLine();
         trialData = trialData + s + "\t";
       }
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
      }

    for(int t = 1; t<= trials; t++){
      runningTotal = 0;
      first = trialData.substring(0, trialData.indexOf(9));
      rest = trialData.substring(trialData.indexOf(9)+1);
      trialData = rest;
      a = Integer.parseInt(first.substring(0, first.indexOf(32)));
      b = Integer.parseInt(first.substring(first.indexOf(32)+1));

      for(int startnum = a; startnum <= b; startnum++) {
        ones = 0;
        for(int z=1, myint = startnum; z<=32; z++){
          if(myint == 0) {
            runningTotal = runningTotal + ones;
            break;
          }
          if(myint%2 == 1) ones++;
          myint = myint/2;
        }
      }
      System.out.println(runningTotal);
    } 
  }
}
