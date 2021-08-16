package be.bxlformation.tu;


import lombok.Data;

@Data
public class Triangle {
    int coteA;
    int coteB;
    int coteC;


    public Triangle(int coteA, int coteB, int coteC) {
        this.coteA = coteA;
        this.coteB = coteB;
        this.coteC = coteC;
    }

    public String getTriangleType () {
        //valid length
        if(!(coteB+coteA>coteC && coteC+coteA > coteB && coteB+coteC>coteA)) return"ceci n'est pas un triangle";

        //rect
        if(Math.pow(coteA,2)+Math.pow(coteB,2)==Math.pow(coteC,2)
                || Math.pow(coteB,2)+Math.pow(coteC,2)==Math.pow(coteA,2)
                ||Math.pow(coteC,2)+Math.pow(coteA,2)==Math.pow(coteB,2)) return "rectangle";
        //equi
        if(coteA == coteB && coteB == coteC) return "equilateral";

        //iso
        if(coteA == coteB || coteA == coteC || coteB == coteC) return "isocele";

        //scalène
        if(coteA != coteB && coteA != coteC && coteB !=coteC) return "scalene";

        return"";
    }
}
