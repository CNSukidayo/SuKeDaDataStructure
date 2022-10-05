package cnsukidayo.com.gitee.leetcode;

class MyLinkedList {
    // 链表的总长度
    private int size = 0;
    // 链表的头结点
    private LinkedListNode firstNode;
    // 链表的尾结点
    private LinkedListNode lastNode;


    public MyLinkedList() {

    }

    public int get(int index) {
        // 无效的索引
        if (index < 0 || index > size - 1) {
            return -1;
        }
        return getNodeFromIndex(index).getValue();
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        // 如果索引大于链表大小,直接返回即可
        if (index > size) {
            return;
        }
        // 添加头结点
        if (size == 0) {
            firstNode = new LinkedListNode(val);
            lastNode = firstNode;
            size++;
            return;
        }
        LinkedListNode newValue = new LinkedListNode(val);
        // 需要单独处理添加尾节点的操作
        if (index == size) {
            lastNode.setNext(newValue);
            newValue.setPre(lastNode);
            lastNode = newValue;
            size++;
            return;
        }
        // 进行到这一步链表的长度必定>0
        LinkedListNode addNode = getNodeFromIndex(index);
        newValue.setNext(addNode);
        newValue.setPre(addNode.getPre());
        addNode.setPre(newValue);
        if (newValue.getPre() != null) {
            newValue.getPre().setNext(newValue);
        } else {
            // 如果newValueNext==null则表明,当前的current就是尾节点,那还需要把尾节点赋值给lastNode
            firstNode = newValue;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        // 无效索引
        if (index < 0 || index >= size) {
            return;
        }
        // 链表长度为1时的另外判断
        if (size == 1) {
            size--;
            return;
        }
        // 进行到这一步,链表的长度必定>1
        LinkedListNode deleteNode = getNodeFromIndex(index);

        if (deleteNode.getPre() != null) {
            deleteNode.getPre().setNext(deleteNode.getNext());
        } else {
            // 此时要删除的节点为头结点
            firstNode = deleteNode.getNext();
        }
        if (deleteNode.getNext() != null) {
            deleteNode.getNext().setPre(deleteNode.getPre());
        } else {
            // 此时要删除的节点为尾结点
            lastNode = deleteNode.getPre();
        }
        size--;
    }

    private LinkedListNode getNodeFromIndex(int index) {
        LinkedListNode current = null;
        if (index < size / 2) {
            current = firstNode;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = lastNode;
            for (int i = 0; i < size - index - 1; i++) {
                current = current.getPre();
            }
        }
        return current;
    }

    private static class LinkedListNode {
        private int value;
        private LinkedListNode next;
        private LinkedListNode pre;

        public LinkedListNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public LinkedListNode getNext() {
            return next;
        }

        public void setNext(LinkedListNode next) {
            this.next = next;
        }


        public LinkedListNode getPre() {
            return pre;
        }

        public void setPre(LinkedListNode pre) {
            this.pre = pre;
        }
    }
}