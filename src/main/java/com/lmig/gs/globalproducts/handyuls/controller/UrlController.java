package com.lmig.gs.globalproducts.handyuls.controller;

import com.lmig.gs.globalproducts.handyuls.model.Url;
import com.lmig.gs.globalproducts.handyuls.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/urls")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Url> saveUrl(@RequestParam("nnumber") String nnumber, @RequestBody Url url) {
        try {
            if (urlService.saveUrl(nnumber, url) != null) {
                System.out.println("Controller saved");
                return ResponseEntity.created(new URI("/urls/" + url.getId())).build();
            }
            return (ResponseEntity<Url>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUrl(@PathVariable("id") Long id, @RequestParam("nnumber") String nnumber, @RequestBody Url url) {
        if (Long.valueOf(id).equals(url.getId()) && urlService.editUrl(id, nnumber, url) != null) {
            return ResponseEntity.ok("Successful");
            //.accepted().build();
        } else if (Long.valueOf(id) != url.getId()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("The url Id is different or getUser does not exist! Try again with different information");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUrl(@PathVariable("id") Long id, @RequestParam("nnumber") String nnumber) {
        if (urlService.deleteUrl(id, nnumber) == true) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Url> getUrl(@PathVariable("id") Long id, @RequestParam("nnumber") String nnumber) {
        Url url = urlService.getUrl(id, nnumber);
        if (url != null) {
            return ResponseEntity.ok(url);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Url>> getUrls(@RequestParam("nnumber") String nnumber) {
        List<Url> urls = urlService.getUrls(nnumber);
        if (urls != null) {
            return ResponseEntity.ok(urls);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
