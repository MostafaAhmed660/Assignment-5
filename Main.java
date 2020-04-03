package eg.edu.alexu.csd.datastructure.stack.cs;

import java.util.Scanner;

public class Main {
	/***
	 * //////////function for UI of stack////////////////
	 */
	public static void UIstack(){
		Stack s = new Stack();
		int choise ;
		Scanner myObj = new Scanner(System.in);
		while (true){
			try {
				myObj = new Scanner(System.in);
				choise = -1 ;
				System.out.printf("====================================================\n" +
						"select one options for the 5 operations listed below :\n" +
						"===================================================\n" +
						"1: Push\n" +
						"2: Pop\n" +
						"3: Peek\n" +
						"4: Get size\n" +
						"5: Check if empty\n" +
						"6: return to Main Menu\n" +
						"7: exit programme\n" +
						"ENTER YOUR CHOISE PLZ (1 , 2 , 3 , 4 , 5 , 6 or 7)");
				choise = myObj.nextInt();
				if (choise == 1) {
					int value;
					System.out.printf("enter valid number :");
					value = myObj.nextInt();
					s.push(value);
				}
				else if (choise == 2)
					System.out.println("pop value :" + s.pop() + " from stack");

				else if (choise == 3)
					System.out.println("top pf stack is :" + s.peek());

				else if (choise == 4)
					System.out.println("size of stack is :" + s.size());

				else if (choise == 5) {
					if (s.isEmpty())
						System.out.println("stack is Empty");
					else
						System.out.println("stack isn't Empty");
				}
				else if (choise == 6) return;
				else if (choise == 7) System.exit(0);
				else
					System.out.println("INVALID INPUT !! PLZ ENTER VALID INPUT (1 , 2 , 3 , 4 , 5 or 6)");
			}
			catch (Exception e){
				System.out.println("some thing was going wrong PlZ select valid operation");
			}
		}
	}

	/***
	 * //////////function for UI of ExpressionEvaluator////////////////
	 */
	public static void UIExpressionEvaluator(){
		ExpressionEvaluator s = new ExpressionEvaluator();
		int choise ;
		Scanner myObj = new Scanner(System.in);
		while (true){
			try {
				myObj = new Scanner(System.in);
				choise = -1 ;
				System.out.printf("====================================================\n" +
						"select one options for the 2 operations listed below :\n" +
						"===================================================\n" +
						"1: infixToPostfix\n" +
						"2: evaluate expression\n" +
						"3: return to Main Menu\n" +
						"4: exit programme\n" +
						"ENTER YOUR CHOISE PLZ (1 , 2 or 3 )");
				choise = myObj.nextInt();
				if (choise == 1) {
					myObj = new Scanner(System.in);
					System.out.println("Enter valid expression :");
					String str = myObj.nextLine();
					System.out.println(s.infixToPostfix(str));
				}
				else if (choise == 2) {
					myObj = new Scanner(System.in);
					System.out.println("Enter valid expression :");
					String str = myObj.nextLine();
					System.out.println(s.evaluate(str));
				}
				else if (choise == 3) return;
				else if (choise == 4) System.exit(0);
				else
					System.out.println("INVALID INPUT !! PLZ ENTER VALID INPUT (1 , 2 or 3)");
			}
			catch (Exception e){
				System.out.println("some thing is going wrong PlZ select valid expression");
			}

		}
	}

	public static void main(String[] args) {

		Scanner myObj = new Scanner(System.in);
		int choise = -1 ;
		while (true) {
			try {
				myObj = new Scanner(System.in);
				choise = -1;
				System.out.printf("====================================================\n" +
						"select one UI form\n" +
						"=====================\n" +
						"1 . UI of stack implemmentation\n" +
						"2 . UI of Expression Evaluator\n" +
						"3 . exit programme\n" +
						"ENTER YOUR CHOISE PLZ (1 , 2 or 3)\n");

				choise = myObj.nextInt();
				if (choise == 1)
					UIstack();
				else if (choise == 2)
					UIExpressionEvaluator();
				else if (choise == 3)
					return;
				else
					System.out.println("INVALID INPUT !! PLZ ENTER VALID INPUT (1 , 2 or 3)");
			}
			catch (Exception e){
				System.out.println("INVALID INPUT !! PLZ ENTER VALID INPUT (1 , 2 or 3)");
			}
		}

	}
}
