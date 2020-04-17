package stack.conversion;

public class Expressions {

    /* ************* INFIX EXPRESSIONS **************** */
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
    public static final String PREFIX15 = "e-(d*c)+(b*a)";
    public static final String PREFIX16 = "a+b-c*d";
    public static final String PREFIX17 = "(a-b/c)*(a/k-l)";
    public static final String PREFIX18 = "(a+b)*c+d/(e+f*g)-h";
    public static final String PREFIX19 = "a+b*c";
    public static final String PREFIX20 = "k+l-m*n+(o^p)*w/u/v*t+q";



    /* ************* POSTFIX EXPRESSIONS **************** */
    public static final String POSTFIX1 = "ab*cd*+e-";
    public static final String POSTFIX2 = "abc*+d-";
    public static final String POSTFIX3 = "ab+cd+*";
    public static final String POSTFIX4 = "ab*cd*+";
    public static final String POSTFIX5 = "ab+c+d+";
    public static final String POSTFIX6 = "ab+c*de-fg+*-";
    public static final String POSTFIX7 = "abc*de-/+";
    public static final String POSTFIX8 = "ab+cd-*ef+/";
    public static final String POSTFIX9 = "ab+cd-*ef-gh+*/";
    public static final String POSTFIX10 = "ab+cd-*e+fg+/";
    public static final String POSTFIX11 = "ab+c*defg*+/+h-";
    public static final String POSTFIX12 = "ab+c-d*ef+-";
    public static final String POSTFIX13 = "ab*c/de+fgh/*-+";
    public static final String POSTFIX14 = "ab*cd--ef+/";
    public static final String POSTFIX15 = "edc*-ba*+";
    public static final String POSTFIX16 = "ab+cd*-";
    public static final String POSTFIX17 = "abc/-ak/l-*";
    public static final String POSTFIX18 = "ab+c*defg*+/+h-";
    public static final String POSTFIX19 = "abc*+";
    public static final String POSTFIX20 = "kl+mn*-op^w*u/v/t*+q+";
}
