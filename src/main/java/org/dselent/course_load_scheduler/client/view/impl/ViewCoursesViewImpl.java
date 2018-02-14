package org.dselent.course_load_scheduler.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasWidgets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.presenter.ViewCoursesPresenter;
import org.dselent.course_load_scheduler.client.view.ViewCoursesView;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.StackPanel;

public class ViewCoursesViewImpl extends BaseViewImpl<ViewCoursesPresenter> implements ViewCoursesView {

	private static viewCoursesUiBinder uiBinder = GWT.create(viewCoursesUiBinder.class);
	@UiField Label pageTitle;
	@UiField Button addCourse;
	@UiField HTMLPanel baseContainer;
	@UiField Button editCourseButton;
	@UiField Button removeCourseButton;
	@UiField StackPanel courseList;

	interface viewCoursesUiBinder extends UiBinder<Widget, ViewCoursesViewImpl> {
	}

	public ViewCoursesViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(ViewCoursesPresenter presenter) {
		// TODO Auto-generated method stub
		this.presenter = presenter;
	}

	@Override
	public Widget getWidgetContainer() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		// TODO Auto-generated method stub
		return baseContainer;
	}

	
	@Override
	public StackPanel getCourseList() {
		return courseList;
	}
	
	@Override
	public void setCourseList(StackPanel courseList) {
		this.courseList = courseList;
	}
	

	@Override
	public Button getRemoveCourseButton() {
		// TODO Auto-generated method stub
		return removeCourseButton;
	}

	@Override
	public Button getEditCourseButton() {
		// TODO Auto-generated method stub
		return editCourseButton;
	}

	@UiHandler("addCourse")
	void onAddCourseClick(ClickEvent event) {
		//TODO: redirect to another page or cue popup
		Window.alert("add Course button! Either a new page or popup here.");
	}
	
	
	@UiHandler("editCourseButton")
	void onEditCourseButtonClick(ClickEvent event) {
		//TODO: redirect to another page or cue popup
		Window.alert("Edit Course button! Either a new page or popup here.");
	}
	
	@UiHandler("removeCourseButton")
	void onRemoveCourseButtonClick(ClickEvent event) {
		int index = courseList.getSelectedIndex();//what is to be removed? get the index.
		
		//TODO: get the information for the course entry in the database and remove it
		//TODO: only remove from list when it gets confirmation??

		if(index >= 0) {//returns -1 when nothing is selected--doesn't break program, but throws exception
			courseList.remove(index);//<--helpful for removing?!?
		}
	}
	
}
