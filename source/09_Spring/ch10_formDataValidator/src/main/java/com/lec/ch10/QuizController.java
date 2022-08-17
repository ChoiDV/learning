package com.lec.ch10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Quiz;
import com.lec.ch10.vo.QuizValidator;

@Controller
public class QuizController {	
	@RequestMapping(value="quizInput.do",method=RequestMethod.GET)
	public String quizInputForm() {
		return "quiz/quizInput";
	}
	@ModelAttribute("cnt")  
	public int cnt() {
		return 4;
	}
	
	@RequestMapping(value="quizInput.do",method=RequestMethod.POST)
	public String quizInput(Quiz quiz, Model model, Errors errors) {
		int kor = quiz.getKor();
		int eng = quiz.getEng();
		int mat = quiz.getMat();
		int sum = kor+eng+mat;
		double	avg = sum/3.0;	
		model.addAttribute("sum",sum);
		model.addAttribute("avg",avg);
		QuizValidator validator = new QuizValidator();
		validator.validate(quiz, errors);
		if(errors.hasErrors()) {
			if(errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "name은 필수 입력사항이고 1글자 이상 입력해주세요.");
			}
			if(errors.getFieldError("kor") != null) {
				model.addAttribute("korError", "올바른 국어점수를 입력해주세요 0~100 점");
			}
			if(errors.getFieldError("eng") != null) {
				model.addAttribute("engError", "올바른 영어점수를 입력해주세요 0~100 점");
			}
			if(errors.getFieldError("mat") != null) {
				model.addAttribute("matError", "올바른 수학점수를 입력해주세요 0~100 점");
			}			
			return "quiz/quizInput";
		}
		return "quiz/quizResult";
	}
}
