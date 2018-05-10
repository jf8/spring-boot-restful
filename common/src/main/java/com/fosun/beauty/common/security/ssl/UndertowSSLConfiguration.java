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

package com.fosun.beauty.common.security.ssl;

import com.fosun.beauty.common.config.FosunProperties;
import io.undertow.UndertowOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * SSL configuration for Undertow.
 * <p>
 * SSL_USER_CIPHER_SUITES_ORDER : It will force the cipher suite defined by the user,
 * allowing to achieve perfect forward secrecy.
 * This can only be activated with HTTPS and a cipher suite defined by the user (server.ssl.ciphers).
 * <p>
 * Please note that when using Fosun, you can use the `server.ssl.ciphers` property that is commented out
 * in your `application-prod.yml` file, and which is ready to work with this configuration.
 *
 * @see
 * <a href="https://github.com/ssllabs/research/wiki/SSL-and-TLS-Deployment-Best-Practices#25-use-forward-secrecy" target="_blank">More explanation on perfect forward secrecy</a>
 */
@Configuration
@ConditionalOnClass({ UndertowServletWebServerFactory.class })
@ConditionalOnProperty({ "server.ssl.ciphers", "server.ssl.key-store" })
public class UndertowSSLConfiguration {

    private final UndertowServletWebServerFactory factory;

    private final FosunProperties FosunProperties;

    private final Logger log = LoggerFactory.getLogger(UndertowSSLConfiguration.class);

    public UndertowSSLConfiguration(UndertowServletWebServerFactory undertowServletWebServerFactory,
        FosunProperties FosunProperties) {
        this.factory = undertowServletWebServerFactory;
        this.FosunProperties = FosunProperties;

        configuringUserCipherSuiteOrder();
    }

    private void configuringUserCipherSuiteOrder() {
        log.info("Configuring Undertow");
        if (FosunProperties.getHttp().isUseUndertowUserCipherSuitesOrder()) {
            log.info("Setting user cipher suite order to true");
            factory.addBuilderCustomizers(builder -> builder.setSocketOption(UndertowOptions
                .SSL_USER_CIPHER_SUITES_ORDER, Boolean.TRUE));
        }
    }
}
