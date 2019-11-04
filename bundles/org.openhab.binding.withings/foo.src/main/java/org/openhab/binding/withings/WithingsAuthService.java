/**
 * Copyright (c) 2010-2019 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.withings.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.openhab.binding.withings.internal.handler.WithingsAccountHandler;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.openhab.binding.withings.internal.WithingsBindingConstants.WITHINGS_ALIAS;
import static org.openhab.binding.withings.internal.WithingsBindingConstants.WITHINGS_IMG_ALIAS;

/**
 * The {@link WithingsAuthService} ...
 *
 * @author Hakan Tandogan - Initial contribution
 */
@Component(service = WithingsAuthService.class, immediate = true, configurationPid = "binding.withings.authService")
@NonNullByDefault
public class WithingsAuthService {

    private static final String TEMPLATE_PATH = "templates/";
    private static final String TEMPLATE_PLAYER = TEMPLATE_PATH + "player.html";
    private static final String TEMPLATE_INDEX = TEMPLATE_PATH + "index.html";
    private static final String ERROR_UKNOWN_BRIDGE = "Returned 'state' by doesn't match any Bridges. Has the bridge been removed?";

    private final Logger logger = LoggerFactory.getLogger(WithingsAuthService.class);

    private final List<WithingsAccountHandler> handlers = new ArrayList<>();

//    private @NonNullByDefault({}) HttpService httpService;
//    private @NonNullByDefault({}) BundleContext bundleContext;

    @Activate
    protected void activate(ComponentContext componentContext, Map<String, Object> properties) {
//        try {
//            bundleContext = componentContext.getBundleContext();
//            httpService.registerServlet(WITHINGS_ALIAS, createServlet(), new Hashtable<>(),
//                    httpService.createDefaultHttpContext());
//            httpService.registerResources(WITHINGS_ALIAS + WITHINGS_IMG_ALIAS, "web", null);
//        } catch (NamespaceException | ServletException | IOException e) {
//            logger.warn("Error during spotify servlet startup", e);
//        }
    }

    @Deactivate
    protected void deactivate(ComponentContext componentContext) {
//        httpService.unregister(SPOTIFY_ALIAS);
//        httpService.unregister(SPOTIFY_ALIAS + SPOTIFY_IMG_ALIAS);
    }

    /**
     * Creates a new {@link WithingsAuthServlet}.
     *
     * @return the newly created servlet
     * @throws IOException thrown when an HTML template could not be read
     */
//    private HttpServlet createServlet() throws IOException {
//        return new WithingsAuthServlet(this, readTemplate(TEMPLATE_INDEX), readTemplate(TEMPLATE_PLAYER));
//    }

    /**
     * Reads a template from file and returns the content as String.
     *
     * @param templateName name of the template file to read
     * @return The content of the template file
     * @throws IOException thrown when an HTML template could not be read
     */
    private String readTemplate(String templateName) throws IOException {
        /*
        URL index = bundleContext.getBundle().getEntry(templateName);

        if (index == null) {
            throw new FileNotFoundException(
                    String.format("Cannot find '{}' - failed to initialize Withings servlet", templateName));
        } else {
            try (InputStream inputStream = index.openStream()) {
                return IOUtils.toString(inputStream);
            }
        }
        */
        return "";
    }

    /**
     * Call with Withings redirect uri returned State and Code values to get the refresh and access tokens and persist
     * these values
     *
     * @param servletBaseURL the servlet base, which will be the Withings redirect url
     * @param state The Withings returned state value
     * @param code The Withings returned code value
     * @return returns the name of the Withings user that is authorized
     */
    public String authorize(String servletBaseURL, String state, String code) {
//        WithingsAccountHandler listener = getWithingsAuthListener(state);

//          if (listener == null) {
//            logger.debug(
//                    "Withings redirected with state '{}' but no matching bridge was found. Possible bridge has been removed.",
//                    state);
//            throw new WithingsException(ERROR_UKNOWN_BRIDGE);
//        } else {
//            return listener.authorize(servletBaseURL, code);
//        }
        return "";
    }

    /**
     * @param listener Adds the given handler
     */
    public void addWithingsAccountHandler(WithingsAccountHandler listener) {
        if (!handlers.contains(listener)) {
            handlers.add(listener);
        }
    }

    /**
     * @param handler Removes the given handler
     */
    public void removeWithingsAccountHandler(WithingsAccountHandler handler) {
        handlers.remove(handler);
    }

    /**
     * @return Returns all {@link WithingsAccountHandler}s.
     */
    public List<WithingsAccountHandler> getWithingsAccountHandlers() {
        return handlers;
    }

    /**
     * Get the {@link WithingsAccountHandler} that matches the given thing UID.
     *
     * @param thingUID UID of the thing to match the handler with
     * @return the {@link WithingsAccountHandler} matching the thing UID or null
     */
    private @Nullable WithingsAccountHandler getWithingsAuthListener(String thingUID) {
//        Optional<WithingsAccountHandler> listener = handlers.stream().filter(l -> l.equalsThingUID(thingUID))
//                  .findFirst();
//        return listener.isPresent() ? listener.get() : null;
        return null;
    }

/*
    @Reference
    protected void setHttpService(HttpService httpService) {
        this.httpService = httpService;
    }

    protected void unsetHttpService(HttpService httpService) {
        this.httpService = null;
    }
*/
}
