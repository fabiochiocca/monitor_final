package com.uniritter.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Consumer {

	public String getMetrica(String parametros) {
		  String objetoRetorno = "";
	      String urlWebService = "http://localhost:9003/service/metrica";
		
	      try {
	         
	         urlWebService = urlWebService+ "?id="+parametros;
			
	         URL url = new URL(urlWebService);
	         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	         connection.setRequestMethod("GET");
	         connection.setConnectTimeout(15000);
	         connection.connect();

	         String responseJson = inputStreamToString(connection.getInputStream());
	         connection.disconnect();
			
	         objetoRetorno = responseJson;

	      } catch (Exception e) {
	         objetoRetorno = e.getMessage();
	      }	
	      return objetoRetorno;
	   }

	   public static Object postObjeto(Object objetoEnvio, Class tipoObjetoRetorno, String urlWebService) {
	      Object objetoRetorno = null;
		
	      try {
	         String requestJson = toJson(objetoEnvio);
			
	         URL url = new URL(urlWebService);
	         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	         connection.setRequestMethod("POST");
	         connection.setDoOutput(true);
	         connection.setUseCaches(false);
		 connection.setConnectTimeout(15000);
	         connection.setRequestProperty("login", "teste");
	         connection.setRequestProperty("senha", "teste");
	         connection.setRequestProperty("Content-Type", "application/json");
	         connection.setRequestProperty("Accept", "application/json");
	         connection.setRequestProperty("Content-Length", Integer.toString(requestJson.length()));
				
	         DataOutputStream stream = new DataOutputStream(connection.getOutputStream());
	         stream.write(requestJson.getBytes("UTF-8"));
	         stream.flush();
	         stream.close();
	         connection.connect();

	         String responseJson = inputStreamToString(connection.getInputStream());
	         connection.disconnect();
	         objetoRetorno = fromJson(responseJson, tipoObjetoRetorno);

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return objetoRetorno;
	   }


	   public static String inputStreamToString(InputStream is) throws IOException {
	      if (is != null) {
	         Writer writer = new StringWriter();

	         char[] buffer = new char[1024];
	         try {
	            Reader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	            int n;
	            while ((n = reader.read(buffer)) != -1) {
	               writer.write(buffer, 0, n);
	            }
	         } finally {
	            is.close();
	         }
	         return writer.toString();
	      } else {
	         return "";
	      }
	   }

	   public static String toJson(Object objeto) throws Exception {
	      ObjectMapper mapper = new ObjectMapper();
	      StringWriter jsonValue = new StringWriter();
	      mapper.writeValue(new PrintWriter(jsonValue), objeto);
	      return jsonValue.toString();
	   }


	   @SuppressWarnings("deprecation")
	public static Object fromJson(String json, Class objectClass) throws Exception {
	      JsonFactory f = new MappingJsonFactory();
	      JsonParser jp = f.createJsonParser(json);
	      Object obj = jp.readValueAs(objectClass);
	      return obj;
	   }

	public String getMetricas() {
		String objetoRetorno = "";
	      String urlWebService = "http://localhost:9003/service/metricas";
		
	      try {
			
	         URL url = new URL(urlWebService);
	         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	         connection.setRequestMethod("GET");
	         connection.setConnectTimeout(15000);
	         connection.connect();

	         String responseJson = inputStreamToString(connection.getInputStream());
	         connection.disconnect();
			
	         objetoRetorno = responseJson;

	      } catch (Exception e) {
	    	  objetoRetorno = e.getMessage();
	      }	
	      return objetoRetorno;

	}

}
