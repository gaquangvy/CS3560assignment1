import java.util.List;

public class Student {
    private String id;
    private List<Character> answerChoices;

    //initial class with only student id
    Student(String id) {this.id = id;}

    //getter and setter for answerChoice
    public void setAnswerChoices(List<Character> answerChoices) {
        this.answerChoices = answerChoices;
    }
    public List<Character> getAnswerChoices() {
        return answerChoices;
    }
}
