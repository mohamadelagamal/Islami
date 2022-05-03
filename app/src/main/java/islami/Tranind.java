package islami;


import android.widget.Switch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Tranind {

    public static void main(String[]args){
    int a []= {2,3,5,9};
    String  item []=new String[50];
//        for (int j = 0 ; j<item.length ; j++){
//           item[j]="afd;sjl";
//        }
        sorting();
        //System.out.println(Arrays.toString(towSum2(a,5)));
    }

    private static int[] towSum(int[] a, int target) {
        for (int i = 0; i<a.length ;i++){
            for (int j = i+1 ; j<a.length ; j++){
                if (a[j]==target-a[i])
                    return new int[]{i,j};
            }
        }
        throw new IllegalArgumentException("not available numbers") ;
    }
    private static int[] towSum2(int[] a, int target) {
        HashMap map = new HashMap<Integer,Integer>();
        for (int i = 0; i < a.length; i++) {
            int comp = target-a[i];
            if(!map.containsKey(comp))
                map.put(a[i],i);
            else
                return new int[]{i,(int)map.get(comp)};
        }
        throw new IllegalArgumentException("not available numbers");
    }
    public static void sorting(){
        int arr[] = new int[33];
        for (int i=1 ; i<33 ; i++ ){
            arr[i] = i ;
        }
       // System.out.println(Arrays.toString(arr));
    }
}
