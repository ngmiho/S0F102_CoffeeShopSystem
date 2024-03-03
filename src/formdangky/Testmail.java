/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formdangky;
/**
 *
 * @author 84377
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Testmail {
    public static void parseMail(String email)throws Exception
    {
        String mau="\\w+@\\w+(\\.\\w+){1,2}";
        Pattern pattern = Pattern.compile(mau);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()==false)
            throw new Exception();
    }
}
