package cn.cicoding.microservicesstreamrocketmqproducer;

import cn.cicoding.microservicesstreamrocketmqproducer.source.MySink;
import cn.cicoding.microservicesstreamrocketmqproducer.source.MySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * start mqnamesrv.cmd
 * start mqbroker.cmd -n 127.0.0.1:9876 autoCreateTopicEnable=true
 */
@EnableBinding({Source.class, MySource.class, MySink.class, Sink.class})
@SpringBootApplication
public class MicroservicesStreamRocketmqProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesStreamRocketmqProducerApplication.class, args);
	}


}
