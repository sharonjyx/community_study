package com.nowcoder.community;

import com.nowcoder.community.util.SensitiveFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTests {
    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSenstiveFilter() {
        String text = "aaa赌博，bbb嫖娼，可以吸毒，123开票，哈哈哈！";
        text=sensitiveFilter.filter(text);
        System.out.println(text);

        text = "aaa赌博，☆嫖☆娼☆，可以吸毒，123开票，哈哈哈！";
        text=sensitiveFilter.filter(text);
        System.out.println(text);

        text = "aaa赌博，☆嫖☆娼☆，可以吸毒，123开票，fabc！";
        text=sensitiveFilter.filter(text);
        System.out.println(text);
    }
}
