package eg.edu.alexu.csd.datastructure.stack.cs;

public class Stack implements IStack{
    linkedlist stack = new linkedlist() ;

    /***
     * fuction return the top of stack after remove it
     * @return
     */
    public Object pop(){
        Object value = stack.get(stack.size-1);
        stack.remove(stack.size-1);
        return value ;
    }

    /***
     * fuction return the top of stack without remove it
     * @return
     */
    public Object peek(){
        return stack.get(stack.size-1);
    }

    /***
     * fuction to take object and push it on the top of stack
     * @param element object that want to push on the top of stack
     */
    public void push(Object element){
        stack.add(element);
    }

    /***
     * function to check if the stack is empty or not
     * @return
     */
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    /***
     * function to return size of stack
     * @return
     */
    public int size(){
        return stack.size;
    }

}
