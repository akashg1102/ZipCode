import java.util.Arrays; 
import java.util.Comparator; 
import java.util.Stack; 
public class ZipCode { 
  
    // The main function that takes a set of intervals, merges overlapped list and print results
    public static void mergeList(Interval arr[])  
    {  
        // Test if the given set has at least one interval  
        if (arr.length <= 0)  
            return;  
    
        // Create an empty stack of intervals  
        Stack<Interval> stack=new Stack<>(); 
    
        // sort the intervals in increasing order  
        Arrays.sort(arr,new Comparator<Interval>(){ 
            public int compare(Interval i1,Interval i2) 
            { 
                return i1.start-i2.start; 
            } 
        }); 
    
        // push the first interval to stack  
        stack.push(arr[0]);  
    
        // Start from the next interval and merge if necessary  
        for (int i = 1 ; i < arr.length; i++)  
        {  
            // get interval from stack top  
            Interval top = stack.peek();  
  
  
            if (top.end < arr[i].start)  
                stack.push(arr[i]);  
      
            else if (top.end < arr[i].end)  
            {  
                top.end = arr[i].end;  
                stack.pop();  
                stack.push(top);  
            }  
        }  
    
        // Print contents of stack  
        System.out.print("Sorry !! Items cannot be shipped to these Zip Codes : "); 
        while (!stack.isEmpty())  
        {  
            Interval t = stack.pop();  
            System.out.print("["+t.start+","+t.end+"] "); 
        }   
    }   
  
    public static void main(String args[]) { 
        Interval arr[]=new Interval[3]; 
        arr[0]=new Interval(94133,94233); 
        arr[1]=new Interval(94200,94299); 
        arr[2]=new Interval(94600,94699); 
        mergeList(arr); 
    } 
} 
  
class Interval 
{ 
    int start,end; 
    Interval(int start, int end) 
    { 
        this.start=start; 
        this.end=end; 
    } 
}