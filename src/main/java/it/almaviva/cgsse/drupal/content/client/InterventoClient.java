package it.almaviva.cgsse.drupal.content.client;

import it.almaviva.cgsse.drupal.content.bean.file.ContentFileResponseBean;
import it.almaviva.cgsse.drupal.content.bean.file.FileWorkableBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoRequestBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoResponseBean;
import it.almaviva.cgsse.drupal.content.bean.intervento.ContentInterventoResponseBeanList;
import it.almaviva.cgsse.drupal.content.bean.intervento.InterventoWorkableBean;
import it.almaviva.cgsse.drupal.content.factory.ContentFactory;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.drupal.jsonapi.DataForContentObject;
import it.almaviva.cgsse.utils.PropertiesManager;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static it.almaviva.cgsse.drupal.content.Costants.CONTENT_INTERVENTO;
import static it.almaviva.cgsse.drupal.exception.NotValideRequestException.EXCEPTION_MESSAGE_INPUT_UUID_NULL_OR_EMPTY;
import static it.almaviva.cgsse.drupal.exception.NotValideRequestException.EXCEPTION_MESSAGE_REQUEST_NULL;

public class InterventoClient extends AContentClient<ContentInterventoRequestBean> {

    //All Kind ruturn
    private ContentInterventoResponseBeanList resListJsonapiObject;
    private ContentInterventoResponseBean resJsonapiObject;
    private ContentFileResponseBean resFileJsonapiObject;

    private List<InterventoWorkableBean> resList;
    private InterventoWorkableBean res;
    private FileWorkableBean resFile;

    public InterventoClient(ContentInterventoRequestBean contentRequest){
        this.request = contentRequest;
    }

    @Override
    protected String getEndpoint() {
        return CONTENT_INTERVENTO;
    }

    @Override
    protected void validateContentRequest() throws NotValideRequestException {

    }

    @Override
    protected void validateUUIDRequest() throws NotValideRequestException {
        if(this.request == null){
            throw new NotValideRequestException(EXCEPTION_MESSAGE_REQUEST_NULL);
        }

        if(this.request.getUuid() == null || this.request.getUuid().trim().isEmpty()){
            throw new NotValideRequestException(EXCEPTION_MESSAGE_INPUT_UUID_NULL_OR_EMPTY);
        }
    }

    @Override
    protected void setResult(HttpResponse<String> response, boolean isList) throws IOException {
        if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_RESPONSE)){
            System.out.println("RESPONSE BODY: "+response.body());
        }

        if(isList){
            //Solo il metodo GetAll passa di qui
            this.resListJsonapiObject= ContentFactory.createInterventoResponse_jsonapiFormatList(response.body());
            this.resList = ContentFactory.createInterventoResponse_WarkableFormatList(response.body());

            if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_ADAPTER)){
                System.out.println("ContentInterventoResponseBean: "+resListJsonapiObject.toString());
                for(DataForContentObject dataObjt: resListJsonapiObject.getData()){
                    System.out.println("ContentInterventoResponseBean-Attributes: "+ dataObjt.getAttributes().toString());
                    System.out.println("ContentInterventoResponseBean-Relationship: "+ dataObjt.getRelationships().toString());
                }
                System.out.println("ContentInterventoBean: "+resList.toString());
            }

        }else{
            this.resJsonapiObject = ContentFactory.createInterventoResponse_jsonapiFormat(response.body());
            this.res = ContentFactory.createInterventoResponse_WarkableFormat(response.body());
            if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_ADAPTER)) {
                System.out.println("ContentInterventoResponseBean: " + resJsonapiObject.toString());
                System.out.println("ContentInterventoResponseBean-Attributes: " + resJsonapiObject.getdata().getAttributes().toString());
                System.out.println("ContentInterventoResponseBean-Relationship: " + resJsonapiObject.getdata().getRelationships().toString());
                System.out.println("ContentInterventoBean: " + res.toString());
            }
        }
    }


    @Override
    protected void setFileResult(HttpResponse<String> response) throws IOException {
        this.resFileJsonapiObject= ContentFactory.createFileResponse_jsonapiFormat(response.body());
        this.resFile = ContentFactory.createFileResponse_WarkableFormat(response.body());
        if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_ADAPTER)) {
            System.out.println("ContentFileResponseBean: " + resFileJsonapiObject.toString());
            System.out.println("ContentFileResponseBean-Attributes: " + resFileJsonapiObject.getdata().getAttributes().toString());
            System.out.println("FileWorkableBean: " + resFile.toString());
        }
    }

    public List<InterventoWorkableBean> getResList() {
        return resList;
    }

    public InterventoWorkableBean getRes() {
        return res;
    }

    public FileWorkableBean getResFile() {
        return resFile;
    }

}
