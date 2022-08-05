public class LinkList {
    Node headNode;
    Node tailNode;

    public LinkList() {

    }

    public void add(int num1) {
        if (headNode == null) {
            headNode = new Node(num1, headNode);
        } else {
            tailNode = new Node(num1, tailNode);
        }

    }
}
