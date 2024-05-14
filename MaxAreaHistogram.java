import java.util.Stack;
public class MaxAreaHistogram{
    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = stack.peek();
            }
            stack.push(i);
        }
        stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = stack.peek();
            }
            stack.push(i);
        }
        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = width * height;
            maxArea = Math.max(maxArea, area);
        }
        System.out.println("Maximum Area of Histogram: "+maxArea);
    }

    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        maxArea(arr);
    }
}
