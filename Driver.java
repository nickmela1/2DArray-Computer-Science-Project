import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class Driver
{
   public static void main(String[] args) throws IOException
   {
      try
      {
         String typeYourFile = JOptionPane.showInputDialog("Enter the name of the file: ");;
         File file = new File(typeYourFile);
         if (typeYourFile.length() <= 1 || typeYourFile == null || !file.exists())
         {
            JOptionPane.showMessageDialog(null, "File entry is not found or is invalid");
            System.exit(0);
         }
         Scanner inputFile = new Scanner(file);
         int[] array = getRowsColumns(file, typeYourFile);
         double[][] fileArray = loadArray(array, file, typeYourFile);
         TwoDimArray array1 = new TwoDimArray(fileArray, array);
         JOptionPane.showMessageDialog(null, array1.getArrayMinValue() + " is the minimum value" + "\n\n" + array1.getArrayMaxValue() + " is the maximum value");
         JOptionPane.showMessageDialog(null, "Standard deviation:" + "\n\n" + String.format("%.2f", array1.getStandardDeviation()));
         String find = "";
         find = JOptionPane.showInputDialog("Which value would you like to search for?");
         if (find.length() == 0)
         {
            JOptionPane.showMessageDialog(null, "Invalid entry");
         }
         else
         {
            double find1 = Double.parseDouble(find);
            JOptionPane.showMessageDialog(null, "You are searching for " + find + "\n\n" + array1.findValue(find1));
         }
      }
      catch (Exception e)
      {
         JOptionPane.showMessageDialog(null, "Invalid input");
      }
   }
   
   public static double[][] loadArray(int[] array, File file, String theFile) throws IOException
   {
      file = new File(theFile);
      Scanner inputFile = new Scanner(file);
      int rows = array[0];
      int columns = array[1];
      int index = 0;
      double[][] fileArray = new double[rows][columns];
      while (inputFile.hasNextLine())
      {
         String[] arr1 = inputFile.nextLine().trim().split(" ");
         for(int i = 0; i < arr1.length; i++)
         {
            if(index==0)
            {
               continue;
            }
            else
            {
               fileArray[index-1][i] = Double.parseDouble(arr1[i]);               
            }
         }
         index++;
      }
      
      return fileArray;
    
   }
   
   public static int[] getRowsColumns(File file, String theFile) throws IOException
   {
      file = new File(theFile);
      Scanner inputFile = new Scanner(file);
      int index = 0;
      int[] rowsColumns = new int[2];
      while (index == 0)
      {
         String[] arr1 = inputFile.nextLine().trim().split(" ");
         for (int i = 0; i < arr1.length; i++)
         {
            if (index == 0)
            {
               if (i == 0)
               {
                  int rows = Integer.parseInt(arr1[i]);
                  rowsColumns[i] = rows;
               }
               else
               {
                  int columns = Integer.parseInt(arr1[i]);
                  rowsColumns[i] = columns;
                  index++;
               }
            
            }
            
         }
      
      }
      
      return rowsColumns;
   
   }

}