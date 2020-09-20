import java.util.*;

public abstract class Question {
    protected String type;
    protected List<String> candidates;
}

class MultipleChoices extends Question {

    MultipleChoices() {
        type = "Multiple Choices";

        System.out.print("How many answers to select? (3-6)");
        Scanner in = new Scanner(System.in);
        int numOfCandidates = in.nextInt();
        if (numOfCandidates <= 3) numOfCandidates = 3;
        else if (numOfCandidates >= 6) numOfCandidates = 6;

        for (int i = 0; i < numOfCandidates; i++) {
            candidates.add("" + (char)(i+65));
        }
    }
}

class SingleChoice extends Question {
    SingleChoice() {
        type = "Single Choice";
        candidates.add("0. False.");
        candidates.add("1. True.");
    }
}