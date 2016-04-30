package coinmachine;
import javax.swing.*;
import java.awt.*;
import java.util.*;


public class CoinMachineUI2 extends JFrame implements Observer {

	// attributes for graphical component
	CoinMachine machine;
	Container top = new Container();
	Container bottom = new Container();
	JLabel countLabel = new JLabel("#Coins : 0");
	JLabel acceptLabel = new JLabel("Accepting Coins");

	/*
	 * run the user interface
	 */
	public CoinMachineUI2( CoinMachine machine ){
		this.machine = machine;
		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}
	
	/*
	 * initialize the interface
	 */
	public void initComponent(){

		this.setLayout(new GridLayout( 2 , 0 ));

		this.add(countLabel);
		this.add(acceptLabel);

		countLabel.setHorizontalAlignment(JLabel.CENTER);
		acceptLabel.setHorizontalAlignment(JLabel.CENTER);


		this.setSize(200,100);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	/*
	 * update the intefece when user use the machine
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {

		countLabel.setText("#Coins : " + machine.getCount() );

		if ( machine.isFull() ) acceptLabel.setText("Machine is full");


	}
}
