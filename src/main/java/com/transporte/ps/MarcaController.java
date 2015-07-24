package com.transporte.ps;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.transporte.ps.domain.Marca;
import com.transporte.ps.service.MarcaService;
import com.transporte.ps.service.MarcaServiceImp;

@RestController
public class MarcaController {
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private MarcaService marcaService = new MarcaServiceImp();

	@RequestMapping(value = "/guardarMarca.html", method = RequestMethod.POST)
	public void guardarMarca(@RequestBody String marca) {
		Marca mar = gson.fromJson(marca, Marca.class);
		marcaService.saveMarca(mar);

	}

	@RequestMapping(value = "/getMarca.html/{id}", method = RequestMethod.GET)
	public String getMarca(@PathVariable(value = "id") int id) {

		System.out.println("valor de del id: " + id);
		Marca marca = marcaService.buscarMarca(id);
		JsonObject jsonObjet = new JsonObject();
		jsonObjet.addProperty("id", marca.getId());
		jsonObjet.addProperty("nombre", marca.getNombre());

		return jsonObjet.toString();
	}

	@RequestMapping(value = "/getAllMarcas.html", method = RequestMethod.GET)
	public String getAll() {
		JsonArray jsonArray = new JsonArray();
		List<Marca> marcas = marcaService.getMarcas();
		for (Marca marca : marcas) {
			JsonObject jsonObjet = new JsonObject();
			jsonObjet.addProperty("id", marca.getId());
			jsonObjet.addProperty("nombre", marca.getNombre());
			jsonArray.add(jsonObjet);
		}
		String stringMarcas = jsonArray.toString();
		//System.out.println(stringMarcas);
		return stringMarcas;
	}

	@RequestMapping(value = "/updateMarca.html", method = RequestMethod.PUT)
	public void updateMarca(@RequestBody String mar) {
		Marca marca = gson.fromJson(mar, Marca.class);
		System.out.println(marca.getId());
		System.out.println(marca.getNombre());
		Marca marca2 = marcaService.buscarMarca(marca.getId());
		marca2.setNombre(marca.getNombre());
		marcaService.updateMarca(marca2);
	}

	@RequestMapping(value = "/deleteMarca.html/{id}", method = RequestMethod.DELETE)
	public void deleteMarca(@PathVariable(value = "id") int id) {

		Marca marca = marcaService.buscarMarca(id);
		marcaService.deleteMarca(marca);
	}

}
