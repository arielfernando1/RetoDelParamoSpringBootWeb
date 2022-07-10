package com.example.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.entities.Evento;
import com.example.demo.entities.Participante;
import com.example.demo.pdf.PDFExporter;
import com.example.demo.services.EventoService;
import com.example.demo.services.ParticipanteService;
import com.itextpdf.text.DocumentException;

@Controller
public class ParticipanteController {
	@Autowired
	private ParticipanteService service;
	@Autowired
	private EventoService service1;

	@GetMapping("/form")
	public String Form(Model model) {
		List<Evento> evtList = service1.ListAll();
		model.addAttribute("evento", evtList);
		model.addAttribute("participante", new Participante());
		return "form";
	}

	@GetMapping("/reglamento")
	public String Reglamento() {
		return "reglamento";
	}

	@GetMapping("/participantes")
	public String Participantes(Model model) {
		List<Participante> partList = service.ListAll();
		model.addAttribute("partList", partList);
		return "participantes";
	}

	@RequestMapping(value = "/participar", method = RequestMethod.POST)
	public void SaveParticipante(@ModelAttribute("participante") Participante part,
			@RequestParam Map<String, String> reqParam, HttpServletResponse response)
			throws DocumentException, IOException {
		service.Save(part);
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=formulario_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Participante> listaParticipantes = service.ListAll();
		PDFExporter exporter = new PDFExporter(listaParticipantes);
		exporter.export(response, reqParam);
	}

	@RequestMapping("/success")
	public String Success() {
		return "success";
	}

	@GetMapping("/pdf")
	public void Pdf(HttpServletResponse response) throws DocumentException, IOException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=formulario_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Participante> listaParticipantes = service.ListAll();
		PDFExporter exporter = new PDFExporter(listaParticipantes);
		// exporter.export(response, );

	}

}
