package MyStack;

public class Henkan {
	// label走査する
	// jumpに紐づけする
	public static int henkan(String value) {
		switch (value) {
		case "push":
			return 0;
		case "pop":
			return 1;
		case "add":
			return 2;
		case "peek":
			return 3;
		case "set":
			return 4;
		case "get":
			return 5;
		case "equal":
			return 6;
		case "jumpif":
			return 7;
		case "print":
			return 8;
		case "label":
			return 9;
		case "exit":
			return 99;
		default:
			return Integer.parseInt(value);
		}
	}
}
