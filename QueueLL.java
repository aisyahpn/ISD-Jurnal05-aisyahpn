import java.util.*;

public class QueueLL<E> {
    private Queue<E> queueList;

    //constructor
    public QueueLL() {
        queueList = new LinkedList<E>();
    }

    public void enqueue(E object) {
        queueList.add(object);
    }

    public E dequeue() throws NoSuchElementException {
        return queueList.remove();
    }

    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    public void printQueue() {
        Iterator<E> it = queueList.iterator();
        while(it.hasNext()) {
            Object value = it.next();

            if (!it.hasNext()) {
                System.out.println(value);
            } else {
                System.out.println(value + " - ");
            }
        }
    }

    public void printTugas1() {
        System.out.println(queueList.peek());
    }
}