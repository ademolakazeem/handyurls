package com.lmig.gs.globalproducts.handyuls.service;

import com.lmig.gs.globalproducts.handyuls.model.Url;
import com.lmig.gs.globalproducts.handyuls.model.User;
import com.lmig.gs.globalproducts.handyuls.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    UserService userService;

    @Autowired
    UrlRepository urlRepository;

    @Override
    public Url saveUrl(String nnumber, Url url) {
        User userFound = userService.findUserByNnumber(nnumber);
        if (userFound != null) {
            url.setCreatedBy(userFound);
            url.setCreated(new Date());
            return urlRepository.save(url);
        }
        return null;
    }

    @Override
    public Url editUrl(Long id, String nnumber, Url url) {
        User userFound = userService.findUserByNnumber(nnumber);
        Url currentUrl = urlRepository.findOne(id);
        if (currentUrl != null && userFound != null) {
            currentUrl.setTerms(url.getTerms());
            currentUrl.setLink(url.getLink());
            currentUrl.setName(url.getName());
            return urlRepository.save(currentUrl);
        }
        return null;
    }

    @Override
    public boolean deleteUrl(Long id, String nnumber) {
        Url url = urlRepository.findOne(id);
        User user = userService.findUserByNnumber(nnumber);
        if (user != null && url != null) {
            urlRepository.delete(url);
            return true;

        }
        return false;
    }

    @Override
    public Url getUrl(Long id, String nnumber) {
        User userFound = userService.findUserByNnumber(nnumber);
        Url urlFoundOne = urlRepository.findOne(id);
        if (urlFoundOne != null && userFound != null) {
            return urlFoundOne;
        }
        return null;
    }

    @Override
    public List<Url> getUrls(String nnumber) {
        User userFound = userService.findUserByNnumber(nnumber);
        List<Url> urls = urlRepository.findAll();
        if (userFound != null && urls != null) {
            return urls;
        }
        return null;
    }


}
