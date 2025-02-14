public class customerList {
    customerNode head;

    public customerList(){
        head = null;
    }

    public boolean isEmpty(){
        if (head == null) return true;
        return false;
    }

    //O(1)
    public void add(customer customer){
        customerNode n = new customerNode(customer);

        if (head == null){
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    //O(N)
    public void insert(customer customer){
        customerNode n = new customerNode(customer);

        if(head == null){
            head = n;
            return;
        }

        if(customer.firstName.compareTo(head.customer.firstName) < 0){
            add(customer);
            n.next = head;
            head = n;
            return;
        }

        customerNode current = head;
        while (current.next != null){
            if(n.customer.firstName.compareTo(current.next.customer.firstName) < 0){
                n.next = current.next;
                current.next = n;
            }
            current = current.next;
        }

        current.next = n;
    }

    //O(N)
    public customer findCustomer(String number){
        if(head == null) return null;

        customerNode current = head;
        while (current != null){
            //if(current.customer.firstName.equals(firstName) && current.customer.lastName.equals(lastName)){
            //    return current.customer;
            //}
            if(current.customer.number.equals(number)){
                return current.customer;
            }
            current = current.next;
        }

        return null;
    }

    //O(N)
    public void print(){
        customerNode current = head;

        while(current != null){
            System.out.println(current.customer);
            current = current.next;
        }
    }
}
