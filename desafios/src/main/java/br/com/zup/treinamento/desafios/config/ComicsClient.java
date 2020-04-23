package br.com.zup.treinamento.desafios.config;

import br.com.zup.treinamento.desafios.models.Comics;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ComicsClient {

    public Comics listApiConnect() {
        // Chave publica da conta na API da Marvel
        String publicKey = "{PUBLIC_KEY}";
        // Chave privada da conta na API da Marvel
        String privateKey = "{PRIVATE_KEY}";

        // Pegando a data e hora atual
        Long timeStamp = System.currentTimeMillis();
        String hash = DigestUtils.md5Hex(timeStamp + privateKey + publicKey);

        RestTemplate restTemplate = new RestTemplate();
        String url = ("http://gateway.marvel.com/v1/public/comics?ts=" + timeStamp + "&apikey=" + publicKey + "&hash=" + hash);

        ResponseEntity<Comics> response = restTemplate.getForEntity(url, Comics.class);
        return response.getBody();
    }
}
