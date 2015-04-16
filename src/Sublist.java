import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;


class Sublist implements Cloneable
{
  // private int sum = 0;
   private ArrayList<Integer> originalObjects;
   private ArrayList<Integer> indices;
   private int sum = 0;
   
   Iterator it = Sublist.iterator();
   
   public ArrayList<Integer> getIndices()
   {
      return indices;
   }

   private static Iterator iterator()
   {
      // TODO Auto-generated method stub
      return null;
   }

   public void setIndices(ArrayList<Integer> indices)
   {
      this.indices = indices;
   }

   // constructor creates an empty Sublist (no indices)
   public Sublist(ArrayList<Integer> list)
   {
      
      originalObjects = list;
      indices = new ArrayList<Integer>();
      int sum = 0;
   }
   int getSum(){return sum;}
   
   
   public void setSum(int sum)
   {
      this.sum = sum;
   }

   int getSumm(Sublist sublist)
   {
      for (int i = 0; i < indices.size(); i++)
      {
         sum += originalObjects.get(indices.get(i));
      }
      
      return sum;
   }
  
   int getSummm(ArrayList<Integer> indices)
   {
      if (indices.size() <= originalObjects.size()){
      
      for (int i = 0; i < indices.size(); i++)
      {
         sum += originalObjects.get(indices.get(i));
      }
      return sum;
   }
      return sum;
   }
   // I have done the clone() for you, since you will need clone() inside
   // addItem().
   public Object clone() throws CloneNotSupportedException
   {
      // shallow copy
      Sublist newObject = (Sublist) super.clone();
      // deep copy
      newObject.indices = (ArrayList<Integer>) indices.clone();
     
      return newObject;
   }

   Sublist addItem(int indexOfItemToAdd) throws CloneNotSupportedException
   {  
    
     
      Sublist s = (Sublist) clone();
      //may need to add indices;
       s.indices.add(0, s.originalObjects.get(indexOfItemToAdd).intValue());
     
     
      return s;
   }
   
   void showSublist()
   {

      System.out.print("Best set is: \n");
      for (int i = 0; i < indices.size(); i++)
      {
         int indice = indices.get(i);
         System.out.print("The original index [" + indice + "] = ");
         System.out.print(originalObjects.get(indice) + ", \n");

      }
   }
};