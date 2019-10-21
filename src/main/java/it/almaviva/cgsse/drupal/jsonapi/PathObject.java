package it.almaviva.cgsse.drupal.jsonapi;

/**
 * Classe per conversione jsonapi to object, della struttura PathObject
 */
public class PathObject {

     private String alias;
     private String pid;
     private String langcode;

     public String getAlias() {
          return alias;
     }

     public void setAlias(String alias) {
          this.alias = alias;
     }

     public String getPid() {
          return pid;
     }

     public void setPid(String pid) {
          this.pid = pid;
     }

     public String getLangcode() {
          return langcode;
     }

     public void setLangcode(String langcode) {
          this.langcode = langcode;
     }

     @Override
     public String toString() {
          StringBuilder s = new StringBuilder(PathObject.class.getName())
               .append("{" )
                  .append("alias='" ).append(alias ).append('\'' )
                  .append(", pid='" ).append( pid ).append( '\'' )
                  .append(", langcode='" ).append( langcode ).append( '\'' )
                  .append('}');
          return s.toString();
     }
}
