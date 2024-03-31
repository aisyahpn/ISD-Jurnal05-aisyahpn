import java.util.Stack;
public class StackApp {

    //isOp (char c) method yang memeriksa apakah karakter yang diberikan adalah operator
    static boolean isOp(char c){
        return (c == '+' || c == '-' || c == '/' || c == '*' ||  c == '^');
    }

    //getPrecedence(char op) method yang mengembalikan prioritas operator 
    static int getPrecedence(char op){
        switch(op){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    //Metode infixtopostfix mengambil ekspresi infix sebagai input dan mengembalikan notasi postfix yang sesuai.
    static String infixtopostfix(String infix){
        //Metode ini pertama kali membalikkan ekspresi infix dan menyimpan string terbalik dalam variabel yang disebut terbalik.
        Stack<Character> operatorstacks =  new Stack<Character>();
        StringBuilder postfixBuilder =  new StringBuilder();
        
        //Metode tersebut kemudian berterusan di atas string kebalik, melalui setiap karakter dalam notasi infix

        for(int i = 0; i < infix.length(); i++ ){
            char c =  infix.charAt(i);

            //jika karakter tersebut adalah spasi atau ruang kosong, abaikan dan lanjut ke iterasi berikutnya
            if(c == ' '){
                continue;
            }
            //Jika karakter ini bukan operator, karakter tersebut ditambahkan ke string prefix yaitu postfixBuilder
            if(!isOp(c)){
                postfixBuilder.append(c);
            }

            //jika karakter adalah operator, 
            else{
                while(!operatorstacks.isEmpty() && getPrecedence(operatorstacks.peek()) >= getPrecedence(c)){
                    postfixBuilder.append(operatorstacks.pop());
                }
                operatorstacks.push(c); //push operator saat ini ke stack
            }
        }
        //operator yng tersisa dalam stack operator muncul dan ditempelkan ke postfixbuilder
        while(!operatorstacks.isEmpty()){
            postfixBuilder.append(operatorstacks.pop());
        }

        //stringbuilder dikonversi menjadi string dan dikembalikan sebagai ekspresi postfix
        String postfix = postfixBuilder.toString();
        return postfix;
    }

    //kasus tes yang menunjukkan penggunaan metode infixtopostfix
    public static void main(String[] args) {
        String infix = "a * b - c";
        String postfix = infixtopostfix(infix);
        System.out.println("infix "  + infix);
        System.out.println("postfix " + postfix);
    }
}