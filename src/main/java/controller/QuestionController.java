package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import entity.Question;
import service.AbstractService;


/**
 * Question controller
 *
 * @author Alex V.
 */
@Controller
public class QuestionController {
	
	private AbstractService abstractService;
	
	@Autowired(required=true)
	@Qualifier(value= "abstractService")
	public void setAbstractService(AbstractService abstractService){
		this.abstractService = abstractService;
	}
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public String listQuestions(Model model) {
		model.addAttribute("question", new Question());
		model.addAttribute("listQuestions", this.abstractService.getAll());
		return "question";
	}
	
	//For add and update person both
	@RequestMapping(value= "/question/add", method = RequestMethod.POST)
	public String create(@ModelAttribute("question") Question question){
		
		if(question.getQuestionId() == 0){
			//new person, add it
			this.abstractService.create(question);
		}else{
			//existing person, call update
			this.abstractService.update(question);
		}
		
		return "redirect:/questions";
		
	}
	
	@RequestMapping("/remove/{questionId}")
    public String removeQuestion(@PathVariable("questionId") int questionId){
		
        this.abstractService.remove(questionId);
        return "redirect:/questions";
    }
	
}
