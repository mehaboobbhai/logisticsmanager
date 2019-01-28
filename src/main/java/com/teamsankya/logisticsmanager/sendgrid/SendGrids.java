package com.teamsankya.logisticsmanager.sendgrid;

import com.sendgrid.*;
import java.io.IOException;

public class SendGrids {
  public static void main(String[] args) throws IOException {
	  System.out.println("inside sendgrids main()");
    Email from = new Email("Ramanji.s@teamsankya.com");
    String subject = "NatureBandhu Order Delevered";
    Email to = new Email("ramanjisunkara@gmail.com");
    Content content = new Content("text/plain", "Your Purchased Item is delevered Happy to searve you..! ");
    Mail mail = new Mail(from, subject, to, content);
    // sendgrid key
    //SendGrid sg = new SendGrid(System.getenv("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"));
    SendGrid sg = new SendGrid("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");
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
         } catch (IOException ex) {
      throw ex;
    }
	  
  }
}