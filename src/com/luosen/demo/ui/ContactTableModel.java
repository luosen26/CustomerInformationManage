package com.luosen.demo.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.luosen.demo.domain.Phone;

public class ContactTableModel extends AbstractTableModel{
	private String[] columnNames= {"编号","姓名","电话号码","性别","电子邮件","地址","备注"};
	private List<Phone> data=null;
	public ContactTableModel(List<Phone> data) {
		this.data=data;
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Phone phone=data.get(rowIndex);
		switch(columnIndex) {
		case 0:return phone.getP_id();
		case 1:return phone.getP_name();
		case 2:return phone.getP_number();
		case 3:return phone.getP_sex();
		case 4:return phone.getP_email();
		case 5:return phone.getP_addr();
		default:return phone.getP_sign();
		}
	}
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

}
