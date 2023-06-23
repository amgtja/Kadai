package Kadai;

import MyStack.MyStack;
import MyStack.Henkan;

public class Kadai3 {

	public static void kadai3() {
		// TODO Auto-generated method stub
		MyStack myS = new MyStack(10);
		String[] value = { "push", "1",
				"set", "41",
				"get", "41",
				"get", "41",
				"add",
				"add",
				"push", "1",
				"add",
				"print",
				"exit" };
		int[] code = new int[100];
		for (int i = 0; i < value.length; i++) {
			code[i] = Henkan.henkan(value[i]);
		}

		int pc = 0;
		while (pc < code.length) {
			switch (code[pc]) {
			case 0:
				myS.push(code[pc + 1]);
				pc += 2;
				break;
			case 1:
				myS.pop();
				pc++;
				break;
			case 2:
				myS.add();
				pc++;
				break;
			case 3:
				myS.peek();
				pc++;
				break;
			case 4:
				myS.set(code[pc + 1]);
				pc += 2;
				break;
			case 5:
				myS.get(code[pc + 1]);
				pc += 2;
				break;
			case 6:
				myS.equal();// push x push 10000 equal x=10000 →1, 0
				pc++;
				break;
			case 7:
				myS.jumpif(code[pc + 1], pc);// jumpif CHECK
				break;
			case 8:
				myS.print();
				pc++;
				break;
			case 9:
				//label
				pc += 2;
				break;
			case 99:
				myS.exit();
				break;
			}
		}
	}
}
