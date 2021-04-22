
public class Question {

    String qText;
    String[] answers = new String[4];
    String correctAnswer;



	public Question(String qText, String[] answers, String correctAnswer) {
        this.qText = qText;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public void edit(String qText, String[] answers, String correctAnswer) {
        this.qText = qText;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(String userAnswer) {
        return (this.correctAnswer).equals(userAnswer);
    }

    public String getQuestionText() {
        return this.qText;
    }

    public String[] getAnswers() {
        return this.answers;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

}
