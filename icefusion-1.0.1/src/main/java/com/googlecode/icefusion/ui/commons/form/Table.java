package com.googlecode.icefusion.ui.commons.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

import com.googlecode.icefusion.ui.commons.BackingBeanForm;
import com.googlecode.icefusion.ui.commons.constant.ICEfusionConsts;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.commandsortheader.CommandSortHeader;

import com.icesoft.faces.component.ext.UIColumn;
import com.icesoft.faces.component.ext.HtmlDataTable;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Manages the behavior of a Table.
 * 
 * @author Rainer Eschen
 *
 */
public class Table extends BackingBeanForm {

	private static final long serialVersionUID = -2759703452155575074L;
	
	@Autowired
	private ICEfusionConsts consts;
	
	/**
	 * Binding to create columns on-the-fly.
	 */
	HtmlDataTable dataTable;
	
	/**
	 * Parameters via binding of pseudo data table
	 */
	HtmlDataTable parameters;
	
	/**
	 * true: Ascending sorting chosen by user for the current column.
	 */
	private Boolean sortAscending = true;

	/**
	 * Name of the current column to sort.
	 */
	private String sortColumn;

	/**
	 * Memory for not repeating the same sorting.
	 */
	private Boolean lastSortAscending;
	
	/**
	 * Memory for not repeating the same sorting.
	 */
	private String lastSortColumn;
	
	/**
	 * Represents a list (row object attribute name, column header label) of columns to show. 
	 * Can even be a subset of attributes in rows.
	 */
	private LinkedHashMap<String,String> columns = new LinkedHashMap<String,String>();
	
	/**
	 * All sortable attributes that can be shown in the table.
	 */
	private List<ITableRowSortable> rows = new ArrayList<ITableRowSortable>();

	/**
	 * Initialize all structures for dynamic presentation.
	 */
	protected void init() {
	
		this.columns = ((ITable) parameters.getValue()).getColumnsMap();
		this.rows = ((ITable) parameters.getValue()).getRowsList();
		
		/* We explicitly have to set ids to get all entries shown
		 * http://www.icefaces.org/JForum/posts/list/5416.page#24504
		 */
		dataTable.getChildren().clear();
		for (Map.Entry<String,String> column : columns.entrySet()) {
			UIColumn uiColumn = new UIColumn();
			uiColumn.setId("Column" + column.getKey());
			dataTable.getChildren().add(uiColumn);
			CommandSortHeader sortHeader = new CommandSortHeader();
			sortHeader.setId("Header" + column.getKey());
			sortHeader.setColumnName(column.getKey());
			HtmlOutputText sortHeaderOutputText = new HtmlOutputText();
			sortHeaderOutputText.setId("HeaderText" + column.getKey());
			sortHeaderOutputText.setValue(consts.getLocalized(column.getValue()));
			sortHeader.getChildren().add(sortHeaderOutputText);
			uiColumn.getFacets().put("header",sortHeader);
			// We need a class-specific output here
			HtmlOutputText outputText = new HtmlOutputText();
			outputText.setId("Text" + column.getKey());
			outputText.setValueExpression("value",
	                consts.createValueExpression("#{iceFusionTableRows." + column.getKey() + "}", String.class));			
			uiColumn.getChildren().add(outputText);
		}
	}
	
	/**
	 * Pseudo initialization starter.
	 * @return dummy value
	 */
	public String getInitializer() {
		
		this.init();
		return "";
	}
	
	/**
	 * Process sorting after the user has clicked on a column header.
	 */
	protected void sort() {

        Comparator comparator = new Comparator() {
        	
        	public int compare(Object o1, Object o2) {
                
            	ITableRowSortable object1 = (ITableRowSortable) o1;
            	ITableRowSortable object2 = (ITableRowSortable) o2;
            	return sortAscending ? object1.compareByAttribute(object2, sortColumn) :
            		object2.compareByAttribute(object1, sortColumn);
            }
        };
        Collections.sort(rows, comparator);        
    }
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {

		this.dataTable = dataTable;
	}

	public HtmlDataTable getParameters() {
		return parameters;
	}

	public void setParameters(HtmlDataTable parameters) {
		this.parameters = parameters;
	}

	public Boolean getLastSortAscending() {
		return lastSortAscending;
	}

	public void setLastSortAscending(Boolean lastSortAscending) {
		this.lastSortAscending = lastSortAscending;
	}

	public String getLastSortColumn() {
		return lastSortColumn;
	}

	public void setLastSortColumn(String lastSortColumn) {
		this.lastSortColumn = lastSortColumn;
	}

	public Boolean getSortAscending() {
		return sortAscending;
	}

	public void setSortAscending(Boolean sortAscending) {
		// Sort only if the parameter has changed
		if (!sortAscending.equals(this.sortAscending)) {
			this.sortAscending = sortAscending;
			this.sort();
		}
	}
	
	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		// Sort only if the parameter has changed
		if (!sortColumn.equals(this.sortColumn)) {
			this.sortColumn = sortColumn;
			this.sort();
		}
	}

	public LinkedHashMap<String, String> getColumns() {
		return columns;
	}

	public void setColumns(LinkedHashMap<String, String> columns) {
		this.columns = columns;
	}

	public List<ITableRowSortable> getRows() {

		return this.rows;
	}

	public void setRows(List<ITableRowSortable> rows) {

		this.rows = rows;
	}
	
	/**
	 * Decides if a paginator has to be shown
	 * @return true: it has to be shown
	 */
	public Boolean getShowPaginator() {
		
		if (this.dataTable.getRows() == 0) {
			return false;
		}
		return this.rows.size() > this.dataTable.getRows();
	}
}
