package coinmachine;

public class Application {
	

	public static void main(String[] args){
		
		final int capacity = 10;  // how many coins the machine can hold

		CoinMachine machine = new CoinMachine( capacity ); //initialize the machine

		// run the user interface
		CoinMachineUI ui1 = new CoinMachineUI( machine ); 
		CoinMachineUI2 ui2 = new CoinMachineUI2( machine );

		// add observer to the machine
		machine.addObserver(ui1);
		machine.addObserver(ui2);
	}
}
