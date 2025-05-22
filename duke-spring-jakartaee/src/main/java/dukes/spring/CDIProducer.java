package dukes.spring;


import dukes.ai.JakartaGTP;
import jakarta.el.ELResolver;
import jakarta.el.ExpressionFactory;
import jakarta.enterprise.context.spi.Context;
import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.spi.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Configuration
public class CDIProducer {

    @Bean
    public JakartaGTP jakartaGTP() {
        return getCDIBean(JakartaGTP.class);
    }

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
            return new MyBeanManager();
//            throw new RuntimeException("Failed to lookup CDI BeanManager", e);
        }
    }





    class MyBeanManager implements BeanManager {


        @Override
        public Object getInjectableReference(InjectionPoint ij, CreationalContext<?> ctx) {
            return null;
        }

        @Override
        public jakarta.enterprise.inject.spi.Bean<?> getPassivationCapableBean(String id) {
            return null;
        }

        @Override
        public void validate(InjectionPoint injectionPoint) {

        }

        @Override
        public List<Decorator<?>> resolveDecorators(Set<Type> types, Annotation... qualifiers) {
            return List.of();
        }

        @Override
        public boolean isPassivatingScope(Class<? extends Annotation> annotationType) {
            return false;
        }

        @Override
        public Set<Annotation> getInterceptorBindingDefinition(Class<? extends Annotation> bindingType) {
            return Set.of();
        }

        @Override
        public Set<Annotation> getStereotypeDefinition(Class<? extends Annotation> stereotype) {
            return Set.of();
        }

        @Override
        public boolean areQualifiersEquivalent(Annotation qualifier1, Annotation qualifier2) {
            return false;
        }

        @Override
        public boolean areInterceptorBindingsEquivalent(Annotation interceptorBinding1, Annotation interceptorBinding2) {
            return false;
        }

        @Override
        public int getQualifierHashCode(Annotation qualifier) {
            return 0;
        }

        @Override
        public int getInterceptorBindingHashCode(Annotation interceptorBinding) {
            return 0;
        }

        @Override
        public ELResolver getELResolver() {
            return null;
        }

        @Override
        public ExpressionFactory wrapExpressionFactory(ExpressionFactory expressionFactory) {
            return null;
        }

        @Override
        public <T> AnnotatedType<T> createAnnotatedType(Class<T> type) {
            return null;
        }

        @Override
        public <T> InjectionTargetFactory<T> getInjectionTargetFactory(AnnotatedType<T> annotatedType) {
            return null;
        }

        @Override
        public <X> ProducerFactory<X> getProducerFactory(AnnotatedField<? super X> field, jakarta.enterprise.inject.spi.Bean<X> declaringBean) {
            return null;
        }

        @Override
        public <X> ProducerFactory<X> getProducerFactory(AnnotatedMethod<? super X> method, jakarta.enterprise.inject.spi.Bean<X> declaringBean) {
            return null;
        }

        @Override
        public <T> BeanAttributes<T> createBeanAttributes(AnnotatedType<T> type) {
            return null;
        }

        @Override
        public BeanAttributes<?> createBeanAttributes(AnnotatedMember<?> type) {
            return null;
        }

        @Override
        public <T> jakarta.enterprise.inject.spi.Bean<T> createBean(BeanAttributes<T> attributes, Class<T> beanClass, InjectionTargetFactory<T> injectionTargetFactory) {
            return null;
        }

        @Override
        public <T, X> jakarta.enterprise.inject.spi.Bean<T> createBean(BeanAttributes<T> attributes, Class<X> beanClass, ProducerFactory<X> producerFactory) {
            return null;
        }

        @Override
        public InjectionPoint createInjectionPoint(AnnotatedField<?> field) {
            return null;
        }

        @Override
        public InjectionPoint createInjectionPoint(AnnotatedParameter<?> parameter) {
            return null;
        }

        @Override
        public <T extends Extension> T getExtension(Class<T> extensionClass) {
            return null;
        }

        @Override
        public <T> InterceptionFactory<T> createInterceptionFactory(CreationalContext<T> ctx, Class<T> clazz) {
            return null;
        }

        @Override
        public Object getReference(jakarta.enterprise.inject.spi.Bean<?> bean, Type beanType, CreationalContext<?> ctx) {
            return new JakartaGTP();
        }

        @Override
        public <T> CreationalContext<T> createCreationalContext(Contextual<T> contextual) {
            return null;
        }

        @Override
        public Set<jakarta.enterprise.inject.spi.Bean<?>> getBeans(Type beanType, Annotation... qualifiers) {
            return Set.of(new jakarta.enterprise.inject.spi.Bean<JakartaGTP>() {
                @Override
                public Set<Type> getTypes() {
                    return Set.of();
                }

                @Override
                public Set<Annotation> getQualifiers() {
                    return Set.of();
                }

                @Override
                public Class<? extends Annotation> getScope() {
                    return null;
                }

                @Override
                public String getName() {
                    return "";
                }

                @Override
                public Set<Class<? extends Annotation>> getStereotypes() {
                    return Set.of();
                }

                @Override
                public boolean isAlternative() {
                    return false;
                }

                @Override
                public JakartaGTP create(CreationalContext<JakartaGTP> creationalContext) {
                    return null;
                }

                @Override
                public void destroy(JakartaGTP instance, CreationalContext<JakartaGTP> creationalContext) {

                }

                @Override
                public Class<?> getBeanClass() {
                    return null;
                }

                @Override
                public Set<InjectionPoint> getInjectionPoints() {
                    return Set.of();
                }
            });
        }

        @Override
        public Set<jakarta.enterprise.inject.spi.Bean<?>> getBeans(String name) {
            return Set.of();
        }

        @Override
        public <X> jakarta.enterprise.inject.spi.Bean<? extends X> resolve(Set<jakarta.enterprise.inject.spi.Bean<? extends X>> beans) {
            return null;
        }

        @Override
        public <T> Set<ObserverMethod<? super T>> resolveObserverMethods(T event, Annotation... qualifiers) {
            return Set.of();
        }

        @Override
        public List<Interceptor<?>> resolveInterceptors(InterceptionType type, Annotation... interceptorBindings) {
            return List.of();
        }

        @Override
        public boolean isScope(Class<? extends Annotation> annotationType) {
            return false;
        }

        @Override
        public boolean isNormalScope(Class<? extends Annotation> annotationType) {
            return false;
        }

        @Override
        public boolean isQualifier(Class<? extends Annotation> annotationType) {
            return false;
        }

        @Override
        public boolean isStereotype(Class<? extends Annotation> annotationType) {
            return false;
        }

        @Override
        public boolean isInterceptorBinding(Class<? extends Annotation> annotationType) {
            return false;
        }

        @Override
        public Context getContext(Class<? extends Annotation> scopeType) {
            return null;
        }

        @Override
        public Collection<Context> getContexts(Class<? extends Annotation> scopeType) {
            return List.of();
        }

        @Override
        public Event<Object> getEvent() {
            return null;
        }

        @Override
        public Instance<Object> createInstance() {
            return null;
        }

        @Override
        public boolean isMatchingBean(Set<Type> beanTypes, Set<Annotation> beanQualifiers, Type requiredType, Set<Annotation> requiredQualifiers) {
            return false;
        }

        @Override
        public boolean isMatchingEvent(Type specifiedType, Set<Annotation> specifiedQualifiers, Type observedEventType, Set<Annotation> observedEventQualifiers) {
            return false;
        }
    }
}
