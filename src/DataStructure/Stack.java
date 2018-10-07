package DataStructure;

import Elements.Node;

public class Stack {

    public Node top;

    public Stack(int data) {
        this.top = new Node(data);
    }

    public boolean isEmpty(){
        return (this.top == null);
    }

    public void push(int data){
        Node temp = new Node(data);
        temp.next = this.top;
        this.top = temp;
    }

    public int pop(){
        if(this.top != null) {
            int temp = this.top.data;
            this.top = this.top.next;
            return temp;
        }else{
            System.out.println("No Element in Stack");
            return -1;
        }
    }
     public int peek(){
         if(this.top != null) {
             return this.top.data;
         }else{
             System.out.println("No Element in Stack");
             return -1;
         }
     }

    public void printStack(){
        Node temp = this.top;
        String l = "";
        int n = 0;
        while (temp != null){
            if(n == 0){
                l = Integer.toString(temp.data);
                n++;
                temp = temp.next;
            }else{
                l = l + ',' + Integer.toString(temp.data);
                n++;
                temp = temp.next;
            }
        }
        System.out.println("value of stack is :" + l);
    }
}
