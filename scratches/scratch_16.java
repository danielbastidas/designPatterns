import java.util.Stack;

class Scratch {
    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(-1*Integer.MAX_VALUE);
        System.out.println(scratch.solution("(((((((((((((((((((((((((((((((" +
                "((((((((((())))))))){}}}}}}}}({}}}}}})}({)}({)}({)}({)}({)}{" +
                "(}){{{{{{{{{{{{{{{{{{{{{{{{{{{{{{(}{)}{{{{{{{{{{{{{{{{{"));
    }

    public int solution(String S){
        boolean flag = false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i< S.length();i++) {
            if (S.charAt(i)=='(' || S.charAt(i)=='{' || S.charAt(i)=='[') {
                stack.push(S.charAt(i));
            } else {
                switch (S.charAt(i)) {
                    case ')':
                        if (!stack.isEmpty() && stack.peek().equals('(')) {
                            stack.pop();
                        } else{
                            flag = true;
                            break;
                        }
                        break;
                    case ']':
                        if (!stack.isEmpty() && stack.peek().equals('[')) {
                            stack.pop();
                        } else{
                            flag = true;
                            break;
                        }
                        break;
                    case '}':
                        if (!stack.isEmpty() && stack.peek().equals('{')) {
                            stack.pop();
                        } else{
                            flag = true;
                            break;
                        }
                        break;
                }
            }

        }
        return !flag && stack.isEmpty() ? 1:0;
    }


}