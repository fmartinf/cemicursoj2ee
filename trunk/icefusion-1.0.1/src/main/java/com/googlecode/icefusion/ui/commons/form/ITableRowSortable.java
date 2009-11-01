package com.googlecode.icefusion.ui.commons.form;


import java.io.Serializable;


/**
 * Defines the minimum requirements for data table row objects, so that a table can be sorted.
 * 
 * @author Rainer Eschen
 * 
 */
public interface ITableRowSortable extends Serializable {

    /**
     * Compare two objects for sorting based on the given attribute name.
     * 
     * @param object Second object to compare this object with
     * @param attribute Attribute name to use for referencing
     * @return 0: equal, -1: lesser than object, +1: greater than object
     */
    public int compareByAttribute(ITableRowSortable object, String attribute);
}
