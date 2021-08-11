package leetcode.aug2021;

public class LC4MedianOfTwoSortedArray {
    
 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     
     /*
      * Need to split the two array such way that,
      * * Both side should have equal numbers
      * * LeftMaxX should be lesser than the rightminY
      * * LeftMaxY should be lesser than the rightMinX.
      * 
      *  If you are able to successfully partition the two arrays, You median would be ,
      *  
      *  In case of Even,
      *  
      *  Avg ( Max(leftMaxX,leftMaxY) , Min(rightMinX,rightMinY) )
      *  
      *  or
      *  Max(leftMaxX,leftMaxY)
      *  
      */
     
     int leftMaxX;
     int rightMaxX;
     int rightMinX;
     int rightMaxY;
    
        
    }

}
