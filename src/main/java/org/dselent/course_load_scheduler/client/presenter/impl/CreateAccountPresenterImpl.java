package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidAccountCreationAction;
import org.dselent.course_load_scheduler.client.action.LoadLoginPageAction;
import org.dselent.course_load_scheduler.client.action.SendCreateAccountAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidAccountCreationStrings;
import org.dselent.course_load_scheduler.client.event.InvalidAccountCreationEvent;
import org.dselent.course_load_scheduler.client.event.LoadCreateAccountEvent;
import org.dselent.course_load_scheduler.client.event.LoadLoginPageEvent;
import org.dselent.course_load_scheduler.client.event.SendCreateAccountEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.exceptions.PasswordCharacterException;
import org.dselent.course_load_scheduler.client.exceptions.PasswordLengthException;
import org.dselent.course_load_scheduler.client.exceptions.PasswordMatchException;
import org.dselent.course_load_scheduler.client.model.FacultyType;
import org.dselent.course_load_scheduler.client.presenter.CreateAccountPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.CreateAccountView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.inject.Inject;

public class CreateAccountPresenterImpl extends BasePresenterImpl implements CreateAccountPresenter {

	private CreateAccountView view;
	private IndexPresenter parentPresenter;
	private boolean createAccountClickInProgress;

	@Inject
	public CreateAccountPresenterImpl(IndexPresenter parentPresenter, CreateAccountView view) {
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		createAccountClickInProgress = false;
	}

	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;

		registration = eventBus.addHandler(LoadCreateAccountEvent.TYPE, this);
		eventBusRegistration.put(LoadCreateAccountEvent.TYPE, registration);

		registration = eventBus.addHandler(InvalidAccountCreationEvent.TYPE, this);
		eventBusRegistration.put(InvalidAccountCreationEvent.TYPE, registration);
	}

	@Override
	public void onLoadCreateAccount(LoadCreateAccountEvent evt) {
		populateComboBox();
		this.go(parentPresenter.getView().getViewRootPanel());
	}
	
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}

	public CreateAccountView getView() {
		return view;
	}

	@Override
	public IndexPresenter getParentPresenter() {
		return parentPresenter;
	}

	@Override
	public void loadLoginPage() {
		eventBus.fireEvent(new LoadLoginPageEvent(new LoadLoginPageAction()));
	}

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter) {
		this.parentPresenter = parentPresenter;
	}

	public void populateComboBox() {
		ListBox box = view.getFacultyTypeComboBox();
		box.clear();

		List<FacultyType> types = retrieveFacultyTypes();
		Iterator<FacultyType> iterator = types.iterator();


		while(iterator.hasNext()) {
			FacultyType type = iterator.next();

			box.addItem(type.getType(), Integer.toString(type.getId()));
		}

		view.setFacultyTypeComboBox(box);
	}

	private List<FacultyType> retrieveFacultyTypes() {
		FacultyType admin = new FacultyType();
		admin.setId(0);
		admin.setType("user");
		FacultyType user = new FacultyType();
		user.setId(1);
		user.setType("admin");

		List<FacultyType> ret = new ArrayList<FacultyType>();
		ret.add(admin);
		ret.add(user);
		return ret;

	}

	@Override
	public void createAccount() {

		if(!createAccountClickInProgress)
		{
			createAccountClickInProgress = true;
			view.getSubmitButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			String firstName = view.getFirstNameTextBox().getText();
			String lastName = view.getLastNameTextBox().getText();
			String email = view.getEmailTextBox().getText();
			ListBox ftBox = view.getFacultyTypeComboBox();
			String facultyType = ftBox.getValue(ftBox.getSelectedIndex());
			String password = view.getPasswordTextBox().getText();
			String confirmPassword = view.getConfirmPasswordTextBox().getText();

			boolean validFirstName = true;
			boolean validLastName = true;
			boolean validEmail = true;
			boolean validPassword = true;

			List<String> invalidReasonList = new ArrayList<>();

			try
			{
				validateForNullString(firstName);
			}catch(EmptyStringException e){
				invalidReasonList.add(InvalidAccountCreationStrings.NULL_FIRST_NAME);
				validFirstName = false;
			}

			try
			{
				validateForNullString(lastName);
			}catch(EmptyStringException e){
				invalidReasonList.add(InvalidAccountCreationStrings.NULL_LAST_NAME);
				validLastName = false;
			}

			try
			{
				validateForNullString(email);
			}catch(EmptyStringException e){
				invalidReasonList.add(InvalidAccountCreationStrings.NULL_EMAIL);
				validEmail = false;
			}

			try
			{
				validatePassword(password, confirmPassword);
			} catch(EmptyStringException e) {
				invalidReasonList.add(InvalidAccountCreationStrings.NULL_PASSWORD);
				validPassword = false;
			} catch(PasswordLengthException e) {
				invalidReasonList.add(InvalidAccountCreationStrings.TOO_SHORT);
				validPassword = false;
			} catch(PasswordCharacterException e) {
				invalidReasonList.add(InvalidAccountCreationStrings.NO_SPECIAL_CHARACTERS);
				validPassword = false;
			} catch(PasswordMatchException e) {
				invalidReasonList.add(InvalidAccountCreationStrings.NO_MATCH);
				validPassword = false;
			}

			if(validFirstName && validLastName && validEmail && validPassword)
			{
				sendCreateAccount(firstName, lastName, facultyType, email, password);
			}
			else
			{
				InvalidAccountCreationAction ila = new InvalidAccountCreationAction(invalidReasonList);
				InvalidAccountCreationEvent ile = new InvalidAccountCreationEvent(ila);
				eventBus.fireEvent(ile);
			}
		}
	}

	/*@Override
	public void onInvalidAccountCreation(InvalidAccountCreationEvent evt) {
		createAccountClickInProgress = false;
		view.getSubmitButton().setEnabled(true);
		parentPresenter.hideLoadScreen();
		StringBuilder sb = new StringBuilder();
		InvalidAccountCreationAction action = evt.getAction();
		for(int i = 0; i < action.getNumberOfReasons(); i++)
		{
			sb.append(action.getReason(i));
			sb.append("\n");
		}
		
		Window.alert(sb.toString());
		//this.go(parentPresenter.getView().getViewRootPanel());
	}*/
	
	private void validateForNullString(String string) throws EmptyStringException {
		checkEmptyString(string);
	}

	private void validatePassword(String password, String confirmPassword) throws EmptyStringException,
	PasswordLengthException, PasswordCharacterException, PasswordMatchException {

		checkEmptyString(password);
		//		checkForSpecialCharacter(password);
		if(password.length() < 8) {
			throw new PasswordLengthException();
		}
		if(!password.equals(confirmPassword)) {
			throw new PasswordMatchException();
		}
	}

	//check for a non-alphanumeric character
	//	private void checkForSpecialCharacter(String password) throws PasswordCharacterException {
	//		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
	//		Matcher m = p.matcher(password);
	//		if(!m.find()) {
	//			throw new PasswordCharacterException();
	//		}
	//	}

	private void checkEmptyString(String string) throws EmptyStringException{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}		
	}

	private void sendCreateAccount(String firstName, String lastName, String facultyType, String email, String password) {

		SendCreateAccountAction scaa = new SendCreateAccountAction(firstName, lastName, facultyType, email, password);
		SendCreateAccountEvent scae = new SendCreateAccountEvent(scaa, view.getViewRootPanel());
		eventBus.fireEvent(scae);
	}
}
