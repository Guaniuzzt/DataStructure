package queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		//测试一把
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' '; //接受用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		//输出一个菜单
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列取出数据");
			System.out.println("h(head):查看队列头的数据");
			key = scanner.next().charAt(0);
			
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("Please enter your data.");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getData();
					System.out.printf("取出的数据是： %d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = queue.peekHead();
					System.out.printf("队列头的数据是： %d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				
				break;
			default:
				break;
			}
		}
		
		System.out.println("程序退出");
		
		
		

	}

}

class ArrayQueue{
	
	private int maxSize;    //表示数组最大容量
	private int front;
	private int rear;
	private int[] array;
	
	//创建队列的构造器
	
	public ArrayQueue(int arrayMaxSize) {
		this.maxSize = arrayMaxSize;
		array = new int[maxSize];
		front = -1;//指向队列头的前一个位置（不包含第一个数据）
		rear = -1;//指向队列尾部（即队列最后一个数据）
		
	}
	
	//判断队列是否满
	public boolean isFull() {
		return rear == maxSize -1;
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}   
	
	//添加数据到队列
	public void addQueue(int data) {
		//判断队列是否满
		if(this.isFull()) {
			System.out.println("the queue is full");
			return;
		}else {
			rear++;
			array[rear] = data;
		}
	}
	
	
	//获取队列数据
	public int getData() {
		//判断队列是否为空
		if(this.isEmpty()) {
			throw new RuntimeException("Can not get data from empty queue.");
		}
		front++;
		return array[front];
	}
	
	
	//显示队列的所有数据
	public void showQueue() {
		if(this.isEmpty()) {
			throw new RuntimeException("Can not show data from empty queue.");
		}
		for(int i=front+1; i<maxSize; i++ ) {
			System.out.printf("array[%d] = %d\n", i, array[i]);
		}
	}
	
	
	//显示队列的头部，不是取出数据
	public int peekHead() {
		if(this.isEmpty()) {
			throw new RuntimeException("Can not peek data from empty queue.");
		}
		
		return array[front+1];
	}
	
	
	
	
	
	
}
