// Generated by WebFx
package java.util;

import java.util.Iterator;
import java.util.logging.Logger;
import webfx.platform.shared.util.function.Factory;

public class ServiceLoader<S> implements Iterable<S> {

    public static <S> ServiceLoader<S> load(Class<S> serviceClass) {
        switch (serviceClass.getName()) {
            case "javafx.application.Application": return new ServiceLoader<S>(io.fxgame.game2048.Game2048::new);
            case "webfx.kit.launcher.spi.WebFxKitLauncherProvider": return new ServiceLoader<S>(webfx.kit.launcher.spi.gwt.GwtWebFxKitLauncherProvider::new);
            case "webfx.kit.mapper.spi.WebFxKitMapperProvider": return new ServiceLoader<S>(webfx.kit.mapper.spi.gwt.GwtWebFxKitHtmlMapperProvider::new);
            case "webfx.platform.client.services.storage.spi.LocalStorageProvider": return new ServiceLoader<S>(webfx.platform.gwt.services.storage.spi.impl.GwtLocalStorageProvider::new);
            case "webfx.platform.client.services.storage.spi.SessionStorageProvider": return new ServiceLoader<S>(webfx.platform.gwt.services.storage.spi.impl.GwtSessionStorageProvider::new);
            case "webfx.platform.client.services.uischeduler.spi.UiSchedulerProvider": return new ServiceLoader<S>(webfx.platform.gwt.services.uischeduler.spi.impl.GwtUiSchedulerProvider::new);
            case "webfx.platform.gwt.services.resource.spi.impl.GwtResourceBundle": return new ServiceLoader<S>();
            case "webfx.platform.shared.services.appcontainer.spi.ApplicationContainerProvider": return new ServiceLoader<S>(webfx.platform.gwt.services.appcontainer.spi.impl.GwtApplicationContainerProvider::new);
            case "webfx.platform.shared.services.appcontainer.spi.ApplicationJob": return new ServiceLoader<S>();
            case "webfx.platform.shared.services.appcontainer.spi.ApplicationModuleInitializer": return new ServiceLoader<S>(webfx.kit.launcher.WebFxKitLauncherModuleInitializer::new, webfx.platform.shared.services.appcontainer.spi.impl.ApplicationJobsStarter::new, webfx.platform.gwt.services.resource.spi.impl.GwtResourceModuleInitializer::new);
            case "webfx.platform.shared.services.log.spi.LoggerProvider": return new ServiceLoader<S>(webfx.platform.gwt.services.log.spi.impl.GwtLoggerProvider::new);
            case "webfx.platform.shared.services.resource.spi.ResourceServiceProvider": return new ServiceLoader<S>(webfx.platform.gwt.services.resource.spi.impl.GwtResourceServiceProvider::new);
            case "webfx.platform.shared.services.scheduler.spi.SchedulerProvider": return new ServiceLoader<S>(webfx.platform.gwt.services.uischeduler.spi.impl.GwtUiSchedulerProvider::new);
            case "webfx.platform.shared.services.shutdown.spi.ShutdownProvider": return new ServiceLoader<S>(webfx.platform.gwt.services.shutdown.spi.impl.GwtShutdownProvider::new);
            // UNKNOWN SPI
            default:
               Logger.getLogger(ServiceLoader.class.getName()).warning("Unknown " + serviceClass + " SPI - returning no provider");
               return new ServiceLoader<S>();
        }
    }

    private final Factory[] factories;

    public ServiceLoader(Factory... factories) {
        this.factories = factories;
    }

    public Iterator<S> iterator() {
        return new Iterator<S>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < factories.length;
            }

            @Override
            public S next() {
                return (S) factories[index++].create();
            }
        };
    }
}