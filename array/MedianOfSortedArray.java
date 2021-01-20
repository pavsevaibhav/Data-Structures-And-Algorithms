package array;

public class MedianOfSortedArray {

	//median of two sorted array of different sizes
	private static int medianOfDiffSizes(int[] arr,int[] brr,int n,int m) {
        int min_index = 0,  
                max_index = n, i = 0, 
                j = 0, median = 0; 
              
            while (min_index <= max_index) 
            { 
                i = (min_index + max_index) / 2; 
                j = ((n + m + 1) / 2) - i; 
              
                // if i = n, it means that Elements  
                // from a[] in the second half is an  
                // empty set. and if j = 0, it means  
                // that Elements from b[] in the first 
                // half is an empty set. so it is  
                // necessary to check that, because we 
                // compare elements from these two  
                // groups. Searching on right 
                if (i < n && j > 0 && brr[j - 1] > arr[i])      
                    min_index = i + 1; 
                          
                // if i = 0, it means that Elements 
                // from a[] in the first half is an  
                // empty set and if j = m, it means  
                // that Elements from b[] in the second 
                // half is an empty set. so it is  
                // necessary to check that, because  
                // we compare elements from these two 
                // groups. searching on left 
                else if (i > 0 && j < m && brr[j] < arr[i - 1])      
                    max_index = i - 1; 
          
                // we have found the desired halves. 
                else
                { 
                    // this condition happens when we  
                    // don't have any elements in the  
                    // first half from a[] so we 
                    // returning the last element in  
                    // b[] from the first half. 
                    if (i == 0)          
                        median = brr[j - 1];          
                      
                    // and this condition happens when  
                    // we don't have any elements in the 
                    // first half from b[] so we  
                    // returning the last element in  
                    // a[] from the first half. 
                    else if (j == 0)          
                        median = arr[i - 1];          
                    else    
                        median = Math.max(arr[i - 1],  
                                         brr[j - 1]);          
                    break; 
                } 
            } 
              
            // calculating the median. 
            // If number of elements is odd  
            // there is one middle element. 
            if ((n + m) % 2 == 1) 
                return median; 
                  
            // Elements from a[] in the  
            // second half is an empty set.  
            if (i == n) 
                return (median + brr[j]) / 2; 
                  
            // Elements from b[] in the 
            // second half is an empty set. 
            if (j == m) 
                return (median + arr[i]) / 2; 
              
            return (median + Math.min(arr[i],  
                                     brr[j])) / 2; 
        } 
    //Median of two sorted array of same sizes
	private static int medianOfSameSizes(int[] arr,int[] brr,int startA,int endA,int startB,int endB) {
		if((endA - startA) ==1)
			return (Math.max(arr[startA], brr[startB]) + Math.min(arr[endA], brr[endB]))/2;
		
		/* get the median of the first array */
		int m1 = median(arr,startA,endA);
		/* get the median of the second array */
		int m2 = median(brr,startB,endB);
		/* If medians are equal then return either m1 or m2 */
		if(m1 == m2)
			return m1;
		/* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
		else if(m1 < m2) {
			return medianOfSameSizes(arr, brr, (endA + startA + 1)/2, endA, startB, (endB + startB + 1)/2);
		}
		 /* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
		else
			return medianOfSameSizes(arr, brr, startA, (endA + startA + 1)/2, (endB + startB + 1)/2, endB);
	}
	
	private static int median(int[] arr,int start,int end) {
		int n = (end - start + 1);
		if(n%2==0)
			return (arr[start + n/2] + arr[start + n/2-1]);
		else
			return arr[start + n/2];
	}
}
