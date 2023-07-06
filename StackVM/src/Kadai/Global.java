package Kadai;

public class Global {
	public static boolean log = false;
	public static int hensu;
	public static int lhensu;
	private static boolean func = false;
	private static boolean token;
	private static int pc;
	private static int call;

	public static boolean isToken() {
		return token;
	}

	public static void setToken(boolean i) {
		token = i;
	}

	public static boolean isFUNC() {
		return func;
	}

	public static void setFUNC(boolean i) {
		func = i;
	}

	public static void setPC(int p) {
		pc = p;
	}

	public static void pPC(int a) {
		pc += a;
	}

	public static void pPC() {
		pc += 1;
	}

	public static int ispc() {
		// TODO Auto-generated method stub
		return pc;
	}

	public static int ispc(int a) {
		return pc + a;
	}

	public static int isCALL() {
		return call;
	}

	public static void setCALL(int p) {
		call = p;
	}

	public static void setCALL2(int p) {
		// TODO Auto-generated method stub
		call = p;

	}
}
