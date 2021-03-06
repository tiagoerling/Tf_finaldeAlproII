package supermercado;

public class QueueLinked<E> implements QueueTAD<E>
{
    private static final class Node<E> {
        public E element;
        public Node<E> next;
        
        public Node(E e){
            element = e;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int count;
    
    public QueueLinked()
    {
        head = null;
        tail = null;
        count = 0;        
    }

    @Override
    public int size()
    {
        return count;
    }

    @Override
    public boolean isEmpty()
    {
        return (count == 0);
    }
    
    @Override
    public void clear()
    {
        head = null;
        tail = null;
        count = 0;        
    }

    @Override
    public E element()
    {
        if(isEmpty())
            throw new EmptyQueueException();
        return head.element;
    }
    
    @Override
    public void add(E element)
    {
        Node<E> n = new Node<E>(element);
        if (head == null)
           head = n;
        else
           tail.next = n;
        tail = n;
        count++;        
    }
    
    @Override
    public E remove()
    {
        if(isEmpty())
            throw new EmptyQueueException();
        Node<E> target = head;
        E item = target.element;
        head = target.next;
        target.element = null;
        target.next = null;
        if (head == null)
           tail = null;
        count--;
        return item;            
    }    
}
