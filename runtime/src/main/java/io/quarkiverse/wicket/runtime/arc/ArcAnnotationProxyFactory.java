/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.quarkiverse.wicket.runtime.arc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Qualifier;

import org.apache.wicket.injection.IFieldValueFactory;
import org.apache.wicket.proxy.LazyInitProxyFactory;

import io.quarkus.logging.Log;

/**
 * Factory for creating proxies for fields annotated with {@link Inject}.
 */
@ApplicationScoped
class ArcAnnotationProxyFactory implements IFieldValueFactory {
    private static final Annotation[] EMPTY_ANNOTATIONS = new Annotation[0];

    /**
     * Generates the proxy that functions as a stand-in for the (non-serializable)
     * CDI bean.
     */
    @Override
    public Object getFieldValue(Field field, Object injectionPoint) {
        if (Log.isDebugEnabled())
            Log.debugf("Injecting %s#%s", injectionPoint.getClass().getSimpleName(), field.getName());

        Class<?> beanType = field.getType();
        Annotation[] fieldAnnotations = field.getAnnotations();

        // if there is only one annotation, that is the @Inject annotation, which is not
        // a qualifier, so we can skip it (resulting in an empty array of qualifiers)
        Annotation[] qualifiers = fieldAnnotations.length == 1 ? EMPTY_ANNOTATIONS
                : Arrays.stream(fieldAnnotations)
                        .filter(a -> a.annotationType().isAnnotationPresent(Qualifier.class))
                        .toArray(Annotation[]::new);

        // the factory has its own caching of proxies, such that only one proxy is created
        return LazyInitProxyFactory.createProxy(beanType, new ArcBeanLocator(beanType, qualifiers));
    }

    /**
     * Checks if the field is annotated with {@link ArcBean}.
     */
    @Override
    public boolean supportsField(Field field) {
        return (field.getAnnotation(Inject.class) != null);
    }
}
