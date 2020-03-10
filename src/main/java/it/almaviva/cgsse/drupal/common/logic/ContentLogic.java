package it.almaviva.cgsse.drupal.common.logic;

import it.almaviva.cgsse.bo.bean.BOBean;
import it.almaviva.cgsse.drupal.content.bean.AContent;

import java.util.List;

public abstract class ContentLogic <A extends AContent, B extends BOBean> extends Logic{

    abstract public List<B> execGetAll();

    abstract public List<B> execGetByFK(String fk) throws Exception;

    abstract public Boolean execEdit(A req);

    abstract public Boolean execInsert(A req);

    abstract public Boolean execDeleteByFK(String fk);
}
