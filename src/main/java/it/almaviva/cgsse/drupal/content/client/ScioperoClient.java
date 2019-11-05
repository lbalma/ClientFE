package it.almaviva.cgsse.drupal.content.client;

import it.almaviva.cgsse.drupal.content.bean.sciopero.*;
import it.almaviva.cgsse.drupal.content.factory.ContentFactory;
import it.almaviva.cgsse.drupal.content.bean.sciopero.ScioperoWorkableBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.drupal.jsonapi.DataForContentObject;
import it.almaviva.cgsse.utils.PropertiesManager;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static it.almaviva.cgsse.drupal.content.utils.Costants.CONTENT_SCIOPERO;
import static it.almaviva.cgsse.drupal.exception.NotValideRequestException.EXCEPTION_MESSAGE_INPUT_UUID_NULL_OR_EMPTY;
import static it.almaviva.cgsse.drupal.exception.NotValideRequestException.EXCEPTION_MESSAGE_REQUEST_NULL;

public class ScioperoClient extends AContentClient<ContentScioperoRequestBean> {

    //All Kind ruturn
    private ContentScioperoResponseBeanList resListJsonapiObject;
    private ContentScioperoResponseBean resJsonapiObject;
    private List<ScioperoWorkableBean>resList;
    private ScioperoWorkableBean res;

    public ScioperoClient(ContentScioperoRequestBean contentRequest){
        this.request = contentRequest;
    }

    @Override
    protected String getEndpoint() {
        return CONTENT_SCIOPERO;
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
            this.resListJsonapiObject= ContentFactory.createScioperoResponse_jsonapiFormatList(response.body());
            this.resList = ContentFactory.createScioperoResponse_WarkableFormatList(response.body());

            if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_ADAPTER)){
                System.out.println("ContentScioperoResponseBean: "+resListJsonapiObject.toString());
                for(DataForContentObject dataObjt: resListJsonapiObject.getData()){
                    System.out.println("ContentScioperiResponseAttributes-Attributes: "+ dataObjt.getAttributes().toString());
                    System.out.println("ContentScioperiResponseRelationships-Relationship: "+ dataObjt.getRelationships().toString());
                }
                System.out.println("ContentScioperoBean: "+resList.toString());
            }

        }else{
            this.resJsonapiObject = ContentFactory.createScioperoResponse_jsonapiFormat(response.body());
            this.res = ContentFactory.createScioperoResponse_WarkableFormat(response.body());
            if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_ADAPTER)) {
                System.out.println("ContentScioperoResponseBean: " + resJsonapiObject.toString());
                System.out.println("ContentScioperiResponseAttributes-Attributes: " + resJsonapiObject.getdata().getAttributes().toString());
                System.out.println("ContentScioperiResponseRelationships-Relationship: " + resJsonapiObject.getdata().getRelationships().toString());
                System.out.println("ContentScioperoBean: " + res.toString());
            }
        }
    }

    public List<ScioperoWorkableBean> getResList() {
        return resList;
    }

    public ScioperoWorkableBean getRes() {
        return res;
    }
}
