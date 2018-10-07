package DataStructure;

import Elements.Node;

public class LinkedList {

    Node head;

    public void insertData(int data){
        Node temp = this.head;
        if(this.head == null){
            this.head = new Node(data);
        }else{
            while(temp.next!= null){
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
        System.out.println("data added to list :"+data);
    }

    public void removeData(){
        Node temp = this.head;
        if(this.head == null){
            System.out.println("No data");
        }else if (this.head.next == null){
            System.out.println("Data is removed : "+this.head.data);
            this.head = null;
        }else{
            while(temp.next.next!= null){
                temp = temp.next;
            }
            System.out.println("Data is removed : "+temp.next.data);
            temp.next = null;
        }
    }

    public LinkedList reverse(){
        if (this.head == null){
            System.out.println("stack is empty");
        }
        else if (this.head.next == null){
            System.out.println("the stack is having only one element");
        }else{
            Node prev = null;
            Node succ = this.head.next;
            while(succ != null){
                if(prev == null){
                    prev = this.head;
                    prev.next = null;
                }else {
                    prev = this.head;
                }
                this.head = succ;
                succ = succ.next;
                this.head.next = prev;
            }
        }
        return this;
    }
}
