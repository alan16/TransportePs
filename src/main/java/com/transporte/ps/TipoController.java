package com.transporte.ps;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.transporte.ps.domain.Tipo;
import com.transporte.ps.service.TiposServiceImp;
import com.transporte.ps.service.TiposService;

@RestController
public class TipoController {

	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private TiposService tipoService = new TiposServiceImp();

	@RequestMapping(value = "/guardarTipo.html", method = RequestMethod.POST)
	public void guardarMarca(@RequestBody String mod) {
		Tipo tipo = gson.fromJson(mod, Tipo.class);
		tipoService.saveTipo(tipo);
	}

	@RequestMapping(value = "/getAllTipos.html", method = RequestMethod.GET)
	public String getAll() {
		JsonArray jsonArray = new JsonArray();
		List<Tipo> tipos = tipoService.getTipos();
		for (Tipo tipo : tipos) {
			JsonObject jsonObjet = new JsonObject();
			jsonObjet.addProperty("id", tipo.getId());
			jsonObjet.addProperty("nombre", tipo.getNombre());
			jsonArray.add(jsonObjet);
		}
		String stringTipos = jsonArray.toString();
		return stringTipos;
	}

	@RequestMapping(value = "/getTipo.html/{id}", method = RequestMethod.GET)
	public String getTipo(@PathVariable(value = "id") int id) {

		Tipo tipo = tipoService.buscarTipo(id);
		JsonObject jsonObjet = new JsonObject();
		jsonObjet.addProperty("id", tipo.getId());
		jsonObjet.addProperty("nombre", tipo.getNombre());

		return jsonObjet.toString();
	}

	@RequestMapping(value = "/updateTipo.html", method = RequestMethod.PUT)
	public void updateTipo(@RequestBody String mod) {
		Tipo tipo = gson.fromJson(mod, Tipo.class);
		Tipo tipo2 = tipoService.buscarTipo(tipo.getId());
		tipo2.setNombre(tipo.getNombre());
		tipoService.updateTipo(tipo2);
	}

	@RequestMapping(value = "/deleteTipo.html/{id}", method = RequestMethod.DELETE)
	public void deleteMarca(@PathVariable(value = "id") int id) {

		Tipo tipo = tipoService.buscarTipo(id);
		tipoService.deleteTipo(tipo);
	}
	
}
