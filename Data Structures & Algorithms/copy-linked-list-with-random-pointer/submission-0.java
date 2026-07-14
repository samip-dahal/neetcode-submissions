/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Map<Node, Node> map = getKeyValueMap(head);
        Node tempHead = head;
        
        while (tempHead != null) {
            Node copyNode = map.get(tempHead);
            copyNode.next = map.get(tempHead.next);
            copyNode.random = map.get(tempHead.random);
            tempHead = tempHead.next;
        }
        
        return map.get(head);
    }

    private Map<Node, Node> getKeyValueMap(Node head) {

        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            Node copyNode = new Node(head.val);
            map.put(head, copyNode);
            head = head.next;
        }

        return map;
    }
}
