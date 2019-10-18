package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.drupal.bean.ATaxonomyRequest;
import it.almaviva.cgsse.drupal.bean.TaxonomyAziendaBean;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;

public class TaxonomyAziendaClient extends ATaxonomyClient<TaxonomyAziendaBean> {

    public TaxonomyAziendaClient(TaxonomyAziendaBean taxonomyRequest){
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
