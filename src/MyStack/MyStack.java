package MyStack;

public class MyStack{
	private long[] arr;
	private int top;
	private long capacity;
	public long num1;
	public long num2;
	public long num3;
	
	public MyStack(int size){
		arr = new long[size];
		capacity = size;
		top = -1;
	}
    public void push(long x){
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }
        arr[++top] = x;
    }
    //Stackから最上位の要素をポップするユーティリティ関数
    public long pop()
    {
        //Stackのアンダーフローをチェックします
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        //Stackサイズを1減らし、(オプションで)ポップされた要素を返します
        return arr[top--];
    }
 
    //Stackの最上位要素を返すユーティリティ関数
    public long peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }
 
        return -1;
    }
    //Stackの上2つを足してStackに追加するユーティリティ関数
    public void add() 
    {
        num1 = pop();
        num2 = pop();
        num3 = num1 + num2;
        arr[++top] = num3;

    }
    //Stackのサイズを返すユーティリティ関数
    public long size() {
        return top + 1;
    }
 
    //Stackが空かどうかをチェックするユーティリティ関数
    public boolean isEmpty() {
        return top == -1;               //また return size() == 0;
    }
 
    //Stackがいっぱいかどうかをチェックするユーティリティ関数
    public boolean isFull() {
        return top == capacity - 1;     //また return size() == capacity;
    }
}
