package stack.conversion;

public class Expressions {

    public static final String PREFIX1 = "(a*b)+(c*d)-e";
    public static final String PREFIX2 = "a+b*c-d";
    public static final String PREFIX3 = "(a+b)*(c+d)";
    public static final String PREFIX4 = "a*b+c*d";
    public static final String PREFIX5 = "a+b+c+d";
    public static final String PREFIX6 = "(a+b)*c-(d-e)*(f+g)";
    public static final String PREFIX7 = "a+(b*c)/(d-e)";
    public static final String PREFIX8 = "(a+b)*(c-d)/(e+f)";
    public static final String PREFIX9 = "(a+b)*(c-d)/((e-f)*(g+h))";
    public static final String PREFIX10 = "((a+b)*(c-d)+e)/(f+g)";
    public static final String PREFIX11 = "(a+b)*c+d/(e+f*g)-h";
    public static final String PREFIX12 = "(a+b-c)*d-(e+f)";
    public static final String PREFIX13 = "a*b/c+(d+e-(f*(g/h)))";
    public static final String PREFIX14 = "((a*b)-(c-d))/(e+f)";


}
