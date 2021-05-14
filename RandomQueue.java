import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class RandomQueue<Item> implements Iterable<Item>  {

    private int size;

    //nodes for first and last
    private Node <Item> first;
    private Node <Item> last;

    //Node data structure
    private class Node<Item>
    {
        Item item;
        Node<Item> next;
    }

    // construct an empty randomized queue
    public RandomQueue(){
        size = 0;
        first = null;
        last = null;
    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return(size == 0);
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        if (item == null) {
            throw new NullPointerException("Can't add empty element to rando");
        }

        Node<Item> tmp = last;
        last = new Node <>();
        last.item = item;
        last.next = null;

        //check for empty set
        if(isEmpty()){
            first = last;
        }
        else{
            tmp.next = last;
        }

        size++;
        
    }

    // remove and return a random item
    public Item randoue(){
        //corner case for empty queue
        if(isEmpty()){
            throw new NullPointerException("Can't pull value from empty list"); 
        }
        
        //random number generator from: https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
        int randomNum = ThreadLocalRandom.current().nextInt(1, size + 1);
        Node <Item> tmp = first;
        Node <Item> tmp1 = new Node <>();

        //LOGIC FOR IF FIRST VALUE IS SELECTED
        if(randomNum == 1){
            first = tmp.next;
            size = size - 1;
            return tmp.item;
        }

        //iterate thru list until correct value is found
        for(int i = 1; i < randomNum; i++){
            //save second to last's pointer for when tmp is deleted
            if(i == randomNum - 1){
                tmp1 = tmp;
            }

            tmp = tmp.next;
        }
        
        //jump pointer over removed value
        tmp1.next = tmp.next;
        //decrement size
        size = size - 1;
        return tmp.item;
    }

    // return a random item (but do not remove it)
    public Item sample(){
         //corner case for empty queue
         if(isEmpty()){
            throw new NullPointerException("Can't pull value from empty list"); 
        }
        
        //random number generator from: https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
        int randomNum = ThreadLocalRandom.current().nextInt(1, size + 1);
        Node <Item> tmp = first;

        //LOGIC FOR IF FIRST VALUE IS SELECTED
        if(randomNum == 1){
            return tmp.item;
        }

        //iterate thru list until correct node is reached
        for(int i = 0; i < randomNum - 1; i++){            
            tmp = tmp.next;
        }
        
        return tmp.item;

    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();}
    
    public class ListIterator implements Iterator<Item>{
        // Current iterable element
        public Node<Item> current;

        // Init with first element to start from
        private void RandomQueueIterator(Node<Item> item)
        {
            current = item;
        }

        public boolean hasNext()
        {
            return (current != null);
        }

        public Item next()
        {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }

            Item item = current.item;
            current = current.next;

            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args)
    {
        RandomQueue<String> random = new RandomQueue<>();

        //test the enqueue method
        String word = "Hello";
        random.enqueue(word);

        word = ", world.";
        random.enqueue(word);

        word = "It's";
        random.enqueue(word);

        word = "me.";
        random.enqueue(word);

        //test randoue method
        System.out.println("Random: " + random.randoue());
        System.out.println("Size: " + random.size());

        //test the sample method
        System.out.println("Random: " + random.sample());
        System.out.println("Size: " + random.size());

        

    }

}