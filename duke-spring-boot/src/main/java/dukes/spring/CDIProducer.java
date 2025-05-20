package dukes.spring;

import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.spi.BeanManager;
import org.springframework.context.annotation.Configuration;

import javax.naming.InitialContext;
import javax.naming.NamingException;

@Configuration
public class CDIProducer {


    private <T> T getCDIBean(Class<T> beanClass) {
        BeanManager beanManager = getCDIBeanManager();
         jakarta.enterprise.inject.spi.Bean<T> bean
                 = (jakarta.enterprise.inject.spi.Bean<T>) beanManager.getBeans(beanClass).iterator().next();

        CreationalContext<T> ctx = beanManager.createCreationalContext(bean);
        T cdiBean = (T) beanManager.getReference(bean, beanClass, ctx);
        return cdiBean;

    }

    private BeanManager getCDIBeanManager() {
        try {
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:comp/BeanManager");
        } catch (NamingException e) {
            throw new RuntimeException("Failed to lookup CDI BeanManager", e);
        }

    }
}
