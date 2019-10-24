package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.drupal.common.client.ClientCommon;
import it.almaviva.cgsse.drupal.taxonomy.bean.ATaxonomy;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.utils.PropertiesManager;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe astratta per interfaccia con i servizi drupal di tassonomia
 */
public abstract class ATaxonomyClient<R extends ATaxonomy> extends ClientCommon {

    protected R taxonomyRequest;
    private int status;


    /**
     * Metodo che ritorna la lista di del contenuto della tassonomia
     *
     * @throws Exception
     */
    public void getAll() throws Exception{
        //INIT
        HttpRequest request =  createGetHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //CHECK
        checkHTTPResponceCod(response);
        //RESULT
        setResult(response, true);

    }

    /**
     * Metodo che torna un elemento specifico della tassonomia
     *
     * @throws Exception
     */
    public void get() throws Exception{
        //INIT
        HttpRequest request = createGetHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //CHECK
        checkHTTPResponceCod(response);
        //RESULT
        setResult(response, false);

    }

    /**
     * Metodo che torna un elemento specifico della tassonomia
     *
     * @throws Exception
     */
    public void getByFk() throws Exception{
        //INIT
        HttpRequest request = createGetByFkHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //CHECK
        checkHTTPResponceCod(response);
        //RESULT
        setResult(response, true);

    }


    /**
     * Metodo che inserisce un elemento nella tassonomia
     *
     * @throws Exception
     */
    public void post() throws Exception{
        //VALIDATE
        validateTaxonomyRequest();
        //INIT
        HttpRequest request = createPostHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //CHECK
        checkHTTPResponceCod(response);
        //RESULT
        setResult(response, false);

    }

    /**
     * Metodo che elimina un elemento nella tassonomia
     *
     * @throws Exception
     */
    public boolean del() throws Exception{
        //VALIDATE
        validateUUIDRequest();
        //INIT
        HttpRequest request = createDelHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //CHECK
        checkHTTPResponceCod(response);
        //RESULT
        return true;
    }

    /**
     * Metodo che aggiorna un elemento nella tassonomia
     *
     * @throws Exception
     */
    public void patch() throws Exception{
        //VALIDATE
        validateUUIDRequest();
        //INIT
        HttpRequest request = createPatchHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //CHECK
        checkHTTPResponceCod(response);
        //RESULT
        setResult(response, false);
    }

    /**
     * Url del servizio
     *
     * @return
     */
    private String getService() throws IOException {
        String FE_PROTOCOL = PropertiesManager.getInstance().getValue(PropertiesManager.FE_PROTOCOL);
        String FE_IP = PropertiesManager.getInstance().getValue(PropertiesManager.FE_IP);
        String FE_PORT = PropertiesManager.getInstance().getValue(PropertiesManager.FE_PORT);
        String FE_DOMAIN = PropertiesManager.getInstance().getValue(PropertiesManager.FE_DOMAIN);
        String FE_TAXONOMY_SERVICE = PropertiesManager.getInstance().getValue(PropertiesManager.FE_TAXONOMY_SERVICE);

        StringBuilder s = new StringBuilder();
        s.append(FE_PROTOCOL).append("://");
        s.append(FE_IP).append(":");
        s.append(FE_PORT).append("/");
        s.append(FE_DOMAIN).append("/");
        s.append(FE_TAXONOMY_SERVICE);

        return s.toString();
    }

    /**
     * Metodo per la creazione di una richiesta http GET
     * @return
     */
    private HttpRequest createGetHttpRequest() throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().GET();
        setServiceUri(builder, taxonomyRequest.getUUID());
        setStandardHeader(builder);
        return  builder.build();
    }

    /**
     * Metodo per la creazione di una richiesta http POST
     * @return
     */
    private HttpRequest createPostHttpRequest() throws IOException {
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
    private HttpRequest createDelHttpRequest() throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().DELETE();
        setServiceUri(builder, taxonomyRequest.getUUID());
        setStandardHeader(builder);
        setAuth(builder);
        return builder.build();
    }

    /**
     * Metodo per la creazione di una richiesta http GET
     * @return
     */
    private HttpRequest createGetByFkHttpRequest() throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().GET();
        setServiceUriFilterFk(builder, taxonomyRequest.getFk());
        setStandardHeader(builder);
        return  builder.build();
    }
    /**
     * Metodo per la creazione di una richiesta http PATCH
     * @return
     */
    private HttpRequest createPatchHttpRequest() throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(taxonomyRequest.toJsonBodyUpdate()));
        setServiceUri(builder, taxonomyRequest.getUUID());
        setStandardHeader(builder);
        builder.setHeader(HEADER_METHOD_OVER,HEADER_PATCH);
        setAuth(builder);
        return builder.build();
    }


    /**
     * Metodo per la configurazione del servizio e relativo enpoit di destinazione del client
     *
     * @param builder
     * @param params
     */
    private void setServiceUri(HttpRequest.Builder builder, String params) throws IOException {
        builder.uri(URI.create(getService()+"/"+getEndpoint() + (params != null && !params.isEmpty() ? "/"+params : "")));
    }

    /**
     * Metodo per la configurazione del servizio e relativo enpoit di destinazione del client
     *
     * @param builder
     */
    private void setServiceUriFilterFk(HttpRequest.Builder builder, String fk) throws IOException {
        String url = getService()+"/"+getEndpoint() + "?filter["+getEndpoint()+"-fk][path]=field_fk&filter["+getEndpoint()+"-fk][value]="+fk;
        System.out.println(url);
        builder.uri(URI.create(url));
    }

    protected void checkHTTPResponceCod(HttpResponse<String> response) throws Exception{
        if(true){
            System.out.println("checkHTTPResponceCod:"+ response.statusCode());
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

    /**
     * Metodo per toranre lo satatus della richiesta effettuata
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * Metodo privato per il settaggio dello status chiamata
     * @param status
     */
    private void setStatus(int status) {
        this.status = status;
    }
}
