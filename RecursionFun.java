//Akanshu Singh
/**
 * Complete the seven methods methods in this file using recursion, no loops. 
 * Also complete these three methods inside LinkedList<E>:
 *   get(int)
 *   removeAll(E)
 *   duplicateAll(E)
 *   
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 *   findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will
 * be using this same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Your Name
 */
public class RecursionFun {

  // Complete recursive method combinations that returns from n choose k.
  // This method is described in 17_SimpleRecursion.pptx.
  public int combinations(int n, int k) {
    if (k==1)
    	return n;
    if (n==k)
    	return 1;
    return combinations(n-1,k-1)+combinations(n-1,k);
	  
  }

 
  // Complete recursive method intWithCommas that returns the argument as a String
  // with commas in the correct places.
  //
  // intWithCommas(999) returns "999"
  // intWithCommas(1234) returns "1,234"
  // intWithCommas(1007) returns "1,007"
  // intWithCommas(1023004567) returns "1,023,004,567"
  //
  // Precondition: n >= 0
  public String intWithCommas(int n) {
	  String var;
	  if (n<999) {
		  var=String.valueOf(n);
		  return var;
	  }else {
		  var=String.valueOf(n%1000);
		  if (var.length()==0)
			  var="000";
		  else if (var.length()==1)
			  var="00"+var;
		  else if (var.length()==2)
			  var="0"+var;
			  
		return intWithCommas(n/1000)+","+var;  
	  }
    
  }

  // Write recursive method reverseArray that reverses the array elements in a
  // filled array of ints. Use recursion; do not use a loop. The following
  // assertions must pass:
  //
  // int[] a = { 2, 4, 6 };
  // rf.reverseArray(a);
  // assertEquals(6, a[0]);
  // assertEquals(4, a[1]);
  // assertEquals(2, a[2]);
  //
  // Precondition: x.length > 0
  public void reverseArray(int[] x) {
    // You need a private helper that needs additional arguments.
    // like x and x.length to keep track of array the indexes
    // with no loop. Here is an example with the private helper
    // immediately below.
    reverseArray(x, 0, x.length);
  }

  private void reverseArray(int[] x, int index, int len) {
    // TODO: Complete this method with a recursive algorithm. 
    // Do NOT use a loop.
	  int var;
	  if (index!=(len)/2) {
		  var=x[index];
		  x[index]=x[len-index-1];
		  x[len-index-1]=var;
		  reverseArray(x,index+1,len);
	    
	  }
  }

  // Write recursive method arrayRange that returns the maximum
  // integer minus the minimum integer in the filled array of 
  // integers, Use recursion; do not use a loop. 
  // Precondition: a.length > 0
  public int arrayRange(int[] a) {
	  
    return arrayRange(a,0,a.length);
  }

  private int arrayRange(int[] a, int i, int length) {
	
	  if (a.length==1)
		  return 0;
	  if (a.length==2)
		  return Math.abs(a[0]-a[1]);
	  if (i==length-2) {
		  return Math.abs(a[length-1]-a[length-2]);
	  }
	  else {
		  max1(a,i);
		  return arrayRange(a,i+1,length);
	  }
}




private void max1(int[] a,int i) {
	int var=Math.max(Math.max(a[i], a[i+1]), a[i+2]);
	int var1=Math.min(Math.min(a[i], a[i+1]),a[i+2]);
	a[i+1]=var;
	a[i+2]=var1;
	
}


// Return true if nums has all int elements in ascending order.
  // If not isSorted, return false.
  public boolean isSorted(int[] nums) {
	  
	  return isSorted(nums,0);
  }

  private boolean isSorted(int[] nums, int i) {
	  if (nums.length==0||nums.length==1)
		  return true;
	  if (i==nums.length-1)
		  return true;
	  else {
		  if (nums[i]<=nums[i+1])
			  return isSorted(nums,i+1);
		  else
			  return false;
		  
	  }
	  
}


// Complete method found to return true if search is found in strs.
  // If not found, return false. Use equals, not ==.
  public boolean found(String search, String[] strs) {
     return found(search,strs,0);
  }


private boolean found(String search, String[] strs, int i) {
	if (strs.length==0)
		  return false;
	  if (i==strs.length)
		  return false;
	  else {
		  if (strs[i].equals(search))
			  return true;
		  else
			  return found(search,strs,i+1);
		  
	  }
	
}
}
