package in.org.cutm.quizbackend.Service;


import in.org.cutm.quizbackend.Entity.Questions;
import in.org.cutm.quizbackend.Repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Questions createQuestion(Questions question) {
        // Perform any necessary validation or business logic
        // Save the question entity in the database
        return questionRepository.save(question);
    }

    public Questions getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));
    }

    public Questions updateQuestion(Long id, Questions updatedQuestion) {
        Questions question = getQuestionById(id);
        // Perform any necessary validation or business logic
        // Update the question entity with the new values
        question.setQuestionText(updatedQuestion.getQuestionText());
        question.setOption1(updatedQuestion.getOption1());
        question.setOption2(updatedQuestion.getOption2());
        question.setOption3(updatedQuestion.getOption3());
        question.setOption4(updatedQuestion.getOption4());
        question.setCorrectOption(updatedQuestion.getCorrectOption());
        question.setTechnology(updatedQuestion.getTechnology());
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        Questions question = getQuestionById(id);
        // Perform any necessary validation or business logic
        questionRepository.delete(question);
    }

    public List<Questions> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Questions> gettechquestion(String tech){
        List<Questions> techQues = getAllQuestions()
                .stream().filter(questions -> Objects.equals(questions.getTechnology(), tech)).collect(Collectors.toList());
        return techQues;
    }
}
