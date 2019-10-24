package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomyRilevanzaBOBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.drupal.jsonapi.DataObject;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaResponseAttributes;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaResponseBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.rilevanza.TaxonomyRilevanzaResponseBeanList;
import it.almaviva.cgsse.drupal.taxonomy.factory.TaxonomyFactory;

import java.net.http.HttpResponse;
import java.util.List;

import static it.almaviva.cgsse.drupal.exception.NotValideRequestException.*;
import static it.almaviva.cgsse.drupal.taxonomy.Costants.TAXONOMY_RILEVANZA;

public class TaxonomyRilevanzaClient extends ATaxonomyClient<TaxonomyRilevanzaRequestBean> {

    //All Kind ruturn
    private TaxonomyRilevanzaResponseBeanList resListJsonapiObject;
    private TaxonomyRilevanzaResponseBean resJsonapiObject;
    private List<TaxonomyRilevanzaBOBean> resBOList;
    private TaxonomyRilevanzaBOBean resBO;

    public TaxonomyRilevanzaClient(TaxonomyRilevanzaRequestBean taxonomyRequest){
        this.taxonomyRequest = taxonomyRequest;
    }

    @Override
    protected String getEndpoint() {
        return TAXONOMY_RILEVANZA;
    }

    @Override
    protected void setResult(HttpResponse<String> response, boolean isList) {
        if(true){
            System.out.println("RESPONSE BODY: "+response.body());
        }

        if(isList){
            //Solo il metodo GetAll passa di qui
            this.resListJsonapiObject= TaxonomyFactory.createRilevanzaResponse_jsonapiFormatList(response.body());
            this.resBOList = TaxonomyFactory.createRilevanzaResponse_boFormatList(response.body());

            if(true){
                System.out.println("TaxonomyRilevanzaResponseBean: "+resListJsonapiObject.toString());
                for(DataObject dataObjt: resListJsonapiObject.getData()){
                    System.out.println("TaxonomyRilevanzaResponseBean-Attributes: "+((TaxonomyRilevanzaResponseAttributes) dataObjt.getAttributes()).toString());
                }
                System.out.println("TaxonomyRilevanzaBOBean: "+resBOList.toString());
            }

        }else{
            this.resJsonapiObject = TaxonomyFactory.createRilevanzaResponse_jsonapiFormat(response.body());
            this.resBO = TaxonomyFactory.createRilevanzaResponse_boFormat(response.body());
            if(true) {
                System.out.println("TaxonomyRilevanzaResponseBean: " + resJsonapiObject.toString());
                System.out.println("TaxonomyRilevanzaResponseBean-Attributes: " + ((TaxonomyRilevanzaResponseAttributes) resJsonapiObject.getdata().getAttributes()).toString());
                System.out.println("TaxonomyRilevanzaBOBean: " + resBO.toString());
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

    public List<TaxonomyRilevanzaBOBean> getResBOList() {
        return resBOList;
    }

    public TaxonomyRilevanzaBOBean getResBO() {
        return resBO;
    }
}
