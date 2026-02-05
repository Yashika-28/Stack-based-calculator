import java.util.*;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class Stack<T> {
    private Node<T> top = null;

    public void push(T item) {
        Node<T> newNode = new Node<T>(item);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException(" \u001B[41m\t\t\t Stack is empty \u001B[0m");
        } else {
            T data = top.data;
            top = top.next;
            return data;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException(" \u001B[41m \t\t\t\t Stack is empty \u001B[0m");
        } else {
            return top.data;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        int count = 0;
        Node<T> current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public boolean endsWithOperator() {
    Node<T> current = top;
    while (current.next != null) {
        current = current.next;
    }
    T data = current.data;
    return data.equals("+") || data.equals("-") || data.equals("/") || data.equals("*");
}
}
class Input {
    private Stack<String> inputStack = new Stack<>();
    private Scanner scanner = new Scanner(System.in);
    public void takeInput() {
        System.out.print("\t\t\t \u001B[36m Enter characters (enter '.' to stop): \u001B[34m ");
        
        while (true) {
            String inputString = scanner.nextLine();
            System.out.print(" \u001B[0m");
            if (inputString.equals(".")) {
                break;
            }
            
            String[] parts = inputString.split(" ");
            for (String part : parts) {
                if (isValid(part)) {
                    inputStack.push(part);
                } else {
                    System.out.println(" \u001B[41m\t\t\t Invalid Expression !!! \u001B[0m ");
                    System.out.println("\t\t \u001B[36m Enter characters (enter '.' to stop):\u001B[34m ");
                }
            }
        }
    }
    private boolean isValid(String part) {
        for (char c : part.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '+' && c != '-' && c != '*' && c != '/' && c != ')' && c != '(' ) {
                return false;
            }
        }
        return true;
    }

    public Stack<String> getInputStack() {
        return inputStack;
    }
}
class detectType{
    Scanner process = new Scanner( System.in);
    Evaluvate evolve  = new Evaluvate();
public void FindType(Stack<String> InputStack){
    if(InputStack.peek().equals("+") || InputStack.peek().equals("-") || InputStack.peek().equals("/") || InputStack.peek().equals("*")){
    System.out.println("\t\t\t\u001B[33m +----------------------------------------+");
    System.out.println("\t\t\t\u001B[33m |\u001B[32m        The expression is postfix       \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t\u001B[33m +----------------------------------------+");
    System.out.println("\t\t\t \u001B[33m|\u001B[32m   Evaluvate the expression     Press 1 \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t \u001B[33m|\u001B[32m   Convert into Prefix          Press 2 \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t \u001B[33m|\u001B[32m   Convert into Infix           Press 3 \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t \u001B[33m|\u001B[32m   Exit the step                Press 0 \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t \u001B[33m+----------------------------------------+\u001B[0m");
    while(true){
        System.out.print("\t\t\t\t       \u001B[36m Input : \u001B[34m ");
    int input= process.nextInt();
    System.out.print("\u001B[0m ");
    switch(input){
    case 1: 
    System.out.print("\t\t\t \u001B[35m The value of the expression is :\u001B[0m ");
        evolve.evaluatePostfix(InputStack);
        return;
    case 2: 
    System.out.print("\t\t\t \u001B[35m The Prefix expression is :\u001B[0m ");
        evolve.postToPre( InputStack);
        return;
    case 3:
        System.out.print(" \t\t\t \u001B[35m The Infix expression is :\u001B[0m  ");
        evolve.postToIn(InputStack);
        return;
    case 0:
        return;
    default: 
        System.out.println("\u001B[41m\t\t\t  Invalid input !!! Re- eneter your choice\n\u001B[0m");
        break;
    }
    }
    }
    else if(InputStack.endsWithOperator()){
        System.out.println("\t\t\t\u001B[33m +----------------------------------------+");
    System.out.println("\t\t\t\u001B[33m |\u001B[32m        The expression is Prefix        \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t\u001B[33m +----------------------------------------+");
    System.out.println("\t\t\t \u001B[33m|\u001B[32m   Evaluvate the expression     Press 1 \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t \u001B[33m|\u001B[32m   Convert into Postfix         Press 2 \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t \u001B[33m|\u001B[32m   Convert into Infix           Press 3 \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t \u001B[33m|\u001B[32m   Exit the step                Press 0 \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t \u001B[33m+----------------------------------------+\u001B[0m");
    while(true){
        System.out.print("\t\t\t\t       \u001B[34m Input : \u001B[36m ");
    int input= process.nextInt();
    System.out.print("\u001B[0m");
    switch(input){
    case 1: 
    System.out.print("\t\t\t \u001B[35m The value of the expression is :\u001B[0m ");
        evolve.evaluatePrefix(InputStack);
        return;
    case 2: 
    System.out.print("\t\t\t \u001B[35mThe Postfix expression is : \u001B[0m");
        evolve.preToPost( InputStack);
        return;
    case 3:
    System.out.print("\t\t\t \u001B[35mThe Infix expression is : \u001B[0m");
        evolve.preToIn(InputStack);
        return;
    case 0:
        return;
    default: 
        System.out.print("\u001B[41m\t\t\t  Invalid input !!! Re- eneter your choice\n\u001B[0m");
        break;
        }
    }
    }
    else {
        System.out.println("\t\t\t\u001B[33m +----------------------------------------+");
    System.out.println("\t\t\t\u001B[33m |\u001B[32m        The expression is Infix         \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t\u001B[33m +----------------------------------------+");
    System.out.println("\t\t\t \u001B[33m|\u001B[32m   Evaluvate the expression     Press 1 \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t \u001B[33m|\u001B[32m   Convert into Postfix         Press 2 \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t \u001B[33m|\u001B[32m   Convert into prefix          Press 3 \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t \u001B[33m|\u001B[32m   Exit the step                Press 0 \u001B[33m|\u001B[0m");
    System.out.println("\t\t\t \u001B[33m+----------------------------------------+\u001B[0m");
    while(true){
        System.out.print("\t\t\t\t       \u001B[34m Input : \u001B[36m ");
    int input= process.nextInt();
    System.out.print("\u001B[0m");
    switch(input){
    case 1: 
        evolve.evaluvateInfix(InputStack);
        return; 
    case 2: 
    System.out.print("\t\t\t \u001B[35m The Postfix expression is : \u001B[0m");
        evolve.inToPre( InputStack);
        return;
    case 3:
        System.out.print("\t\t\t \u001B[35m The Prefix expression is : \u001B[0m");
        evolve.inToPost(InputStack);
        return;
    case 0:
        return;
    default: 
        System.out.print("\u001B[41m\t\t\t  Invalid input !!! Re- eneter your choice\n\u001B[0m");
        break; 
         }
    }
    }
}
class Evaluvate {    
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    } 
    private float performOperation(float operand1, float operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new IllegalArgumentException("\u001B[41m\t\t\t Cannot divide by zero\u001B[0m");
                }
            default:
                throw new IllegalArgumentException("\u001B[41m\t\t\t\t Invalid operator\u001B[0m");
        }
    }
    private int precedence(String operator) {
    switch (operator) {
        case "+":
        case "-":
            return 1;
        case "*":
        case "/":
            return 2;
        case "(":
        case ")":
            return -1;
        default:
            throw new IllegalArgumentException("\u001B[41m\t\t\t\t Invalid operator\u001B[0m");
    }
}
    public void evaluatePrefix(Stack<String> inputStack) {
    Stack<String> operandStack = new Stack<>();
    while (!inputStack.isEmpty()) {
        String token = inputStack.pop();
        if (isOperator(token)) {
            float operand1 = Float.parseFloat(operandStack.pop());
            float operand2 = Float.parseFloat(operandStack.pop());
            float result = performOperation(operand1, operand2, token);
            operandStack.push(Float.toString(result));
        } else {
            operandStack.push(token);
        }
    }
    System.out.print(operandStack.pop());
}
    public void evaluvateInfix(Stack<String> inputStack) {
    Stack<String> evaluationStack = new Stack<>();
    Stack<String> operatorStack = new Stack<>();
    List<String> steps = new ArrayList<>();

    while (!inputStack.isEmpty()) {
        String token = inputStack.pop();

        if (isOperator(token)) {
            while (!operatorStack.isEmpty() && precedence(token) <= precedence(operatorStack.peek())) {
                String operator = operatorStack.pop();
                float operand2 = Float.parseFloat(evaluationStack.pop());
                float operand1 = Float.parseFloat(evaluationStack.pop());
                float  result = performOperation(operand1, operand2, operator);
                evaluationStack.push(Float.toString(result));
                steps.add(operand1 + " " + operator + " " + operand2 + " = " + result);
            }
            operatorStack.push(token);
        } else {
            evaluationStack.push(token);
        }
    }

    while (!operatorStack.isEmpty()) {
        String operator = operatorStack.pop();
        float operand2 = Float.parseFloat(evaluationStack.pop());
        float operand1 = Float.parseFloat(evaluationStack.pop());
        float result = performOperation(operand1, operand2, operator);
        evaluationStack.push(Float.toString(result));
        steps.add(operand1 + " " + operator + " " + operand2 + " = " + result);
    }
    System.out.print( "\t\t\t \u001B[35m The value of the expression is :\u001B[0m "+evaluationStack.pop());
}

public void evaluatePostfix(Stack<String> inputStack) {
    Stack<String> reversedStack = new Stack<>();
    while (!inputStack.isEmpty()) {
        reversedStack.push(inputStack.pop());
    }

    Stack<String> operandStack = new Stack<>();

    while (!reversedStack.isEmpty()) {
        String token = reversedStack.pop();

        if (isOperator(token)) {
            if (operandStack.size() < 2) {
                System.out.println("\n \t\t\t \u001B[41mError: not enough operands for operator " + token+ "\u001B[0m");
                return;
            }
            float operand2 = Float.parseFloat(operandStack.pop());
            float operand1 = Float.parseFloat(operandStack.pop());
            float result = performOperation(operand1, operand2, token);
            operandStack.push(Float.toString(result));
        } else {
            operandStack.push(token);
        }
    }

    if (!operandStack.isEmpty()) {
        System.out.print( operandStack.pop());
    } else {
        System.out.println("\n \t\t\t \u001B[41mError: stack is empty after evaluation\u001B[0m");
    }
}

public void postToPre(Stack<String> inputStack) {
    Stack<String> reversedStack = new Stack<>();
    while (!inputStack.isEmpty()) {
        reversedStack.push(inputStack.pop());
    }

    Stack<String> s = new Stack<>();

    while (!reversedStack.isEmpty()) {
        String token = reversedStack.pop();

        if (isOperator(token)) {
            if (s.size() < 2) {
                System.out.println("\n \t\t\t \u001B[41mError: not enough operands for operator " + token+"\u001B[0m");
                return;
            }
            String op1 = s.peek();
				s.pop();
				String op2 = s.peek();
				s.pop();
				String temp= token + op2 + op1;
				s.push(temp);
        } else {
            s.push(token);
        }
    }

    if (!s.isEmpty()) {
        System.out.print( s.pop());
    } else {
        System.out.println("\n \t\t\t \u001B[41mError: stack is empty after conversion \u001B[0m");
    }
}

public void postToIn(Stack<String> inputStack) {
    Stack<String> reversedStack = new Stack<>();
    while (!inputStack.isEmpty()) {
        reversedStack.push(inputStack.pop());
    }

    Stack<String> s = new Stack<>();

    while (!reversedStack.isEmpty()) {
        String token = reversedStack.pop();

        if (isOperator(token)) {
            if (s.size() < 2) {
                System.out.println("\n \t\t\t \u001B[41mError: not enough operands for operator " + token +"\u001B[0m");
                return;
            }
            String op1 = s.peek();
            s.pop();
            String op2 = s.peek();
            s.pop();
            s.push("(" + op2 + token + op1 + ")");
        } else {
            s.push(token);
        }
    }

    if (!s.isEmpty()) {
        System.out.print( s.peek());
    } else {
        System.out.println("\n \t\t\t \u001B[41mError: stack is empty after conversion\u001B[0m");
    }
}


public void preToPost(Stack<String> inputStack) {
    Stack<String> operandStack = new Stack<>();

    while (!inputStack.isEmpty()) {
        String token = inputStack.pop();

        if (isOperator(token)) {
            String operand1 = operandStack.pop();
            String operand2 = operandStack.pop();
            String result = operand1 + " " + operand2 + " " + token;
            operandStack.push(result);
        } else {
            operandStack.push(token);
        }
    }
    System.out.print( operandStack.pop());
}

public void preToIn(Stack<String> inputStack) {
    Stack<String> operandStack = new Stack<>();
    while (!inputStack.isEmpty()) {
        String token = inputStack.pop();

        if (isOperator(token)) {
            String operand1 = operandStack.pop();
            String operand2 = operandStack.pop();
            String result = "(" + operand1 + " " + token + " " + operand2 + ")";
            operandStack.push(result);
        } else {
            operandStack.push(token);
        }
    }
    System.out.print( operandStack.pop());
}

public void inToPre(Stack<String> inputStack) {
    Stack<String> operatorStack = new Stack<>();
    Stack<String> outputStack = new Stack<>();

    while (!inputStack.isEmpty()) {
        String token = inputStack.pop();

        if (isOperator(token)) {
            while (!operatorStack.isEmpty() && precedence(token) <= precedence(operatorStack.peek())) {
                outputStack.push(operatorStack.pop());
            }
            operatorStack.push(token);
        } else if (token.equals("(")) {
            operatorStack.push(token);
        } else if (token.equals(")")) {
            while (!operatorStack.peek().equals("(")) {
                outputStack.push(operatorStack.pop());
            }
            operatorStack.pop(); 
        } else {
            outputStack.push(token);
        }
    }

    while (!operatorStack.isEmpty()) {
        outputStack.push(operatorStack.pop());
    }
    Stack<String> prefixStack = new Stack<>();
    while (!outputStack.isEmpty()) {
        prefixStack.push(outputStack.pop());
    }
    while (!prefixStack.isEmpty()) {
        System.out.print(prefixStack.pop() + " ");
    }
}
public void inToPost(Stack<String> inputStack) {
    Stack<String> operatorStack = new Stack<>();
    Stack<String> outputStack = new Stack<>();

    while (!inputStack.isEmpty()) {
        String token = inputStack.pop();
        if (isOperator(token)) {
            while (!operatorStack.isEmpty() && precedence(token) <= precedence(operatorStack.peek())) {
                outputStack.push(operatorStack.pop());
            }
            operatorStack.push(token);
        } else if (token.equals("(")) {
            operatorStack.push(token);
        } else if (token.equals(")")) {
            while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                outputStack.push(operatorStack.pop());
            }
            if (!operatorStack.isEmpty()) {
                operatorStack.pop(); 
            }
        } else {
            outputStack.push(token);
        }
    }
    while (!operatorStack.isEmpty()) {
        outputStack.push(operatorStack.pop());
    }
    while (!outputStack.isEmpty()) {
        System.out.print(outputStack.pop() + " ");
    }
}
}
}
class Main {
    public static void main(String[] args) {
        while( true){
        Input input = new Input();
        input.takeInput();
        Stack<String> inputStack = input.getInputStack();
        // test if the expression is valid 
        if(!inputStack.isEmpty() && (inputStack.peek().equals("+") || inputStack.peek().equals("-") || inputStack.peek().equals("/") || inputStack.peek().equals("*")) && inputStack.endsWithOperator() ){
            System.out.println("\u001B[41m\t\t\t\t\t Invalid Expression \u001B[0m");
            input.takeInput();
            inputStack = input.getInputStack();
        }
        detectType Find = new detectType();
        Find.FindType(inputStack);
        System.out.print("\n \t\t    \u001B[41m Do you want to enter another expression? (yes/no):\u001B[0m ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            System.out.println("\u001B[0m");
            if ("no".equalsIgnoreCase(choice)) {
                break; 
            }
        }
    }
}

