package cs.csmath.complexnumber;

import java.io.FileNotFoundException;

public class ComplexNumber {

    private double realPart;
    private double imagPart;

    public ComplexNumber() {
        super();
    }

    public ComplexNumber(double real, double imag) {
        this.setImagPart(imag);
        this.setRealPart(real);
    }

    public ComplexNumber(ComplexNumber cn) {
        this.realPart = cn.getRealPart();
        this.imagPart = cn.getImagPart();
    }


    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double real) {
        this.realPart = real;
    }

    public double getImagPart() {
        return imagPart;
    }

    public void setImagPart(double imag) {
        this.imagPart = imag;
    }

    public void add(ComplexNumber otherCN) {
        double newReal = (this.getRealPart() + otherCN.getRealPart());
        double newImag = (this.getImagPart() + otherCN.getImagPart());
        this.setRealPart(newReal);
        this.setImagPart(newImag);
    }

    public static ComplexNumber add(ComplexNumber firstCN, ComplexNumber secondCN) {
        ComplexNumber cn1 = new ComplexNumber(firstCN);
        ComplexNumber cn2 = new ComplexNumber(secondCN);
        cn2.add(cn1);
        return cn2;

        //this is an alternate method that does not rely on add method
        /*double a = firstCN.getRealPart();
        double b = firstCN.getImagPart();
        double c = secondCN.getRealPart();
        double d = secondCN.getImagPart();

        double newReal = a + c;
        double newImg = b + d;

        ComplexNumber newCom = new ComplexNumber(newReal, newImg);

        return newCom;*/
    }

    public void sub(ComplexNumber otherCN) {
        double newReal = (this.getRealPart() - otherCN.getRealPart());
        double newImag = (this.getImagPart() - otherCN.getImagPart());
        this.setRealPart(newReal);
        this.setImagPart(newImag);
    }

    public static ComplexNumber sub(ComplexNumber firstCN, ComplexNumber secondCN) {
        double a = firstCN.getRealPart();
        double b = firstCN.getImagPart();
        double c = secondCN.getRealPart();
        double d = secondCN.getImagPart();

        double newReal = a - c;
        double newImg = b - d;

        ComplexNumber newCom = new ComplexNumber(newReal, newImg);

        return newCom;
    }

    public void mult(ComplexNumber otherCN) {
        double a = this.getRealPart();
        double b = this.getImagPart();
        double c = otherCN.getRealPart();
        double d = otherCN.getImagPart();

        double newReal = (a * c)
                - (b * d);
        double newImag = (b * c)
                + (a * d);
        this.setRealPart(newReal);
        this.setImagPart(newImag);
    }

    public static ComplexNumber mult(ComplexNumber firstCN, ComplexNumber secondCN) {
        double a = firstCN.getRealPart();
        double b = firstCN.getImagPart();
        double c = secondCN.getRealPart();
        double d = secondCN.getImagPart();

        double newReal = (a * c)
                - (b * d);
        double newImag = (b * c)
                + (a * d);
        ComplexNumber newCom = new ComplexNumber(newReal, newImag);

        return newCom;
    }

    public void div(ComplexNumber otherCN) {
        double a = this.getRealPart();
        double b = this.getImagPart();
        double c = otherCN.getRealPart();
        double d = otherCN.getImagPart();

        /*double newReal = ((a*c) + (b*d)) / ((c*c) + (d*d));
        double newImg = ((b*c) - (a*d)) / ((c*c) + (d*d));
        this.setImagPart(newImg);
        this.setRealPart(newReal);
        */

        double denominator = c * c + d * d;
        if (Math.abs(denominator) < 0.000001) {
            throw new ArithmeticException();
        }

        double newReal = ((a * c) + (b * d)) / ((c * c) + (d * d));
        double newImg = ((b * c) - (a * d)) / ((c * c) + (d * d));

        this.setImagPart(newImg);
        this.setRealPart(newReal);
    }


    public static ComplexNumber div(ComplexNumber firstCN, ComplexNumber secondCN){
        double a = firstCN.getRealPart();
        double b = firstCN.getImagPart();
        double c = secondCN.getRealPart();
        double d = secondCN.getImagPart();

        double newReal = ((a*c) + (b*d)) / ((c*c) + (d*d));
        double newImg = ((b*c) - (a*d)) / ((c*c) + (d*d));

        ComplexNumber newCom = new ComplexNumber(newReal, newImg);

        return newCom;
    }

    public ComplexNumber conj(){
        ComplexNumber con = new ComplexNumber();
        con.setRealPart(this.realPart);
        con.setImagPart(-this.getImagPart());
        return con;
    }

    public double abs(){
        double ab = Math.sqrt((this.getRealPart()*this.getRealPart())
                + (this.getImagPart() * this.getImagPart()));
        return ab;
    }

    public static double abs(ComplexNumber otherCN){
        double ab = Math.sqrt((otherCN.getRealPart()*otherCN.getRealPart())
                + (otherCN.getImagPart() * otherCN.getImagPart()));
        return ab;
    }

    @Override
    public String toString() {
//        autogenerated
        /*return "ComplexNumber{" +
                "realPart=" + realPart +
                ", imagPart=" + imagPart +
                '}';*/


        return realPart + "+" + imagPart + "i";
    }

    public static void main(String[] args){
        ComplexNumber cn = new ComplexNumber(6.0,4.0);
        /*ComplexNumber cn2 = new ComplexNumber(0.0, 0.0);
        System.out.println(cn.toString());
        cn.div(cn2);
        System.out.println(cn.toString());
*/
        double ab = ComplexNumber.abs(cn);
        System.out.println(ab);
        int i = 1;
        while(i < 50){
            System.out.println(i);
            i += 1;
        }


/*
        ComplexNumber cn3 = new ComplexNumber();
        cn3 = ComplexNumber.div(cn2, cn);
        System.out.println(cn3.toString());*/
    }
}
