package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.beans.Marks;
import com.dxc.repository.MarksRepository;

@RestController
public class MarksController {
	
	@Autowired
	MarksRepository marksRepository;
	
	@GetMapping("marks")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Marks> getMarks()
	{
		List<Marks> marks = (List<Marks>) marksRepository.findAll();
		return marks;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="mark/{id}")
	public Marks getMark(@PathVariable("id") int id) 
	{
		Marks mark = marksRepository.findById(id).orElse(new Marks());
		return mark;
	}
	
	@PostMapping("mark")
	@CrossOrigin(origins = "http://localhost:4200")
	public Marks save(@RequestBody Marks mark)
	{
		return marksRepository.save(mark);
	}
	
	@PutMapping("mark")
	@CrossOrigin(origins = "http://localhost:4200")
	public Marks update(Marks mark)
	{
		return ((MarksController) marksRepository).update(mark);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("mark/{id}")
	public String deletestudent(@PathVariable ("id") int id) {
		marksRepository.deleteById(id);
		return "deleted successfully";
	}

}