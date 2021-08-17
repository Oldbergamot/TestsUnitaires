package be.bxlformation.tu.triangle;


import lombok.Data;

@Data
public class Triangle extends Exception{
    int coteA;
    int coteB;
    int coteC;


    public Triangle(int coteA, int coteB, int coteC) {
        this.coteA = coteA;
        this.coteB = coteB;
        this.coteC = coteC;
    }

    public String getTriangleType () {
        //if null


        //valid length
        if(!(coteB+coteA>coteC && coteC+coteA > coteB && coteB+coteC>coteA)) {
            try {
                throw new NotATriangleException("not a triangle");
            }catch (NotATriangleException e) {
               return e.getMessage();

            }
        }

        //rect
        if(Math.pow(coteA,2)+Math.pow(coteB,2)==Math.pow(coteC,2)
                ||Math.pow(coteB,2)+Math.pow(coteC,2)==Math.pow(coteA,2)
                ||Math.pow(coteC,2)+Math.pow(coteA,2)==Math.pow(coteB,2)) return "rectangle";
        //equi
        if(coteA == coteB && coteB == coteC) return "equilateral";

        //iso
        if(coteA == coteB || coteA == coteC || coteB == coteC) return "isocele";

        //scalène test pas nécéssaire pcq tout a déjà été vérifié avant
        //if(coteA != coteB && coteA != coteC && coteB != coteC) return "scalene";

        return "scalene";
    }
}
