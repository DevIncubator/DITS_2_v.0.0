package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import entity.Answer;
import service.AbstractService;

@Controller
public class AnswerController {
    AbstractService abstractService;

    @Autowired(required=true)
    @Qualifier(value= "abstractService")
    public void setAbstractService(AbstractService abstractService){
        this.abstractService = abstractService;
    }

    @RequestMapping(value = "/answers", method = RequestMethod.GET)
    public String listQuestions(Model model) {
        model.addAttribute("answer", new Answer());
        model.addAttribute("listAnswers", this.abstractService.getAll());
        return "answer";
    }

    //For add and update person both
    @RequestMapping(value= "/answer/add", method = RequestMethod.POST)
    public String create(@ModelAttribute("answer") Answer answer){

        if(answer.getAnswerId() == 0){
            //new person, add it
            this.abstractService.create(answer);
        }else{
            //existing person, call update
            this.abstractService.update(answer);
        }

        return "redirect:/answers";

    }

    @RequestMapping("/remove/{answerId}")
    public String removeAnswer(@PathVariable("answerId") int answerId){

        this.abstractService.remove(answerId);
        return "redirect:/answers";
    }

   /* public static void main(String[] args) {
        AnswerController ac = new AnswerController();
        Answer answer = new Answer();
        answer.setAnswerId(66);
        answer.setCorrect(true);
        answer.setDescription("test Description");
        answer.setQuestionId(1);
        System.out.println(ac.create(answer ));
    }*/

}
