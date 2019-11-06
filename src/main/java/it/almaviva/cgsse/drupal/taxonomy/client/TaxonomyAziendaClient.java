package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyAziendaBOBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.drupal.jsonapi.DataObject;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaResponseBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.azienda.TaxonomyAziendaResponseBeanList;
import it.almaviva.cgsse.drupal.taxonomy.factory.TaxonomyFactory;
import it.almaviva.cgsse.utils.PropertiesManager;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static it.almaviva.cgsse.drupal.exception.NotValideRequestException.*;
import static it.almaviva.cgsse.drupal.taxonomy.utils.Costants.TAXONOMY_AZIENDA;

public class TaxonomyAziendaClient extends ATaxonomyClient<TaxonomyAziendaRequestBean> {

    //All Kind ruturn
    private TaxonomyAziendaResponseBeanList resListJsonapiObject;
    private TaxonomyAziendaResponseBean resJsonapiObject;
    private List<TaxonomyAziendaBOBean> resBOList;
    private TaxonomyAziendaBOBean resBO;

    public TaxonomyAziendaClient(TaxonomyAziendaRequestBean taxonomyRequest){
        this.request = taxonomyRequest;
    }

    @Override
    protected String getEndpoint() {
        return TAXONOMY_AZIENDA;
    }

    @Override
    protected void setResult(HttpResponse<String> response, boolean isList) throws IOException {
        if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_RESPONSE)){
            System.out.println("RESPONSE BODY: "+response.body());
        }

        if(isList){
            //Solo il metodo GetAll passa di qui
            this.resListJsonapiObject= TaxonomyFactory.createAziendaResponse_jsonapiFormatList(response.body());
            this.resBOList = TaxonomyFactory.createAziendaResponse_boFormatList(response.body());

            if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_ADAPTER)){
                System.out.println("TaxonomyAziendaResponseBean: "+resListJsonapiObject.toString());
                for(DataObject dataObjt: resListJsonapiObject.getData()){
                    System.out.println("TaxonomyAziendaResponseBean-Attributes: "+ dataObjt.getAttributes().toString());
                }
                System.out.println("TaxonomyAziendaBOBean: "+resBOList.toString());
            }

        }else{
            this.resJsonapiObject = TaxonomyFactory.createAziendaResponse_jsonapiFormat(response.body());
            this.resBO = TaxonomyFactory.createAziendaResponse_boFormat(response.body());
            if(PropertiesManager.getInstance().getBooleanValue(PropertiesManager.LOGGER_ADAPTER)) {
                System.out.println("TaxonomyAziendaResponseBean: " + resJsonapiObject.toString());
                System.out.println("TaxonomyAziendaResponseBean-Attributes: " + resJsonapiObject.getdata().getAttributes().toString());
                System.out.println("TaxonomyAziendaBOBean: " + resBO.toString());
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

    public List<TaxonomyAziendaBOBean> getResBOList() {
        return resBOList;
    }

    public TaxonomyAziendaBOBean getResBO() {
        return resBO;
    }
}
