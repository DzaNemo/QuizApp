package link.quizassgn;

public class Questions {

    private int ID;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String answer;

    public Questions(){
        /*ID=0;
        question="";
        optionA="";
        optionB="";
        optionC="";
        answer="";*/
    }
    public Questions(String question, String optionA, String optionB, String optionC, String answer) {

        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.answer = answer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getAnswer() {
            return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /* public int getID()
    {
        return ID;
    }
    public String getQUESTION() {
        return QUESTION;
    }
    public String getOPTA() {
        return OPTIONA;
    }
    public String getOPTB() {
        return OPTIONB;
    }
    public String getOPTC() {
        return OPTIONC;
    }
    public String getANSWER() {
        return ANSWER;
    }
    public void setID(int id)
    {
        ID=id;
    }
    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }
    public void setOPTA(String oPTA) {
        OPTIONA = oPTA;
    }
    public void setOPTB(String oPTB) {
        OPTIONB = oPTB;
    }
    public void setOPTC(String oPTC) {
        OPTIONC = oPTC;
    }
    public void setANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }*/
}
