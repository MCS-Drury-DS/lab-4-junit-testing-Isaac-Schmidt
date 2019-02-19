package cs.csmath.complexnumber;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumberTest {
    static final double DELTA = 0.000001;

    @Test
    public void getRealPart() {
        ComplexNumber cn = new ComplexNumber(2.0, 1.0);
        double a = cn.getRealPart();
        assertEquals(2.0, a, DELTA);
    }

    @Test
    public void setRealPart() {
        ComplexNumber cn = new ComplexNumber(2.0, 1.0);
        double b = cn.getImagPart();
        assertEquals(1.0, b, DELTA);
    }

    @Test
    public void getImagPart() {
        ComplexNumber cn = new ComplexNumber(1.0, 1.0);
        double imagPart = cn.getImagPart();
        assertEquals(1.0, imagPart, DELTA);
    }

    @Test
    public void setImagPart() {
        ComplexNumber cn = new ComplexNumber(1.0, 1.0);
        cn.setImagPart(2.0);
        assertEquals(2.0, cn.getImagPart(), DELTA);
    }

    //Tests 4.5+3.0i + 6.0+4.0i
    @Test
    public void add() {
        ComplexNumber cn = new ComplexNumber(4.5, 3.0);
        ComplexNumber cn2 = new ComplexNumber(6.0, 4.0);
        cn.add(cn2);
        assertEquals("Tests 4.5+3.0i + 6.0+4.0i", 10.5, cn.getRealPart(), DELTA);
        assertEquals(7.0, cn.getImagPart(), DELTA);
    }

    @Test
    public void add1() {
        ComplexNumber cn = new ComplexNumber(4.5, 3.0);
        ComplexNumber cn2 = new ComplexNumber(6.0, 4.0);
        ComplexNumber result = ComplexNumber.add(cn, cn2);
        assertEquals("Assert real part", 10.5, result.getRealPart(), DELTA);
        assertEquals("Assert imaginary part", 7.0, result.getImagPart(), DELTA);
    }

    //Tests 6.0+4.0i - 4.5+3.0i
    @Test
    public void sub() {
        ComplexNumber cn = new ComplexNumber(4.5, 3.0);
        ComplexNumber cn2 = new ComplexNumber(6.0, 4.0);
        cn2.sub(cn);
        assertEquals("Assert real part", 1.5, cn2.getRealPart(), DELTA);
        assertEquals(1.0, cn2.getImagPart(), DELTA);
    }


    @Test
    public void sub1() {
        ComplexNumber cn = new ComplexNumber(4.5, 3.0);
        ComplexNumber cn2 = new ComplexNumber(6.0, 4.0);
        ComplexNumber cn3 = new ComplexNumber();
        cn3 = ComplexNumber.sub(cn2, cn);
        assertEquals("Assert real part", 1.5, cn3.getRealPart(), DELTA);
        assertEquals("Assert imaginary part",1.0, cn3.getImagPart(), DELTA);
    }

    //Tests 6.0+4.0i * 4.5+3.0i
    @Test
    public void mult() {
        ComplexNumber cn = new ComplexNumber(4.5, 3.0);
        ComplexNumber cn2 = new ComplexNumber(6.0, 4.0);
        cn.mult(cn2);
        assertEquals("Assert real part", 15.0, cn.getRealPart(), DELTA);
        assertEquals("Assert imaginary part",36.0, cn.getImagPart(), DELTA);
    }

    @Test
    public void mult1() {
        ComplexNumber cn = new ComplexNumber(4.5, 3.0);
        ComplexNumber cn2 = new ComplexNumber(6.0, 4.0);
        ComplexNumber cn3 = new ComplexNumber();
        cn3 = ComplexNumber.mult(cn2, cn);
        assertEquals("Assert real part", 15.0, cn3.getRealPart(), DELTA);
        assertEquals("Assert imaginary part",36.0, cn3.getImagPart(), DELTA);
    }

    //Tests 5.0+3.0i / 2.0+2.0i
    @Test
    public void div() {
        ComplexNumber cn = new ComplexNumber(5.0, 3.0);
        ComplexNumber cn2 = new ComplexNumber(2.0, 2.0);
        cn.div(cn2);
        assertEquals("Assert real part",2.0, cn.getRealPart(), DELTA);
        assertEquals("Assert imaginary part",-0.5, cn.getImagPart(), DELTA);
    }

    @Test
    public void divByZero() {
        ComplexNumber cn = new ComplexNumber(5.0, 3.0);
        ComplexNumber cn2 = new ComplexNumber(0.0, 0.0);

        try{
            cn.div(cn2);
            fail();
        }
        catch(ArithmeticException e){
            e.printStackTrace();
        }



    }

    @Test
    public void div1() {
        ComplexNumber cn = new ComplexNumber(5.0, 3.0);
        ComplexNumber cn2 = new ComplexNumber(2.0, 2.0);
        ComplexNumber cn3 = new ComplexNumber();
        cn3 = ComplexNumber.div(cn, cn2);
        assertEquals("Assert real part", 2.0, cn3.getRealPart(), DELTA);
        assertEquals("Assert imaginary part",-0.5, cn3.getImagPart(), DELTA);
    }

    @Test
    public void conj() {
        ComplexNumber cn = new ComplexNumber(5.0, -3.0);
        ComplexNumber cn2 = cn.conj();
        assertEquals("5.0+3.0i", cn2.toString());

    }

    @Test
    public void abs() {
        ComplexNumber cn = new ComplexNumber(3.0,-4.0);
        double result = ComplexNumber.abs(cn);
        assertEquals(5.0, result, DELTA);
    }

    @Test
    public void testToString() {
        ComplexNumber cn = new ComplexNumber(1.0, 1.0);
        String s = cn.toString();
        assertEquals("1.0+1.0i", s);
    }
}