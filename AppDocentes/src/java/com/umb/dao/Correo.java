package com.umb.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class Correo {

    String FROM = "felchax@gmail.com";
    String FROMNAME = "App Reserva y Prestamo de Aulas de Laboratorio | UMB";
    //String TO = "abel.chaux@umb.edu.co";
    String CONFIGSET = "ConfigSet";
    String HOST = "smtp.gmail.com";
    int PORT = 587;
    String SUBJECT = "Notificacion App de Reserva y Prestamo de Aulas de Laboratorio | UMB";
    String message;
    ArrayList<String> destinatarios;

    public Correo() {
        destinatarios=new ArrayList();
        destinatarios.add("abel.chaux@umb.edu.co");
        destinatarios.add("felipechauxx@misena.edu.co");
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void correoBloque(Date fecha, Date bloqueInicio, String laboratorio,String usuario) throws Exception {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(bloqueInicio);
        calendar.add(Calendar.MINUTE, 120);
        System.out.println("finall -> " + calendar.getTime());

        SimpleDateFormat fechaFormat = new SimpleDateFormat("YYYY/MM/dd");
        SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");

        String BODY
                = "<h1>Creacion de bloque</h1>"
                + "  <p><strong>" + usuario + "</strong> ha creado un bloque de laboratorio, a continuación, se muestra el detalle del bloque: </p>\n"
                + "<table>\n"
                + "\n"
                + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\"><strong>FECHA</strong></td>\n"
                + "    <td style=\"border: 1px solid black\">" + fechaFormat.format(fecha) + "</td>\n"
                + "\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\"><strong>INICIO BLOQUE</strong></td>\n"
                + "    <td style=\"border: 1px solid black\">" + horaFormat.format(bloqueInicio) + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\"><strong>FIN BLOQUE</strong></td>\n"
                + "    <td style=\"border: 1px solid black\">" + horaFormat.format(calendar.getTime()) + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\"><strong>LABORATORIO</strong></td>\n"
                + "    <td style=\"border: 1px solid black\">" + laboratorio + "</td>\n"
                + "  </tr>\n"
                + "</table>";

        enviarCorreo(BODY);

    }

    public void correoReserva(String usuarioReserva, String fecha, String bloque, String laboratorio, String asignatura, String personaAsignada) {
        //nombre usuario, bloque inicio y fin 
        System.out.println("enviar correo");

        String BODY
                = "<h1>Reporte de reservas</h1>\n"
                + "  <p><strong>" + usuarioReserva + "</strong> ha reservado un bloque de laboratorio, a continuación, se muestra el detalle de la reserva: </p>\n"
                + "<table>\n"
                + "\n"
                + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\"><strong>USUARIO ASIGNADO</strong></td>\n"
                + "    <td style=\"border: 1px solid black\"><strong><a href='mailto:felchax@gmail.com'>" + personaAsignada + "</a></strong></td>\n"
                + "\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\"><strong>FECHA</strong></td>\n"
                + "    <td style=\"border: 1px solid black\">" + fecha + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\"><strong>BLOQUE</strong></td>\n"
                + "    <td style=\"border: 1px solid black\">" + bloque + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\"><strong>LABORATORIO </strong></td>\n"
                + "    <td style=\"border: 1px solid black\">" + laboratorio + "</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td style=\"border: 1px solid black\"><strong>ASIGNATURA</strong></td>\n"
                + "    <td style=\"border: 1px solid black\">" + asignatura + "</td>\n"
                + "  </tr>\n"
                + "</table>";

        enviarCorreo(BODY);

    }

    public void enviarCorreo(String body) {
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
            for (String TO : destinatarios) {
                BodyPart texto = new MimeBodyPart();
                texto.setText(body);
                MimeMessage msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(FROM, FROMNAME));
                msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
                msg.setSubject(SUBJECT);
                msg.setContent(body, "text/html");
                msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
                Transport transport = session.getTransport();
                System.out.println("Sending...");
                transport.connect(HOST, "felchax@gmail.com", "hlfaxxwyseqyubhj");
                // Send the email.
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();
            }

            System.out.println("Email sent!");
            message = "Email enviado";
        } catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
            message = "Error " + ex.getMessage();
        }
    }
}
