package com.sabpaisa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sabpaisa.entity.TimeTable;
import com.sabpaisa.service.TimeTableService;

@Controller
public class TimeTableController {

	@Autowired
	private TimeTableService timeTableService;

	@GetMapping("/timeTable")
	public String timetableget(Model model) {
		model.addAttribute("title", "TimeTable");
		List<TimeTable> as = timeTableService.getTimeTables();
		System.out.println("Time table data" + as);
		model.addAttribute("timeTables", as);
		return "admin/timeTable";
	}

	@RequestMapping("/addTimeTable")
	public String addTimeTable(TimeTable timeTable, Model model) {
		TimeTable as = new TimeTable();
		model.addAttribute("timeTable", as);
		return "admin/addTimeTable";
	}

	@PostMapping("/addTimeTable")
	public String addtimeTable(@ModelAttribute("admin/addTimeTable") TimeTable timeTable) {
		System.out.println("this is inserting page");
		TimeTable as = timeTableService.addTimeTable(timeTable);
		System.out.println(" inserting successfully" + as);

		return "admin/addTimeTable";
	}

	@RequestMapping("/updateTimeTable/{id}")
	public String updatetimeTable(TimeTable timeTable,Model model,@PathVariable("id") int id) {
		System.out.println("this is update page...");
		model.addAttribute("timeTable", timeTable);
		Optional<TimeTable> timetableData= timeTableService.getTimeTable(id);
		TimeTable sr=timetableData.get();
		model.addAttribute("id", sr.getId());
		model.addAttribute("schoolTime", sr.getSchoolTime());
		model.addAttribute("monday", sr.getMonday());
		model.addAttribute("tuesday", sr.getTuesday());
		model.addAttribute("wednesday", sr.getWednesday());
		model.addAttribute("thursday", sr.getThursday());
		model.addAttribute("friday", sr.getFriday());
		model.addAttribute("saturday", sr.getSaturday());
		model.addAttribute("sunday", sr.getSunday());
		System.out.println("show data Successfully :: "+sr);
		return "admin/updateTimeTable";
	}
	
	@PostMapping("/updateTimeTable")
	public String updateTimetable(@ModelAttribute("admin/updateTimeTable")TimeTable timeTable) {
		System.out.println("test...");
		timeTableService.updateTimeTable(timeTable);
		System.out.println("Update Successfully"+timeTableService.updateTimeTable(timeTable));		
		return "admin/timeTable";
	}
	
	@PostMapping("/deleteTimeTable/{id}")
	public String deleteTimeTable(@PathVariable("id") int id) {
		timeTableService.deleteTimeTable(id);
		return "admin/timeTable"+id;
	}
	

}
