package crtsh;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Api {
	
//	public String getDomain(String domain) {
//		String Domain = domain;
//		return Domain;
//	}
	
	public void api(String domain) throws Exception {
		//System.out.println("parsed domain from api instances: " + domain);
		
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://crt.sh/?q=%25."+domain+"&output=json")).build();
		CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
		HttpResponse<String> reponse = future.get();
		String responseBody = reponse.body();
		//System.out.println(responseBody);
		ParseJson parseJson = new ParseJson();
		parseJson.toJson(responseBody);
		
	}	
}
