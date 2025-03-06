import java.util.Stack;

public class RemoveStars {
    public String removeStars(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder str = new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetter(c)) {
                stack.push(c);
            }else if(c=='*'){
                stack.pop();
            }
        }
       for(char c:stack) {
            str.append(c);
        }
        return str.toString();
    }
    public static void main(String[] args) {
        String str="leet**cod*e";
        RemoveStars remove=new RemoveStars();
        System.out.println(remove.removeStars(str));
    }


}
