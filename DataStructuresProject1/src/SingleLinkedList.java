public class SingleLinkedList<E> {
    private Node<E> head = null;

    public void add(E item){
        head = new Node<E>(item, head);
        System.out.println(head);
    }
    
    @Override
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

    public E element(int i) {
        Node<E> nodeRef = head;
        int c = 0;
        while (nodeRef!=null && c<i) {
            nodeRef=nodeRef.next;
            c++;
        }
        if(nodeRef!=null)
            return nodeRef.data;
        else return null;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E item){
            data = item;
            next = null;
        }

        private Node(E item, Node<E> nodeRef){
            data = item;
            next = nodeRef;
        }
    }
}   