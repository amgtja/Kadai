package Kadai;
import java.util.Scanner;
import RunStack.*;


public class Kadai2 {
    static int[] code = new int[100];
    static int pc = 0;
	public static void kadai2(){
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] values = line.split(" ",0);
        for(int i=0; i<values.length; i++){
            try{
                code[i] = Integer.parseInt(values[i]);
            }catch ( NumberFormatException ex ){
                return;
            }
        }
        
        AddStack addStack = new AddStack();
        
        for(int i=0; i<code[pc]; i++) {
        	meas(addStack);
        }
	}
	private static void meas(AddStack a) {
        //ここに計測開始の時間を記録する変数を入れる
        long startTime = System.currentTimeMillis();
        switch(code[pc+1]){
            case 0: a.PC(code[pc+2]); break;
            case 1: a.FOR(code[pc+2]); break;
            case 2: a.WHILE(code[pc+2]); break;
            case 3: a.DO(code[pc+2]); break;
        }
        long endTime = System.currentTimeMillis();
        //ここに計測終了の時間を記録する変数を入れる
        System.out.println("process time is " + (endTime - startTime));
	}
}
