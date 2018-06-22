package com.zcy.springintejms.controller;

import com.zcy.springintejms.entity.Email;
import com.zcy.springintejms.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jms.Destination;

/**
 * Created by xin on 15-2-8 下午8:46
 *
 * @project activeMQ
 * @package com.tiantian.springintejms.controller
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */

@Controller
@RequestMapping("mq")
public class SenderController {

    @Autowired
    private ProducerService producerService;
    @Autowired
    @Qualifier("queueDestination")
    private Destination queueDestination;

    @Autowired
    @Qualifier("sessionAwareQueue")
    private Destination sessionAwareQueue;

    @Autowired
    @Qualifier("adapterQueue")
    private Destination adapterQueue;

    @Autowired
    @Qualifier("topicDestination")
    private Destination topicDestination ;

    /**
     * 选上面的任意一种目的地地址填入下面地址栏
     */
    @RequestMapping("/send")
    public void send(){
        for (int i=0; i<2; i++) {
            Email email = new Email("this is the receiver"+i,"this is the title","this is the content");

            //发送给destination目的地一条消息
            //producerService.sendMessage(topicDestination, "你好，生产者！topicDestination：" + (i+1));
            producerService.sendMessage(adapterQueue, email);
        }
    }
}
