package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.drupal.bean.ATaxonomyRequest;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.drupal.utils.ClientCostant;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

/**
 * Classe astratta per interfaccia con i servizi drupal di tassonomia
 */
public abstract class ATaxonomyClient<R extends ATaxonomyRequest> extends ClientCostant {

    protected R taxonomyRequest;

    //Client
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    /**
     * Metodo che ritorna la lista di del contenuto della tassonomia
     *
     * @return
     * @throws Exception
     */
    public String getAll() throws Exception{

        HttpRequest request =  createGetHttpRequest(null);
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());
        return response.body();
    }

    /**
     * Metodo che torna un elemento specifico della tassonomia
     *
     * @param uuid identificativo univoco di un elemento della tassonomia su Drupal
     * @return
     * @throws Exception
     */
    public String get(String uuid) throws Exception{

        HttpRequest request = createGetHttpRequest(uuid);
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());
        return response.body();
    }

    /**
     * Metodo che inserisce un elemento nella tassonomia
     *
     * @return
     * @throws Exception
     */
    public String post() throws Exception{

        validateTaxonomyRequest();
        HttpRequest request = createPostHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());
        return response.body();

    }


    /**
     * Url del servizio
     *
     * @return
     */
    private String getService(){
        return "http://localhost:80/protocgsse/jsonapi/taxonomy_term"; //TODO Inserire in file di properties
    }

    /**
     * Metodo per la creazione di una richiesta http GET
     * @param params
     * @return
     */
    private HttpRequest createGetHttpRequest(String params){
        HttpRequest.Builder builder = HttpRequest.newBuilder().GET();
        setServiceUri(builder, params);
        setStandardHeader(builder);
        return  builder.build();
    }

      /*  return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(getService()+"/"+getEndpoint() + (params != null && !params.isEmpty() ? "/"+params : "")))
                .setHeader(HEADER_ACCEPT, HEADER_DRUPAL_JSONAPI)
                .setHeader(HEADER_CONTENT_TYPE, HEADER_DRUPAL_JSONAPI)
                .build();*/

    /**
     * Metodo per la creazione di una richiesta http POST
     * @return
     */
    private HttpRequest createPostHttpRequest() {
        HttpRequest.Builder builder = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(taxonomyRequest.toJsonBodyInsert()));
        setServiceUri(builder, null);
        setStandardHeader(builder);
        setAuth(builder);
        return builder.build();
    }
     /*   return HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(taxonomyRequest.toJsonBodyInsert()))
                .uri(URI.create(getService() + "/" + getEndpoint()))
                .setHeader(HEADER_ACCEPT, HEADER_DRUPAL_JSONAPI)
                .setHeader(HEADER_CONTENT_TYPE, HEADER_DRUPAL_JSONAPI)
                .setHeader(HEADER_AUTH,  getAuth())
                .build();

*/
    /**
     * Metodo per aggiungere il contennuto necessario all'autorizzazionee nell header
     *
     * @return
     */
    private String getAuth(){//TODO Gestire con file di properties e criptazione della password
        String encoding = Base64.getEncoder().encodeToString(("admin:admin").getBytes());
        return "Basic "+encoding;
    }

    /**
     * Metodo per aggiungere il tipi contunuto a accettati nell header per a comunicazione con le jsonapi di drupal
     *
     * @param builder
     */
    private void setStandardHeader(HttpRequest.Builder builder){
        builder.setHeader(HEADER_ACCEPT, HEADER_DRUPAL_JSONAPI);
        builder.setHeader(HEADER_CONTENT_TYPE, HEADER_DRUPAL_JSONAPI);
    }

    /**
     * Metodo per aggiugnere nell header la simple auth
     *
     * @param builder
     */
    private void setAuth(HttpRequest.Builder builder){
        builder.setHeader(HEADER_AUTH,  getAuth());
    }

    /**
     * Metodo per la configurazione del servizio e relativo enpoit di destinazione del client
     *
     * @param builder
     * @param params
     */
    private void setServiceUri(HttpRequest.Builder builder, String params){
        builder.uri(URI.create(getService()+"/"+getEndpoint() + (params != null && !params.isEmpty() ? "/"+params : "")));
    }

    /**
     * Endpoit del servizio
     *
     * @return
     */
    protected abstract String getEndpoint();

    /**
     * Validataore del bean di richiesta
     */
    protected abstract void validateTaxonomyRequest() throws NotValideRequestException;
}
