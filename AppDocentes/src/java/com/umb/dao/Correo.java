package com.umb.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class Correo {

    String FROM = "felchax@gmail.com";
    String FROMNAME = "felipe";
    String TO = "abel.chaux@umb.edu.co";
    String CONFIGSET = "ConfigSet";
    String HOST = "smtp.gmail.com"; 
    int PORT = 587;
    String SUBJECT = "App docentes Reporte";
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void enviarCorreo(Date fecha, Date bloqueInicio, String laboratorio) throws Exception {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(bloqueInicio);
        calendar.add(Calendar.MINUTE, 120);
        System.out.println("finall -> "+calendar.getTime());

        SimpleDateFormat fechaFormat = new SimpleDateFormat("YYYY/MM/dd");
        SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
// Create a Properties object to contain connection configuration information.
        // Create a transport.
        // Send the message.
        String BODY
                = "<h1>Reporte App</h1>"
                + "<table>\n"
                + "\n"
                + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\">Fecha</td>\n"
                + "    <td style=\"border: 1px solid black\">" + fechaFormat.format(fecha) + "</td>\n"
                + "\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\"> inicio bloque</td>\n"
                + "    <td style=\"border: 1px solid black\">" + horaFormat.format(bloqueInicio) + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\">fin bloque</td>\n"
                + "    <td style=\"border: 1px solid black\">"+ horaFormat.format(calendar.getTime()) +"</td>\n"
                + "  </tr>\n"
                 + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\">Laboratorio</td>\n"
                + "    <td style=\"border: 1px solid black\">"+ laboratorio +"</td>\n"
                + "  </tr>\n"
                + "</table>";

        try {

            Properties props = System.getProperties();

            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.debug", "true");
            props.put("mail.smtp.ssl.enable", "true");

            // Create a Session object to represent a mail session with the specified properties. 
            Session session = Session.getDefaultInstance(props);

            // Create a message with the specified information. 
            BodyPart texto = new MimeBodyPart();
            texto.setText(BODY);

            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(FROM, FROMNAME));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
            msg.setSubject(SUBJECT);
            msg.setContent(BODY, "text/html");

            // Add a configuration set header. Comment or delete the 
            // next line if you are not using a configuration set
            msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);

            Transport transport = session.getTransport();
            System.out.println("Sending...");

            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, "felchax@gmail.com", "hlfaxxwyseqyubhj");

            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("Email sent!");
            message = "Email enviado";
        } catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
            message = "Error " + ex.getMessage();
        }
    }
}
