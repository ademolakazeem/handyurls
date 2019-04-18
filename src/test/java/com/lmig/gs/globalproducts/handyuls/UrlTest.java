package com.lmig.gs.globalproducts.handyuls;

import com.lmig.gs.globalproducts.handyuls.model.Url;
import com.lmig.gs.globalproducts.handyuls.repository.UrlRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UrlTest {

    @Autowired
    private UrlRepository urlRepository;

    @Test
    public void save() {
        Url url = new Url();
        url.setName("Udemy");
        url.setLink("https://www.udemy.com/docker-mastery/");
        url.setTerms("udemy, course");

        //assertNotNull("Url has ID: ", url.getId());
        assertEquals("Assert Name", "Udemy", url.getName());
    }

}
