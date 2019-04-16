
class Node_T<T>  {

    private T value;
    private Node_T<T> nextRef;

    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public Node_T<T> getNextRef() {
        return nextRef;
    }
    public void setNextRef(Node_T<T> ref) {
        this.nextRef = ref;
    }

}



public class SinglyLinkedList<T> {

    private Node_T<T> head;
    private Node_T<T> tail;

    public void append(T element) throws Exception{

        if  (element == null) {
            System.out.println("Nothing to append ...");
            throw new Exception("Error append(T element)  failed nothing to append ");
        }
        Node_T<T> nd = new Node_T<T>();
        nd.setValue(element);
        System.out.println("Adding: "+element);
        /**
         * check if the list is empty
         */
        if(head == null){
            //since there is only one element, both head and
            //tail points to the same object.
            head = nd;
            tail = nd;
        } else {
            //set current tail next link to new Node_T
            tail.setNextRef(nd);
            //set tail as newly created Node_T
            tail = nd;
        }
    }



    public void removeAll() throws Exception   {

        if	(head == null) {
            System.out.println("Nothing to remove ...");
            throw new Exception("Error removeAll failed nothing to remove ");
        }
        Node_T<T> backup = null;
        while (head != null) {
            backup = head.getNextRef();
            head = null;
            head = backup;
        }
        tail = null;
    }

    public void removeTail() throws Exception {

        if	(head == null) {
            System.out.println("Nothing to remove ...");
            throw new Exception("Error removetail - failed nothing to remove ");
        }
        Node_T<T> node = head;
        while (node.getNextRef().getNextRef() != null) {
            node = node.getNextRef();
        }
        tail = node;
        node.setNextRef(null);

    }



    public void traverse()  {

        if (head == null && tail == null) {
            System.out.println("SinglyLinkedList Empty");
            return;
        }
        Node_T<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNextRef();
        }
    }

    public static void main(String a[]) throws Exception{
        SinglyLinkedList<Integer> quiz1 = new SinglyLinkedList<Integer>();
        quiz1.append(13);
        quiz1.append(132);
        quiz1.append(333);
        quiz1.append(222);
        quiz1.append(99);
        quiz1.traverse();
        System.out.println("Test Remove Tail");
        quiz1.removeTail();
        quiz1.traverse();
        System.out.println("Test Remove All");
        quiz1.removeAll();
        quiz1.traverse();


    }
}

