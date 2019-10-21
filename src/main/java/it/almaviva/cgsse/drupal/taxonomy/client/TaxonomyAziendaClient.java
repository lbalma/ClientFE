package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.bo.bean.TaxonomyAziendaBOBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.drupal.jsonapi.DataObject;
import it.almaviva.cgsse.drupal.taxonomy.bean.TaxonomyAziendaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.TaxonomyAziendaResponseAttributes;
import it.almaviva.cgsse.drupal.taxonomy.bean.TaxonomyAziendaResponseBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.TaxonomyAziendaResponseBeanList;
import it.almaviva.cgsse.drupal.taxonomy.factory.TaxonomyFactory;

import java.net.http.HttpResponse;
import java.util.List;

import static it.almaviva.cgsse.drupal.taxonomy.Costants.*;
import static it.almaviva.cgsse.drupal.exception.NotValideRequestException.*;

public class TaxonomyAziendaClient extends ATaxonomyClient<TaxonomyAziendaRequestBean> {

    //All Kind ruturn
    private TaxonomyAziendaResponseBeanList resListJsonapiObject;
    private TaxonomyAziendaResponseBean resJsonapiObject;
    private List<TaxonomyAziendaBOBean> resBOList;
    private TaxonomyAziendaBOBean resBO;

    public TaxonomyAziendaClient(TaxonomyAziendaRequestBean taxonomyRequest){
        this.taxonomyRequest = taxonomyRequest;
    }

    @Override
    protected String getEndpoint() {
        return TAXONOMY_AZIENDA;
    }

    @Override
    protected void setResult(HttpResponse<String> response, boolean isList) {
        if(true){
            System.out.println("RESPONSE BODY: "+response.body());
        }

        if(isList){
            //Solo il metodo GetAll passa di qui
            this.resListJsonapiObject= TaxonomyFactory.createAziendaResponse_jsonapiFormatList(response.body());
            this.resBOList = TaxonomyFactory.createAziendaResponse_boFormatList(response.body());

            if(true){
                System.out.println("TaxonomyAziendaResponseBean: "+resListJsonapiObject.toString());
                for(DataObject dataObjt: resListJsonapiObject.getData()){
                    System.out.println("TaxonomyAziendaResponseBean-Attributes: "+((TaxonomyAziendaResponseAttributes) dataObjt.getAttributes()).toString());
                }
                System.out.println("TaxonomyAziendaBOBean: "+resBOList.toString());
            }

        }else{
            this.resJsonapiObject = TaxonomyFactory.createAziendaResponse_jsonapiFormat(response.body());
            this.resBO = TaxonomyFactory.createAziendaResponse_boFormat(response.body());
            if(true) {
                System.out.println("TaxonomyAziendaResponseBean: " + resJsonapiObject.toString());
                System.out.println("TaxonomyAziendaResponseBean-Attributes: " + ((TaxonomyAziendaResponseAttributes) resJsonapiObject.getdata().getAttributes()).toString());
                System.out.println("TaxonomyAziendaBOBean: " + resBO.toString());
            }
        }

    }

    @Override
    protected void validateTaxonomyRequest() throws NotValideRequestException{
        if(this.taxonomyRequest == null){
            throw new NotValideRequestException(EXCEPTION_MESSAGE_REQUEST_NULL);
        }

        if(this.taxonomyRequest.getName() == null || this.taxonomyRequest.getName().trim().isEmpty()){
            throw new NotValideRequestException(EXCEPTION_MESSAGE_INPUT_NAME_NULL_OR_EMPTY);
        }
    }

    @Override
    protected void validateUUIDRequest() throws NotValideRequestException {
        if(this.taxonomyRequest == null){
            throw new NotValideRequestException(EXCEPTION_MESSAGE_REQUEST_NULL);
        }

        if(this.taxonomyRequest.getUUID() == null || this.taxonomyRequest.getUUID().trim().isEmpty()){
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
