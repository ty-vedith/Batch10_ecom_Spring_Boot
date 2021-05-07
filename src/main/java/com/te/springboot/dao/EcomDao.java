package com.te.springboot.dao;

import java.util.List;

import com.te.springboot.bean.Admin;
import com.te.springboot.bean.Item;

public interface EcomDao {
	
public Admin authenticate(Integer id, String password);
	
	public boolean addItem(Item item);
	
	public boolean removeItem(Integer id);
	
	public Item searchItem(Integer id);
	
	public List<Item> getAllItems();
	
	public boolean updateItem(Item item);

}
