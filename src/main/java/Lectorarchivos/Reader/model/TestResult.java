package Lectorarchivos.Reader.model;
import org.springframework.stereotype.Component;

@Component
public class TestResult {

    private int correctLines = 0;

    private int incorrectlines = 0;


    public void setLinePass(int correctLines) {
        this.correctLines = correctLines;
    }

    public void setLineFail(int incorrectlines) {
        this.incorrectlines =incorrectlines;
    }

    public int getLinePass() {
        return correctLines;
    }
    public int getLineFail() {
        return incorrectlines;
    }
    @Override
    public String toString() {
        return "TestResult{" +
                "pass=" + correctLines +
                ", fail=" + incorrectlines +
                '}';
    }
}
