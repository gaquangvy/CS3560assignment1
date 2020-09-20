import java.util.List;
import java.util.Scanner;

public class SimulationDriver {
    private List<Student> students;
    private Question question;
    private VotingService votingService;
    Scanner in = new Scanner(System.in);

    public void createQuestion() {
        char questionChoice;
        do {
            System.out.print("Please choose (M)ultiplie Choices or (S)ingle Choice: ");
            questionChoice = in.next().charAt(0);
        } while (questionChoice != 'm' || questionChoice != 's');

        if (questionChoice == 'm') question = new MultipleChoices();
        else question = new SingleChoice();
    }
}
