package coinmachine;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;


public class CoinMachineUI extends JFrame implements Observer {
	
	// attributes for graphical components
	CoinMachine machine;
	JPanel top = new JPanel();
	JPanel bottom = new JPanel();
	JLabel balanceLabel = new JLabel( "Balance : 0");
	JLabel statusLabel = new JLabel( "Status :");
	JButton oneBaht = new JButton();
	JButton fiveBaht = new JButton();
	JButton tenBaht = new JButton();
	Border border = BorderFactory.createTitledBorder("Insert Money");
	JProgressBar bar;
	
	
	/*
	 * run the user interface
	 */
	public CoinMachineUI( CoinMachine machine ){
		
		this.machine = machine;
		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}
	
	/*
	 * initialize the inteface
	 */
	public void initComponent(){
		
		this.setLayout( new FlowLayout() );
		this.add(top);
		this.add(bottom);
		
		top.setLayout(new GridLayout( 0 , 3 ));
		bottom.setLayout(new FlowLayout());
		
		bottom.setBorder(border);
	
		bar = new JProgressBar( 0 , machine.getCapacity() );
		
		top.add(balanceLabel);
		top.add(statusLabel);
		top.add(bar);
		
		balanceLabel.setHorizontalAlignment(JLabel.CENTER);
		statusLabel.setHorizontalAlignment(JLabel.CENTER);
	
		oneBaht.setIcon(new ImageIcon(CoinMachineUI.class.getResource("/images/1baht.png")));
		fiveBaht.setIcon(new ImageIcon(CoinMachineUI.class.getResource("/images/5baht.png")));
		tenBaht.setIcon(new ImageIcon(CoinMachineUI.class.getResource("/images/10baht.png")));
		
		bottom.add(oneBaht);
		bottom.add(fiveBaht);
		bottom.add(tenBaht);
		
		
		// add action listener to all buttons
		oneBaht.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				machine.insert(new Coin(1));
			}
			
			
		});
		
		fiveBaht.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				
				machine.insert(new Coin(5));
			}
		});
		
		tenBaht.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				
				machine.insert(new Coin(10));
			}
		});
		
		bar.setValue(0);
		bar.setString("0");
		bar.setStringPainted(true);
		
		this.setSize(450,200);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	/*
	 * observer when user input coins and update the interface
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		
		balanceLabel.setText("Balance : " + machine.getBalance());
		bar.setValue(machine.getCount());
		bar.setString(String.valueOf(machine.getCount()));
		
	}
	
	
}
