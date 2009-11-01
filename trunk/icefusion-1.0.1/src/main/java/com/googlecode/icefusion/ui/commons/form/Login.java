package com.googlecode.icefusion.ui.commons.form;


import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.icefusion.ui.commons.BackingBeanForm;
import com.googlecode.icefusion.ui.commons.constant.Context;
import com.googlecode.icefusion.ui.commons.constant.ICEfusionConsts;
import com.googlecode.icefusion.ui.commons.constant.Locale;
import com.googlecode.icefusion.ui.commons.validation.IValidationProcessor;
import com.googlecode.icefusion.ui.commons.validation.Validation;
import com.googlecode.icefusion.ui.commons.validation.validator.PasswordLengthValidator;
import com.googlecode.icefusion.ui.commons.validation.validator.RequiredValidator;
import com.googlecode.icefusion.ui.commons.validation.validator.UsernameLowerCaseValidator;
import com.icesoft.faces.component.ext.HtmlDataTable;


/**
 * Manages the behavior of a login form.
 * 
 * @author Rainer Eschen
 * 
 */
public class Login extends BackingBeanForm implements IValidationProcessor {

    private static final long serialVersionUID = 5019986113172641800L;

    @Autowired
    private ICEfusionConsts consts;

    @Autowired
    private Context context;

    /**
     * Parameters via binding of pseudo data table
     */
    HtmlDataTable parameters;

    private String username;

    private String password;

    /**
     * Validation results to show.
     */
    private List<String> validationMessages = new ArrayList<String>();

    /**
     * Field that is in validation.
     */
    private String validationField;

    /**
     * Define validation for password
     */
    private Validation usernameValidation = new Validation(this, new RequiredValidator(),
            new UsernameLowerCaseValidator());

    /**
     * Define validation for password
     */
    private Validation passwordValidation = new Validation(this, new RequiredValidator(), new PasswordLengthValidator());

    /**
     * Available Languages
     */
    public SelectItem[] getLocales() {

        SelectItem[] locales = new SelectItem[this.context.getSettings().getLocales().size()];
        int i = 0;
        for (Locale locale : this.context.getSettings().getLocales()) {
            locales[i++] = new SelectItem(locale.getCode(), consts.getLocalized(locale.getLabel(), "icefusion"));
        }
        return locales;
    }

    /**
     * Process login form
     * 
     * @return navigation id
     */
    public String login() {

        this.usernameValidation();
        this.passwordValidation();
        if (!this.getValidationErrorStatus()) {
            ((ILogin)parameters.getValue()).setLoginUsername(this.getUsername());
            ((ILogin)parameters.getValue()).setLoginPassword(this.getPassword());
            return ((ILogin)parameters.getValue()).loginAction();
        }
        return null;
    }

    public void usernameValidation() {

        if (!this.getValidationErrorStatus()) {
            this.setValidationField("application.login.username");
            this.usernameValidation.validateValue(this.username);
        }
    }

    public void passwordValidation() {

        if (!this.getValidationErrorStatus()) {
            this.setValidationField("application.login.password");
            this.passwordValidation.validateValue(this.password);
        }
    }

    public String getLocale() {
        return this.context.getSettings().getLocale().getCode();
    }

    public void setLocale(String locale) {
        this.context.getSettings().setLocale(locale);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HtmlDataTable getParameters() {
        return parameters;
    }

    public void setParameters(HtmlDataTable parameters) {
        this.parameters = parameters;
    }

    public String validationDialogButtonOk() {
        this.validationMessages.clear();
        return null;
    }

    public Boolean getValidationErrorStatus() {
        return this.validationMessages.size() > 0;
    }

    public List<String> getValidationMessages() {
        return this.validationMessages;
    }

    public void setValidationMessages(List<String> messages) {
        this.validationMessages = messages;
    }

    public String getValidationField() {
        return this.validationField;
    }

    public void setValidationField(String field) {
        this.validationField = field;
    }
}
