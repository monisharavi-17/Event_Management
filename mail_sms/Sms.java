package mail_sms;
import java.net.URI;
import java.net.URISyntaxException;
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

public class Sms {
  // Find your Account Sid and Token at twilio.com/console
  public static final String ACCOUNT_SID = "AC72c9bc086f17c9f72a23be93ad3bd4cb";
  public static final String AUTH_TOKEN = "21deda12647bb73e2df57e9717d56233";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
      new com.twilio.type.PhoneNumber("+919962141580"),
      new com.twilio.type.PhoneNumber("+17076220498"),
      "Hi, Your Booking is Being Processed. Our Event Manager will contact you soon")
    .create();

    System.out.println(message.getSid());
  }
}