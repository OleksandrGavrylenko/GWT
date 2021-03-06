package com.manning.gwtia.ch17.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;


public class Examples implements EntryPoint, ValueChangeHandler<String>
{

	
	ExamplePanel examples = new ExamplePanel();
	
    public void onModuleLoad ()
    {
        RootPanel.get().add(examples, 0, 0);
    	setUpHistoryManagement();
    }
    
    
    
	public void setUpHistoryManagement(){
		// Make this class your history manager (see onValueChange method)
		History.addValueChangeHandler(this);
		// Handle any existing history token
		History.fireCurrentHistoryState();
	}
	
	
	public void onValueChange(ValueChangeEvent<String> event) {
		// Get the token from the event
		String page = event.getValue().trim();
		// Check if the token is null or empty
		if ((page == null) || (page.equals(""))){}
			//showHomePage();
		// Else check what the token is and call the appropriate method.
		else if (page.equals(HistoryTokens.COMPUTESTYLE))
			examples.showComputeStyle();
		else if (page.equals(HistoryTokens.INTRODUCTION))
			examples.showInstructionsPanel();
		else if (page.equals(HistoryTokens.PROPERTY))
			examples.showPropertyExample();
	}
    
}
