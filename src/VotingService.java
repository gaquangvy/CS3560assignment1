import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VotingService implements iVote {
    private Question question;
    private String questionContent;
    private List<String> answers;
    private List<Integer> answerStatistics;

    VotingService(Question question) {
        this.question = question;
        questionContent = new String();
        answers = new ArrayList<>();
        answerStatistics = new ArrayList<>();
    }

    @Override
    public void createQuestion() {
        Scanner in = new Scanner(System.in);

        //question
        System.out.println("Please create a question:");
        questionContent = in.nextLine();

        //answers
        if (question.getType() == "Multiple Choice") {
            List<String> selections = question.getCandidates();
            System.out.println("Please type answer:");
            for (int i = 0; i < selections.size(); i++) {
                System.out.print(selections.get(i) + " - ");
                answers.add(in.nextLine());
                answerStatistics.add(0);
            }
        }
        else {
            answers = question.getCandidates();
            answerStatistics.add(0);
            answerStatistics.add(0);
        }
    }

    @Override
    public String previewQuestion() {
        String preview = new String();
        if (question.getType() == "Single Choice") preview += "(1-True or 0-False) ";
        preview += questionContent + "\n";

        if (question.getType() == "Multiple Choice") {
            List<String> selections = question.getCandidates();
            for (int i = 0; i < selections.size(); i++) {
                preview += "\t" + selections.get(i) + " - " + answers.get(i) + "\n";
            }
        }

        return preview;
    }

    @Override
    public void collectAnswer(char answer) {
        List<String> selections = question.getCandidates();
        for (int i = 0; i < selections.size(); i++) {
            if (selections.get(i).charAt(0) == answer) answerStatistics.set(i, answerStatistics.get(i) + 1);
        }
    }

    @Override
    public String statistic() {
        int sum = 0;
        for (int i = 0; i < answerStatistics.size(); i++) {
            sum += answerStatistics.get(i);
        }

        String stat = "Answering Result:\n";
        List<String> selections = question.getCandidates();
        for (int i = 0; i < answerStatistics.size(); i++) {
            stat += "\t(" + selections.get(i);
            stat += ")\t" + answerStatistics.get(i);
            stat += "/" + sum;
            stat += "|" + "*".repeat(answerStatistics.get(i)) + "\n";
        }

        return stat;
    }
}

interface iVote {
    public void createQuestion();
    public String previewQuestion()
    public void collectAnswer(char answer);
    public String statistic();
}