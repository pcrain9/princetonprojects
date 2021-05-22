import java.util.Iterator;

public class DequeAn <Item> implements Iterable<Item> {
    Node first, last;
    int counter = 0;
    
    private class Node{
    Item item;
    Node next;
    }

    // construct an empty deque
    public Deque(){
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return first == null;
    }

    // return the number of items on the deque
    public int size(){
        return counter;
    }

    // add the item to the front
    public void addFirst(Item item){
        //create tmp node
        if(item == null){
            System.out.println("Error: IllegalArgumentException");
            System.exit(2);
        }
        Node tmp = first;
        first = new Node();
        first.item = item;
        first.next = tmp;
        counter++;
    }

    // add the item to the back
    public void addLast(Item item){
        if(item == null){
            System.out.println("Error: IllegalArgumentException");
            System.exit(2);
        }
        Node tmp = last;
        last.item = item;
        last.next = null;
        
        //handle corner case
        if(isEmpty()){
            first = last;
        }
        else {
            tmp.next = last;}
        counter++;
    }

    // remove (pop) and return the item from the front
    public Item removeFirst(){
        //corner case
        if(first == null){
            System.out.println("java.util.NoSuchElementException");
            System.exit(3);
        }
        Item item = first.item;
        first = first.next;
        --counter;
        return item;
        
    }

    // remove and return the item from the back
    public Item removeLast(){
        if(last == null){
            System.out.println("java.util.NoSuchElementException");
            System.exit(3);
        }
        Node tmp = first;
        //corner case
        if(tmp.next.next == null){
            return last.item;
        }
        //Get the second to last item in list
        while(tmp.next.next != null){
            tmp = tmp.next;
        }
        last = tmp;
        --counter;
        return tmp.next.item;
        
       
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){ return new ListIterator();}
        private class ListIterator implements Iterator<Item>{
        private Node <Item> current = first;
        public boolean hasNext(){
            return current != null;
            }
        public void remove(){
            System.out.println("error: UnsupportedErrorOperation");
            System.exit(4);
            }
        public Item next(){
            Item item = current.item;
            current = current.next;

            //check for end of list
            if(current == null){
                System.out.println("error: NoSuchElementException");
                System.exit(3);
                return null;
            }

            return item;
            }

        }
    
    // unit testing (required)
    public static void main(String[] args){
        
    }
}
