package stack.conversion;

public class Expressions {

    /* ************* INFIX EXPRESSIONS **************** */
    public static final String INFIX1 = "(a*b)+(c*d)-e";
    public static final String INFIX2 = "a+b*c-d";
    public static final String INFIX3 = "(a+b)*(c+d)";
    public static final String INFIX4 = "a*b+c*d";
    public static final String INFIX5 = "a+b+c+d";
    public static final String INFIX6 = "(a+b)*c-(d-e)*(f+g)";
    public static final String INFIX7 = "a+(b*c)/(d-e)";
    public static final String INFIX8 = "(a+b)*(c-d)/(e+f)";
    public static final String INFIX9 = "(a+b)*(c-d)/((e-f)*(g+h))";
    public static final String INFIX10 = "((a+b)*(c-d)+e)/(f+g)";
    public static final String INFIX11 = "(a+b)*c+d/(e+f*g)-h";
    public static final String INFIX12 = "(a+b-c)*d-(e+f)";
    public static final String INFIX13 = "a*b/c+(d+e-(f*(g/h)))";
    public static final String INFIX14 = "((a*b)-(c-d))/(e+f)";
    public static final String INFIX15 = "e-(d*c)+(b*a)";
    public static final String INFIX16 = "a+b-c*d";
    public static final String INFIX17 = "(a-b/c)*(a/k-l)";
    public static final String INFIX18 = "(a+b)*c+d/(e+f*g)-h";
    public static final String INFIX19 = "a+b*c";
    public static final String INFIX20 = "k+l-m*n+(o^p)*w/u/v*t+q";
    public static final String INFIX21 = "(1*2)+(3*4)-5";



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



    /* ************* PREFIX EXPRESSIONS **************** */
    public static final String PREFIX1 = "+*ab-*cde";
    public static final String PREFIX2 = "+a-*bcd";
    public static final String PREFIX3 = "*+ab+cd";
    public static final String PREFIX4 = "+*ab*cd";
    public static final String PREFIX5 = "+a+b+cd";
    public static final String PREFIX6 = "-*+abc*-de+fg";
    public static final String PREFIX7 = "+a/*bc-de";
    public static final String PREFIX8 = "*+ab/-cd+ef";
    public static final String PREFIX9 = "*+ab/-cd*-ef+gh";
    public static final String PREFIX10 = "/+*+ab-cde+fg";
    public static final String PREFIX11 = "+*+abc-/d+e*fgh";
    public static final String PREFIX12 = "-*+a-bcd+ef";
    public static final String PREFIX13 = "+*a/bc+d-e*f/gh";
    public static final String PREFIX14 = "/-*ab-cd+ef";
    public static final String PREFIX15 = "-e+*dc*ba";
    public static final String PREFIX16 = "+a-b*cd";
    public static final String PREFIX17 = "*-a/bc-/akl";
    public static final String PREFIX18 = "+*+abc-/d+e*fgh";
    public static final String PREFIX19 = "+a*bc";
    public static final String PREFIX20 = "+k-l+*mn+*^op/w/u*vtq";

    /* ***************************** EXPRESSIONS FOR EVALUATIONS ******************************** */

    /* ************* POSTFIX EXPRESSIONS **************** */
    public static final String POSTFIX_EVAL1 = "231*+9-";
    public static final String POSTFIX_EVAL2 = "453*+45*+";

    /* ************* PREFIX EXPRESSIONS **************** */
    public static final String PREFIX_EVAL1 = "++4*53*45";

    /* ************* INFIX EXPRESSIONS **************** */
    public static final String INFIX_EVAL1 = "4+5*3+4*5";
}
