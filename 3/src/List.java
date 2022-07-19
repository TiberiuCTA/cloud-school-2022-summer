public class List {
    private Node start;
    public class Node{
        private int val;
        private Node next;
        Node(){}
        Node(int val){
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    public List(int val){
        this.start = new Node(val);
    }

    public void printList(){
        Node node = start;
        while(node.next!=null) {
            System.out.println(node.val+" ");
            node = node.next;
        }
        System.out.println(node.val+" ");
    }

    public void add(int val){
        Node node = start;
        while(node.next!=null){
            node = node.next;
        }
        Node aux = new Node(val);
        node.next = aux;
    }

    public int size(){
        Node node = start;
        int size=0;
        while(node.next!=null){
            size++;
            node = node.next;
        }
        size++;
        return size;
    }

    public void addAtPosition(int val, int position) throws Exception {
        if(this.size()<position)
            throw new Exception("position greater than size");

        Node node = start;
        int size=0;
        if(position==0){
            Node aux = new Node(val);
            aux.next = start;
            start = aux;
        }
        else {
            while (node.next != null) {
                if (size == position - 1)
                    break;
                node = node.next;
                size++;
            }
            Node aux = new Node(val);
            Node next = node.next;
            node.next = aux;
            aux.next = next;
        }
    }

    public void inspectPosition(int position) throws Exception {
        if(size()<position)
            throw new Exception("position bigger than size");
        Node node = start;
        int size=0;
        while(node.next!=null){
            if(size==position)
                break;
            node = node.next;
            size++;
        }
        System.out.println(node.val);
    }

    public void setAtPosition(int val, int position) throws Exception {
        if(size()<position)
            throw new Exception("position bigger than size");
        Node node = start;
        int size=0;
        while(node.next!=null){
            if(size==position)
                break;
            node = node.next;
            size++;
        }
        node.setVal(val);
    }

    public void removePosition(int position) throws Exception {
        if(size()<position)
            throw new Exception("position bigger than size");
        Node node = start;
        int size=0;
        while(node.next!=null){
            if(size==position)
                break;
            node = node.next;
            size++;
        }
        node.next = node.next.next;
    }

}
