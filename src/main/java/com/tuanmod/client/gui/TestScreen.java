package com.tuanmod.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class TestScreen extends Screen {
    public TestScreen() {
        super(Text.literal("Mod GUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, "GIAO DIỆN MOD ĐÃ MỜ!", this.width / 2, this.height / 2, 0xFFFFFF);
    }
}
