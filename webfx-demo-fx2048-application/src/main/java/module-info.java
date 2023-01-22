// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.demo.fx2048.application {

    // Direct dependencies modules
    requires java.base;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires webfx.demo.fx2048.css;
    requires webfx.extras.webtext;
    requires webfx.platform.resource;
    requires webfx.platform.shutdown;
    requires webfx.platform.storage;

    // Exported packages
    exports io.fxgame.game2048;

    // Provided services
    provides javafx.application.Application with io.fxgame.game2048.Game2048;

}