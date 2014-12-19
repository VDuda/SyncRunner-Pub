/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.mage;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;

import controller.ChannelController;

/**
 *
 * @author B2E_2
 */
public class MageControl extends ChannelController<Object>{

	@Override
	public void getOrders(Connection conn) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void getInventory(Connection conn) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void createInventory(File data) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public File compareToDB(File data) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public File bulkList(File data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void list(Object data) {
		// TODO Auto-generated method stub
		
	}


}
