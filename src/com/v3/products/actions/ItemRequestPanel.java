package com.v3.products.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.lang.WordUtils;

import com.jidesoft.hints.ListDataIntelliHints;
import com.jidesoft.swing.AutoCompletion;
import com.jidesoft.swing.ComboBoxSearchable;
import com.jidesoft.swing.Searchable;
import com.v3.actions.ActionFindor;
import com.v3.dto.Brand;
import com.v3.dto.Category;
import com.v3.dto.ColorMap;
import com.v3.dto.Size;
import com.v3.dto.Style;
import com.v3.utilities.ContextFocusListener;
import com.v3.utilities.ContextMenuMouseListener;

public class ItemRequestPanel extends JPanel {
	
	//private ItemRequest 
	
	//Colors
	public static final Color BLACK = Color.BLACK;
	public static final Color BLUE = Color.decode("#000080");
    public static final Color BROWN = Color.decode("#8B4513");
    public static final Color GRAY = Color.decode("#808080");
    public static final Color GREEN = Color.decode("#008000");
    public static final Color BEIGE = Color.decode("#F5F5DC");
    public static final Color IVORY = Color.decode("#FFFFF0");
    public static final Color WHITE = Color.WHITE;
    public static final Color PINK = Color.decode("#FF69B4");
    public static final Color PURPLE = Color.decode("#800080");
    public static final Color RED = Color.decode("#FF0000");
    public static final Color ORANGE = Color.decode("#FFA500");
    public static final Color YELLOW = Color.decode("#FFFF00");
    public static final Color DEFAULT = new Color(240,240,240);
	
	//Local Variables
	private List<Item> ItemList = new ArrayList<Item>();
	private AutoCompletion comboColorHolder;
	private AutoCompletion comboSizeHolder;
	private AutoCompletion txtBrandHolder;
	ListDataIntelliHints<Brand> brandHints;
	ListDataIntelliHints<Style> styleHints;
	ListDataIntelliHints<Category> categoryHints;
	ListDataIntelliHints<ColorMap> colorMapHints;
	//private AutoCompletion txt;

	private final ImageIcon ICON = new ImageIcon(ItemRequestPanel.class.getResource("/images/no-image-icon.png"));
	private JList list;
	private JPanel panelImg;
	private JPanel panelColor;
	private JLabel lblImg;
	private JLabel lblTitle;
	private JLabel lblBrand;
	private JLabel lblStyle;
	private JLabel lblGroup;
	private JLabel lblSize;
	private JLabel lblSizeMap;
	private JLabel lblColor;
	private JLabel lblColorMap;
	private JComboBox txtColor;
	private JTextField txtTitle;
	private JTextField txtBrand;
	private JTextField txtGroup;
	private JTextField txtStyle;
	private JTextField txtSizeMap;
	private JTextField txtColorMap;
	private JLabel lblStatus;
	private JButton btnNew;
	private JButton btnSave;
	private JButton btnRemove;
	private JLabel lblGender;
	private JComboBox comboGender;
	private JComboBox comboSize;

	private ActionFindor FinderService = new ActionFindor(); 
	private JLabel lblTitleR;
	private JTextField txtTitleR;
	private JTextField txtMaterial;

	/**
	 * Create the panel.
	 */
	public ItemRequestPanel() {
		
		setLayout(null);
		//setPreferredSize(new Dimension(600, 350));
		
		JLabel lblAmazonResults = new JLabel("Results:");
		lblAmazonResults.setBounds(10, 11, 70, 14);
		add(lblAmazonResults);
		
		list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 11));
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {//Listener fires twice, 1:deselect 2:select
				int selected = list.getSelectedIndex();
				if(!e.getValueIsAdjusting()){
				//System.out.println(amznItems.size());
				//System.out.println("Current Item selected: "+selected);
					populateSelection();
				}
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(10, 36, 162, 100);
		add(list);
		
		panelImg = new JPanel();
		panelImg.setBounds(200, 36, 106, 100);
		panelImg.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(panelImg);
		panelImg.setLayout(new BorderLayout(0, 0));
		
		lblImg = new JLabel();
		panelImg.add(lblImg, BorderLayout.CENTER);
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		

		lblImg.setIcon(ICON);
		
		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(10, 238, 48, 14);
		add(lblTitle);
		
		lblBrand = new JLabel("Brand:");
		lblBrand.setBounds(350, 44, 60, 14);
		add(lblBrand);
		
		lblStyle = new JLabel("Style:");
		lblStyle.setBounds(350, 97, 60, 14);
		add(lblStyle);
		
		lblGroup = new JLabel("Product:");
		lblGroup.setBounds(350, 69, 60, 14);
		add(lblGroup);
		
		lblSize = new JLabel("Size:");
		lblSize.setBounds(10, 199, 48, 14);
		add(lblSize);
		
		lblSizeMap = new JLabel("Size-Map:");
		lblSizeMap.setBounds(155, 199, 79, 14);
		add(lblSizeMap);
		
		lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 174, 48, 14);
		add(lblColor);
		
		lblColorMap = new JLabel("Color-Map:");
		lblColorMap.setBounds(155, 174, 79, 14);
		add(lblColorMap);
		
		panelColor = new JPanel();
		panelColor.setBackground(DEFAULT);
		panelColor.setBounds(10, 139, 28, 24);
		panelColor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		add(panelColor);
		
		txtColor = new JComboBox();
		txtColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String color = txtColor.getSelectedItem().toString();
				Color sc = DEFAULT;
				
				//System.out.println("ACTION EVENT~");
				
				if(color.equals("Black")){
					sc = BLACK;
				}else if(color.equals("Blue")){
					sc = BLUE;
				}else if(color.equals("Brown")){
					sc = BROWN;
				}else if(color.equals("Gray")){
					sc = GRAY;
				}else if(color.equals("Green")){
					sc = GREEN;
				}else if(color.equals("Beige")){
					sc = BEIGE;
				}else if(color.equals("Ivory")){
					sc = IVORY;
				}else if(color.equals("White")){
					sc = WHITE;
				}else if(color.equals("Pink")){
					sc = PINK;
				}else if(color.equals("Purple")){
					sc = PURPLE;
				}else if(color.equals("Red")){
					sc = RED;
				}else if(color.equals("Orange")){
					sc = ORANGE;
				}else if(color.equals("Yellow")){
					sc = YELLOW;
				}
				
				//MULTI is not implemented yet, just use Default
				panelColor.setBackground(sc);
			}
		});
		txtColor.setBounds(59, 171, 86, 20);
		add(txtColor);
		
		txtTitle = new JTextField();
		txtTitle.addMouseListener(new ContextMenuMouseListener());
		txtTitle.addFocusListener(new ContextFocusListener("N/A"));
		txtTitle.setBounds(48, 232, 497, 20);
		add(txtTitle);
		txtTitle.setColumns(10);
		
		txtBrand = new JTextField();
		txtBrand.addMouseListener(new ContextMenuMouseListener());
		txtBrand.addFocusListener(new ContextFocusListener("N/A"));
		txtBrand.setBounds(411, 41, 134, 20);
		add(txtBrand);
		txtBrand.setColumns(10);
		
		txtGroup = new JTextField();
		txtGroup.addMouseListener(new ContextMenuMouseListener());
		txtGroup.addFocusListener(new ContextFocusListener("N/A"));
		txtGroup.setBounds(411, 66, 134, 20);
		add(txtGroup);
		txtGroup.setColumns(10);
		
		txtStyle = new JTextField();
		txtStyle.addMouseListener(new ContextMenuMouseListener());
		txtStyle.addFocusListener(new ContextFocusListener("N/A"));
		txtStyle.setBounds(411, 91, 134, 20);
		add(txtStyle);
		txtStyle.setColumns(10);
		
		txtSizeMap = new JTextField();
		txtSizeMap.addMouseListener(new ContextMenuMouseListener());
		txtSizeMap.addFocusListener(new ContextFocusListener("N/A"));
		txtSizeMap.setColumns(10);
		txtSizeMap.setBounds(214, 196, 122, 20);
		add(txtSizeMap);
		
		txtColorMap = new JTextField();
		txtColorMap.addMouseListener(new ContextMenuMouseListener());
		txtColorMap.addFocusListener(new ContextFocusListener("N/A"));
		txtColorMap.setColumns(10);
		txtColorMap.setBounds(214, 171, 122, 20);
		add(txtColorMap);
		
		lblStatus = new JLabel("None Found");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(90, 11, 79, 14);
		add(lblStatus);
		
		btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Button Defaults
				comboGender.setSelectedIndex(0);
				
				//Item Defaults
				Item item = new Item();
				item.setBrand("N/A");
				item.setStyle("N/A");
				item.setColorMap("N/A", "N/A");
				item.setSizeMap("N/A", "N/A");
				item.setImgThumb("");
				item.setOnAmazon(false);
				System.out.println(item==null);
				System.out.println(ItemList==null);
				ItemList.add(item);
				rebuildListModel();
			}
		});
		btnNew.setBounds(200, 7, 89, 23);
		add(btnNew);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				save();
			}
			
		});
		btnSave.setBounds(297, 7, 89, 23);
		add(btnSave);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(list.getModel().getSize()>0){
					ItemList.remove(list.getSelectedIndex());
					rebuildListModel();
				}
			}
			
		});
		btnRemove.setBounds(396, 7, 89, 23);
		add(btnRemove);
		
		lblGender = new JLabel("Gender:");
		lblGender.setBounds(350, 122, 79, 14);
		add(lblGender);
		
		comboGender = new JComboBox();
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"Select...", "Men", "Women"}));
		comboGender.setBounds(411, 122, 109, 20);
		add(comboGender);
		
		lblTitleR = new JLabel("TitleR:");
		lblTitleR.setBounds(10, 261, 48, 14);
		add(lblTitleR);
		
		
		txtTitleR = new JTextField();
		txtTitleR.setColumns(10);
		txtTitleR.setBounds(48, 255, 497, 20);
		add(txtTitleR);
		
		
		
		for(com.v3.dto.Color o:FinderService.findAllColor()){
			txtColor.addItem(o.getColor());
		}
		
		Searchable colors=  new ComboBoxSearchable(txtColor);
		comboColorHolder = new AutoCompletion(txtColor,colors);
		
		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setBounds(350, 174, 48, 14);
		add(lblMaterial);
		
		txtMaterial = new JTextField();
		txtMaterial.addMouseListener(new ContextMenuMouseListener());
		txtMaterial.addFocusListener(new ContextFocusListener("N/A"));
		txtMaterial.setColumns(10);
		txtMaterial.setBounds(411, 171, 134, 20);
		add(txtMaterial);
		
		comboSize = new JComboBox();
		for(Size o:FinderService.findAllSize()){
			comboSize.addItem(o.getSize());
		}
		Searchable sizes=  new ComboBoxSearchable(comboSize);
		comboSizeHolder = new AutoCompletion(comboSize,sizes);
		comboSize.setBounds(59, 196, 86, 20);
		add(comboSize);
		
		reloadHints();


	}
	
	private void reloadHints(){
		brandHints = new ListDataIntelliHints<Brand>(txtBrand, FinderService.findAllBrand());
		styleHints = new ListDataIntelliHints<Style>(txtStyle, FinderService.findAllStyle());
		categoryHints = new ListDataIntelliHints<Category>(txtGroup, FinderService.findAllCategory());
		colorMapHints = new ListDataIntelliHints<ColorMap>(txtColorMap, FinderService.findAllColorMap());

	}
	
	private String buildTitleR(){
		//[Brand]+[Gender/Age Group]+[Product Line]+[Color]+[Material*]+[Shoe Type]+[Size] 
		//Kenneth Cole REACTION Women's Work Space Black Leather Pump 7.5 M US

		StringBuilder sb = new StringBuilder("");
		sb.append(txtBrand.getText());
		sb.append(" ");
		sb.append(WordUtils.capitalizeFully(comboGender.getSelectedItem().toString()));
		sb.append("'s ");
		sb.append(txtStyle.getText());
		if(txtMaterial.getText().contains("Leather")){
			sb.append(" ");
			sb.append(txtMaterial.getText());
		}
		sb.append(" ");
		sb.append(txtGroup.getText());
		return sb.toString();
	}
	
	/**
	 * Rebuilds the model, allows for the panel to be dynamic.
	 * Uses data attained from the getAmznItem() method via amznItems List
	 * Data is attained from AmznItems list, add items to that list and call this 
	 * method to make data visible
	 */
	private void rebuildListModel(){

		
		System.out.println("Rebuilt Item!");
		DefaultListModel data =  new DefaultListModel(); //GARBARGE COLLECTION is REQUIRED! 
		//System.out.println(amznItems.size());
		if(ItemList!=null)
		for(Item item: ItemList){
			data.addElement(item.getBrand()+" "+item.getStyle());
		}
		
		list.setModel(data);
		if(data.size()>0){
			list.setSelectedIndex(0);
		}
		reloadHints();// <- too memory intensive, instead just add the string locally
		//buildSelection(); <- this is auto called when Model is changed
	}
	
	/**
	 * Grabs the required data based on selected item in the list.
	 * Auto called by ListSelectionListener when Model is rebuilt.
	 */
	private void populateSelection(){
		//THIS METHOD NEEDS TO BE REBUILT/RESTRUCTURED

		int i = list.getSelectedIndex();
		ImageIcon ico = ICON;
		
		if(i>=0){
			Item item = ItemList.get(i);
			
			
			try {
				if(!item.getImgThumb().isEmpty())
					ico = new ImageIcon(new URL(item.getImgThumb()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			lblStatus.setText("Found "+ (list.getModel().getSize()));
			lblImg.setIcon(ico);
			txtTitle.setText(item.getTitle());
			txtBrand.setText(item.getBrand());
			txtStyle.setText(item.getStyle());
			txtGroup.setText(item.getProductGroup());
			txtColorMap.setText(item.getColorMap().getColorMap());
			String gender = item.getGender();

			if(gender.toUpperCase().startsWith("M")){
				comboGender.setSelectedIndex(1);
			}else if(gender.toUpperCase().startsWith("W")){
				comboGender.setSelectedIndex(2);
			}else{
				comboGender.setSelectedIndex(0);
			}
			txtMaterial.setText(item.getMaterial());
			txtColor.setSelectedItem(item.getColorMap().getColor().getColor());
			txtSizeMap.setText(item.getSizeMap().getSizeMap());
			comboSize.setSelectedItem(item.getSizeMap().getSize().getSize());
			txtTitleR.setText(buildTitleR());

		} else{
			lblStatus.setText("None Found");
			lblImg.setIcon(ico);
			txtTitle.setText("");
			txtBrand.setText("");
			txtStyle.setText("");
			txtGroup.setText("");
			txtColorMap.setText("");
			txtMaterial.setText("");
			txtColor.setSelectedIndex(0);
			txtSizeMap.setText("");
			txtTitleR.setText("");
			comboSize.setSelectedIndex(0);
			comboGender.setSelectedIndex(0);
			panelColor.setBackground(DEFAULT);
			
		}
	}
	
	/*
	public Item getInventoryItem(int id){
		Item item = productService.findById(id);
		return null;
	}*/	
	
	/**
	 * <p>Logically checks each channel, starting with Local Inventory.</p>
	 * @param upc
	 * @return List of Items, will return <b>null</b> if nothing found
	 */
	public List<Item> getItem(String upc){
		boolean itemFound = false;
		
		ItemRequest itemRequest = null;
		
		//Search Inventory
		itemRequest = new ItemRequestDB();
		System.out.println("Searching Inventory");
		itemFound = itemRequest.findItem(upc);
		if(itemFound){
			JOptionPane.showMessageDialog(null, "Similar item exists in DB. ");
			setItemList(itemRequest.getItems());
			return itemRequest.getItems();
		}
		
		//Search Amazon
		itemRequest = new ItemRequestAMZ();
		System.out.println("Searching Amazon");
		itemFound = itemRequest.findItem(upc);
		if(itemFound){
			setItemList(itemRequest.getItems());
			
			return itemRequest.getItems();
		}
		
		//Search etc...
		setItemList(null); //Nothing found, rebuild empty list
		return itemRequest.getItems();
	}
	
	public Item getSelectedItem(){
		int selected = list.getSelectedIndex();
		if(selected>=0){
			Item item = ItemList.get(selected);
			System.out.println(selected);
			save();
			return item;
		}else{
			return null;
		}
	}
	
	private void save(){
		int i = list.getSelectedIndex();
		if(i>=0){
			Item item = ItemList.get(i);
			item.setBrand(txtBrand.getText());
			item.setColorMap(txtColorMap.getText(),
					txtColor.getSelectedItem().toString());
			item.setGender(comboGender.getSelectedItem().toString());
			item.setProductGroup(txtGroup.getText());
			item.setSizeMap(txtSizeMap.getText(),
					(String)comboSize.getSelectedItem());
			item.setMaterial(txtMaterial.getText());
			item.setStyle(txtStyle.getText());
			//item.setStyleNum(txtStyleNum);
			item.setTitle(txtTitle.getText());
			//item.setWidth(width);
			rebuildListModel();
		}
	}
	
	/**
	 * @return the itemList
	 */
	public List<Item> getItemList() {
		return ItemList;
	}

	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(List<Item> itemList) {
		//if(itemList!=null)
		ItemList = itemList;
		rebuildListModel();
	}
}
