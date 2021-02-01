package leetcode;

public class LC1678GoalParser {
public String interpret(String command) {
    if(command==null || command.length()==0) {
        return command;
    }
    
    command = command.replace("()", "o");
    command = command.replace("(al)", "al");
    return command;
        
    }
    
    public static void main(String[] args) {
        LC1678GoalParser obj = new LC1678GoalParser();
        System.out.println(obj.interpret("(al)G(al)()()G"));
    }

}
