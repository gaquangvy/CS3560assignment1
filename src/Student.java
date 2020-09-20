public class Student {
    private String id;
    private char answerChoice;

    //initial class with only student id
    Student(String id) {this.id = id;}

    //getter and setter for answerChoice
    public void setAnswer(char answer) {
        answerChoice = answer;
    }
    public char getAnswerChoice() {
        return answerChoice;
    }
}
