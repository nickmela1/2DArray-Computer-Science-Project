import java.io.*; 
import java.lang.Math;
import java.util.*;

public class TwoDimArray
{   
   private double[][] _twoDimArray;
   private int _columns, _rows;
   private double maxValue, minValue, standardDev, findValue, replace, replaceAll, loadArray;
      
   public TwoDimArray(double[][] twoDimArray, int[] rowColArray)
   {
      
      _twoDimArray = twoDimArray;
      _rows = rowColArray[0];
      _columns = rowColArray[1];
   }
  
   public double getArrayMinValue()
   {
      for(int i = 0; i < _twoDimArray.length; i++)
      {
         for(int j = 0; j <= _twoDimArray.length; j++)
         {
            if(i == 0 && j == 0)
            {
               minValue = _twoDimArray[i][j];
            }
            if(_twoDimArray[i][j] < minValue)
            {
               minValue = _twoDimArray[i][j];
            }
         }
      }
      return minValue;
   }
   
   public double getArrayMaxValue()
   {
      for(int i = 0; i < _twoDimArray.length; i++)
      {
         for(int j = 0; j <= _twoDimArray.length; j++)
         {
            if(i == 0 && j == 0)
            {
               maxValue = _twoDimArray[i][j];
            }
            if (_twoDimArray[i][j] > maxValue)
            {
               maxValue = _twoDimArray[i][j];
            }
         }
      }
      return maxValue;
   }
   
   public double getStandardDeviation()
   {
      // get average
      double xbar = 0;
      //keep count of how many elements for our n      
      int n = 0;
      for(int i = 0; i < _twoDimArray.length; i++)
      {
         for(int j = 0; j <= _twoDimArray.length; j++)
         {
            xbar += _twoDimArray[i][i];
            n++;
         }
      }
      xbar = xbar/n;
      // get the sum of all x minus xbar
      double sumXMinusXbar = 0;
      double num = 0;
      for(int i = 0; i < _twoDimArray.length; i++)
      {
         for(int j = 0; j <= _twoDimArray.length; j++)
         {
            if(i!=0)
            {
               num =  _twoDimArray[i][i] - xbar;
               sumXMinusXbar += Math.pow(num,2)/n;
            }         
         }
      }      
      double stdDev = Math.sqrt(sumXMinusXbar);      
      return stdDev;
   }
   
   public String findValue(double value)
   {
      List<String> toReturn = new ArrayList();
      String notFound = ("Not found");
      for(int i = 0; i < _twoDimArray.length; i++)
      {
         for(int j = 0; j <= _twoDimArray.length; j++)
         {
            if(_twoDimArray[i][j] == value)
            {
               String str = "Found " + value + " at position "+ i + "," + j;
               toReturn.add(str);
               String str1 = toReturn.toString();
               return str1;
            }       
         }
      }
      return notFound;
   }
      
}