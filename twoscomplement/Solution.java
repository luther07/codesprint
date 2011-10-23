import java.io.*;
import java.util.ArrayList;
public class Solution {

  public int fact( int num ) {
    int result = 1;
    for( int i = 1; i <= num; i++) {
      result = i *  result;
    }
    return result;
  }
  public static void main(String [] args){
    int trials = 0;
    String s;
    ArrayList<Integer> trialInfo = new ArrayList<Integer>();
    int range1, range2;
    long runningTotal;
    int tricky1, tricky2;
    double topDifference = 0;

    try{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       s = br.readLine();
       trials = Integer.parseInt(s);
       for(int i = 1; i <= trials; i++) {
         s = br.readLine();
         range1 = Integer.parseInt(s.substring(0, s.indexOf(32)));
         range2 = Integer.parseInt(s.substring(s.indexOf(32) + 1));
         trialInfo.add(new Integer(range1));
         trialInfo.add(new Integer(range2));
       }
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
      }

    //loop for each pair of trial ranges
    for(int t = 1; t<= trials; t++){
      runningTotal = 0;
      range1 = trialInfo.get(2*t-2);
      range2 = trialInfo.get(2*t-1);

      
      //if (range2>(Math.abs(range1)*1000)) {
      //  for(int i = 1; i <= 31; i++) {
      //    if (range2 < (Math.pow(2, i))) {
      //      topDifference = Math.pow(2, i-1);
      //      break;
      //    }
      //  }
      //section where I need to count how many ways to have one 1, two ones, etc and multiply
      //  for(int i = 1; i <= 31; i++)
      //    runningTotal = runningTotal +  
      //}

      // Here we are calculating sums from -x to x-1, because these can be paired, and each pair sums to 32.
      if ((range1<0) && (range2>=0) && (Math.abs(range1)>=Math.abs(range2+1))) {
        runningTotal = runningTotal + (32 * (range2+1));
        tricky1 = range1;
        tricky2 = (-range2) - 2;
      } else if ((range1<0) && (range2>=0) && (Math.abs(range1)<Math.abs(range2))) {
        runningTotal = runningTotal + (32 * (Math.abs(range1)));
        tricky1 = (-range1);
        tricky2 = range2;
      } else {
          tricky1 = range1;
          tricky2 = range2;
      }

      for(int startnum = tricky1; startnum <= tricky2; startnum++) {
        runningTotal = runningTotal + Integer.bitCount(startnum);
      }
      System.out.println(runningTotal);
    } 
  }
}
