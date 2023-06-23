package Kadai;
import java.util.Scanner;
import MyStack.MyStack;


public class Kadai1 {
    public static void kadai1(){
        MyStack myStack = new MyStack(2);
        /*入力のルール
        <a b c d>
        a: 0で等倍、2で2倍
        b: x座標の入力
        c: y座標の入力
        d: 40~42を入力する*/
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] values = line.split(" ",0); 
        int[] code = new int[4];
        for(int i=0; i<4; i++){
            try{
                code[i] = Integer.parseInt(values[i]);
            }catch ( NumberFormatException ex ){
                return;
            }
        }
        //(0 x y)の入力で座標を(x y)だけ動かしたい
        //(1 x y)の入力で座標を(2x 2y)だけ動かしたい
        int pc=0;
        Mylabel: while(true) {
            switch(code[pc]/10) {
	        	case 0:
	        		switch(code[pc]%10) {
		                case 0: 
		                	myStack.push(code[pc+1]);
		                	myStack.push(code[pc+2]);
		                	pc += 3;
		                	break;
		                case 1:
		                	myStack.push(code[pc+1]*2);
		                	myStack.push(code[pc+2]*2);
		                	pc += 3;
		                	break;
	        		}
	        		break;
	        	case 4:
	        		switch(code[pc]%10) {
	        		case 0:
	        			System.out.println("y= "+myStack.pop());
	        			break;
	        		case 1:
	        			System.out.println("x= "+myStack.pop());
	        			break;
	        		case 2:
	        			System.out.println("y= "+myStack.pop());
	        			System.out.println("x= "+myStack.pop());
	        			break;
	        		}
	        		break Mylabel;
            }
        }

    }
}
