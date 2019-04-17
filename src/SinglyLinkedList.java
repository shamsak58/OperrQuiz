
public class SinglyLinkedList {

    Node head = null; // head of list

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    class Node {

        int data;
        Node prev,next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to append a new node
    public  SinglyLinkedList append(SinglyLinkedList list, int data)  {


        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;
        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and append the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            // append the new_node at last node
            last.next = new_node;
        }
        // Return the list by head
        return list;
    }


    public  SinglyLinkedList removeTail(SinglyLinkedList list) throws Exception	{

        if	(head == null) {
            System.out.println("Nothing to remove ...");
            throw new Exception("Error removeAll failed nothing to remove ");
        }
        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null || head.next == null) {
            System.out.println("Linked List is empty no tail to remove");
            return list;
        }
        Node node = head;
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        return list;
    }

    public  SinglyLinkedList removeGreater(SinglyLinkedList list, int val) throws Exception {

        if	(head == null) {
            System.out.println("Nothing to remove ...");
            throw new Exception("Error removeAll failed nothing to remove ");
        }
        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null || head.next == null) {
            System.out.println("Linked List is empty no tail to remove");
            return list;
        }
        Node p = head;
        while (p.next != null) {
            if (p.next.data > val) {
                Node np = p.next;
                p.next = np.next;
            } else {
                p = p.next;
            }
        }

        return list;
    }

    // Method to print the LinkedList.
    public  void printList(SinglyLinkedList list) {
        Node currNode = list.head;

        if (currNode == null) {
            System.out.println("\nLinkedList is empty removeAll Passed");
            return;
        }
        // Traverse through the LinkedList
        System.out.print("LinkedList: ");
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }

    // Driver code
    public static void main(String[] args) throws Exception {
        /* Start with the empty list. */
        int gtTest = 5;
        SinglyLinkedList list = new SinglyLinkedList();
        //
        // ******append test******
        //
        // append the values
        list.append(list, 0);
        list.append(list, 1);
        list.append(list, 20);
        list.append(list, 3);
        list.append(list, 4);
        list.append(list, 5);
        list.append(list, 6);
        list.append(list, 71);
        list.append(list, 99);
        System.out.println("Append test "); // Print the LinkedList
        list.printList(list);
        System.out.println("\n  removeTail test ");
        list.removeTail(list);
        list.printList(list);
        System.out.println("\n  removeGreater test value : "+gtTest);
        list.removeGreater(list, gtTest);
        list.printList(list);

    }
}
