package be.bxlformation.tu.triangle;

import lombok.Data;

@Data
public class TriangleBF<c> {


    private int a;
    private int b;
    private int c;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }
}
