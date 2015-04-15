import java.util.ArrayList;

class Sublist implements Cloneable
{
  // private int sum = 0;
   private ArrayList<Integer> originalObjects;
   private ArrayList<Integer> indices;
   private int sum = 0;
   
   public ArrayList<Integer> getIndices()
   {
      return indices;
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

   int getSumm()
   {
      int sum = 0;
      for (int i = 0; i < indices.size(); i++)
      {
         sum += originalObjects.get(indices.get(i));
      }
      return sum;
   }
   
   int getSummm(ArrayList<Integer> indices)
   {
      int sum = 0;
      for (int i = 0; i < indices.size(); i++)
      {
         sum += originalObjects.get(indices.get(i));
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
     
      this.sum = getSummm(this.indices);
      indices.add(indexOfItemToAdd);
      Sublist s = (Sublist) clone();
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