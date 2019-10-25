package it.almaviva.cgsse.drupal.common.client;

import it.almaviva.cgsse.drupal.common.bean.AJsonapiRequestBean;
import it.almaviva.cgsse.drupal.common.utils.ClientCostant;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.utils.AES;
import it.almaviva.cgsse.utils.PropertiesManager;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public abstract class ClientCommon<X extends AJsonapiRequestBean>  extends ClientCostant{

    protected int status;
    protected X request;


    //Client unico
    protected static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();



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
        setTheResult(response, true);

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
        setTheResult(response, false);

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
        setTheResult(response, true);

    }


    /**
     * Metodo che inserisce un elemento nella tassonomia
     *
     * @throws Exception
     */
    public void post() throws Exception{
        //VALIDATE
        theValidateTaxonomyRequest();
        //INIT
        HttpRequest request = createPostHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //CHECK
        checkHTTPResponceCod(response);
        //RESULT
        setTheResult(response, false);

    }


    /**
     * Metodo che elimina un elemento nella tassonomia
     *
     * @throws Exception
     */
    public boolean del() throws Exception{
        //VALIDATE
        theValidateUUIDRequest();
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
        theValidateUUIDRequest();
        //INIT
        HttpRequest request = createPatchHttpRequest();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //CHECK
        checkHTTPResponceCod(response);
        //RESULT
        setTheResult(response, false);
    }




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


    /**
     * Metodo per la configurazione del servizio e relativo enpoit di destinazione del client
     *
     * @param builder
     * @param params
     */
    private void setServiceUri(HttpRequest.Builder builder, String params) throws IOException {
        String url = getService()+"/"+getTheEndpoint() + (params != null && !params.isEmpty() ? "/"+params : "");
        System.out.println(url);
        builder.uri(URI.create(url));
    }

    /**
     * Metodo per la configurazione del servizio e relativo enpoit di destinazione del client
     *
     * @param builder
     */
    private void setServiceUriFilterFk(HttpRequest.Builder builder, String fk) throws IOException {
        String url = getService()+"/"+getTheEndpoint() + "?filter["+getTheEndpoint()+"-fk][path]=field_fk&filter["+getTheEndpoint()+"-fk][value]="+fk;
        System.out.println(url);
        builder.uri(URI.create(url));
    }

    protected void checkHTTPResponceCod(HttpResponse<String> response) throws Exception{
        if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_RESPONSE)){
            System.out.println("checkError:"+ response.statusCode());
        }
        setStatus(response.statusCode());
        if(response.statusCode() <200 || response.statusCode() >= 300){
            throw new Exception("Error status code: "+status);
        }
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
        String FE_CONTENT_SERVICE = getContentService();

        StringBuilder s = new StringBuilder();
        s.append(FE_PROTOCOL).append("://");
        s.append(FE_IP).append(":");
        s.append(FE_PORT).append("/");
        s.append(FE_DOMAIN).append("/");
        s.append(FE_CONTENT_SERVICE);

        return s.toString();
    }


    /**
     * Metodo per la creazione di una richiesta http GET
     * @return
     */
    protected HttpRequest createGetHttpRequest() throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().GET();
        setServiceUri(builder, request.getTheUUID());
        setStandardHeader(builder);
        return  builder.build();
    }

    /**
     * Metodo per la creazione di una richiesta http GET
     * @return
     */
    protected HttpRequest createGetByFkHttpRequest() throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().GET();
        setServiceUriFilterFk(builder, request.getTheFk());
        setStandardHeader(builder);
        return  builder.build();
    }

    /**
     * Metodo per la creazione di una richiesta http POST
     * @return
     */
    protected HttpRequest createPostHttpRequest() throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(request.toJsonBodyInsert()));
        setServiceUri(builder, request.getTheUUID());
        setStandardHeader(builder);
        setAuth(builder);
        return builder.build();
    }

    /**
     * Metodo per la creazione di una richiesta upload file http POST
     * @return
     */
    protected HttpRequest createPostFileHttpRequest(String endpoint) throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(request.toJsonBodyInsert()));
        setServiceUri(builder, endpoint);
        setFileHeader(builder);
        setAuth(builder);
        return builder.build();
    }

    /**
     * Metodo per la creazione di una richiesta http DELETE
     * @return
     */
    protected HttpRequest createDelHttpRequest() throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().DELETE();
        setServiceUri(builder, request.getTheUUID());
        setStandardHeader(builder);
        setAuth(builder);
        return builder.build();
    }


    /**
     * Metodo per la creazione di una richiesta http PATCH
     * @return
     */
    protected HttpRequest createPatchHttpRequest() throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(request.toJsonBodyUpdate()));
        setServiceUri(builder, request.getTheUUID());
        setStandardHeader(builder);
        builder.setHeader(HEADER_METHOD_OVER,HEADER_PATCH);
        setAuth(builder);
        return builder.build();
    }

    /**
     * @param i
     */
    protected abstract void setStatus(int i);


    protected abstract String getEndpoint();
    
    protected abstract void theValidateUUIDRequest() throws NotValideRequestException;
    protected abstract void setTheResult(HttpResponse<String> response, boolean b) throws IOException;
    protected abstract void theValidateTaxonomyRequest() throws NotValideRequestException;
    /**
     * Endpoit del servizio
     *
     * @return
     */
    protected abstract String getTheEndpoint();

    /**
     * Endpoit del servizio
     *
     * @return
     */
    protected abstract String getContentService() throws IOException;
}
