package MyStack;

import java.util.HashMap;
import java.util.Map;

import Kadai.Global;

public class MyStack {
	private static int[] arr;
	private static int top;
	private static int capacity;
	public int num1;
	public int num2;
	public int num3;
	public int num;
	Map<Integer, Integer> map = new HashMap<>();

	public MyStack(int size) {
		arr = new int[size];
		capacity = size;
		top = -1;
	}

	public void status() {
		for (int i = top; i >= 0; i--)
			System.out.println(arr[i]);
	}

	public void push(int a) {
		if (isFull()) {
			System.out.println("Overflow\nProgram Terminated\n");
			System.exit(-1);
		}
		top++;
		arr[top] = a;
		if (Global.log) {
			System.out.println("push " + a);
			System.out.println("-------");
		}
		if (Global.log) {
			status();
			System.out.println("-------");
		}
	}

	public void push2(int a) {
		if (isFull()) {
			System.out.println("Overflow\nProgram Terminated\n");
			System.exit(-1);
		}
		top++;
		arr[top] = a;
	}

	public void push(String a) {

	}

	// Stackから最上位の要素をポップするユーティリティ関数
	public int pop() {
		// Stackのアンダーフローをチェックします
		if (isEmpty()) {
			System.out.println("Underflow\nProgram Terminated");
			System.exit(-1);
		}
		// Stackサイズを1減らし、(オプションで)ポップされた要素を返します
		if (Global.log) {
			System.out.println("pop");
			System.out.println("-------");
		}
		if (Global.log) {
			status();
			System.out.println("-------");
		}
		return arr[top--];

	}

	public int pop2() {
		// Stackのアンダーフローをチェックします
		if (isEmpty()) {
			System.out.println("Underflow\nProgram Terminated");
			System.exit(-1);
		}
		return arr[top--];
	}

	// Stackの最上位要素を返すユーティリティ関数
	public int peek() {
		if (!isEmpty()) {
			if (Global.log)
				System.out.println("peek");
			System.out.println(arr[top]);
			return arr[top];
		} else {
			System.exit(-1);
		}

		return -1;
	}

	public void print() {
		if (!isEmpty()) {
			if (Global.log) {
				System.out.println("print");
				System.out.println("-------");
			}
			System.out.println(arr[top--]);
		} else
			System.exit(-1);
	}

	// Stackの上2つを足してStackに追加するユーティリティ関数
	public void add() {
		if (top >= 1) {
			num1 = arr[top--];
			num2 = arr[top--];
			num3 = num1 + num2;
			top++;
			arr[top] = num3;
			if (Global.log) {
				System.out.println("add");
				System.out.println("-------");
			}
			if (Global.log) {
				status();
				System.out.println("-------");
			}
		} else
			System.out.println("dame");
	}

	// Stackのサイズを返すユーティリティ関数
	public int size() {
		return top + 1;
	}

	// Stackが空かどうかをチェックするユーティリティ関数
	public static boolean isEmpty() {
		return top == -1; // また return size() == 0;
	}

	// Stackがいっぱいかどうかをチェックするユーティリティ関数
	public static boolean isFull() {
		return top == capacity - 1; // また return size() == capacity;
	}

	// Stackのローカル変数を一時的に保管する
	public void set(int a) {
		Global.hensu = arr[top--];
		map.put(a, Global.hensu);
		if (Global.log) {
			System.out.println("set");
			System.out.println("-------");
		}
		if (Global.log) {
			status();
			System.out.println("-------");
		}
	}

	// Stackのローカル変数を取り出す
	public void get(int a) {
		push2(map.get(a));
		if (Global.log) {
			System.out.println("get");
			System.out.println("-------");
		}
		if (Global.log) {
			status();
			System.out.println("-------");
		}
	}

	// Stackに積まれている上2つが同じかどうかを判定する
	public void equal() {
		num1 = pop2();
		num2 = pop2();
		if (num2 == num1)
			push2(1);
		else
			push2(0);
		if (Global.log) {
			System.out.println("equal");
			System.out.println("-------");
		}
		if (Global.log) {
			status();
			System.out.println("-------");
		}
	}

	public void label(int name, int b) {
		Global.lhensu = b;
		map.put(name, Global.lhensu);
		if (Global.log) {
			System.out.println("label");
			System.out.println(name);
			System.out.println("pc = " + b);
		}
	}

	public void jumpif(int value) {
		if (pop2() == 0) {
			Global.setPC(value);
		} else
			Global.pPC(2);
		if (Global.log) {
			System.out.println("*******");
			System.out.println("jumpif");
		}
	}

	public void exit() {
		System.out.print("owari");
		System.exit(0);
	}

//reloadは98
	public void reload() {
		if (Global.isToken() == false) {
			for (int i = top; i >= 0; i--) {
				pop2();
			}
			Global.hensu = 0;
			Global.setToken(true);
			Global.setPC(0);
			System.out.println("reloading");
		} else {
			Global.pPC(1);
			System.out.println("no reloading");
		}
	}

	// funcの番号は101
	public void func() {
		Global.pPC(2);
	}

	// retの番号は102
	public void ret() {
		// コールされていなければ何もせず次に
		if (Global.isCALL() == 0)
			Global.pPC();
		// コールされていればコールのところに戻っていき、コールの値を0にする
		else {
			Global.setPC(Global.isCALL());
			Global.setCALL2(0);
			if (Global.log) {
				System.out.println("*******");
				System.out.println("return");
			}
		}
	}

	// callの番号は103
	public void call(int a) {
		Global.setCALL(Global.ispc(2));
		Global.setPC(a);
		if (Global.log) {
			System.out.println("call");
			System.out.println("setcall " + Global.isCALL());
			System.out.println("*******");
		}
	}

	public void more() {
		if (Global.log) {
			System.out.println("moreif");
			System.out.println("*******");
		}

		int a = pop2();
		int b = pop2();
		if (a < b)
			push(1);
		else
			push(0);
	}
}
