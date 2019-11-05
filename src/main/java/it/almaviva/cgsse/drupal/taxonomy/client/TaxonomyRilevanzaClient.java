package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyRilevanzaBOBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.drupal.jsonapi.DataObject;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaResponseBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaResponseBeanList;
import it.almaviva.cgsse.drupal.taxonomy.factory.TaxonomyFactory;
import it.almaviva.cgsse.utils.PropertiesManager;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static it.almaviva.cgsse.drupal.exception.NotValideRequestException.*;
import static it.almaviva.cgsse.drupal.taxonomy.utils.Costants.TAXONOMY_RILEVANZA;

public class TaxonomyRilevanzaClient extends ATaxonomyClient<TaxonomyRilevanzaRequestBean> {

    //All Kind ruturn
    private TaxonomyRilevanzaResponseBeanList resListJsonapiObject;
    private TaxonomyRilevanzaResponseBean resJsonapiObject;
    private List<TaxonomyRilevanzaBOBean> resBOList;
    private TaxonomyRilevanzaBOBean resBO;

    public TaxonomyRilevanzaClient(TaxonomyRilevanzaRequestBean taxonomyRequest){
        this.request = taxonomyRequest;
    }

    @Override
    protected String getEndpoint() {
        return TAXONOMY_RILEVANZA;
    }

    @Override
    protected void setResult(HttpResponse<String> response, boolean isList) throws IOException {
        if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_RESPONSE)){
            System.out.println("RESPONSE BODY: "+response.body());
        }

        if(isList){
            //Solo il metodo GetAll passa di qui
            this.resListJsonapiObject= TaxonomyFactory.createRilevanzaResponse_jsonapiFormatList(response.body());
            this.resBOList = TaxonomyFactory.createRilevanzaResponse_boFormatList(response.body());

            if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_ADAPTER)){
                System.out.println("TaxonomyRilevanzaResponseBean: "+resListJsonapiObject.toString());
                for(DataObject dataObjt: resListJsonapiObject.getData()){
                    System.out.println("TaxonomyRilevanzaResponseBean-Attributes: "+ dataObjt.getAttributes().toString());
                }
                System.out.println("TaxonomyRilevanzaBOBean: "+resBOList.toString());
            }

        }else{
            this.resJsonapiObject = TaxonomyFactory.createRilevanzaResponse_jsonapiFormat(response.body());
            this.resBO = TaxonomyFactory.createRilevanzaResponse_boFormat(response.body());
            if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_ADAPTER)) {
                System.out.println("TaxonomyRilevanzaResponseBean: " + resJsonapiObject.toString());
                System.out.println("TaxonomyRilevanzaResponseBean-Attributes: " + resJsonapiObject.getdata().getAttributes().toString());
                System.out.println("TaxonomyRilevanzaBOBean: " + resBO.toString());
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

    public List<TaxonomyRilevanzaBOBean> getResBOList() {
        return resBOList;
    }

    public TaxonomyRilevanzaBOBean getResBO() {
        return resBO;
    }
}
