package CriticalSection.src;

public class ClientManager {

	public static void main(String[] args) {

		FileProcess proceso1 = new FileProcess("Thread 1 is wrtting");
		proceso1.start();
		FileProcess proceso2 = new FileProcess("Thread 2 is writting");
		proceso2.start();
	}
}

class FileProcess extends Thread {
	private String msgLog;

	public FileProcess(String msg) {
		this.msgLog = msg;
	}

	@Override
	public void run() {
		long t1 = System.nanoTime();
		Logger fileLogger = FileLogger.getFileLogger();
		long t2 = System.nanoTime();
		System.out.println("Obtener el objeto de tipo FileLogger tomó: "
				+ (t2 - t1) + " nanosegundos");
		for (int i = 0; i < 20; i++) {
			long t3 = System.nanoTime();
			fileLogger.log(msgLog);
			long t4 = System.nanoTime();
			System.out.println("Escribir en el objeto de tipo FileLogger tomó: "
					+ (t4 - t3) + " nanosegundos");
		}
	}

}
