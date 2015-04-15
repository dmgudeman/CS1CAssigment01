import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Foothill
{
  static int GIVENSIZE;
  static ArrayList<Integer> dataSet;
  static int maximum = 0;
   // ------- main --------------
   public static void main(String[] args) throws Exception
   {
      int target = 72;
      boolean checkLimitList;

      dataSet = new ArrayList<Integer>();

      int max = 0, kBest = 0;

      dataSet.add(2);
      dataSet.add(12);
      dataSet.add(22);
      dataSet.add(5);
      dataSet.add(15);
      dataSet.add(25);
      dataSet.add(9);
      dataSet.add(12);
      dataSet.add(29);
      GIVENSIZE = dataSet.size();
      int limit = 0;
      for (int i = 0; i < dataSet.size(); i++)
      {
         limit += dataSet.get(i);
      }
      // for formatting and timing
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);
      long startTime, stopTime;

      checkLimitList = checkLimitList(dataSet, target);

      startTime = System.nanoTime();
      if (checkLimitList)
      {
         ArrayList<Sublist> powerset = makePowerset(dataSet);

         for (int i = 0; i < powerset.size(); i++)
         {
            Sublist set = powerset.get(i);
            int sum = set.getSumm();
            if (sum == target)
            {
               kBest = i;
               break;
            } else
            {
               if (sum > max && sum <= target)
               {
               
                  max = sum;
                  kBest = i;
               }
            }
         }
         System.out.println("The target is " + target + "\n");
         powerset.get(kBest).showSublist();

         System.out.print("\nwith sum of " + powerset.get(kBest).getSumm());
      }
      stopTime = System.nanoTime();

      // report algorithm time
      System.out.println("\nAlgorithm elapsed time: "
            + tidy.format((stopTime - startTime) / 1e9) + " seconds.\n");
   }

   /**
    * A method that makes a powerset of all subsets of the original data set
    */
   public static ArrayList<Sublist> makePowerset(ArrayList<Integer> list)
         throws CloneNotSupportedException
   {
      ArrayList<Sublist> powerset = new ArrayList<Sublist>();
      
      powerset.add(new Sublist(list)); // add the empty set
      // for every item in the original list
      for (int i = 0; i < list.size(); i++)
      {

         ArrayList<Sublist> newPowerset = new ArrayList<Sublist>();
         ArrayList<Sublist> MAXPowerset = new ArrayList<Sublist>();
         Sublist topSubset = new Sublist(list);
         
         Sublist newSubset = new Sublist(list);
       for (int k= 0; k < GIVENSIZE*GIVENSIZE; k++)  
       {       newSubset.addItem(k);
               
        for (int j = 0; j < GIVENSIZE; j = 0)
         {
               newSubset.addItem(j);     
           if (newSubset.getSumm() > maximum) {
              
           }
           
           
         } //close j loop

         // powerset is now powerset of list.subList(0, list.indexOf(item)+1)
         powerset = newPowerset;
      } //close k loop
      return powerset;
      }
      return powerset;
   }

   /**
    * helper function to screen for an inadequate dataset
    */
   public static boolean checkLimitList(ArrayList<Integer> list, int target)
         throws CloneNotSupportedException
   {
      int limitSum = 0;

      for (int i = 0; i < list.size(); i++)
      {
         limitSum += list.get(i);
         // System.out.println(limitSum);
      }
      if (limitSum <= target)
      {
         System.out
               .println("The most this grouping can sum to is: " + limitSum);
         return false;
      }
      return true;
   }
}
