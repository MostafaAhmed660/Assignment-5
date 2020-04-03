package eg.edu.alexu.csd.datastructure.stack.cs;

public class linkedlist {
    Node head ;
    public int size ;

    public static class Node {
        Object data ;
        Node next ;
        Node(Object data){
            this.data = data ;
        }
    }

    /***
     * function to add object "element" at spacial index in linkedkist
     * @param index position where we want to add element
     * @param element
     */
    public void add(int index,Object element){
        if (index > size - 1) {
            System.out.printf("ERROR INVALID INDEX");
        }
        else {
            size++;
            Node mynode = new Node(element);
            if (index == 0) {
                mynode.next = head;
                head = mynode;
            } else {
                Node n = head;
                for (int i = 0; i < index - 1; i++) {
                    n = n.next;
                }
                mynode.next = n.next;
                n.next = mynode;
            }
        }
    }

    /***
     * function to add object "element" at the end of linkedkist
     * @param element
     */
    public void add(Object element){
        size++;
        Node mynode = new Node(element);
        if (head == null){
            head = mynode ;
        }
        else{
            Node n = head ;
            while (n.next != null)
                n=n.next;
            n.next = mynode ;
            mynode.next = null;
        }
    }

    /***
     * function that return a sublist of linkedlist from index1 to index2
     * @param fromIndex index1
     * @param toIndex index2
     * @return
     */
    public linkedlist sublist(int fromIndex, int toIndex){
        linkedlist mylist = new linkedlist();
        if (toIndex > size-1 || fromIndex > toIndex ){
            System.out.printf("ERROR INVALIED INDEXES");
        }
        else {
            Node n = head;
            for (int i = 0; i < fromIndex; i++)
                n = n.next;
            for (int i = fromIndex; i <= toIndex; i++) {
                mylist.add(n.data);
                n = n.next;
            }
        }
        return mylist ;
    }

    /***
     * function to print element in linkedlist
     */
    public void showall(){
        Node node = head ;
        while (node!=null){
            System.out.printf(node.data+" ");
            node = node.next ;
        }
    }

    /***
     * function to retrun the element at given index
     * @param index
     * @return
     */
    public Object get(int index) {
        if (index > size - 1) {
            System.out.printf("ERROR INVALID INDEX");
            return -1 ;
        }
        else {
            Node n = head;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            return n.data;

        }
    }

    /***
     * function to set element on a given index
     * @param index
     * @param element
     */
    public void set(int index,Object element) {
        if (index > size - 1) {
            System.out.printf("ERROR INVALID INDEX");
        }
        else {
            Node n = head;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            n.data = element;
        }
    }

    /***
     * function to clear linkedlist or make it empty
     */
    public void clear(){
        head = null ;
        size = 0 ;
    }

    /***
     * function to check if linkedlist is empty or not
     * @return
     */
    public boolean isEmpty(){
        return (head == null);
    }

    /***
     * function to remove element at given index
     * @param index
     */
    public void remove(int index){
        if (index > size -1)
            System.out.printf("ERROR INVALID INDEX");
        else if (head == null)
            System.out.printf("ERROR LINKEDLIST IS EMPTY");
        else if (index == 0){
            size--;
            head = head.next;
        }
        else {
            size--;
            Node n = head;
            for (int i = 0; i < index-1; i++)
                n = n.next;
            n.next = (n.next).next;
        }
    }

    /***
     * function return the size of the linkedlist
     * @return
     */
    public int size(){
        return size ;
    }

    /***
     * function to check if "o" contains on linkedlist of not "linear search function"
     * @param o element
     * @return
     */
    public boolean contains(Object o){
        Node n = head ;
        while (n != null){
            if (n.data == o)
                return true ;
            n = n.next;
        }
        return false ;
    }
}