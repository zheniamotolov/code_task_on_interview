import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepCopyOfLinkedListWIthRandomPointer {

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node2.random=node1;
        node3.random=node5;
        node4.random=node3;
        node5.random=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        int i=9;
        do{
            // what you want to do
            i++;
            System.out.println(i);
        }while(i<2);

        List<Node> list = new ArrayList<>();
        Collections.addAll(list, node1,node2,node3,node4,node5);
        Node node_new = copyRandomList(node1);
        System.out.println(node_new);


    }
    public static Node copyRandomList(Node head) {
        Node new_head=head;
        Map<Node,Node> map = new HashMap<>();

        while(new_head!=null){
            map.put(new_head,new Node(new_head.val));
            new_head=new_head.next;
        }
        new_head=head;
        while(new_head!=null){
            Node temp=map.get(new_head);
            temp.random=map.get(temp.random);
            new_head=new_head.next;
        }

        return map.get(head);
    }
}
