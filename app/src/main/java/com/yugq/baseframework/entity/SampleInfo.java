package com.yugq.baseframework.entity;

import java.util.List;

/**
 * 实体类:使用快速gsonformat生成
 * @author : yugq
 * @date ${date}
 */
public class SampleInfo {

    /**
     * name : BeJson
     * url : http://www.bejson.com
     * page : 88
     * isNonProfit : true
     * address : {"street":"科技园路.","city":"江苏苏州","country":"中国"}
     * links : [{"name":"Google","url":"http://www.google.com"},{"name":"Baidu","url":"http://www.baidu.com"},{"name":"SoSo","url":"http://www.SoSo.com"}]
     */

    private String name;
    private String url;
    private int page;
    private boolean isNonProfit;
    /**
     * street : 科技园路.
     * city : 江苏苏州
     * country : 中国
     */

    private AddressEntity address;
    /**
     * name : Google
     * url : http://www.google.com
     */

    private List<LinksEntity> links;

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public String getUrl() { return url;}

    public void setUrl(String url) { this.url = url;}

    public int getPage() { return page;}

    public void setPage(int page) { this.page = page;}

    public boolean isIsNonProfit() { return isNonProfit;}

    public void setIsNonProfit(boolean isNonProfit) { this.isNonProfit = isNonProfit;}

    public AddressEntity getAddress() { return address;}

    public void setAddress(AddressEntity address) { this.address = address;}

    public List<LinksEntity> getLinks() { return links;}

    public void setLinks(List<LinksEntity> links) { this.links = links;}

    public static class AddressEntity {
        private String street;
        private String city;
        private String country;

        public String getStreet() { return street;}

        public void setStreet(String street) { this.street = street;}

        public String getCity() { return city;}

        public void setCity(String city) { this.city = city;}

        public String getCountry() { return country;}

        public void setCountry(String country) { this.country = country;}
    }

    public static class LinksEntity {
        private String name;
        private String url;

        public String getName() { return name;}

        public void setName(String name) { this.name = name;}

        public String getUrl() { return url;}

        public void setUrl(String url) { this.url = url;}
    }
}
