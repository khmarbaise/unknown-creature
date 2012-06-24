package com.soebes.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Homepage
 */
public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    // TODO Add any page properties or variables here

    /**
     * Constructor that is invoked when page is invoked without a session.
     * 
     * @param parameters
     *            Page parameters
     */
    public HomePage(final PageParameters parameters) {

	// Add the simplest type of label
	add(new Label("message", "If you see this message wicket is properly configured and running"));

	FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
	add(feedbackPanel);

	// Add a form with an onSubmit implementation that sets a message
	add(new Form("form") {
	    protected void onSubmit() {
		info("the form was submitted!");
	    }
	});
    }
}
