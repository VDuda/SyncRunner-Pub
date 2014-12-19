package com.v3.utilities;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * 
 * @author Volodimir Duda
 *
 *	This Adapter is intended for use ONLY by JTextField Components.
 *	Forces Text to be highlighted on FocusGained, with minor Foreground variation (Gray -> Black)
 *	Forces Text to be altered if empty on FocusLost, with minor Foreground variation (Black -> Gray)
 */
public class ContextFocusListener extends FocusAdapter {
	
	private String message = "";
	
	/**
	 * Default constructor
	 */
	public ContextFocusListener(){
		super();
	}
	
	/**
	 * Attach a message to the text when blank field
	 * @param message - String
	 */
	public ContextFocusListener(String message){
		this.message = message;
		
	}

	/**
	 * <b>Very important! </b> - Method will try to alter text color and Text format
	 */
	@Override
	public void focusLost(FocusEvent e){
		//System.out.println("He Left me!");
		e.getComponent().setForeground(Color.GRAY);
		if(((javax.swing.JTextField)e.getComponent()).getText().isEmpty())//check if JTextField is empty
			((javax.swing.JTextField)e.getComponent()).setText(message);//set this text if true
	}
	
	/**
	 * <b>Very important! </b> - Method will try to alter text color and Text format
	 */
	@Override
	public void focusGained(FocusEvent e){
		//System.out.println("He Married me!");
		e.getComponent().setForeground(Color.BLACK);
		((javax.swing.JTextField)e.getComponent()).selectAll();;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
		
	
}
