package it.almaviva.cgsse.drupal.taxonomy.client;

import it.almaviva.cgsse.drupal.common.client.ClientCommon;
import it.almaviva.cgsse.drupal.exception.NotValideRequestException;
import it.almaviva.cgsse.drupal.taxonomy.bean.ATaxonomy;
import it.almaviva.cgsse.utils.PropertiesManager;

import java.io.IOException;
import java.net.http.HttpResponse;

/**
 * Classe astratta per interfaccia con i servizi drupal di tassonomia
 */
public abstract class ATaxonomyClient<R extends ATaxonomy> extends ClientCommon<R> {



    @Override
    protected  void setTheResult(HttpResponse<String> response, boolean isList) throws IOException{
        setResult(response, isList);
    }

    @Override
    protected  void theValidateUUIDRequest() throws NotValideRequestException {
         validateUUIDRequest();
    }

    @Override
    protected  void theValidateRequest() throws NotValideRequestException {
        validateTaxonomyRequest();
    }

    @Override
    protected  String getTheEndpoint()
    {
        return getEndpoint();
    }

    @Override
    protected  String getContentService() throws IOException {
        return PropertiesManager.getInstance().getValue(PropertiesManager.FE_TAXONOMY_SERVICE);
    }

    /**
     * Endpoit del servizio
     *
     * @return
     */
    protected abstract String getEndpoint();

    /**
     * Validataore del bean di richiesta
     */
    protected abstract void validateTaxonomyRequest() throws NotValideRequestException;

    /**
     * Validataore del bean di richiesta
     */
    protected abstract void validateUUIDRequest() throws NotValideRequestException;

    /**
     * Metodo per la gestione dei risultati
     *
     * @param response
     * @param isList
     */
    protected abstract void setResult(HttpResponse<String> response, boolean isList) throws IOException;

    /**
     * Metodo per toranre lo satatus della richiesta effettuata
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * Metodo privato per il settaggio dello status chiamata
     * @param status
     */
    @Override
    protected void setStatus(int status) {
        this.status = status;
    }
}
