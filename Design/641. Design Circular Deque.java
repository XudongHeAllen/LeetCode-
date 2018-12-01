Design your implementation of the circular double-ended queue (deque).

Your implementation should support following operations:

MyCircularDeque(k): Constructor, set the size of the deque to be k.
insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
getRear(): Gets the last item from Deque. If the deque is empty, return -1.
isEmpty(): Checks whether Deque is empty or not. 
isFull(): Checks whether Deque is full or not.

	private class NodeDouble{
		int val;
		NodeDouble next;
		NodeDouble prev;
		
		public NodeDouble(int val){
			this.val = val;
			this.next = null;
			this.prev = null;
		}
		
	}
	
	NodeDouble front; 
	NodeDouble rear; 
	int max , size;
	
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public Design_Circular_Queue_2(int k) {
        this.max = k;
        this.size = 0;
        this.front = new NodeDouble(0);
        this.rear = new NodeDouble(0);
        this.front.next = this.rear;
        this.rear.prev = this.front;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int val) {
        if(!isFull()){
        	size++;
        	NodeDouble n = new NodeDouble(val);
        	n.prev = this.rear.prev;
        	this.rear.prev.next = n;
        	n.next = this.rear;
        	this.rear.prev = n;
        	return true;
        }
    	
        return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()){
        	size--;
        	this.front.next = this.front.next.next;
        	this.front.next.prev = this.front;
        	return true;
        }
        
        return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : this.front.next.val;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	return isEmpty() ? -1 : this.rear.prev.val;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (this.size == 0);
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (this.size == this.max);
    }
