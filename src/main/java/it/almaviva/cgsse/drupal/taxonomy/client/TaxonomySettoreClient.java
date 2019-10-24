package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.bo.bean.taxonomy.TaxonomySettoreBOBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.drupal.jsonapi.DataObject;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreRequestBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreResponseAttributes;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreResponseBean;
import it.almaviva.cgsse.drupal.taxonomy.bean.settore.TaxonomySettoreResponseBeanList;
import it.almaviva.cgsse.drupal.taxonomy.factory.TaxonomyFactory;

import java.net.http.HttpResponse;
import java.util.List;

import static it.almaviva.cgsse.drupal.exception.NotValideRequestException.*;
import static it.almaviva.cgsse.drupal.taxonomy.Costants.TAXONOMY_SETTORE;

public class TaxonomySettoreClient extends ATaxonomyClient<TaxonomySettoreRequestBean> {

    //All Kind ruturn
    private TaxonomySettoreResponseBeanList resListJsonapiObject;
    private TaxonomySettoreResponseBean resJsonapiObject;
    private List<TaxonomySettoreBOBean> resBOList;
    private TaxonomySettoreBOBean resBO;

    public TaxonomySettoreClient(TaxonomySettoreRequestBean taxonomyRequest){
        this.taxonomyRequest = taxonomyRequest;
    }

    @Override
    protected String getEndpoint() {
        return TAXONOMY_SETTORE;
    }

    @Override
    protected void setResult(HttpResponse<String> response, boolean isList) {
        if(true){
            System.out.println("RESPONSE BODY: "+response.body());
        }

        if(isList){
            //Solo il metodo GetAll passa di qui
            this.resListJsonapiObject= TaxonomyFactory.createSettoreResponse_jsonapiFormatList(response.body());
            this.resBOList = TaxonomyFactory.createSettoreResponse_boFormatList(response.body());

            if(true){
                System.out.println("TaxonomySettoreResponseBean: "+resListJsonapiObject.toString());
                for(DataObject dataObjt: resListJsonapiObject.getData()){
                    System.out.println("TaxonomySettoreResponseBean-Attributes: "+((TaxonomySettoreResponseAttributes) dataObjt.getAttributes()).toString());
                }
                System.out.println("TaxonomySettoreBOBean: "+resBOList.toString());
            }

        }else{
            this.resJsonapiObject = TaxonomyFactory.createSettoreResponse_jsonapiFormat(response.body());
            this.resBO = TaxonomyFactory.createSettoreResponse_boFormat(response.body());
            if(true) {
                System.out.println("TaxonomySettoreResponseBean: " + resJsonapiObject.toString());
                System.out.println("TaxonomySettoreResponseBean-Attributes: " + ((TaxonomySettoreResponseAttributes) resJsonapiObject.getdata().getAttributes()).toString());
                System.out.println("TaxonomySettoreBOBean: " + resBO.toString());
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

    public List<TaxonomySettoreBOBean> getResBOList() {
        return resBOList;
    }

    public TaxonomySettoreBOBean getResBO() {
        return resBO;
    }
}
