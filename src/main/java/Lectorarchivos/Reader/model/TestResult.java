package Lectorarchivos.Reader.model;
import org.springframework.stereotype.Component;

@Component
public class TestResult {

    private int objectPass = 0;
    private int objectFail = 0;

    public TestResult() {
    }

    public void setObjectPass(int objectPass) {
        this.objectPass = objectPass;
    }

    public void setObjectFail(int objectFail) {
        this.objectFail = objectFail;
    }

    public int getObjectPass() {
        return objectPass;
    }

    public int getObjectFail() {
        return objectFail;
    }
    @Override
    public String toString() {
        return "TestResult{" +
                "pass=" + objectPass +
                ", fail=" + objectFail +
                '}';
    }
}
