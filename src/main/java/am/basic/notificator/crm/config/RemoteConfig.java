package am.basic.notificator.crm.config;


import am.basic.notificator.crm.service.CrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.support.RemoteExporter;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
public class RemoteConfig {



    @Value("${spring.ws.oauth.http.url}")
    private String oauthHttpUrl;


    @Autowired
    private CrmService crmService;



    @Bean(name = "/interconnect/crmService")
    public RemoteExporter documentService() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(crmService);
        exporter.setServiceInterface(CrmService.class);
        return exporter;
    }

    @Bean
    public TokenStore tokenStore() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(oauthHttpUrl);
        invoker.setServiceInterface(TokenStore.class);
        invoker.afterPropertiesSet();
        return (TokenStore) invoker.getObject();
    }



}
