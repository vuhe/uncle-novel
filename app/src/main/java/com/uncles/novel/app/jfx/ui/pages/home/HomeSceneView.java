package com.uncles.novel.app.jfx.ui.pages.home;

import com.jfoenix.controls.JFXPopup;
import com.uncles.novel.app.jfx.framework.annotation.FxView;
import com.uncles.novel.app.jfx.framework.ui.appication.SceneView;
import com.uncles.novel.app.jfx.framework.ui.appication.SceneViewNavigateBundle;
import com.uncles.novel.app.jfx.framework.ui.components.button.IconButton;
import com.uncles.novel.app.jfx.framework.ui.components.decorator.StageDecorator;
import com.uncles.novel.app.jfx.framework.ui.components.sidebar.SidebarNavigationPane;
import com.uncles.novel.app.jfx.framework.util.FxmlLoader;
import com.uncles.novel.app.jfx.framework.util.ResourceUtils;
import com.uncles.novel.app.jfx.ui.MainViewModel;
import com.uncles.novel.app.jfx.ui.pages.home.header.SettingPopupView;
import com.uncles.novel.app.jfx.ui.pages.home.header.ThemePopupView;
import javafx.scene.Scene;

/**
 * @author blog.unclezs.com
 * @since 2021/02/26 15:23
 */
@FxView(fxml = "/layout/home/home.fxml", bundle = "i18n.home")
public class HomeSceneView extends SceneView {
    public StageDecorator root;
    public SidebarNavigationPane container;
    private static final MainViewModel VIEW_MODEL = new MainViewModel();
    private ThemePopupView themePopupView;

    public void print() {
        System.out.println(localized("Uncle小说"));
    }

    @Override
    public void onSceneCreated(Scene scene) {
        System.out.println("MainView created");
        scene.getStylesheets().setAll(ResourceUtils.loadCss(String.format(ThemePopupView.THEME_FORMAT, "default")));
    }

    @Override
    public void onTheme(StageDecorator view, IconButton themeButton) {
        if (themePopupView == null) {
            themePopupView = FxmlLoader.load(ThemePopupView.class);
        }
        JFXPopup themePopup = themePopupView.getView();
        themePopup.show(themeButton, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT, 0, 40);
    }

    @Override
    public void onSetting(StageDecorator view, IconButton settingButton) {
        SettingPopupView settingPopupView = FxmlLoader.load(SettingPopupView.class);
        JFXPopup settingPopup = settingPopupView.getView();
        settingPopup.show(settingButton, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT, 0, 40);
    }

    @Override
    public void onShow(SceneViewNavigateBundle bundle) {
        System.out.println("MainView show");
        String data = bundle.get("data");
        if (data != null) {
            System.out.println("MainView收到数据：" + data);
        }
    }

    @Override
    public void onHidden() {
        System.out.println("MainView hidden");
    }

    @Override
    public void onDestroy() {
        System.out.println("MainView destroy");
    }
}