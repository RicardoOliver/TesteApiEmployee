package br.desafio.api.DesafioAPI;

import org.jsoup.Connection.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import org.springframework.core.*;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.net.CacheResponse;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;


public class EmployeeStepsDefinitions {

	HttpHeaders headers;
	String emp_name;
	RestTemplate restTemplate;
	String addURI;
	String employeeId;
	ResponseEntity<String> response;
	String responseBodyPost;
	String responseBody;
	Response getEmpIdFromResponse;

	// ------------------------POST----------------------------------

	@Dado("^conjunto  Post emprega servico api do endpoint$")
	public void conjunto_Post_emprega_servico_api_do_endpoint() {
		addURI = "http://dummy.restapiexample.com/api/v1/create";
		System.out.println("Add URL:" + addURI);

	}

	@Quando("^conjunto Post faz solicitacao do  cabechalho$")
	public void conjunto_Post_faz_solicitacao_do_cabechalho() {
		headers = new HttpHeaders();
		headers.add("Accept", "Application/json");
		headers.add("Content-Type", "Application/json");
	}

	@Quando("^deve enviar o Post HTTP via request$")
	public void eve_enviar_o_post_http_via_request() {
		double name_id = Math.random();
		emp_name = "Ricardo" + name_id;
		String jsonBody = "{\"name\":\"" + emp_name + "\",\"salary\":\"123\",\"age\":\"25\"}";
		System.out.println("\n\n" + jsonBody);
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		this.restTemplate = new RestTemplate();
		this.response = this.restTemplate.postForEntity(addURI, entity, String.class);
	}

	@Então("deve receber resposta valida$")
	public void deve_receber_resposta_valida() throws ParseException {
		try {
			this.responseBodyPost = response.getBody();
			this.responseBody = this.response.getBody().toString();
			System.out.println("responseBody --->" + responseBody);

			employeeId = getEmpIdFromResponse(responseBody);
			System.out.println("empId é :" + employeeId);

			assertNotEquals(responseBody, employeeId);
			if (response.getStatusCode() == HttpStatus.OK) {
				System.out.println("Request Sucesso!");
				System.out.println(response.getBody());
			} else {
				System.out.println("Request Falha!");
				System.out.println(response.getStatusCode());
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//------------------------PUT----------------------------------
	@Dado("^Conjunto Put emprega servico api endpoint$")
	public void conjunto_Put_emprega_servico_api_do_endpoint() {
		addURI = "http://dummy.restapiexample.com/api/v1/update/{id}";
		System.out.println("Add URL:" + addURI);

	}

	@Quando("^Conjunto de Update via request Body$")
	public void conjunto_Put_faz_solicitacao_do_cabechalho() {
		headers = new HttpHeaders();
		headers.add("Accept", "Application/json");
		headers.add("Content-Type", "Application/json");
	}

	@Quando("^deve enviar a Put via HTTP request$")
	public void eve_enviar_o_put_http_via_request() {
		double name_id = Math.random();
		emp_name = "Ricardo" + name_id;
		String jsonBody = "{\"name\":\"" + emp_name + "\",\"salary\":\"123\",\"age\":\"25\"}";
		System.out.println("\n\n" + jsonBody);
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		this.restTemplate = new RestTemplate();
		this.response = this.restTemplate.postForEntity(addURI, entity, String.class);
	}

	@Então("deve receber resposta valida do codigo via HTTP 200$")
	public void deve_receber_resposta_valida_coigoPut() throws ParseException {
		try {
			this.responseBodyPost = response.getBody();
			this.responseBody = this.response.getBody().toString();
			System.out.println("responseBody --->" + responseBody);

			employeeId = getEmpIdFromResponse(responseBody);
			System.out.println("empId é :" + employeeId);

			assertNotEquals(responseBody, employeeId);
			if (response.getStatusCode() == HttpStatus.OK) {
				System.out.println("Request Sucesso!");
				System.out.println(response.getBody());
			} else {
				System.out.println("Request Falha!");
				System.out.println(response.getStatusCode());
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------Get----------------------------------
	@Dado("^Conjunto Get de empregados do servico api endpoint$")
	public void conjunto_Get_emprega_servico_api_do_endpoint() {
		addURI = "http://dummy.restapiexample.com/api/v1/employee";
		System.out.println("Add URL:" + addURI);

	}

	@Quando("^Conjunto de solicitacao do cabecalho$")
	public void conjunto_Get_faz_solicitacao_do_cabechalho() {
		headers = new HttpHeaders();
		headers.add("Accept", "Application/json");
		headers.add("Content-Type", "Application/json");
	}

	@Quando("^deve enviar a solicitacao HTTP GET$")
	public void eve_enviar_o_Get_http_via_request() {
		double name_id = Math.random();
		emp_name = "Ricardo" + name_id;
		String jsonBody = "{\"name\":\"" + emp_name + "\",\"salary\":\"123\",\"age\":\"25\"}";
		System.out.println("\n\n" + jsonBody);
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		this.restTemplate = new RestTemplate();
		this.response = this.restTemplate.postForEntity(addURI, entity, String.class);
	}

	@Então("deve receber resposta valida do codigo via HTTP 200$")
	public void deve_receber_resposta_valida_coigoGet() throws ParseException {
		try {
			this.responseBodyPost = response.getBody();
			this.responseBody = this.response.getBody().toString();
			System.out.println("responseBody --->" + responseBody);

			employeeId = getEmpIdFromResponse(responseBody);
			System.out.println("empId é :" + employeeId);

			assertNotEquals(responseBody, employeeId);
			if (response.getStatusCode() == HttpStatus.OK) {
				System.out.println("Request Sucesso!");
				System.out.println(response.getBody());
			} else {
				System.out.println("Request Falha!");
				System.out.println(response.getStatusCode());
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------Delete----------------------------------
	@Dado("^Conjunto  Delete empregado servico api endpoint$")
	public void conjunto_Delete_emprega_servico_api_do_endpoint() {
		addURI = "http://dummy.restapiexample.com/api/v1/delete/{id}";
		System.out.println("Add URL:" + addURI);

	}

	@Quando("^Conjunto Delete Solicitacao HTTP$")
	public void eve_enviar_o_Delete_http_via_request() {
		double name_id = Math.random();
		emp_name = "Ricardo" + name_id;
		String jsonBody = "{\"name\":\"" + emp_name + "\",\"salary\":\"123\",\"age\":\"25\"}";
		System.out.println("\n\n" + jsonBody);
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		this.restTemplate = new RestTemplate();
		this.response = this.restTemplate.postForEntity(addURI, entity, String.class);
	}

	@Então("deve receber resposta valida do codigo via HTTP 200$")
	public void deve_receber_resposta_valida_coigoDelete() throws ParseException {
		try {
			this.responseBodyPost = response.getBody();
			this.responseBody = this.response.getBody().toString();
			System.out.println("responseBody --->" + responseBody);

			employeeId = getEmpIdFromResponse(responseBody);
			System.out.println("empId é :" + employeeId);

			assertNotEquals(responseBody, employeeId);
			if (response.getStatusCode() == HttpStatus.OK) {
				System.out.println("Request Sucesso!");
				System.out.println(response.getBody());
			} else {
				System.out.println("Request Falha!");
				System.out.println(response.getStatusCode());
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static String getEmpIdFromResponse(String json) throws ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonResponseObject = new JSONObject();
		Object obj = new Object();
		try {
			obj = parser.parse(json);
		} catch (org.jsoup.SerializationException e) {
			e.getMessage();
		}
		jsonResponseObject = (JSONObject) obj;
		String id = jsonResponseObject.get("id").toString();
		return id;
	}
}
