import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VotingService implements iVote {
    private final Question question;
    private String questionContent;
    private List<String> answers;
    private final List<Integer> answerStatistics;

    VotingService(Question question) {
        this.question = question;
        questionContent = "";
        answers = new ArrayList<>();
        answerStatistics = new ArrayList<>();
    }

    @Override
    public void createQuestion() {
        Scanner in = new Scanner(System.in);

        //question
        System.out.print("Please create a question: ");
        questionContent = in.nextLine();

        //answers
        if (question.getType().equals("Multiple Choices")) {
            List<String> selections = question.getCandidates();
            System.out.println("Please type answer:");
            for (String selection : selections) {
                System.out.print(selection + " - ");
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
        StringBuilder preview = new StringBuilder();
        if (question.getType().equals("Single Choice")) preview.append("(1-True or 0-False) ");
        preview.append(questionContent).append("\n");

        if (question.getType().equals("Multiple Choices")) {
            List<String> selections = question.getCandidates();
            for (int i = 0; i < selections.size(); i++) {
                preview.append("\t").append(selections.get(i)).append(" - ").append(answers.get(i)).append("\n");
            }
        }

        return preview.toString();
    }

    @Override
    public void collectAnswer(String answer) {
        List<String> selections = question.getCandidates();
        for (int i = 0; i < selections.size(); i++) {
            if (selections.get(i).equals(answer)) answerStatistics.set(i, answerStatistics.get(i) + 1);
        }
    }

    @Override
    public String statistic() {
        int sum = answerStatistics.stream().mapToInt(answerStatistic -> answerStatistic).sum();

        StringBuilder stat = new StringBuilder("Answering Result:\n");
        List<String> selections = question.getCandidates();
        for (int i = 0; i < answerStatistics.size(); i++) {
            stat.append("\t(").append(selections.get(i));
            stat.append(")\t").append(answerStatistics.get(i));
            stat.append("/").append(sum);
            stat.append("\t|").append("*".repeat(answerStatistics.get(i))).append("\n");
        }

        return stat.toString();
    }
}

interface iVote {
    void createQuestion();
    String previewQuestion();
    void collectAnswer(String answer);
    String statistic();
}