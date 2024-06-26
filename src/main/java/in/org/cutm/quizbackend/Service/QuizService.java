package in.org.cutm.quizbackend.Service;


import in.org.cutm.quizbackend.Entity.Questions;
import in.org.cutm.quizbackend.Entity.Quiz;
import in.org.cutm.quizbackend.Entity.QuizQuestion;
import in.org.cutm.quizbackend.Repository.QuestionRepository;
import in.org.cutm.quizbackend.Repository.QuizQuestionRepository;
import in.org.cutm.quizbackend.Repository.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
	@Autowired
	private final QuizRepository quizRepository;
	
	@Autowired
	private QuizQuestionRepository quizQuestionRepository;
	
	@Autowired
	private QuestionRepository questRepository;
	

	public QuizService(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	public Quiz createQuiz(Quiz quiz) {
		// Perform any necessary validation or business logic
		// Save the quiz entity in the database

		return quizRepository.save(quiz);
	}

	public Quiz getQuizById(Long id) {
		return quizRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quiz not found"));
	}

	public Quiz updateQuiz(Long id, Quiz updatedQuiz) {
		Quiz quiz = getQuizById(id);
		// Perform any necessary validation or business logic
		// Update the quiz entity with the new values
		quiz.setQuizName(updatedQuiz.getQuizName());
		quiz.setTechnology(updatedQuiz.getTechnology());
		return quizRepository.save(quiz);
	}

	public void deleteQuiz(Long id) {
		Quiz quiz = getQuizById(id);
		// Perform any necessary validation or business logic
		quizRepository.delete(quiz);
	}

	public List<Quiz> getAllQuizzes() {
		return quizRepository.findAll();
	}
	
	public List<Questions> getQuizQuestById(Long id){
		System.out.println("Id"+id);
	    List<QuizQuestion> quizQuesList =  quizQuestionRepository.findByQuiz(getQuizById(id));
	    List<Questions> questionList = new ArrayList<>();
	    for(QuizQuestion quizQues: quizQuesList) {
	        Optional<Questions> optionalQuestions = questRepository.findById(quizQues.getQuestion().getId());
	        optionalQuestions.ifPresent(questionList::add);
	    }
	    
	    questionList.forEach(q->System.out.println(q.getQuestionText()));
	    return questionList;
	}

}
