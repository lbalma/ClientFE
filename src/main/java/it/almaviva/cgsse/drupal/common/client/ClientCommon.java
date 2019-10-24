package it.almaviva.cgsse.drupal.common.client;

import it.almaviva.cgsse.drupal.common.utils.ClientCostant;
import it.almaviva.cgsse.utils.AES;
import it.almaviva.cgsse.utils.PropertiesManager;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Base64;

public class ClientCommon extends ClientCostant {
    //Client unico
    protected static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    /**
     * Metodo per aggiungere il contennuto necessario all'autorizzazionee nell header
     *
     * @return
     */
    protected String getAuth() throws IOException {
        String FE_ACCOUNT_PICE_A = PropertiesManager.getInstance().getValue(PropertiesManager.FE_ACCOUNT_PICE_A);
        String FE_ACCOUNT_PICE_B = PropertiesManager.getInstance().getValue(PropertiesManager.FE_ACCOUNT_PICE_B);
        String decryptedPaceA = AES.decrypt(FE_ACCOUNT_PICE_A);
        String decryptedPaceB = AES.decrypt(FE_ACCOUNT_PICE_B);


        String encoding = Base64.getEncoder().encodeToString((decryptedPaceA+":"+decryptedPaceB).getBytes());
        return "Basic "+encoding;
    }

    /**
     * Metodo per aggiungere il tipi contunuto a accettati nell header per a comunicazione con le jsonapi di drupal
     *
     * @param builder
     */
    protected void setStandardHeader(HttpRequest.Builder builder){
        builder.setHeader(HEADER_ACCEPT, HEADER_DRUPAL_JSONAPI);
        builder.setHeader(HEADER_CONTENT_TYPE, HEADER_DRUPAL_JSONAPI);
    }

    /**
     * Metodo per aggiungere il tipi contunuto a accettati nell header per a comunicazione con le jsonapi di drupal
     *
     * @param builder
     */
    protected void setFileHeader(HttpRequest.Builder builder){
        builder.setHeader(HEADER_ACCEPT, HEADER_DRUPAL_JSONAPI);
        builder.setHeader(HEADER_CONTENT_TYPE, HEADER_DRUPAL_JSONAPI_CONTENT_TYPE_BINARY);
        builder.setHeader(HEADER_CONTENT_DISPOSITION, "file,filename=\"name.pdf\"");//TODO file name to variable
    }


    /**
     * Metodo per aggiugnere nell header la simple auth
     *
     * @param builder
     */
    protected void setAuth(HttpRequest.Builder builder) throws IOException {
        builder.setHeader(HEADER_AUTH,  getAuth());
    }



}
