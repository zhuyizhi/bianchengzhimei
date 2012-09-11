package multithread;

class Run implements Runnable {

	Integer numIhread = new Integer(0);

	int num;
	String numStr = "";

	public Run() {

	}
	@Override
	public void run() {

		// synchronized (numStr) {
		for (int i = 0; i < 100; i++) {
			numStr = "" + i;
			System.out.println(Thread.currentThread().getName() + ":num=" + num
					+ "---numStr:" + numStr + "======numIhread:"
					+ numIhread);
			numIhread++;

		}
		// }

	}

}
public class RunClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Run run1 = new Run();
		// Run run2 = new Run();
		new Thread(run1).start();
		new Thread(run1).start();
	}
}