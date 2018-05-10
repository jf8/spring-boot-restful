/*
 * Copyright 2016-2018 the original author or authors from the Fosun project.
 *
 * This file is part of the Fosun project, see https://www.fosun.com/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fosun.beauty.common.config.jcache;

import org.hibernate.cache.jcache.JCacheRegionFactory;
import org.hibernate.cache.spi.CacheDataDescription;

import javax.cache.Cache;
import java.util.Properties;

/**a
 * Extends the default {@code JCacheRegionFactory} but makes sure all caches already exist to prevent
 * spontaneous creation of badly configured caches (e.g. {@code new MutableConfiguration()}.
 */
@SuppressWarnings("serial")
public class NoDefaultJCacheRegionFactory extends JCacheRegionFactory {

    public static final String EXCEPTION_MESSAGE = "All Hibernate caches should be created upfront. " +
        "Please update CacheConfiguration.java to add";

    @Override
    protected Cache<Object, Object> createCache(String regionName, Properties properties, CacheDataDescription
        metadata) {
        throw new IllegalStateException(EXCEPTION_MESSAGE + " " + regionName);
    }
}
