public class Student {
    private final String id;
    private String answer;

    //initial class with only student id
    Student(String id) {
        this.id = id;
        answer = "";
    }

    //getter and setter for answer
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getAnswer() {
        return answer;
    }

    //notification of choosing answer
    public String notification() {
        return "Student " + id + " voted " + answer;
    }
}
