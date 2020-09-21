import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SimulationDriver {
    private static List<Student> students;
    private static Question question;

    public static void createSurvey() {
        Scanner in = new Scanner(System.in);

        char questionChoice;
        do {
            System.out.print("Please choose (M)ultiple Choices or (S)ingle Choice: ");
            questionChoice = in.next().toLowerCase().charAt(0);
        } while (questionChoice != 'm' && questionChoice != 's');

        if (questionChoice == 'm') question = new MultipleChoices();
        else question = new SingleChoice();
    }

    public static void createClass() {
        Random rand = new Random();
        students = new ArrayList<>();
        int totalNumber = rand.nextInt(46) + 5; //random total number from 5 to 50
        System.out.println("There are " + totalNumber + " students in class!");

        for (int i = 0; i < totalNumber; i++) {
            StringBuilder randomID = new StringBuilder();
            for (int j = 0; j < 7; j++) {
                randomID.append((char) (rand.nextInt(26) + 65));
            }
            students.add(new Student(randomID.toString()));
        }
    }

    public static void choosingAnswer() {
        List<String> selections = question.getCandidates();
        Random rand = new Random();
        for (int i = 0; i < students.size(); i++) {
            //there is a student choose an option
            String choice = selections.get(rand.nextInt(selections.size()));
            students.get(i).setAnswer(choice);
            System.out.println("\t" + students.get(i).notification());

            //there is at most one student changing one's mind
            boolean changing = rand.nextBoolean();
            if (changing) {
                choice = selections.get(rand.nextInt(selections.size()));
                int changingStudent = rand.nextInt(i+1);
                students.get(changingStudent).setAnswer(choice);
                System.out.println("\t(renew) " + students.get(i).notification());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("************************Creating Survey************************");
        createSurvey();
        VotingService survey = new VotingService(question);
        survey.createQuestion();
        System.out.print("\n======Student View======\n" + survey.previewQuestion());

        System.out.println("\n************************Creating Class************************");
        createClass();
        choosingAnswer();
        //collecting answers
        for (Student student : students)
            survey.collectAnswer(student.getAnswer());

        System.out.println("\n************************Result Statistics************************");
        System.out.println(survey.statistic());
    }
}
