mplement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).


class MyQueue {
    
    private Stack<Integer> main;
    private Stack<Integer> helper;
    int bottom = 0;

    /** Initialize your data structure here. */
    public MyQueue() {
        main = new Stack<>();
        helper = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {        
        while(!helper.isEmpty())
            main.push(helper.pop());
        if(main.isEmpty())
            bottom = x;
        main.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!helper.isEmpty()){
            int answer = helper.pop();
            if(!helper.isEmpty())
                bottom = helper.peek();
            return answer;
        }
        while(main.size() > 1){
            helper.push(main.pop());
        }
        if(!helper.isEmpty())
            bottom = helper.peek();
        
        return main.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return bottom;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return main.isEmpty() && helper.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
