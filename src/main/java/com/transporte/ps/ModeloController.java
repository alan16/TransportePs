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
import com.transporte.ps.domain.Modelo;
import com.transporte.ps.service.ModelosService;
import com.transporte.ps.service.ModeloServiceImp;

@RestController
public class ModeloController {
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private ModelosService modeloService = new ModeloServiceImp();

	@RequestMapping(value = "/guardarModelo.html", method = RequestMethod.POST)
	public void guardarMarca(@RequestBody String mod) {
		Modelo modelo = gson.fromJson(mod, Modelo.class);
		modeloService.saveModelo(modelo);
	}

	@RequestMapping(value = "/getAllModelos.html", method = RequestMethod.GET)
	public String getAll() {
		JsonArray jsonArray = new JsonArray();
		List<Modelo> modelos = modeloService.getModelos();
		for (Modelo modelo : modelos) {
			JsonObject jsonObjet = new JsonObject();
			jsonObjet.addProperty("id", modelo.getId());
			jsonObjet.addProperty("nombre", modelo.getNombre());
			jsonArray.add(jsonObjet);
		}
		String stringModelos = jsonArray.toString();
		System.out.println(stringModelos);
		return stringModelos;
	}

	@RequestMapping(value = "/getModelo.html/{id}", method = RequestMethod.GET)
	public String getModelo(@PathVariable(value = "id") int id) {

		Modelo modelo = modeloService.buscarModelo(id);
		JsonObject jsonObjet = new JsonObject();
		jsonObjet.addProperty("id", modelo.getId());
		jsonObjet.addProperty("nombre", modelo.getNombre());

		return jsonObjet.toString();
	}

	@RequestMapping(value = "/updateModelo.html", method = RequestMethod.PUT)
	public void updateModelo(@RequestBody String mod) {
		Modelo modelo = gson.fromJson(mod, Modelo.class);
		Modelo modelo2 = modeloService.buscarModelo(modelo.getId());
		modelo2.setNombre(modelo.getNombre());
		modeloService.updateModelo(modelo2);
	}

	@RequestMapping(value = "/deleteModelo.html/{id}", method = RequestMethod.DELETE)
	public void deleteMarca(@PathVariable(value = "id") int id) {

		Modelo modelo = modeloService.buscarModelo(id);
		modeloService.deleteModelo(modelo);
	}
}
