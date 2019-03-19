public class DoubleCyclicLinkedList<E> {
private Node<E> head;
private int size;
private Node<E> index;

public DoubleCyclicLinkedList (){
   head = null;
   size = 0;
   index = null;
}

public E go_next(){
if (index == null) return null;
index = index.next;
if (index == null) return null;
return index.data; 
}

public E go_previous(){
if(index == null) return null;
Node<E> tmp = index.pre;
if (tmp == head.pre) return null; 
index = index.pre;
return index.data;
}


public void addFirst(E item){
   Node<E> current = new Node<E> (item, head, null); 
   size++;
   if (head == null) {
     current.pre = current;
   }
   else{
     current.pre = head.pre;
      head.pre = current;
   }
  head = current;   
}

public void addLast(E item){
   Node<E> current = new Node<E> (item, null, null); 
   size++;
   if (head==null) {
      current.pre = current;
      head = current; 
   } 
   else{
      head.pre.next = current;
      current.pre = head.pre;
      head.pre = current;
   }   
}
   
public String toString(){
   Node<E> nodeRef = head;
   StringBuilder result = new StringBuilder();
   while (nodeRef!=null){
      result.append(nodeRef.data);
      if(nodeRef.next!=null)
         result.append(" ==> ");
      nodeRef = nodeRef.next;
   }
   return result.toString();
}


public E getFirst() {
   if (head == null){
      return null;
   }
   else{
      index = head;
      return head.data;
   }
}

public E getLast() {
   if(head == null){
      return null;
   }
   else{
      index = head.pre;
      return head.pre.data;  
   }   
}

public E remove(){
   Node<E> nodeRef = head;
   if (nodeRef != null){
      head = head.next;
      return nodeRef.data;
   }
   else{
      return null;
   }
}

private static class Node<E> {
private E data;
private Node<E> next;
private Node<E> pre;

private Node(E item){
   data = item;
   next = null;
   pre = null;
   }

private Node(E item, Node<E> refNext, Node<E> refPre){
   data = item;
   next = refNext;
   pre = refPre;
}
}
}   