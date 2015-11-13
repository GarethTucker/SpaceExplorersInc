package util;
/**
 * This class is used for debugging
 *
 * @author Gareth
 *
 */
public class PrintTool {

	private static boolean debugging = true;

	public static void p(String s) {
		if (debugging) {
			StackTraceElement[] stackTraceElements = Thread.currentThread()
					.getStackTrace();
			System.out.print(stackTraceElements[2].getClassName() + "."
					+ stackTraceElements[2].getMethodName() + "() line:"
					+ stackTraceElements[2].getLineNumber() + ": ");
			System.out.print(s);
			System.out.println();
		}
	}

	public static void p() {
		if (debugging) {
			StackTraceElement[] stackTraceElements = Thread.currentThread()
					.getStackTrace();
			System.out.print(stackTraceElements[2].getClassName() + "."
					+ stackTraceElements[2].getMethodName() + "() line:"
					+ stackTraceElements[2].getLineNumber() + ": ");
			System.out.print("I MADE IT HERE");
			System.out.println();
		}
	}

	public static void p(Object o) {
		if (debugging) {
			StackTraceElement[] stackTraceElements = Thread.currentThread()
					.getStackTrace();
			if (o == null) {
				System.out.println("NULL");
			} else {
				System.out.print(stackTraceElements[2].getClassName() + "."
						+ stackTraceElements[2].getMethodName() + "() line:"
						+ stackTraceElements[2].getLineNumber() + ": ");
				System.out.print(o.toString());
				System.out.println();
			}
		}
	}
}