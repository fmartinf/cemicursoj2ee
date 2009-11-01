package com.googlecode.icefusion.ui.commons.form;


import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * Defines all methods for the data table management.
 * 
 * @author Rainer Eschen
 * 
 */
public interface ITable extends Serializable {

    public List<ITableRowSortable> getRowsList();

    public LinkedHashMap<String, String> getColumnsMap();
}
