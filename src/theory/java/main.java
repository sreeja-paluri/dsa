package theory.java;

class main {
    public static void main(String[] args) {

        QueueLL queue = new QueueLL();
        queue.enqueue(1);
        queue.enqueue(2);
        QueueLL.Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.size()); // 1
        System.out.println(queue.getHeadData()); // 2
        System.out.println(queue.isEmpty());
        PriorityQueue pq = new PriorityQueue();
        pq.enqueue(3);
        pq.enqueue(1);
        pq.enqueue(2);
        System.out.println(pq.dequeue()); // Dequeued priority: 1, 1
        System.out.println(pq.dequeue());

    }
}
