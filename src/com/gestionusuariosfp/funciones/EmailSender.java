package com.gestionusuariosfp.funciones;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("EmailSender")
public class EmailSender {


	@Autowired
	private JavaMailSenderImpl javaMailSender;

	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendMail(String receptor, String emisorTarea, String nombre, String descripcion) {
		
		javaMailSender.setPassword("geusfp.2018");
		javaMailSender.setUsername("GEUSFP@gmail.com");
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		
		Properties prop = javaMailSender.getJavaMailProperties();
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.debug", "true");
		
		//Añadir texto email a las constantes del programa
		String emisorEmail = "danieldiezarias@gmail.com";
		String receptorEmail = receptor;
		String asuntoEmail = "Tareas corporativas GEUS-FP";
		String cuerpoEmail = "Tarea generada con nombre "+nombre+" emitida "
						 + "por el analista "+emisorTarea+". El detallado de la "
						 + "tarea es el siguiente: "+descripcion;

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

			helper.setFrom(emisorEmail);
			helper.setTo(receptorEmail);
			helper.setSubject(asuntoEmail);
			helper.setText(cuerpoEmail);

			javaMailSender.send(mimeMessage);
			System.out.println("Email enviado correctamente...");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	
	
	}

}
