import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://api.nasa.gov/planetary/apod?api_key=qjQhhnL9g0XjBw2T6MjERGafgM6IJ8JVfApe3SbX";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        ObjectMapper mapper = new ObjectMapper();
        NasaAnswer answer = mapper.readValue(response.getEntity().getContent(), NasaAnswer.class);
        System.out.println(answer.title);
        System.out.println(answer.explanation);
        System.out.println(answer.url);


        String[] splitedUrl = answer.url.split("/");
        String fileName = splitedUrl[splitedUrl.length - 1];
        HttpGet imageRequest = new HttpGet(answer.url);
        CloseableHttpResponse imageResponse = httpClient.execute(imageRequest);
        FileOutputStream fos = new FileOutputStream("images/" + fileName);
        imageResponse.getEntity().writeTo(fos);
        fos.close();
    }
}