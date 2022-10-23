package ism.inscription.entities.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isEmail(String field){
        Pattern pattern=Pattern.compile("[a-zA-z-Z0-9]*@(gmail|yahoo){1}(.com|.fr){1}",Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(field);
        return !(matcher.find() && matcher.group().equals(field));
    }
    public static boolean isLibelle(String field){
        Pattern pattern=Pattern.compile("[a-zA-z-Z0-9]*\\s+[ a-zA-z-Z]*",Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(field);
        return !(matcher.find() && matcher.group().equals(field));
    }
    public static boolean isProf(String field){
        Pattern pattern=Pattern.compile("[a-zA-z-Z0-9]*[ a-zA-z-Z]*",Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(field);
        return !(matcher.find() && matcher.group().equals(field));
    }
    public static boolean isNomComplet(String field){
        Pattern pattern=Pattern.compile("[a-zA-z-Z]*\\s+[ a-zA-z-Z]*",Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(field);
        return !(matcher.find() && matcher.group().equals(field));
    }
}
