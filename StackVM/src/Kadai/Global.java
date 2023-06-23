package Kadai;

public class Global {
	public static boolean log = true;
	public static int hensu;
	public static int lhensu;
	private static boolean token;
	private static int pc;

	public static boolean isToken() {
		return token;
	}

	public static void setToken(boolean i) {
		Global.token = i;
	}


	public static void setPC(int p) {
		Global.pc = p;
	}

	public static void pPC(int a) {
		Global.pc += a;
	}

	public static int ispc() {
		// TODO Auto-generated method stub
		return pc;
	}
	public static int ispc(int a) {
		return pc + a;
	}
}
