class Printer{
	String status = "Available";
	synchronized void printDocument(String docName, int copies) {
		
		status = "Busy";
		System.out.println("[Printer] Printing the document ----"+docName);
		
		showPrinterStatus();
		for(int i=1;i<=copies;i++) {
			System.out.println("[Printer] "+docName+" copy ##"+i);
		
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		status = "Available";
	}
	
	void showPrinterStatus() {
		System.out.println("Printer status: "+status);
	}
}
class Laptop extends Thread{
	Printer pRef;
	void attachPrinter(Printer p) {
		pRef = p;
	}
	
	@Override
	public void run() {
		pRef.printDocument("PythonDocument.pdf--------", 10);
	}
}

class Desktop extends Thread{
	Printer pRef;
	void attachPrinter(Printer p) {
		pRef = p;
	}
	
	@Override
	public void run() {
		pRef.printDocument("javaDoc.pdf>>>>>>>>>>>", 10);
	}
}

public class SynchronizationApp {

	public static void main(String[] args) {
		Printer printer = new Printer();
		
//		printer.showPrinterStatus();
//		printer.printDocument("LearningJava.pdf", 10);
//		printer.showPrinterStatus();
		
		Desktop desktop = new Desktop();
		desktop.attachPrinter(printer);
		
		Laptop laptop = new Laptop();
		laptop.attachPrinter(printer);
		
		laptop.start();
		desktop.start();
		
	}

}
