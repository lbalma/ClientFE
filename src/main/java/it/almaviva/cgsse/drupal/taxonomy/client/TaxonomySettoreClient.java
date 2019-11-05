package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomySettoreBOBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.drupal.jsonapi.DataObject;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreResponseBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreResponseBeanList;
import it.almaviva.cgsse.drupal.taxonomy.factory.TaxonomyFactory;
import it.almaviva.cgsse.utils.PropertiesManager;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static it.almaviva.cgsse.drupal.exception.NotValideRequestException.*;
import static it.almaviva.cgsse.drupal.taxonomy.utils.Costants.TAXONOMY_SETTORE;

public class TaxonomySettoreClient extends ATaxonomyClient<TaxonomySettoreRequestBean> {

    //All Kind ruturn
    private TaxonomySettoreResponseBeanList resListJsonapiObject;
    private TaxonomySettoreResponseBean resJsonapiObject;
    private List<TaxonomySettoreBOBean> resBOList;
    private TaxonomySettoreBOBean resBO;

    public TaxonomySettoreClient(TaxonomySettoreRequestBean taxonomyRequest){
        this.request = taxonomyRequest;
    }

    @Override
    protected String getEndpoint() {
        return TAXONOMY_SETTORE;
    }

    @Override
    protected void setResult(HttpResponse<String> response, boolean isList) throws IOException {
        if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_RESPONSE)){
            System.out.println("RESPONSE BODY: "+response.body());
        }

        if(isList){
            //Solo il metodo GetAll passa di qui
            this.resListJsonapiObject= TaxonomyFactory.createSettoreResponse_jsonapiFormatList(response.body());
            this.resBOList = TaxonomyFactory.createSettoreResponse_boFormatList(response.body());

            if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_ADAPTER)){
                System.out.println("TaxonomySettoreResponseBean: "+resListJsonapiObject.toString());
                for(DataObject dataObjt: resListJsonapiObject.getData()){
                    System.out.println("TaxonomySettoreResponseBean-Attributes: "+ dataObjt.getAttributes().toString());
                }
                System.out.println("TaxonomySettoreBOBean: "+resBOList.toString());
            }

        }else{
            this.resJsonapiObject = TaxonomyFactory.createSettoreResponse_jsonapiFormat(response.body());
            this.resBO = TaxonomyFactory.createSettoreResponse_boFormat(response.body());
            if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_ADAPTER)) {
                System.out.println("TaxonomySettoreResponseBean: " + resJsonapiObject.toString());
                System.out.println("TaxonomySettoreResponseBean-Attributes: " + resJsonapiObject.getdata().getAttributes().toString());
                System.out.println("TaxonomySettoreBOBean: " + resBO.toString());
            }
        }

    }

    @Override
    protected void validateTaxonomyRequest() throws NotValideRequestException{
        if(this.request == null){
            throw new NotValideRequestException(EXCEPTION_MESSAGE_REQUEST_NULL);
        }

        if(this.request.getName() == null || this.request.getName().trim().isEmpty()){
            throw new NotValideRequestException(EXCEPTION_MESSAGE_INPUT_NAME_NULL_OR_EMPTY);
        }
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

    public List<TaxonomySettoreBOBean> getResBOList() {
        return resBOList;
    }

    public TaxonomySettoreBOBean getResBO() {
        return resBO;
    }
}
