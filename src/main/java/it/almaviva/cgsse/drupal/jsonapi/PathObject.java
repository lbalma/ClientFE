package it.almaviva.cgsse.drupal.jsonapi;

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
          return "PathObject{" +
                  "alias='" + alias + '\'' +
                  ", pid='" + pid + '\'' +
                  ", langcode='" + langcode + '\'' +
                  '}';
     }
}
