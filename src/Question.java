import java.util.*;

public abstract class Question {
    protected String questionContent;

    Question(String question) {
        questionContent = question;
    }

    public abstract String toString();
}

class MultipleChoices extends Question {
    private List<String> questionCandidates;

    MultipleChoices(String question) {
        super(question);
        questionCandidates = new ArrayList<>();

        System.out.print("How many answers to select? (3-6)");
        Scanner in = new Scanner(System.in);
        int numOfCandidates = in.nextInt();
        if (numOfCandidates <= 3) numOfCandidates = 3;
        else if (numOfCandidates >= 6) numOfCandidates = 6;

        for (int i = 0; i < numOfCandidates; i++) {
            System.out.print("Candidate #" + (i+1) + ": ");
            questionCandidates.add(in.nextLine());
        }
    }

    public String toString() {
        String questionPresentation = questionContent + "\n";
    }
}