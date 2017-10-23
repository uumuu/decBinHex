package decHexBin;

import java.util.ArrayList;

public class DigitStack <E>{

    int maxSize;
    int top = 0;

    ArrayList<E> digitArray = new ArrayList<>();
    public DigitStack(int n) {
        maxSize = n;
    }

    public boolean isEmpty() {
        if (top == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void push(E input) {
        if (top < maxSize) {
            digitArray.add(input);
            digitArray.set(top, input);
            top ++;
        }
        else {
            System.out.println("Stack overflow.");
        }
    }

    public E pop() {
        if (!this.isEmpty()) {
            E temp = this.peek();
            top--;
            return temp;
        }
        else {
            return null;
        }
    }

    public E peek() {
        if (!this.isEmpty()) {
            return digitArray.get(top-1);
        }
        else{
            return null;
        }
    }
}
