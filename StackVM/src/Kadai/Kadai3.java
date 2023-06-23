package Kadai;

import MyStack.MyStack;
import MyStack.Henkan;

public class Kadai3 {

	public static void kadai3() {
		// TODO Auto-generated method stub
		MyStack myS = new MyStack(10);
		String[] value =
			{"push","1",
					"set","41",
					"label","100",
					"get","41",
					"push","1",
					"add",
					"push","10","equal",
					"jumpif","100",
					"print","exit"};
		int[] code = new int[100];
		Global.hensu = 0;
		// labelの走査（未完成）
		// String→intへの変更と、jumpifの後の変数をlabelと対応（未完成）
		// String→intへの変更
		for (int i = 0; i < value.length; i++) {
			code[i] = Henkan.henkan(value[i]);
			if(value[i] == "label")
				myS.label(code[i+1], i+2);
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
				System.out.println(pc);
				myS.get(code[pc + 1]);
				pc += 2;
				break;
			case 6:
				myS.equal();
				pc++;
				break;
			case 7:
				myS.jumpif(code[pc + 1], pc);
				System.out.println(pc);
				break;
			case 8:
				myS.print();
				pc++;
				break;
			case 9:
				// label
				pc += 2;
				break;
			case 99:
				myS.exit();
				break;
			default:
				break;
			}
		}
	}
}
