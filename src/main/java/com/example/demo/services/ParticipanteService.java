package com.example.demo.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Participante;
import com.example.demo.repos.ParticipanteRepo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

@Service
@Configurable
public class ParticipanteService {
	@Autowired
	ParticipanteRepo repo;

	public List<Participante> ListAll() {
		return repo.findAll();

	}

	public void Save(Participante prt) {
		repo.save(prt);
	}

	public void generarPDF() throws FileNotFoundException, DocumentException {
		Document doc = new Document();
		PdfWriter.getInstance(doc, new FileOutputStream("hola.pdf"));
		doc.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk chunk = new Chunk("Hello World", font);
		doc.add(chunk);
		doc.close();
	}

}
