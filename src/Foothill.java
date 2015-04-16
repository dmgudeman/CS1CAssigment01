import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Foothill
{
  static int GIVENSIZE;
  static ArrayList<Integer> dataSet;
  static int maximum = 0;
  static int kBest = 0;
  static int target;
   // ------- main --------------
   public static void main(String[] args) throws Exception
   {
      target = 72;
      boolean checkLimitList;

      dataSet = new ArrayList<Integer>();

      int max = 0;
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
     
      // for formatting and timing
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);
      long startTime, stopTime;

      
      checkLimitList = checkLimitList(dataSet, target);

      startTime = System.nanoTime();
      if (checkLimitList)
      {
         Sublist newSubset = new Sublist(dataSet);
         max = startChecker(max, newSubset);
         makeSubset(newSubset);
         
         stopTime = System.nanoTime();

          // report algorithm time
         System.out.println("\nAlgorithm elapsed time: "
            + tidy.format((stopTime - startTime) / 1e9) + " seconds.\n");
      }
   }
   
   /**
    * Method to check the sum of the subset
    */
   private static int startChecker(int max, Sublist sublist)
   {
      for (int i = 0; i < dataSet.size(); i++)
      {
         int sum = sublist.getSumm(sublist);
         if (sublist.getSumm(sublist) == target)
         {
            
            kBest = i;
            break;
         } 
         else
         {
            if (sum > max && sum <= target)
            {
               System.out.println("THis is getSumm: " + sublist.getSumm(sublist));
               max = sum;
               kBest = i;
            }
         }
      }
      return max;
   }

   /**
    * A method that makes a powerset of all subsets of the original data set
    */
   public static void makeSubset(Sublist newSubset)
         throws CloneNotSupportedException
   {
   
      int baseIndex = 0;
      int offsetIndex = 0;
      int comboIndex = 0;

   
      for (int x = 0; x < GIVENSIZE * GIVENSIZE; x++)
      {
        if (x != 0)  baseIndex = (GIVENSIZE * GIVENSIZE) % x;
        {
           for (int j = 0; j < GIVENSIZE; j++)
           {
             if (j != 0) offsetIndex = (GIVENSIZE) % j;
    
               comboIndex = baseIndex + offsetIndex;
            
               addChecker(comboIndex, newSubset);
           }
        }
     }
   }
   
   private static void addChecker(int comboIndex,
         Sublist newSubset) throws CloneNotSupportedException
   {
      // Sublist topSubset;
      
      int newSum = newSubset.getSum() + dataSet.get(comboIndex);

        if (newSum > maximum
            && newSum< target)
           
         newSubset.setSum(newSum);
        
           
           newSubset.addItem(comboIndex);
      {
       

         System.out.print("\nwith sum of " + newSubset.getSum());
      }
   }
 
   /**
    * helper function to screen for an inadequate dataset
    */
   public static boolean checkLimitList(ArrayList<Integer> list, int target)
         throws CloneNotSupportedException
   {
      int limit = 0;
      int limitSum = 0;
      
      for (int i = 0; i < dataSet.size(); i++)
      {
         limit += dataSet.get(i);
      }
     

      for (int i = 0; i < list.size(); i++)
      {
         limitSum += list.get(i);
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
