package it.almaviva.cgsse.drupal.content.client;

import it.almaviva.cgsse.drupal.common.bean.AJsonapiRequestBean;
import it.almaviva.cgsse.drupal.common.client.ClientCommon;
import it.almaviva.cgsse.drupal.content.bean.AContent;
import it.almaviva.cgsse.drupal.content.bean.GenericFile;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.utils.PropertiesManager;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * Classe astratta per interfaccia con i servizi drupal di tassonomia
 */
public abstract class AContentClient<R extends AContent> extends ClientCommon<R>  {

    /**
     * Metodo che inserisce un file
     *
     * @throws Exception
     */
    public void postFile(String field) throws Exception{
        //VALIDATE
        validateContentRequest();
        //INIT
        HttpRequest request = createPostFileHttpRequest(field);
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //CHECK
        checkHTTPResponseCode(response);
        //RESULT
        setFileResult(response);
    }



    /**
     * Metodo che aggiorna l'entita con un fle
     *
     * @throws Exception
     */
    public void patchUpdateContentFile(String field, GenericFile gf) throws Exception{
        //VALIDATE
        validateContentRequest();
        //INIT
        HttpRequest request = creatPatchFileHttpRequest(field, gf);
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //CHECK
        checkHTTPResponseCode(response);
    }

    /**
     * Metodo che aggiorna l'entita con un fle
     *
     * @throws Exception
     */
    public void patchUpdateContentRelationship(String field, AJsonapiRequestBean req) throws Exception{
        //VALIDATE
        validateContentRequest();
        //INIT
        HttpRequest request = creatPatchRelationshipHttpRequest(field, req);
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //CHECK
        checkHTTPResponseCode(response);
    }

    /**
     * Metodo che aggiorna l'entita con un fle
     *
     * @throws Exception
     */
    public void patchUpdateContentRelationshipList(String field, List<AJsonapiRequestBean> req) throws Exception{
        //VALIDATE
        validateContentRequest();
        //INIT
        HttpRequest request = creatPatchRelationshipHttpRequestList(field, req);
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //CHECK
        checkHTTPResponseCode(response);
    }

    /**
     * Metodo per la creazione di una richiesta upload file http PATCH
     * @return
     */
    protected HttpRequest creatPatchFileHttpRequest(String field, GenericFile gf) throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(gf.toJsonBody()));
        setServiceUriFileFieldPatch(builder, field);
        setStandardHeader(builder);
        builder.setHeader(HEADER_METHOD_OVER,HEADER_PATCH);

        setAuth(builder);
        return builder.build();
    }

    /**
     * Metodo per la creazione di una richiesta upload file http PATCH
     * @return
     */
    protected HttpRequest creatPatchRelationshipHttpRequest(String field, AJsonapiRequestBean req) throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(req.toJsonBodyInject()));
        setServiceUriFileFieldPatch(builder, field);
        setStandardHeader(builder);
        builder.setHeader(HEADER_METHOD_OVER,HEADER_PATCH);

        setAuth(builder);
        return builder.build();
    }

    /**
     * Metodo per la creazione di una richiesta upload file http PATCH
     * @return
     */
    protected HttpRequest creatPatchRelationshipHttpRequestList(String field, List<AJsonapiRequestBean>  req) throws IOException {
        String body = ClientUtils.getBodyJsonToRequestBeanList(req);
        System.out.println(body);
        HttpRequest.Builder builder = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(body));
        setServiceUriFileFieldPatch(builder, field);
        setStandardHeader(builder);
        builder.setHeader(HEADER_METHOD_OVER,HEADER_PATCH);

        setAuth(builder);
        return builder.build();
    }

    /**
     * Metodo per la creazione di una richiesta upload file http POST
     * @return
     */
    protected HttpRequest createPostFileHttpRequest(String field) throws IOException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofByteArray(request.getBinaryFile()));
        setServiceUriFileField(builder, field);
        setFileHeader(builder, request.getFileName());

        setAuth(builder);
        return builder.build();
    }

    /**
     * Metodo per la configurazione del servizio e relativo enpoit di destinazione del client
     *
     * @param builder
     * @param field
     */
    private void setServiceUriFileField(HttpRequest.Builder builder, String field) throws IOException {
        String url = getService()+"/"+getTheEndpoint() + "/" + field;
        System.out.println(url);
        builder.uri(URI.create(url));
    }

    /**
     * Metodo per la configurazione del servizio e relativo enpoit di destinazione del client
     *
     * @param builder
     * @param field
     */
    private void setServiceUriFileFieldPatch(HttpRequest.Builder builder, String field) throws IOException {
        String url = getService()+"/"+getTheEndpoint() + "/" + request.getUuid() + "/relationships/"+field;
        System.out.println(url);
        builder.uri(URI.create(url));
    }

    /**
     * Metodo per aggiungere il tipi contunuto a accettati nell header per a comunicazione con le jsonapi di drupal
     *
     * @param builder
     */
    protected void setFileHeader(HttpRequest.Builder builder, String fileName){
        builder.setHeader(HEADER_ACCEPT, HEADER_DRUPAL_JSONAPI);
        builder.setHeader(HEADER_CONTENT_TYPE, HEADER_DRUPAL_JSONAPI_CONTENT_TYPE_BINARY);
        builder.setHeader(HEADER_CONTENT_DISPOSITION, "file,filename=\""+fileName+"\"");
    }

    /**
     * Metodo Bridge
     *
     * @param response
     * @param isList
     * @throws IOException
     */
    @Override
    protected  void setTheResult(HttpResponse<String> response, boolean isList) throws IOException{
        setResult(response, isList);
    }

    /**
     *  Metodo Bridge
     *
     * @throws NotValideRequestException
     */
    @Override
    protected  void theValidateUUIDRequest() throws NotValideRequestException {
        validateUUIDRequest();
    }

    /**
     *  Metodo Bridge
     *
     * @throws NotValideRequestException
     */
    @Override
    protected  void theValidateRequest() throws NotValideRequestException {
        validateContentRequest();
    }

    /**
     *  Metodo Bridge
     *
     * @return
     */
    @Override
    protected  String getTheEndpoint()
    {
        return getEndpoint();
    }

    @Override
    protected  String getContentService() throws IOException {
        return  PropertiesManager.getInstance().getValue(PropertiesManager.FE_CONTENT_SERVICE);
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
    protected abstract void validateContentRequest() throws NotValideRequestException;

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
    protected abstract void setResult(HttpResponse<String> response, boolean isList) throws IOException;

    protected void setFileResult(HttpResponse<String> response) throws IOException {

    }

    /**
     * Metodo per toranre lo satatus della richiesta effettuata
     * @return
     */
    public int getStatus() {
        return status;
    }


    @Override
    protected void setStatus(int status) {
        this.status = status;
    }

}
