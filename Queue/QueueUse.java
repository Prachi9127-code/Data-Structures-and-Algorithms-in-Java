package Queue;

public class QueueUse {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		QueueUsingLL<Integer> queue = new QueueUsingLL<>();
		//QueueUsingArray queue = new QueueUsingArray(3);
		for(int i=1; i<= 5; i++) {
			queue.enqueue(i);
			
		}
         while(! queue.isEmpty()) {
        	 
        	 try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
	}

}

