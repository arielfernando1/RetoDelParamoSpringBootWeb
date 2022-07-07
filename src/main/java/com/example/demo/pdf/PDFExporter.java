package com.example.demo.pdf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Participante;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDFExporter {
	@SuppressWarnings("unused")
	private List<Participante> participante;

	public PDFExporter(List<Participante> participante) {
		this.participante = participante;
	}

	private void writeTableHeader(Image img, Document document) {
		try {
			int indentation = 0;
			float scaler = ((document.getPageSize().getWidth() / img.getWidth()) * 100);
			System.out.print(document.getPageSize());
			img.scalePercent(scaler);
			//img.setAbsolutePosition(0, 750);
			document.add(img);
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void writeTableData(String[] data) {
		
	}

	public void export(HttpServletResponse response, @RequestParam Map<String, String> req)
			throws DocumentException, IOException {
		Document document = new Document(com.lowagie.text.PageSize.A4,50,50,0,50);
		PdfWriter.getInstance(document, response.getOutputStream());
		//Image image = Image.getInstance("C:/Users/header.png");
		document.open();
		Paragraph a = new Paragraph("Nombre y Apellidos: " + req.get("nombre") + " " + req.get("apellidos"));
		Paragraph b = new Paragraph("Edad: " + req.get("edad"));
		Paragraph c = new Paragraph("Tipo de Sangre: " + req.get("tipoSangre"));
		Paragraph d = new Paragraph("Cedula: " + req.get("cedula"));
		Paragraph e = new Paragraph("Ciudadania: " + req.get("ciudadania"));
		Paragraph f = new Paragraph("Telefono: " + req.get("telefono"));
		Paragraph g = new Paragraph("En caso de emergencia llamar: " + req.get("numeroEmergencia"));
		Paragraph h = new Paragraph("E-mail: " + req.get("email"));
		Paragraph i = new Paragraph("Domicilio: " + req.get("domicilio"));
		Paragraph j = new Paragraph(
				"1.- El participante acepta el presente reglamento y declara que se encuenntra fisicamente apto y entrenado para participar en esta actividad.\n"
						+ "2.- El participante toma conocimiento y acepta voluntariamente, que el Reto del Paramo, los sponsors, auspiciantes y/o sus empresas contratadas o vinculadas NO toman a su cargo ni se responsabilizan por ningun tipo de indeminizacion, reclamo, costo, daño y/o perjuicio reclamad, incluyendo y no limitado a daños por accidentes, daños materiales, fisicos, psiquicos o morales con motivo y en ocasion de la actividad fisica en la que participará.\n"
						+ "3.- El participante autoriza a las organizaciones utilizar, reproducir, distribuir y/o publicar fotografias, peliculas, videos, grabaciones y/o cualquier otro medio, tomadas con motivo y en ocasión del presente ciclo aventura, sin compensación económica alguna a favor del participante.\n"
						+ "4.- La organizacion podrá suspender el evento por cuestiones de seguridad publica, actos publicos, vandalismo y/o razones de fuerza mayor.\n"
						+ "5.- La organizacion no reembolsara el importe de la inscripcion a los participantes que decidan no participar una vez inscritos, cualquiera sea el motivo.\n"
						+ "6.- La participacion en esta carrera implica su responsabilidad por los datos suministrados, su aceptacion plena del reglamento, y el pago de los gastos de inscripcion."

		);
		document.add(a);
		document.add(b);
		document.add(c);
		document.add(d);
		document.add(e);
		document.add(f);
		document.add(g);
		document.add(h);
		document.add(i);
		document.add(j);
		document.close();

	}

}
