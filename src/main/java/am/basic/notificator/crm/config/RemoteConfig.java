package am.basic.notificator.crm.config;


import am.basic.notificator.crm.service.CrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

@Configuration
public class RemoteConfig {


    @Autowired
    private CrmService crmService;


    @Bean(name = "/interconnect/crmService")
    public RemoteExporter documentService() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(crmService);
        exporter.setServiceInterface(CrmService.class);
        return exporter;
    }


}
