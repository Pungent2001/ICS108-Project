
public class Question {

    String qText = new String();
    String[] answers = new String[4];
    String correctAnswer;

    public void question() {
         // Idk LOL
    }

    public void question(String qText, String[] answers, String correctAnswer) {
        this.qText = qText;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public void setQText(String qText, String[] answers, String correctAnswer) {
        this.qText = qText;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public static boolean checkAnswer(String correctAnswer, String userAnswer) {
        return correctAnswer.equals(userAnswer);
    }

    public String getQuestionText() {
        return this.qText;
    }

    // THIS HAS ERRORS
//    public void String[] getAnswers() {
//        return this.answers;
//    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

}
