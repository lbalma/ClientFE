package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.drupal.taxonomy.bean.ATaxonomy;
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
public abstract class ATaxonomyClient<R extends ATaxonomy> extends ClientCostant {

    protected R taxonomyRequest;
    private int status;

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
    public void getAll() throws Exception{

        HttpRequest request =  createGetHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        checkError(response);
        setResult(response, true);

    }

    /**
     * Metodo che torna un elemento specifico della tassonomia
     *
     * @return
     * @throws Exception
     */
    public void get() throws Exception{

        HttpRequest request = createGetHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        checkError(response);
        setResult(response, false);

    }



    /**
     * Metodo che inserisce un elemento nella tassonomia
     *
     * @return
     * @throws Exception
     */
    public void post() throws Exception{

        validateTaxonomyRequest();
        HttpRequest request = createPostHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        checkError(response);
        setResult(response, false);

    }

    /**
     * Metodo che elimina un elemento nella tassonomia
     *
     * @return
     * @throws Exception
     */
    public boolean del() throws Exception{
        validateUUIDRequest();
        HttpRequest request = createDelHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        checkError(response);

        return true;
    }

    /**
     * Metodo che aggiorna un elemento nella tassonomia
     *
     * @return
     * @throws Exception
     */
    public void patch() throws Exception{
        validateUUIDRequest();
        HttpRequest request = createPatchHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        checkError(response);
        setResult(response, false);

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
     * @return
     */
    private HttpRequest createGetHttpRequest(){
        HttpRequest.Builder builder = HttpRequest.newBuilder().GET();
        setServiceUri(builder, taxonomyRequest.getUUID());
        setStandardHeader(builder);
        return  builder.build();
    }

    /**
     * Metodo per la creazione di una richiesta http POST
     * @return
     */
    private HttpRequest createPostHttpRequest() {
        HttpRequest.Builder builder = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(taxonomyRequest.toJsonBodyInsert()));
        setServiceUri(builder, taxonomyRequest.getUUID());
        setStandardHeader(builder);
        setAuth(builder);
        return builder.build();
    }

    /**
     * Metodo per la creazione di una richiesta http DELETE
     * @return
     */
    private HttpRequest createDelHttpRequest() {
        HttpRequest.Builder builder = HttpRequest.newBuilder().DELETE();
        setServiceUri(builder, taxonomyRequest.getUUID());
        setStandardHeader(builder);
        setAuth(builder);
        return builder.build();
    }


    /**
     * Metodo per la creazione di una richiesta http PATCH
     * @return
     */
    private HttpRequest createPatchHttpRequest() {
        HttpRequest.Builder builder = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(taxonomyRequest.toJsonBodyUpdate()));
        setServiceUri(builder, taxonomyRequest.getUUID());
        setStandardHeader(builder);
        builder.setHeader(HEADER_METHOD_OVER,HEADER_PATCH);
        setAuth(builder);
        return builder.build();
    }

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

    protected void checkError(HttpResponse<String> response) throws Exception{
        if(true){
            System.out.println("checkError:"+ response.statusCode());
        }
        setStatus(response.statusCode());
        if(response.statusCode() <200 || response.statusCode() >= 300){
            throw new Exception("Error status code: "+status);
        }
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

    /**
     * Validataore del bean di richiesta
     */
    protected abstract void validateUUIDRequest() throws NotValideRequestException;

    /**
     * Metodo per la gestione dei risultati
     *
     * @param response
     * @param isList
     */
    protected abstract void setResult(HttpResponse<String> response, boolean isList);

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
