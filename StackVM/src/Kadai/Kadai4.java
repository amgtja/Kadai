package Kadai;

import MyStack.MyStack;

import MyStack.Henkan;

public class Kadai4 {

	public static void kadai4() {
		// TODO Auto-generated method stub
		MyStack myS = new MyStack(10);
		String[] value = { "push", "1", "push", "2", "CALL", "10", "CALL", "22", "print", "exit", "FUNC", "111", "set",
				"41", "set", "42", "get", "41", "get", "42", "add", "RETURN", "FUNC", "112", "push", "3", "push", "4", "add",
				"add", "RETURN" };
		int[] code = new int[100];
		Global.hensu = 0;
		// labelの走査（未完成）
		// String→intへの変更と、jumpifの後の変数をlabelと対応（未完成）
		// String→intへの変更
		for (int i = 0; i < value.length; i++) {
			code[i] = Henkan.henkan(value[i]);
		}
		Global.setPC(0);
		while (Global.ispc() < code.length) {
			switch (code[Global.ispc()]) {
			case 0:
				myS.push(code[Global.ispc(1)]);
				Global.pPC(2);
				break;
			case 1:
				myS.pop();
				Global.pPC(1);
				break;
			case 2:
				myS.add();
				Global.pPC(1);
				break;
			case 3:
				myS.peek();
				Global.pPC(1);
				break;
			case 4:
				myS.set(code[Global.ispc(1)]);
				Global.pPC(2);
				break;
			case 5:
				myS.get(code[Global.ispc(1)]);
				Global.pPC(2);
				break;
			case 6:
				myS.equal();
				Global.pPC(1);
				break;
			case 7:
				myS.jumpif(code[Global.ispc(1)]);
				System.out.println(Global.ispc());
				break;
			case 8:
				myS.print();
				Global.pPC(1);
				break;
			case 9:
				// label
				Global.pPC(2);
				break;
			case 98:
				myS.reload();
				break;
			case 99:
				myS.exit();
				break;
			case 101:
				myS.func();
				break;
			case 102:
				myS.ret();
				break;
			case 103:
				myS.call(code[Global.ispc(1)]);
				break;
			default:
				break;
			}
		}
	}
}
