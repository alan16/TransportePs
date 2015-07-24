package com.transporte.ps;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.transporte.ps.domain.Movil;
import com.transporte.ps.service.MovilService;
import com.transporte.ps.service.MovilServiceImp;

@Controller
public class MovilController {

	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private MovilService movilService = new MovilServiceImp();

	@RequestMapping(value = "/guardarMovil.html", method = RequestMethod.POST)
	public void guardarMarca(@RequestBody String mod) {
		Movil movil = gson.fromJson(mod, Movil.class);
		movilService.saveMovil(movil);
	}

	@RequestMapping(value = "/getAllMovils.html", method = RequestMethod.GET)
	public String getAll() {
		JsonArray jsonArray = new JsonArray();
		List<Movil> movils = movilService.getMovils();
		for (Movil movil : movils) {
			JsonObject jsonObjet = new JsonObject();
			jsonObjet.addProperty("tuc", movil.getTuc());
			jsonObjet.addProperty("chasis", movil.getChasis());
			jsonObjet.addProperty("motor", movil.getChasis());
			jsonObjet.addProperty("patente", movil.getChasis());
			jsonObjet.addProperty("", movil.getChasis());
			jsonObjet.addProperty("", movil.getChasis());
			jsonObjet.addProperty("", movil.getChasis());
			
			jsonArray.add(jsonObjet);
		}
		String stringMovils = jsonArray.toString();
		return stringMovils;
	}

	@RequestMapping(value = "/getMovil.html/{id}", method = RequestMethod.GET)
	public String getMovil(@PathVariable(value = "id") int id) {

		Movil movil = movilService.buscarMovil(id);
		JsonObject jsonObjet = new JsonObject();
		jsonObjet.addProperty("id", movil.getTuc());
		jsonObjet.addProperty("nombre", movil.getChasis());

		return jsonObjet.toString();
	}

	@RequestMapping(value = "/updateMovil.html", method = RequestMethod.PUT)
	public void updateMovil(@RequestBody String mod) {
		Movil movil = gson.fromJson(mod, Movil.class);
		Movil movil2 = movilService.buscarMovil(movil.getTuc());
		movil2.setObservacion(movil.getObservacion());
		movilService.updateMovil(movil2);
	}

	@RequestMapping(value = "/deleteMovil.html/{id}", method = RequestMethod.DELETE)
	public void deleteMarca(@PathVariable(value = "id") int id) {

		Movil movil = movilService.buscarMovil(id);
		movilService.deleteMovil(movil);
	}
}
