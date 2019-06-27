package queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		//����һ��
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' '; //�����û�����
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		//���һ���˵�
		while(loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):������ݵ�����");
			System.out.println("g(get):�Ӷ���ȡ������");
			System.out.println("h(head):�鿴����ͷ������");
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
					System.out.printf("ȡ���������ǣ� %d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = queue.peekHead();
					System.out.printf("����ͷ�������ǣ� %d\n", res);
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
		
		System.out.println("�����˳�");
		
		
		

	}

}

class ArrayQueue{
	
	private int maxSize;    //��ʾ�����������
	private int front;
	private int rear;
	private int[] array;
	
	//�������еĹ�����
	
	public ArrayQueue(int arrayMaxSize) {
		this.maxSize = arrayMaxSize;
		array = new int[maxSize];
		front = -1;//ָ�����ͷ��ǰһ��λ�ã���������һ�����ݣ�
		rear = -1;//ָ�����β�������������һ�����ݣ�
		
	}
	
	//�ж϶����Ƿ���
	public boolean isFull() {
		return rear == maxSize -1;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}   
	
	//������ݵ�����
	public void addQueue(int data) {
		//�ж϶����Ƿ���
		if(this.isFull()) {
			System.out.println("the queue is full");
			return;
		}else {
			rear++;
			array[rear] = data;
		}
	}
	
	
	//��ȡ��������
	public int getData() {
		//�ж϶����Ƿ�Ϊ��
		if(this.isEmpty()) {
			throw new RuntimeException("Can not get data from empty queue.");
		}
		front++;
		return array[front];
	}
	
	
	//��ʾ���е���������
	public void showQueue() {
		if(this.isEmpty()) {
			throw new RuntimeException("Can not show data from empty queue.");
		}
		for(int i=front+1; i<maxSize; i++ ) {
			System.out.printf("array[%d] = %d\n", i, array[i]);
		}
	}
	
	
	//��ʾ���е�ͷ��������ȡ������
	public int peekHead() {
		if(this.isEmpty()) {
			throw new RuntimeException("Can not peek data from empty queue.");
		}
		
		return array[front+1];
	}
	
	
	
	
	
	
}
