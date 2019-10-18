package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.drupal.taxonomy.bean.TaxonomyAziendaRequestBean;

public class TaxonomyAziendaClient extends ATaxonomyClient<TaxonomyAziendaRequestBean> {

    public TaxonomyAziendaClient(TaxonomyAziendaRequestBean taxonomyRequest){
        this.taxonomyRequest = taxonomyRequest;
    }

    @Override
    protected String getEndpoint() {
        return "azienda";
    }

    @Override
    protected void validateTaxonomyRequest() throws NotValideRequestException{
        if(this.taxonomyRequest == null){
            throw new NotValideRequestException("Input not valide");
        }

        if(this.taxonomyRequest.getName() == null || this.taxonomyRequest.getName().trim().isEmpty()){
            throw new NotValideRequestException("Input not valide");
        }
    }
}
