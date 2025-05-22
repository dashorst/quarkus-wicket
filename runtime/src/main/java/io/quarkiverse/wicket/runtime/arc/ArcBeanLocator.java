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

import java.io.Serial;
import java.lang.annotation.Annotation;
import java.util.Arrays;

import org.apache.wicket.proxy.IProxyTargetLocator;

/**
 * Locates CDI beans upon deserialization of the proxy that stands in for the
 * CDI bean.
 */
class ArcBeanLocator implements IProxyTargetLocator {
    @Serial
    private static final long serialVersionUID = 1L;

    private final Class<?> beanClass;

    private final Annotation[] qualifiers;

    private transient String stringValue;

    ArcBeanLocator(Class<?> beanClass, Annotation[] qualifiers) {
        this.beanClass = beanClass;
        this.qualifiers = qualifiers;
    }

    Class<?> beanClass() {
        return beanClass;
    }

    Annotation[] qualifiers() {
        return qualifiers;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T locateProxyTarget() {
        return (T) ArcInjector.getInstance().getBean(this);
    }

    @Override
    public final String toString() {
        if (stringValue == null) {
            stringValue = "ArcBeanLocator{" +
                    "beanClass=" + beanClass + (qualifiers.length == 0 ? ""
                            : ", qualifiers=" + Arrays.toString(qualifiers))
                    +
                    '}';
        }
        return stringValue;
    }
}
