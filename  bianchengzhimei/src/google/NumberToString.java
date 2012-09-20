package google;

import java.util.LinkedList;
import java.util.List;
//1. 翻译字符串

//字符串映射到数字：a-1, b-2, c-3...y-25,z-26. 现给出一个数字串，要求打印出所有可能的字符。

public class NumberToString{
     
     public static char numberToChar(int high, int low){
          int val = high * 10 + low;
          return (char)('a' + val - 1);
     }

     public static char numberToChar(int i){
          return (char)('a' + i - 1);
     }
     public static List<String> getString(int[] arr, int dep){
          int len = arr.length;
          if(dep >= len)
               return null;
          List<String> list = new LinkedList<String>();
          if(dep < len-1 && (arr[dep] == 1 || (arr[dep] == 2 && arr[dep + 1] < 7))){
               char c = numberToChar(arr[dep], arr[dep + 1]);
               if(dep + 2 < len){
                    List<String> subList = getString(arr, dep + 2);
                    for(String str : subList){
                         list.add(c + str);
                    }
               }else
                    list.add(c + "");
          }

          char c = numberToChar(arr[dep]);
          if(dep + 1 < len){
               List<String> subList = getString(arr, dep + 1);
               for(String str : subList){
                    list.add(c + str);
               }
          }else
               list.add(c + "");
          
          return list;
     }
     
     public static void main(String[] args){
          int[] arr = {1,2,2,5,9};
          List<String> list = getString(arr, 0);
          for(String str : list)
               System.out.println(str);
     }
}

/**
 *m = 12;
 *z = 25 
 */
