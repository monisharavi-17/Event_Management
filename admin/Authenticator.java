package admin;

import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.security.SecureRandom;
import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
public class Authenticator{

public static String generateSecretKey() {
    SecureRandom random = new SecureRandom();
    byte[] bytes = new byte[20];
    random.nextBytes(bytes);
    Base32 base32 = new Base32();
    return base32.encodeToString(bytes);
}
public static String getTOTPCode(String secretKey) {
    Base32 base32 = new Base32();
    byte[] bytes = base32.decode(secretKey);
    String hexKey = Hex.encodeHexString(bytes);
    return TOTP.getOTP(hexKey);
}
public static void main(String[] args)
{
String secretKey = generateSecretKey();
//System.out.println(secretKey);

//String secretKey = "k1";
String lastCode = null;
while (true) {
    String code = getTOTPCode(secretKey);
    System.out.println(code);
    if (!code.equals(lastCode)) {
        System.out.println(code);
    }
    lastCode = code;
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {};
}
}
}