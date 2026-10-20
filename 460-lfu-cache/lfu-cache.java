import java.util.HashMap;
import java.util.Map;

class LFUCache {
    
    class Node {
        int key, val, freq;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
    
    class DoublyLinkedList {
        Node head, tail;
        int listSize;
        
        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            listSize = 0;
        }
        
        void addNode(Node node) {
            Node nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
            listSize++;
        }
        
        void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
        
        Node removeTail() {
            if (listSize > 0) {
                Node tailNode = tail.prev;
                removeNode(tailNode);
                return tailNode;
            }
            return null;
        }
    }

    private final int capacity;
    private int minFreq;
    private int currSize;
    private final Map<Integer, Node> cache;
    private final Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.currSize = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        updateFreq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;
        
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            updateFreq(node);
            return;
        }
        
        if (currSize >= capacity) {
            DoublyLinkedList minFreqList = freqMap.get(minFreq);
            Node toRemove = minFreqList.removeTail();
            cache.remove(toRemove.key);
            currSize--;
        }
        
        currSize++;
        minFreq = 1;
        Node newNode = new Node(key, value);
        DoublyLinkedList freqList = freqMap.getOrDefault(1, new DoublyLinkedList());
        freqList.addNode(newNode);
        freqMap.put(1, freqList);
        cache.put(key, newNode);
    }
    
    private void updateFreq(Node node) {
        int freq = node.freq;
        DoublyLinkedList oldList = freqMap.get(freq);
        oldList.removeNode(node);
        
        if (freq == minFreq && oldList.listSize == 0) {
            minFreq++;
        }
        node.freq++;
        DoublyLinkedList newList = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        newList.addNode(node);
        freqMap.put(node.freq, newList);
    }
}