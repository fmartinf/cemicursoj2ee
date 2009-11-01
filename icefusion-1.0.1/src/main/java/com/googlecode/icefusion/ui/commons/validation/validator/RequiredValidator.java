/**
 * Copyright (C) 2009 - info@edorasframework.org
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * 		 http://www.mozilla.org/MPL/MPL-1.1.html
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is edoras framework 1.0.0 open source software code.
 *
 * The Initial Developer of the Original Code is mimacom ag, Switzerland.
 * Portions created by the Initial Developer are Copyright (C) 2009
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *
 * Alternatively, the contents of this file may be used under the terms of
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"
 * License), in which case the provisions of the LGPL License are
 * applicable instead of those above. If you wish to allow use of your
 * version of this file only under the terms of the LGPL License and not to
 * allow others to use your version of this file under the MPL, indicate
 * your decision by deleting the provisions above and replace them with
 * the notice and other provisions required by the LGPL License. If you do
 * not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the LGPL License.
 */
package com.googlecode.icefusion.ui.commons.validation.validator;


import com.googlecode.icefusion.ui.commons.validation.IValidator;


/**
 * Validator to check lowercase for username.
 * 
 * @author Rainer Eschen
 * 
 */
public class RequiredValidator implements IValidator {

    private static final long serialVersionUID = -3246414479415312857L;

    String message = "application.validation.validator.required";

    Object value;

    public String getMessage() {

        return this.message;
    }

    public Object getValue() {

        return this.value;
    }

    public void setMessage(String key) {

        this.message = key;
    }

    public void setValue(Object value) {

        this.value = value;
    }

    public Boolean validate() {

        String input = (String)this.value;
        return input.length() > 0;
    }
}
