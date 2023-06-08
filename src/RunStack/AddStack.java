package RunStack;

import MyStack.MyStack;

public class AddStack
{
    private int i;
    private int pc;

    //Call内の変数を初期化するコンストラクタ
    public AddStack(){
        i = 0;
        pc = 0;
    }
    /*以下の方法で1~xまでを足すメソッドをAddStackに書く
    ・プログラムカウンタ
    ・for文
    ・while文
    ・do-while文
    ・for-each文
    */

    MyStack myStack = new MyStack(2);
    
    public void PC(int x){
        label: while(true){
            switch(pc){
                case 0: myStack.push(i);
                case 1: i++;
                        myStack.push(i);
                case 2: myStack.add();
                case 3: if (i == x) break label;
                case 4: if (pc == 1) break;
                case 5: pc++;
            }
        }
        System.out.println("PC answer is "+myStack.pop());
    }
    public void FOR(int x){
        myStack.push(i);
        for(i=1; i<=x; i++){
            myStack.push(i);
            myStack.add();
        }
        System.out.println("FOR answer is "+myStack.pop());
    }
    public void WHILE(int x){
        myStack.push(i);
        while(i<x){
            i++;
            myStack.push(i);
            myStack.add();
        }
        System.out.println("WHILE answer is "+myStack.pop());
    }

    public void DO(int x){
        myStack.push(i);
        do{
            i++;
            myStack.push(i);
            myStack.add();
        }while(i<x);
        System.out.println("DO answer is "+myStack.pop());
    }
    
}