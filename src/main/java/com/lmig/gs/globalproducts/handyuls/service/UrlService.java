package com.lmig.gs.globalproducts.handyuls.service;

import com.lmig.gs.globalproducts.handyuls.model.Url;

import java.util.List;

public interface UrlService {
    Url saveUrl(String nnumber, Url url);

    Url editUrl(Long id, String nnumber, Url url);

    Url getUrl(Long id, String nnumber);

    boolean deleteUrl(Long id, String nnumber);

    List<Url> getUrls(String nnumber);


}
