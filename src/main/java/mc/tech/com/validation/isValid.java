package mc.tech.com.validation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.apache.commons.validator.EmailValidator;
import org.apache.commons.validator.GenericValidator;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class isValid {

    private String password;

    public static boolean isEmptyOrNull(String str)
    {
        return StringUtils.isEmpty(str);
    }
    public static String EmptyIfNull(String str)
    {
        if(isEmptyOrNull(str))
            return "";
        return str;
    }

    public static void checkStringPara(String paraName, String paraValue) {
        if (isEmptyOrNull(paraValue))

            throw new IllegalArgumentException("Invalid Value for:" + paraName);


    }
    public static void checkNumber(String paraName, String paraValue) {
        String contain = "\\d{10}";

        boolean result = paraValue.matches(contain);
        if (paraValue.isEmpty())

            throw new IllegalArgumentException("Required:" + paraName);
        if(!result) {

            throw new IllegalArgumentException("Given phone number is not valid:" + paraName);

        }

    }
    public static String IsValidEmail(String str) {
        if (EmailValidator.getInstance().isValid(str)) {
            return str;
        }
        System.out.println("Please enter correct email");
        String str2 = " Invalid Email";
        return str2;
    }
    public static void IsValidDate(String date) {

        if(!GenericValidator.isDate(date, "yyyy-MM-dd", true)){

            throw new IllegalArgumentException("Given Date  is not valid:" + date);
        }
 }
    public static void givenPhoneNumber_whenValid_thenOK(String phoneNumber) throws NumberParseException {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber phone = phoneNumberUtil.parse(phoneNumber,
                Phonenumber.PhoneNumber.CountryCodeSource.UNSPECIFIED.name());
        if(!phoneNumberUtil.isValidNumber(phone)){

            throw new IllegalArgumentException("Given Phone Number  is not valid:" + phoneNumber);
        }

   }
    public static void isPostCodeValid(String postCode){

        String regex="^[0-9]";
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher=pattern.matcher(postCode);
        if(!matcher.find()){
            throw new IllegalArgumentException("Given postCode  is not valid:" + postCode);

        }
    }


}