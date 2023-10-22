import java.util.Arrays;

public class MyStack {

    public int stack[] = new int[10];
    int size = 0;
    int min=0;

    public void push(int newElem) {
        if (stack.length > size) {
            rightShift();
            stack[0] = newElem;
            size++;
            if(min>newElem){
                min=newElem;
            }
        }
        else{
            stack= Arrays.copyOf(stack, stack.length);
            push(newElem);
        }
    }

    public int top() {
        if (size==0) {
           return 0;
        }
        else{
            return stack[0];
        }
    }

    public void pop() {
        if (size!=0) {

        }

    }

    public int getMin(){
        return min;
    }

    private void rightShift(){
        for(int i=size;i>0;i--){
            stack[i+1]=stack[i];
        }
    }

}
