package eg.edu.alexu.csd.datastructure.stack.cs;

public class ExpressionEvaluator implements IExpressionEvaluator{
    /***
     * function to return the precedence of a given operator
     * @param ch operation that we want to know its precedence
     * @return
     */
    static int Prec(char ch){
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    /***
     * this fucnction take infix expression and convert it - if it was valid - to profix
     * @param expression expression "infix" to be converted to protfix
     * infix expression
     * @return
     */
    public String infixToPostfix(String expression){

        //this part to make the expression in a simple form as possible as can
        //for ex : 5----15+---5 ===> wil be ==> 5 + 15 - 5
        //15-+5 ==> 15 - 5

        int n = expression.length() ;
        String smipleform = new String() ;
        for (int i = 0 ;i < n ; i++){
            char c = expression.charAt(i) ;
            if (c == ' ') continue;
            if (!Character.isLetterOrDigit(c) && c != '/' && c != '*' && c != '+' && c != '-'&& c != '(' && c != ')'){
                return "Invalid expression having speacial characters" ;
            }
            else if(c == '+' || c == '-') {
                int r , k;
                Boolean first = false ;
                if (c == '+') r = 1 ;
                else r = -1 ;

                for (k = i+1; k < n; k++) {
                    c = expression.charAt(k);
                    if (c == ' ') continue;
                    else if (Character.isLetterOrDigit(c) || c == '(')
                        break;
                    else if (c == '-') r *= -1;
                    else
                        return "invalid expression" ;
                }

                if (r > 0) smipleform += '+' ;
                else smipleform += '-' ; ;
                i = k-1 ;
            }
            else{
                smipleform += c ;
            }
        }
        //////////////////////////////////////////////////////////////////////////////
        //this part to check if there is "**" or "*/" or "//" or "/*" because it's invalid expression

        n =  smipleform.length();
        for (int i = 0 ; i < n-1 ;i++){
            String sub =  smipleform.substring(i,i+1) ;
            if (sub == "**" || sub == "//" ||sub == "*/" || sub == "/*")
                return "invalid expression" ;
        }

        //////////////////////////////////////////////////////////////////////////////
        //this part to use dummy zero to avoid error from negative numbers

        expression = "";
        for (int i = 0 ; i < n ; i++){
            char c = smipleform.charAt(i);
            if (c == '-'){
                if (i == 0) {
                    expression += "(0-";
                    int k ;
                    for ( k = i+1 ; k < n ; k++){
                        if (Character.isDigit(smipleform.charAt(k)))
                            expression+=smipleform.charAt(k);
                        else
                            break;
                    }
                    expression += ")";
                    i = k-1 ;
                }
                else if (!Character.isLetterOrDigit(smipleform.charAt(i-1))){
                    expression += "(0-";
                    int k ;
                    for ( k = i+1 ; k < n ; k++){
                        if (Character.isDigit(smipleform.charAt(k)))
                            expression+=smipleform.charAt(k);
                        else
                            break;
                    }
                    expression += ")";
                    i = k-1 ;
                }
                else
                    expression+=c;
            }

            else
                expression+=c;
        }

        //at this point string expression is simply formed and with dummy zeros to avoid any errors from -ve numbers
        ////////////////////////now let's check if number of operators = number of operations and if not return error
        n = expression.length();
        int operators = 0 , operations = 0 ;
        for (int i = 0 ; i < n ; i++) {
            char c = expression.charAt(i);
            if (Character.isLetter(c))
                operators++;
            else if (c == '+' ||c == '-' ||c == '/' ||c == '*')
                operations++;
            else if (c == '(' || c == ')')
                continue;
            else { //is digit
                int l ;
                operators++;
                for (l = i+1 ; l < n ; l++){
                    c = expression.charAt(l);
                    if(!Character.isDigit(c))
                        break;
                }
                i = l-1;
            }
        }

        if ( (operators != operations+1) || (operations==0 && operators == 1) )
            return "invalid expression";
        /////////////////////////////////////////////////////////////

        String result = new String("");
        Stack s = new Stack();
        for (int i = 0 ; i < n ; i++){
            char c = expression.charAt(i);
            if (c == ' ') continue;

            else if (Character.isLetter(c))
                result += c +" ";

            else if (Character.isDigit(c)){
                result += c ;
                int k ;
                for (k = i+1 ; k < n ; k++){
                    if (!Character.isDigit(expression.charAt(k)))
                        break;
                    else
                        result += expression.charAt(k) ;
                }
                i = k-1 ;
                result+=" ";
            }

            else if (c == '(')
                s.push(c);

            else if (c == ')') {
                while (!s.isEmpty() && (char)s.peek() != (char)'(')
                    result += s.pop()+" ";

                if (!s.isEmpty() && (char)s.peek() != '(')
                    return "invalid expression"; // invalid expression
                else
                    s.pop();
            }

            else // c is an operator is encountered
            {
                while (!s.isEmpty() && Prec(c) <= Prec((char)s.peek())){
                    if((char)s.peek() == '(')
                        return "invalid expression";
                    result += s.pop()+" ";
                }
                s.push(c);
            }

        }

        // pop all remaining operators from the stack
        while (!s.isEmpty()){
            if((char)s.peek() == '(')
                return "invalid expression";
            result += s.pop()+" ";
        }
        return result ;

    }


    /***
     * function to evaluate protfix expression
     * @param expression protfix expression to be evalute
     * postfix expression
     * @return
     */
    public int evaluate(String expression){
        int x , y ;

        Stack s = new Stack();
        int n = expression.length();
        for (int i = 0 ; i < n ; i++){
            char c = expression.charAt(i);
            if(c==' ') continue;
            if (!Character.isLetterOrDigit(c) && c != '/' && c != '*' && c != '+' && c != '-' && c != '(' && c != ')'){
                throw new ArithmeticException("");
            }
        }

        for (int i = 0 ; i < n ; i++){
            char c = expression.charAt(i);
            if (c == ' ')continue;
            else if (Character.isDigit(c)) {
                int k , number = 0 ;
                for (k = i ; i < n ;k++) {
                    c = expression.charAt(k);
                    if (Character.isDigit(c))
                            number = number*10 + Character.getNumericValue(c);
                    else
                        break;
                }
                s.push(number);
                i = k-1  ;
            }
            else{
                y = (int)s.pop();
                x = (int)s.pop();
                if (c == '/') s.push(x/y);
                else if(c == '*') s.push(x*y);
                else if(c == '+') s.push(x+y);
                else s.push(x-y);
            }
        }
        if (s.size() > 1) {
            throw new ArithmeticException("");
        }
        return (int) s.peek();
    }
}
