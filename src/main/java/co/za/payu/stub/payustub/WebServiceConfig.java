package co.za.payu.stub.payustub;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;


import java.io.IOException;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    @Bean(name = "enterpriseAPISoapService")
    public DefaultWsdl11Definition defaultWsdl11Definition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EnterpriseAPISoapServicePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://soap.api.controller.web.payjar.com/");
        wsdl11Definition.setSchemaCollection(enterpriseAPISoapServiceSchema());
        return wsdl11Definition;
    }

    @Bean
    public CommonsXsdSchemaCollection enterpriseAPISoapServiceSchema() {
        CommonsXsdSchemaCollection collection =
                new CommonsXsdSchemaCollection(new Resource[] {
                        //new ClassPathResource("array.xsd"),
                        //new ClassPathResource("PayUMapLoader.xsd"),
                        new ClassPathResource("Root.xsd")
                        //new ClassPathResource("DeleteTransactionResponseMessage.xsd"),
                        //new ClassPathResource("GetTransactionResponseMessage.xsd"),
                        //new ClassPathResource("DoTransactionResponseMessage.xsd"),
                        //new ClassPathResource("SetTransactionResponseMessage.xsd"),
                        //new ClassPathResource("LookupTransactionResponseMessage.xsd")
                });

        collection.setInline(true);


        return collection;
    }
    /*
            @Bean(name = "enterpriseAPISoapService")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema enterpriseAPISoapServiceSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EnterpriseAPISoapServicePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://soap.api.controller.web.payjar.com");
        wsdl11Definition.setSchema(enterpriseAPISoapServiceSchema);
        return wsdl11Definition;
    }


    @Bean
    public XsdSchema enterpriseAPISoapServiceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("EnterpriseAPISoapService.xsd"));
    }
    */
}
