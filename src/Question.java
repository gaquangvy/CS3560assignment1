import java.util.*;

public abstract class Question {
    private String type;
    private List<String> candidates;

    Question() {
        type = new String();
        candidates = new ArrayList<>();
    }

    //getter and setter for type
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    //getter and setter for candidates
    public List<String> getCandidates() {
        return candidates;
    }
    public void setCandidates(List<String> candidates) {
        this.candidates = candidates;
    }
}

class MultipleChoices extends Question {
    MultipleChoices() {
        setType("Multiple Choices");

        List<String> candidates = new ArrayList<>();
        System.out.print("How many answers to select? (3-6)");
        Scanner in = new Scanner(System.in);
        int numOfCandidates = in.nextInt();
        if (numOfCandidates <= 3) numOfCandidates = 3;
        else if (numOfCandidates >= 6) numOfCandidates = 6;

        for (int i = 0; i < numOfCandidates; i++) {
            candidates.add("" + (char)(i+65));
        }
        setCandidates(candidates);
    }
}

class SingleChoice extends Question {
    SingleChoice() {
        setType("Single Choice");
        List<String> candidates = new ArrayList<>();
        candidates.add("0. False.");
        candidates.add("1. True.");
        setCandidates(candidates);
    }
}