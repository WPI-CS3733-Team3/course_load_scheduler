package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveGetOneFacultySectionInfoAction;
import org.dselent.course_load_scheduler.client.action.SendGetOneFacultySectionInfoAction;
import org.dselent.course_load_scheduler.client.model.SectionsInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveGetOneFacultySectionInfoKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class GetOneFacultySectionInfoActionTranslatorImpl implements ActionTranslator<SendGetOneFacultySectionInfoAction, ReceiveGetOneFacultySectionInfoAction>{
	@Override
	public JSONObject translateToJson(SendGetOneFacultySectionInfoAction action)
	{
		JSONObject jsonObject = new JSONObject();
		
		//JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendGetOneFacultySectionInfoKeys.FACULTY_ID), action.getId());
		
		return jsonObject;
	}

	@Override
	public ReceiveGetOneFacultySectionInfoAction translateToAction(JSONObject json)
	{
		JSONValue jsonObject = json.get("success");
		JSONValue otherObject = jsonObject.isArray().get(0);

		//loops through each element in the list and fills an ArrayList with the info for each course
		List<SectionsInfo> sectionsInfoList = new ArrayList<SectionsInfo>();

		for(int i = 0; i < otherObject.isArray().size(); i++) {
			JSONObject sectionsInfoObject = otherObject.isArray().get(i).isObject();
			SectionsInfo si = new SectionsInfo();

			//extract the information for the object to return
			//TODO: Check for valid (non-null) values?
			si.setCoursesTitle(JSONHelper.getStringValue(sectionsInfoObject, JSONHelper.convertKeyName(ReceiveGetOneFacultySectionInfoKeys.COURSES_TITLE)));
			si.setFacultyId(JSONHelper.getIntValue(sectionsInfoObject, JSONHelper.convertKeyName(ReceiveGetOneFacultySectionInfoKeys.FACULTY_ID)));
			si.setTermsName(JSONHelper.getStringValue(sectionsInfoObject, JSONHelper.convertKeyName(ReceiveGetOneFacultySectionInfoKeys.TERMS_NAME)));
			//Add extracted info to the list
			sectionsInfoList.add(si);
		}

		//add the list into the action and return
		ReceiveGetOneFacultySectionInfoAction action = new ReceiveGetOneFacultySectionInfoAction(sectionsInfoList);

		return action;
	}

}
