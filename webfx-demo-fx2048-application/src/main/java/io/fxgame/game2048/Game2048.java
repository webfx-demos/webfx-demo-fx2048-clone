package io.fxgame.game2048;

import dev.webfx.kit.util.scene.DeviceSceneUtil;
import dev.webfx.platform.resource.Resource;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Bruno Borges
 */
public class Game2048 extends Application {

    public static final String VERSION = "1.1.0";
    private static Game2048 applicationInstance;
    private GamePane gamePane;

    @Override
    public void stop() {
        gamePane.getGameManager().saveRecord();
    }

    @Override
    public void start(Stage primaryStage) {

        var scene = DeviceSceneUtil.newScene(new Pane() /* temporary dummy root */, 600, 600);
        scene.getStylesheets().add(Resource.toUrl("css/game.css", getClass()));

        // Ensuring the font is loaded before instantiating GamePane (otherwise some bounds may be wrong on first layout - ex: "FX" after 2048)
        Font.loadFont(Resource.toUrl("css/ClearSans-Bold.ttf", getClass()), 14);
        DeviceSceneUtil.onFontsLoaded(() -> {
            gamePane = new GamePane();
            scene.setRoot(gamePane);
            gamePane.requestFocus();
        });

        setGameBounds(primaryStage, scene);
        setEnhancedDeviceSettings(primaryStage, scene);
        setQuitListener(primaryStage);

        primaryStage.show();
        gamePane.requestFocus();
    }

    private void setQuitListener(Stage primaryStage) {
        primaryStage.setOnCloseRequest(t -> {
            t.consume();
            gamePane.getGameManager().quitGame();
        });
    }

    private void setEnhancedDeviceSettings(Stage primaryStage, Scene scene) {
/*
        var isARM = System.getProperty("os.arch").toUpperCase().contains("ARM");
        if (isARM) {
            primaryStage.setFullScreen(true);
            primaryStage.setFullScreenExitHint("");
        }
*/

        /*if (Platform.isSupported(ConditionalFeature.INPUT_TOUCH)) {
            scene.setCursor(Cursor.NONE);
        }*/
    }

    private void setGameBounds(Stage primaryStage, Scene scene) {
/*
        var margin = UserSettings.MARGIN;
        var gameBounds = gamePane.getGameManager().getLayoutBounds();
        var visualBounds = Screen.getPrimary().getVisualBounds();
        double factor = Math.min(visualBounds.getWidth() / (gameBounds.getWidth() + margin),
                visualBounds.getHeight() / (gameBounds.getHeight() + margin));
*/
        primaryStage.setTitle("2048FX");
        primaryStage.setScene(scene);
/*
        primaryStage.setMinWidth(gameBounds.getWidth() / 2d);
        primaryStage.setMinHeight(gameBounds.getHeight() / 2d);
        primaryStage.setWidth(((gameBounds.getWidth() + margin) * factor) / 1.5d);
        primaryStage.setHeight(((gameBounds.getHeight() + margin) * factor) / 1.5d);
*/
    }

    public static interface URLOpener {
        public void open(String url);
    }

    public static URLOpener urlOpener() {
        return (url) -> getInstance().getHostServices().showDocument(url);
    }

    private synchronized static Game2048 getInstance() {
/*
        if (applicationInstance == null) {
            while (applicationInstance == null) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
*/
        return applicationInstance;
    }

    public Game2048() {
        applicationInstance = this;
    }

}
