import java.util.*;

public abstract class Question {
    private String questionContent;
    protected List<String> questionCandidates;

    Question() {
        questionContent = "";
        questionCandidates = new ArrayList<>();
    }

    public void addQuestion(String question) {
        if (questionContent != "") {
            System.out.println("Your previous question is \"" + questionContent + "\"");
            System.out.println("Do you want to change? (Y/N)");
            Scanner in = new Scanner(System.in);
            String choice = in.next();
            if (choice.toUpperCase().charAt(0) == 'Y') questionContent = question;
        }
        else questionContent = question;

        System.out.println("Your current question is \"" + questionContent + "\"");
    }

    public void addCandidate(String answer) {
        questionCandidates.add(answer);
    }

    public String toString() {
        String outputConsole = questionContent + "\n";
        for (int i = 0; i < questionCandidates.size(); i++) {
            outputConsole += "\t" + (char)(65+i) + ". " + questionCandidates.get(i);
        }
        return outputConsole;
    }
}

class MultipleChoices extends Question {
    private List<String> correctAnswers;

    MultipleChoices() {
        correctAnswers = new ArrayList<>();
    }

    void addCorrect(int index) {
        String answer = questionCandidates.get(index);
        if (!correctAnswers.contains(answer))
            correctAnswers.add(answer);
    }
}

class SingleChoice extends Question {
    private String correctAnswer;

    SingleChoice() {
        correctAnswer = "";
    }

    void addCorrect(int index) {
        String answer = questionCandidates.get(index)
        if (correctAnswer != "") {
            if (answer == correctAnswer) System.out.println("The correct answer is the same! Please choose other.");
            else {
                System.out.println("Your previous correct answer is \"" + correctAnswer + "\"");
                System.out.println("Do you want to change? (Y/N)");
                Scanner in = new Scanner(System.in);
                String choice = in.next();
                if (choice.toUpperCase().charAt(0) == 'Y') correctAnswer = answer;
            }
        }
        else correctAnswer = answer;

        System.out.println("The current correct answer is \"" + correctAnswer + "\"");
    }
}