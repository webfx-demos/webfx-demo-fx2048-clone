// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.demo.fx2048.application.openjfx {

    // Direct dependencies modules
    requires webfx.demo.fx2048.application;
    requires webfx.kit.openjfx;
    requires webfx.platform.boot.java;
    requires webfx.platform.console.java;
    requires webfx.platform.resource.java;
    requires webfx.platform.scheduler.java;
    requires webfx.platform.shutdown.java;
    requires webfx.platform.storage.java;
    requires webfx.platform.storagelocation.java;

    // Meta Resource package
    opens dev.webfx.platform.meta.exe;

}